package org.javademos.java25.jep508;

import org.javademos.commons.IDemo;
import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorSpecies;

/**
 * Demo for JDK 25 feature **Vector API (tenth incubator)** (JEP 508)
 *
 * Shows a simple vectorized add (a + b -> out) using jdk.incubator.vector
 * and compares it to a plain scalar loop. Verifies correctness and prints timing.
 *
 * Notes:
 * - This code requires enabling the incubator module at runtime:
 *   --add-modules=jdk.incubator.vector
 *
 * - Recommended: run on JDK 25 (or a build that contains JEP 508).
 *
 * @see jdk.incubator.vector.FloatVector
 */
public class VectorApiDemo implements IDemo {

    // preferred species picks vector size best supported by the platform at runtime
    private static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;

    // safe default sized array (tweakable)
    private static final int DEFAULT_SIZE = 5_000_000;
    private static final int DEFAULT_RUNS = 3;

    @Override
    public void demo() {
        info(508);

        int size = DEFAULT_SIZE;
        int runs = DEFAULT_RUNS;

        System.out.println("JEP 508 Vector API demo — size=" + size + ", runs=" + runs);
        System.out.println("Vector species preferred length: " + SPECIES.length());

        // prepare arrays
        float[] a = new float[size];
        float[] b = new float[size];
        float[] outVec = new float[size];
        float[] outScalar = new float[size];

        for (int i = 0; i < size; i++) {
            a[i] = (i % 100) + 0.5f;
            b[i] = ((i * 3) % 100) + 0.25f;
        }

        System.out.println("Warming up and benchmarking... (may take a few seconds)");

        long vecMs = benchmark(() -> vectorAdd(a, b, outVec), runs);
        long scalarMs = benchmark(() -> scalarAdd(a, b, outScalar), runs);

        // correctness check
        boolean ok = true;
        for (int i = 0; i < size; i++) {
            if (Float.floatToIntBits(outVec[i]) != Float.floatToIntBits(outScalar[i])) {
                System.out.println("Mismatch at index " + i + ": vec=" + outVec[i] + ", scalar=" + outScalar[i]);
                ok = false;
                break;
            }
        }

        System.out.println("Correctness: " + (ok ? "OK" : "FAILED"));
        System.out.println("Vector total time (ms): " + vecMs);
        System.out.println("Scalar total time (ms): " + scalarMs);
        if (vecMs > 0) {
            double speedup = (double) scalarMs / (double) vecMs;
            System.out.printf("Speedup (scalar / vector) ≈ %.2fx%n", speedup);
        }

        System.out.println("\nTip: To run outside IDE, compile & run with --add-modules=jdk.incubator.vector");
        System.out.println("Example (from repo root):");
        System.out.println("  javac --add-modules jdk.incubator.vector src/main/java/org/javademos/java25/jep508/VectorApiDemo.java");
        System.out.println("  java  --add-modules jdk.incubator.vector -cp src/main/java org.javademos.java25.jep508.VectorApiDemo");
    }

    // vectorized addition using FloatVector
    public static void vectorAdd(float[] a, float[] b, float[] out) {
        int length = a.length;
        int i = 0;
        int vs = SPECIES.length();
        int upper = length - (length % vs);

        for (; i < upper; i += vs) {
            FloatVector va = FloatVector.fromArray(SPECIES, a, i);
            FloatVector vb = FloatVector.fromArray(SPECIES, b, i);
            FloatVector vc = va.add(vb);
            vc.intoArray(out, i);
        }

        // tail
        for (; i < length; i++) {
            out[i] = a[i] + b[i];
        }
    }

    // scalar baseline
    public static void scalarAdd(float[] a, float[] b, float[] out) {
        for (int i = 0; i < a.length; i++) {
            out[i] = a[i] + b[i];
        }
    }

    // simple benchmark helper (ms)
    private static long benchmark(Runnable action, int runs) {
        // warm-up
        action.run();
        long start = System.nanoTime();
        for (int i = 0; i < runs; i++) {
            action.run();
        }
        long end = System.nanoTime();
        return (end - start) / 1_000_000L;
    }
}

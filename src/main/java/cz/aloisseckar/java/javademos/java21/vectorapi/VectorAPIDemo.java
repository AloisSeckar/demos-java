package cz.aloisseckar.java.javademos.java21.vectorapi;

import cz.aloisseckar.java.javademos.commons.IDemo;
import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorSpecies;

import java.util.Random;

/**
 * This class demonstrates new feature called Vector API.
 * The status in Java 21 is INCUBATOR => JVM option `--add-modules=jdk.incubator.vector` is required to use it.
 *
 * REFERENCES:
 * Java 21 - https://openjdk.org/jeps/448 - Vector API (Sixth Incubator)
 * Java 20 - https://openjdk.org/jeps/438 - Vector API (Fifth Incubator)
 * Java 19 - https://openjdk.org/jeps/426 - Vector API (Fourth Incubator)
 * Java 18 - https://openjdk.org/jeps/417 - Vector API (Third Incubator)
 * Java 17 - https://openjdk.org/jeps/414 - Vector API (Second Incubator)
 * Java 16 - https://openjdk.org/jeps/338 - Vector API (Incubator)
 *
 * Further reading:
 * https://www.linkedin.com/pulse/whats-new-java-21-meet-vector-api-alexey-iyunski
 * https://medium.com/@Styp/java-18-vector-api-do-we-get-free-speed-up-c4510eda50d2
 *
 * @author alois.seckar@gmail.com
 */
public class VectorAPIDemo implements IDemo {

    private static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_MAX;

    private static final int MAX_ITEMS = 100000000;

    @Override
    public void demo() {
        info("VECTOR API DEMO", "Examples for 'Vector API' feature\nincluded in Java 20");

        // demo task - calculating mass of a random rectangular prism - 100M times
        // TODO find better example...?

        System.out.println("Initializing operands");

        // init operands
        var a = new float[MAX_ITEMS];
        var b = new float[MAX_ITEMS];
        var c = new float[MAX_ITEMS];
        var rand = new Random();
        for (int i = 0; i < MAX_ITEMS; ++i) {
            a[i] = rand.nextFloat();
            b[i] = rand.nextFloat();
            c[i] = rand.nextFloat();
        }

        // First traditional way...
        System.out.println("Prism mass - scalar");
        var s1 = System.nanoTime();
        countPrismMassScalar(a, b, c);
        var f1 = System.nanoTime();
        System.out.println("Took: " + ((f1 - s1) / 1000000) + "ms");

        // Now using vector API...
        System.out.println("Prism mass - vector");
        var s2 = System.nanoTime();
        countPrismMassVector(a, b, c);
        var f2 = System.nanoTime();
        System.out.println("Took: " + ((f2 - s2) / 1000000) + "ms");

    }

    // input arrays are presumed to be the same size
    private float[] countPrismMassScalar(float[] a, float[] b, float[] c) {
        var r = new float[MAX_ITEMS];
        // just process the input one-by-one
        for (int i = 0; i < MAX_ITEMS; i++) {
            r[i] = a[i] * b[i] * c[i];
        }
        return r;
    }

    // input arrays are presumed to be the same size
    private float[] countPrismMassVector(float[] a, float[] b, float[] c) {
        var r = new float[MAX_ITEMS];

        var upperBound = SPECIES.loopBound(a.length);

        // will go through the source arrays step by step
        // each step equals the vector size
        var i = 0;
        for (; i < upperBound; i += SPECIES.length()) {
            // turn next part of source arrays into vectors
            var va = FloatVector.fromArray(SPECIES, a, i);
            var vb = FloatVector.fromArray(SPECIES, b, i);
            var vc = FloatVector.fromArray(SPECIES, c, i);
            // perform the vector operation
            var vr = va.mul(vb).mul(vc);
            // append the result to the target array
            vr.intoArray(r, i);
        }
        // the last offset, that doesn't fit into loop above
        // has to be processed traditional way
        for (; i < a.length; i++) {
            r[i] = a[i] * b[i] * c[i];
        }
        return r;
    }
}

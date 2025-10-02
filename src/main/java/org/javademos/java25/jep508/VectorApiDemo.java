package org.javademos.java25.jep508;

import org.javademos.commons.IDemo;
import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorSpecies;

/// Demo for JDK 25 feature **Vector API** (JEP 508)
///
/// ### JEP history
/// - JDK 16: [JEP 338 - Vector API (Incubator)](https://openjdk.org/jeps/338)
/// - JDK 17: [JEP 414 - Vector API (Second Incubator)](https://openjdk.org/jeps/414)
/// - JDK 18: [JEP 417 - Vector API (Third Incubator)](https://openjdk.org/jeps/417)
/// - JDK 19: [JEP 426 - Vector API (Fourth Incubator)](https://openjdk.org/jeps/426)
/// - JDK 20: [JEP 438 - Vector API (Fifth Incubator)](https://openjdk.org/jeps/438)
/// - JDK 21: [JEP 448 - Vector API (Sixth Incubator)](https://openjdk.org/jeps/448)
/// - JDK 22: [JEP 460 - Vector API (Seventh Incubator)](https://openjdk.org/jeps/460)
/// - JDK 23: [JEP 471 - Vector API (Eighth Incubator)](https://openjdk.org/jeps/471)
/// - JDK 24: [JEP 477 - Vector API (Ninth Incubator)](https://openjdk.org/jeps/477)
/// - JDK 25: [JEP 508 - Vector API (Tenth Incubator)](https://openjdk.org/jeps/508)
///
/// ### Further reading
/// - [Inside Java – Vector API Deep Dive](https://inside.java/)
///
/// @see jdk.incubator.vector.FloatVector
/// @see jdk.incubator.vector.VectorSpecies

public class VectorApiDemo implements IDemo {

    // VectorSpecies defines the shape of SIMD vectors (e.g., length and type)
    private static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;

    @Override
    public void demo() {
        info(508);

        System.out.println("=== Vector API Demo ===");

        float[] a = new float[SPECIES.length()];
        float[] b = new float[SPECIES.length()];
        float[] c = new float[SPECIES.length()];

        // Initialize arrays
        for (int i = 0; i < SPECIES.length(); i++) {
            a[i] = i + 1;
            b[i] = (i + 1) * 10;
        }

        // Load arrays into SIMD vectors
        var va = FloatVector.fromArray(SPECIES, a, 0);
        var vb = FloatVector.fromArray(SPECIES, b, 0);

        // Vectorized addition
        var vc = va.add(vb);

        // Store result back into array
        vc.intoArray(c, 0);

        // Print results
        System.out.println("Vector length: " + SPECIES.length());
        System.out.print("a: "); printArray(a);
        System.out.print("b: "); printArray(b);
        System.out.print("c = a + b: "); printArray(c);

        System.out.println("\nExplanation:");
        System.out.println("- The Vector API performs SIMD operations on arrays.");
        System.out.println("- JEP 508 is the 10th incubator of this API in JDK 25.");
        System.out.println("- Compare performance with normal loops to see gains.");
    }

    private static void printArray(float[] arr) {
        for (float v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }
}

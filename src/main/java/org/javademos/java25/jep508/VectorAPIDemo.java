package org.javademos.java25.jep508;

import org.javademos.commons.IDemo;
import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorSpecies;

import java.util.Random;

/// Demo for JDK 25 feature **Vector API (Tenth Incubator)**.
///
/// The status in Java 25 is INCUBATOR 
///  => JVM option `--add-modules=jdk.incubator.vector` is required to use it.
///
/// The reason for this feature stays in the incubating phase is that it is waiting
/// until necessary features of [Project Valhalla](https://openjdk.org/projects/valhalla/) 
/// become available as preview features.
///
/// ### JEP history
/// - JDK 25: [JEP 508 - Vector API (Tenth Incubator)](https://openjdk.org/jeps/508)
/// - JDK 24: [JEP 489 - Vector API (Ninth Incubator)](https://openjdk.org/jeps/489)
/// - JDK 23: [JEP 469 - Vector API (Eighth Incubator)](https://openjdk.org/jeps/469)
/// - JDK 22: [JEP 460 - Vector API (Seventh Incubator)](https://openjdk.org/jeps/460)
/// - JDK 21: [JEP 448 - Vector API (Sixth Incubator)](https://openjdk.org/jeps/448)
/// - JDK 20: [JEP 438 - Vector API (Fifth Incubator)](https://openjdk.org/jeps/438)
/// - JDK 19: [JEP 426 - Vector API (Fourth Incubator)](https://openjdk.org/jeps/426)
/// - JDK 18: [JEP 417 - Vector API (Third Incubator)](https://openjdk.org/jeps/417)
/// - JDK 17: [JEP 414 - Vector API (Second Incubator)](https://openjdk.org/jeps/414)
/// - JDK 16: [JEP 338 - Vector API (Incubator)](https://openjdk.org/jeps/338)
///
/// ### Further reading
/// - [Baeldung - Java Vector API](https://www.baeldung.com/java-vector-api)
/// - [What’s New in Java 21? Meet the Vector API!](https://www.linkedin.com/pulse/whats-new-java-21-meet-vector-api-alexey-iyunski/)
/// - [Java 18 Vector API: Do We Get Free Speed Up?](https://medium.com/@Styp/java-18-vector-api-do-we-get-free-speed-up-c4510eda50d2)
///
/// @see jdk.incubator.vector.FloatVector
/// @see jdk.incubator.vector.VectorSpecies
///
/// @author Alois Seckar <alois.seckar@gmail.com>
public class VectorAPIDemo implements IDemo {

    // VectorSpecies defines the shape of SIMD vectors (e.g., length and type)
    private static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_MAX;

    private static final int MAX_ITEMS = 100000000;

    @Override
    public void demo() {
        info(508);

        // demo task - calculating mass of a random rectangular prism - 100M times

        try {
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
        } catch (OutOfMemoryError _) {
            System.err.println("ERROR: Not enough memory to run this demo. Consider allocating more.");
        }
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

package org.javademos.java23.jep460;

import org.javademos.commons.IDemo;

/// Demo for JDK 23 feature **Vector API (Seventh Incubator)** (JEP 460)
///
/// JEP history:
/// - JDK 23: [JEP 460 - Vector API (Seventh Incubator)](https://openjdk.org/jeps/460)
///
/// Further reading:
/// - [JEP 460](https://openjdk.org/jeps/460)
/// - [Vector API documentation](https://openjdk.org/projects/amber/vector)
///
/// @see jdk.incubator.vector.VectorSpecies
/// @author alois.seckar@gmail.com
public class JEP460VectorApiDemo implements IDemo {
    @Override
    public void demo() {
        info(460);
        // Simple demo: add two float arrays using Vector API
        // Requires JVM option: --add-modules jdk.incubator.vector
        float[] a = {1.0f, 2.0f, 3.0f, 4.0f};
        float[] b = {5.0f, 6.0f, 7.0f, 8.0f};
        float[] result = new float[a.length];

        var species = jdk.incubator.vector.FloatVector.SPECIES_128;
        int i = 0;
        for (; i < species.length(); i += species.length()) {
            var va = jdk.incubator.vector.FloatVector.fromArray(species, a, i);
            var vb = jdk.incubator.vector.FloatVector.fromArray(species, b, i);
            var vr = va.add(vb);
            vr.intoArray(result, i);
        }
        System.out.println("Result of vector addition:");
        for (float v : result) {
            System.out.print(v + " ");
        }
        System.out.println();
    }
}

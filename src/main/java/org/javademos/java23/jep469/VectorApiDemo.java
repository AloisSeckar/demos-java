package org.javademos.java23.jep469;

import org.javademos.commons.IDemo;
import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorSpecies;

/**
 * Demo for JDK 23 feature **Vector API (Eighth Incubator)** (JEP 469)
 *
 * JEP history:
 * - JDK 23 (eighth incubator): [JEP 469 - Vector API (Eighth Incubator)](https://openjdk.org/jeps/469)
 *
 * Further reading:
 * - [JEP 469](https://openjdk.org/jeps/469)
 *
 * NOTE: This is an incubator feature; run with --add-modules jdk.incubator.vector
 *
 * @author Saiyam Arora
 */
public class VectorApiDemo implements IDemo {

    @Override
    public void demo() {
        info(469);

        System.out.println("➡️ Vector API Demo: Adding two float arrays using Vector API");

        float[] a = {1.0f, 2.0f, 3.0f, 4.0f};
        float[] b = {5.0f, 6.0f, 7.0f, 8.0f};
        float[] result = new float[a.length];

        VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;
        for (int i = 0; i < a.length; i += SPECIES.length()) {
            var mask = SPECIES.indexInRange(i, a.length);
            var va = FloatVector.fromArray(SPECIES, a, i, mask);
            var vb = FloatVector.fromArray(SPECIES, b, i, mask);
            var vc = va.add(vb);
            vc.intoArray(result, i, mask);
        }

        System.out.println("✅ Result:");
        for (float r : result) {
            System.out.println(r);
        }
    }
}

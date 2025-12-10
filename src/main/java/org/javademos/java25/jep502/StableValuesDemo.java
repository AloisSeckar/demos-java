package org.javademos.java25.jep502;

import org.javademos.commons.IDemo;

/// Demo for JDK 25 feature JEP 502 - Stable Values (Preview).
///
/// ### JEP history
/// - JDK 25: [JEP 502 - Stable Values (Preview)](https://openjdk.org/jeps/502)  
///
/// ### Further reading
/// - [JEP 502 - Stable Values. New Feature of Java 25 Explained](https://softwaremill.com/jep-502-stable-values-new-feature-of-java-25-explained/)
///
/// @author @CodeSakshamY / alois.seckar@gmail.com
public class StableValuesDemo implements IDemo {

    // stable value variable can be announced as "final", but not initialized immediately
    private static final StableValue<int[]> STABLE_ARRAY = StableValue.of();

    // the initialization can happen ONCE at the first time when values are requested
    // "orElseSet" accepts a lambda supplier function to initialize the stable value with data
    public static int[] getValues() {
        return STABLE_ARRAY.orElseSet(() -> new int[]{10, 20, 30, 40, 50});
    }

    @Override
    public void demo() {
        info(502);

        System.out.print("Stable array contents: ");

        // here we ask for the stable values for the first time during runtime
        for (int val : getValues()) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}

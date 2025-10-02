package org.javademos.java25.jep502;

import org.javademos.commons.IDemo;

/// Demo for JDK 25 feature **Stable Values (Preview)** (JEP 502)
///
/// ### JEP history
/// - JDK 25: [JEP 502 - Stable Values (Preview)](https://openjdk.org/jeps/502)  
///
/// ### Further reading
/// - [Inside Java – Stable Values Preview](https://inside.java/)
///
/// @see jdk.internal.vm.annotation.Stable
public class StableValuesDemo implements IDemo {

    // A stable value example: a cached, immutable array
    @jdk.internal.vm.annotation.Stable
    private static final int[] STABLE_ARRAY = {1, 2, 3, 4, 5};

    @Override
    public void demo() {
        info(502);

        System.out.println("=== Stable Values Demo (Preview) ===");

        System.out.print("Stable array contents: ");
        for (int val : STABLE_ARRAY) {
            System.out.print(val + " ");
        }
        System.out.println();

        System.out.println("\nExplanation:");
        System.out.println("- @Stable annotation hints JVM that this field won't change once set.");
        System.out.println("- Enables optimizations like constant folding & caching.");
        System.out.println("- In JDK 25, this concept is introduced as a preview feature.");
    }
}

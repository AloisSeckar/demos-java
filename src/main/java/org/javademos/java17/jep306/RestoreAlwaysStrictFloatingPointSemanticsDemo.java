package org.javademos.java17.jep306;

import org.javademos.commons.IDemo;

/// Demo for JDK 17 feature JEP 306 - Restore Always-Strict Floating-Point Semantics.
///
/// JEP history:
/// - JDK 17: [JEP 306 - Restore Always-Strict Floating-Point Semantics](https://openjdk.org/jeps/306)
///
/// Further reading:
/// - [Restore Always-Strict Floating-Point Semantics](https://openjdk.org/jeps/306)
///
/// @author Alexander Schneider @ab-schneider
public class RestoreAlwaysStrictFloatingPointSemanticsDemo implements IDemo {
    @Override
    public void demo() {
        info(306);

        System.out.println("Use of 'strictfp' modifier will produce a compile time warning: ");
        System.out.println("as of release 17, all floating-point expressions are evaluated strictly and 'strictfp' is not required");

        // Before JDK 17, the default floating-point evaluation could keep wider intermediates (e.g., x87 80-bit).
        // Marking code with 'strictfp' modifier forced strict IEEE-754 evaluation,
        // avoiding those extended intermediates. As a result, the same program could produce
        // bit-different results across machines/JVMs if it did NOT use 'strictfp'.
        //
        // Since JDK 17, all floating-point expressions are strict by default,
        // so adding 'strictfp' no longer changes numerical results. If you *do* write 'strictfp',
        // javac will warn it's unnecessary when compiled

        compute();
    }

    // Before JDK 17 to use strict floating-point instead of default 'strictfp' modifier was necessary
    //
    // public strictfp double strictCompute() {
    //    ...
    // }

    public double compute() {
        var s = 0.0;
        for (int i = 0; i < 1_000; i++) {
            s += Math.sin(i);
        }
        return s;
    }
}

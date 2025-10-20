package org.javademos.java18.jep416;

import org.javademos.commons.IDemo;

import java.lang.reflect.Method;

/// Demo for JDK 18 feature JEP 416 - Reimplement Core Reflection with Method Handles.
///
/// This JEP provides an internal-only reimplementation of the Core Reflection API. The underlying
/// mechanisms for `java.lang.reflect.Method`, `Constructor`, and `Field` were replaced to use
/// `java.lang.invoke` method handles. This change unifies the reflective mechanisms in the platform,
/// reducing maintenance costs and simplifying future development (e.g., for Project Valhalla).
/// The public API for reflection remains completely unchanged.
///
/// JEP history:
/// - [JEP 416: Reimplement Core Reflection with Method Handles](https://openjdk.org/jeps/416)
///
/// @author Harshit Kumar
public class CoreReflectionWithMethodHandles implements IDemo {

    /**
     * A static final Method object allows the JIT compiler to perform "constant-folding",
     * which leads to significant optimization with the new Method Handle-based implementation.
     * Storing reflective objects in this way is the key to unlocking the performance benefits of JEP 416.
     */
    private static final Method GREET_METHOD_CONST;

    static {
        try {
            // Initialize the constant Method object once.
            GREET_METHOD_CONST = MyTarget.class.getMethod("greet");
        } catch (NoSuchMethodException e) {
            // This is not expected to fail in a controlled demo.
            throw new RuntimeException("Failed to initialize reflective method", e);
        }
    }

    @Override
    public void demo() {
        info(416);

        // This demo illustrates the performance implications of JEP 416.
        // There are no new APIs to show, as this was purely an internal reimplementation.
        //
        // The key takeaway is that reflection can be significantly faster when the Method,
        // Constructor, or Field object is a constant (e.g., stored in a static final field).
        // This allows the JIT to heavily optimize the call. When it's not a constant,
        // the performance might be slightly slower than the old implementation.
        //
        // Let's run a simplified test to see the difference.
        // (Note: This is not a formal benchmark, just an illustration!)
        System.out.println("Running a comparison between constant-folded and variable reflection...");

        MyTarget target = new MyTarget();
        int iterations = 15_000_000; // Use enough iterations to highlight the difference.

        // --- Case 1: Constant-folded Method ---
        long startConst = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            try {
                GREET_METHOD_CONST.invoke(target);
            } catch (Exception e) {
                // Suppress for demo purposes.
            }
        }
        long endConst = System.nanoTime();
        System.out.printf("Constant-folded `Method.invoke()` time: %d ms%n", (endConst - startConst) / 1_000_000);

        // --- Case 2: Variable (non-constant) Method ---
        long startVar = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            try {
                // Fetch the method inside the loop to prevent JIT from optimizing it away.
                Method greetMethodVar = MyTarget.class.getMethod("greet");
                greetMethodVar.invoke(target);
            } catch (Exception e) {
                // Suppress for demo purposes.
            }
        }
        long endVar = System.nanoTime();
        System.out.printf("Variable (non-constant) `Method.invoke()` time: %d ms%n", (endVar - startVar) / 1_000_000);

        System.out.println("\nAs shown, using a `static final Method` is dramatically faster with the new implementation.");
    }

    /**
     * A simple target class for our reflection calls.
     */
    static class MyTarget {
        public void greet() {
            // The method body is intentionally empty. We want to measure the
            // invocation overhead, not the work done by the method itself.
        }
    }
}
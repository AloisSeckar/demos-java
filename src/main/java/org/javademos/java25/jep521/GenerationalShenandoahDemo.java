package org.javademos.java25.jep521;

import org.javademos.commons.IDemo;

/// Demo for JDK 25 feature **Generational Shenandoah** (JEP 521)
///
/// ### JEP History
/// - JDK 12: [JEP 189 - Shenandoah: A Low-Pause-Time GC (Experimental)](https://openjdk.org/jeps/189)  
/// - JDK 15: [JEP 379 - Shenandoah: Production-Ready](https://openjdk.org/jeps/379)  
/// - JDK 25: [JEP 521 - Generational Shenandoah](https://openjdk.org/jeps/521)  
///
/// ### Further reading
/// - [Inside Java - Shenandoah GC](https://inside.java/tag/shenandoah/)
///
/// @see java.lang.System
public class GenerationalShenandoahDemo implements IDemo {

    @Override
    public void demo() {
        info(521);

        System.out.println("=== Generational Shenandoah Demo ===");

        System.out.println("This demo simulates object allocation to trigger GC activity.");
        System.out.println("Run with JVM options to enable Shenandoah:");
        System.out.println("  -XX:+UseShenandoahGC -XX:+UnlockExperimentalVMOptions -XX:+UseShenandoahGenerational\n");

        // Simulate GC pressure
        try {
            for (int i = 0; i < 10; i++) {
                byte[][] allocations = new byte[1000][];
                for (int j = 0; j < allocations.length; j++) {
                    allocations[j] = new byte[1024 * 100]; // 100 KB blocks
                }
                System.out.println("Iteration " + i + " completed allocations.");
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nExplanation:");
        System.out.println("- Shenandoah GC focuses on reducing pause times.");
        System.out.println("- Generational Shenandoah improves performance by separating short-lived and long-lived objects.");
        System.out.println("- Short-lived objects are collected faster in the young generation.");
        System.out.println("- Long-lived objects remain in the old generation with less frequent scans.");
        System.out.println("\nTip: Use `-Xlog:gc*` to observe GC behavior in the logs.");
    }
}

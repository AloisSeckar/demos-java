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

        // Print JVM info (helps see which GC is running)
        System.out.println("Running JVM: " + System.getProperty("java.vm.name"));
        System.out.println("JVM Info: " + System.getProperty("java.vm.info"));
        System.out.println("Java Version: " + System.getProperty("java.version") + "\n");

        System.out.println("➡ Run with different JVM flags to compare:");
        System.out.println("  G1GC (default): java -Xmx512m GenerationalShenandoahDemo");
        System.out.println("  Shenandoah GC: java -XX:+UseShenandoahGC GenerationalShenandoahDemo");
        System.out.println("  Generational Shenandoah: java -XX:+UseShenandoahGC "
                + "-XX:+UnlockExperimentalVMOptions -XX:+UseShenandoahGenerational GenerationalShenandoahDemo\n");

        // -------------------------------------------------
        // Allocation pressure benchmark
        System.out.println("=== Allocation Pressure Test ===");
        Runtime runtime = Runtime.getRuntime();

        try {
            long beforeUsed = runtime.totalMemory() - runtime.freeMemory();
            long start = System.currentTimeMillis();

            for (int round = 1; round <= 5; round++) {
                byte[][] allocations = new byte[2000][];
                for (int i = 0; i < allocations.length; i++) {
                    allocations[i] = new byte[128 * 1024]; // 128 KB blocks
                }
                System.out.printf("Round %d: Allocated %,d objects%n", round, allocations.length);
                Thread.sleep(300);
            }

            long end = System.currentTimeMillis();
            long afterUsed = runtime.totalMemory() - runtime.freeMemory();

            System.out.printf("%nApprox memory used: %.2f MB%n",
                    (afterUsed - beforeUsed) / (1024.0 * 1024.0));
            System.out.printf("Elapsed time: %d ms%n", (end - start));

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // -------------------------------------------------
        // Explanation
        System.out.println("\nExplanation:");
        System.out.println("- Shenandoah GC minimizes pause times by concurrent compaction.");
        System.out.println("- Generational Shenandoah separates short-lived and long-lived objects.");
        System.out.println("- Young gen: frequent, fast collections.");
        System.out.println("- Old gen: infrequent, reducing overhead.");
        System.out.println("\n➡ Compare GC logs with:");
        System.out.println("   -Xlog:gc*");
    }
}

package org.javademos.java25.jep521;

import org.javademos.commons.IDemo;
import java.lang.management.ManagementFactory;
import java.lang.management.GarbageCollectorMXBean;
import java.util.List;

/// Demo for JDK 25 feature **Generational Shenandoah** (JEP 521)
///
/// ### JEP History
/// - JDK 25: [JEP 521 - Generational Shenandoah](https://openjdk.org/jeps/521)  
/// - JDK 15: [JEP 379 - Shenandoah: Production-Ready](https://openjdk.org/jeps/379)  
/// - JDK 12: [JEP 189 - Shenandoah: A Low-Pause-Time GC (Experimental)](https://openjdk.org/jeps/189)  
///
/// ### Further reading
/// - [Inside Java - Shenandoah GC](https://inside.java/tag/shenandoah/)
///
/// @see java.lang.System
/// @author your-github
public class GenerationalShenandoahDemo implements IDemo {

    @Override
    public void demo() {
        info(521);

        System.out.println("=== Generational Shenandoah Demo ===\n");

        // Print basic JVM and GC info
        System.out.println("JVM: " + System.getProperty("java.vm.name"));
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("Detected Garbage Collectors:");

        List<GarbageCollectorMXBean> gcs = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gc : gcs) {
            System.out.println(" - " + gc.getName());
        }

        System.out.println("\nRunning allocation workload...");

        // Allocate large numbers of short-lived objects to exercise the GC
        Runtime runtime = Runtime.getRuntime();
        long beforeUsed = runtime.totalMemory() - runtime.freeMemory();

        long start = System.currentTimeMillis();
        for (int round = 1; round <= 5; round++) {
            byte[][] allocations = new byte[2000][];
            for (int i = 0; i < allocations.length; i++) {
                allocations[i] = new byte[128 * 1024]; // 128 KB blocks
            }
            System.out.printf("Round %d completed%n", round);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        long end = System.currentTimeMillis();
        long afterUsed = runtime.totalMemory() - runtime.freeMemory();

        System.out.printf("%nApprox memory delta: %.2f MB%n",
                (afterUsed - beforeUsed) / (1024.0 * 1024.0));
        System.out.printf("Elapsed time: %d ms%n", (end - start));

        System.out.println("\nCompare output under:");
        System.out.println("  • G1GC (default)");
        System.out.println("  • Shenandoah GC");
        System.out.println("  • Generational Shenandoah (JEP 521)");
        System.out.println("Run with: -Xlog:gc* to observe collection behavior.");
    }
}

package org.javademos.java15.jep379;

import org.javademos.commons.IDemo;
import java.util.ArrayList;
import java.util.List;

/**
 * ## ☕ JEP 379: Shenandoah: A Low-Pause-Time Garbage Collector (Production)
 *
 * This JEP finalized the Shenandoah garbage collector, making it a production feature
 * in JDK 15. This meant the `-XX:+UnlockExperimentalVMOptions` flag was no longer
 * required to use it.
 *
 * Shenandoah is a **latency-focused** GC that performs most of its work, including
 * heap compaction, concurrently with the application threads.
 *
 * ### Key Benefits:
 * - **Low Pause Times:** GC pause times are consistently very short (often < 10ms).
 * - **Heap Size Independence:** Pause times are largely independent of the heap size.
 * This makes it ideal for applications with very large heaps (hundreds of GBs).
 *
 * ### History:
 * - **JEP 189 (JDK 12):** Shenandoah was first introduced as an *Experimental* feature.
 * - **JEP 379 (JDK 15):** Promoted Shenandoah to a *Production* feature.
 *
 * ### How to Run the Demo:
 * Since this feature is configured via JVM arguments, the demo primarily demonstrates
 * how to force some GC activity and prints the required flags.
 *
 * To run the main application with Shenandoah, you only need:
 * `java -XX:+UseShenandoahGC -Xms... -Xmx... -jar your-app.jar`
 *
 * @see <a href="https://openjdk.org/jeps/379">JEP 379</a>
 * @see <a href="https://openjdk.org/jeps/189">JEP 189 (Initial Introduction)</a>
 */
public class ShenandoahJEP379 implements IDemo {

    private static final int ALLOC_SIZE = 100_000_000; // Allocate 100MB per step
    private static final int GC_CYCLES = 5;            // Number of cycles to run

    @Override
    public void demo() {
        info(379);

        System.out.println("Shenandoah GC is primarily configured with JVM flags, not code.");
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("To use this collector (on a Java 15+ compatible JDK):");
        System.out.println("JVM Flags: -XX:+UseShenandoahGC -Xms4G -Xmx4G -Xlog:gc*=info:file=tmp/shenandoah_gc.log");
        System.out.println("  - NOTE: -Xms and -Xmx are recommended to be the same size.");
        System.out.println("--------------------------------------------------------------------------------------------------");

        try {
            System.out.println("Simulating a memory-stressing workload to trigger GC activity...");
            
            // Allocate objects to force GC cycles
            List<byte[]> allocationList = new ArrayList<>();
            for (int i = 0; i < GC_CYCLES; i++) {
                System.out.printf("Cycle %d: Allocating %d bytes (%.2fMB)...%n", 
                                  i + 1, ALLOC_SIZE, ALLOC_SIZE / 1024.0 / 1024.0);
                
                // Keep some objects alive (e.g., in a list)
                allocationList.add(new byte[ALLOC_SIZE]);
                
                // Allow some time for concurrent GC to run
                Thread.sleep(100); 
            }

            System.out.println("\nWorkload finished. Note: Shenandoah attempts to run concurrently.");
            System.out.println("The short pauses are only visible when running with GC logging enabled.");
            System.out.printf("Final allocated size kept alive: %.2fMB%n", 
                              allocationList.size() * ALLOC_SIZE / 1024.0 / 1024.0);

            // Important: Call System.gc() to try and trigger a full GC. 
            // The logs will show if Shenandoah runs a concurrent cycle or a Stop-The-World (STW) full GC.
            System.out.println("\nCalling System.gc()... (Shenandoah typically runs a concurrent cycle)");
            System.gc();
            
            // Clear the list to allow all memory to be reclaimed
            allocationList.clear(); 
            System.out.println("Cleared allocation list.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (OutOfMemoryError e) {
            System.err.println("!!! ERROR: Demo ran out of memory. Try increasing -Xmx size in your VM options. !!!");
        }
        
    }
}
package org.javademos.java12.jep346;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;

import org.javademos.commons.IDemo;

/// Demo for JDK 12 feature JEP 346 - Promptly Return Unused Committed Memory from G1.
///
/// JEP history:
/// - JDK 12: [JEP 346 - Promptly Return Unused Committed Memory from G1](https://openjdk.org/jeps/346)
///
/// Further reading:
/// - [JDK-8204089 - JEP 346: Promptly Return Unused Committed Memory from G1](https://bugs.openjdk.org/browse/JDK-8204089)
/// - [Garbage-First (G1) Garbage Collector tuning guide](https://docs.oracle.com/en/java/javase/21/gctuning/garbage-first-g1-garbage-collector1.html)
///
/// @author Alois Sečkár <alois.seckar@gmail.com>
public class PromptlyReturnMemoryG1 implements IDemo {
    private static final long MB = 1024 * 1024;

    @Override
    public void demo() {
        info(346);

        // No new API is needed: G1 returns idle heap memory to the OS on its own.
        // When the application is inactive, G1 triggers a periodic GC (`-XX:G1PeriodicGCInterval=<ms>`, 0 = disabled).
        // Periodic GCs run only if the system load average is below `-XX:G1PeriodicGCSystemLoadThreshold`
        // (ignored when 0). By default they are concurrent cycles (`-XX:+G1PeriodicGCInvokesConcurrent`).

        // Snapshot of the heap as seen by the JVM. "committed" is the memory reserved from the OS;
        // after idle periods it should shrink towards "used" once G1 uncommits unused regions.
        MemoryUsage heap = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        System.out.println("Heap used:      " + heap.getUsed() / MB + " MB");
        System.out.println("Heap committed: " + heap.getCommitted() / MB + " MB");
        System.out.println("Heap max:       " + heap.getMax() / MB + " MB");

        // To observe the feature, run the demo with periodic GCs enabled and GC logging on:
        // java -XX:+UseG1GC -XX:G1PeriodicGCInterval=3000 -Xlog:gc,gc+periodic -cp ... Main
        // Log lines are tagged with "(G1 Periodic Collection)".
    }
}

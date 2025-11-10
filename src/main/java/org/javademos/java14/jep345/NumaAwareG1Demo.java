package org.javademos.java14.jep345;

import org.javademos.commons.IDemo;

/// Demo for JDK 14 feature JEP 345 - NUMA-Aware Memory Allocation for G1.
///
/// This JEP improves G1 garbage collector performance on large multi-socket machines
/// by implementing NUMA (Non-Uniform Memory Access) aware memory allocation.
/// This allows the G1 GC to allocate memory from multiple NUMA nodes, improving
/// performance and memory locality for applications running on NUMA hardware.
///
/// JEP history:
/// - JDK 14: [JEP 345 - NUMA-Aware Memory Allocation for G1](https://openjdk.org/jeps/345)
///
/// Further reading:
/// - [JEP 345: NUMA-Aware Memory Allocation for G1](https://openjdk.org/jeps/345)
/// - [G1 Garbage Collector](https://docs.oracle.com/en/java/javase/14/gctuning/garbage-first-garbage-collector.html)
///
/// @author Abhineshhh
public class NumaAwareG1Demo implements IDemo {

    @Override
    public void demo() {
        info(345);

        // NUMA (Non-Uniform Memory Access) is a computer memory design used in
        // multi-processor systems where memory access time depends on the memory
        // location relative to the processor. In NUMA systems, a processor can
        // access its own local memory faster than non-local memory (memory local
        // to another processor or shared between processors).
        //
        // Before JEP 345 (Java 14):
        // - G1 GC allocated memory from a single NUMA node
        // - On multi-socket machines, this caused poor memory locality
        // - Remote memory access caused performance degradation
        // - The heap was not distributed across available NUMA nodes
        //
        // After JEP 345 (Java 14):
        // - G1 GC can allocate memory from multiple NUMA nodes
        // - Better memory locality for application threads
        // - Improved performance on NUMA hardware
        // - Automatic distribution of heap across NUMA nodes
        //
        // How to enable NUMA-aware memory allocation for G1:
        // Use the following JVM options:
        //
        //   -XX:+UseG1GC                    (Enable G1 Garbage Collector)
        //   -XX:+UseNUMA                    (Enable NUMA-aware allocations)
        //
        // Example command:
        //   java -XX:+UseG1GC -XX:+UseNUMA -Xms4g -Xmx4g MyApplication
        //
        // Benefits on NUMA systems:
        // 1. Improved throughput - threads access local memory more frequently
        // 2. Reduced latency - fewer remote memory accesses
        // 3. Better scalability - utilizes all NUMA nodes effectively
        // 4. Automatic optimization - no application code changes needed
        //
        // When to use:
        // - Running on multi-socket servers (2+ CPUs)
        // - Large heap sizes (several GB or more)
        // - Memory-intensive applications
        // - Applications with high allocation rates
        //
        // Notes:
        // - NUMA support requires underlying OS and hardware support
        // - The JVM must be running on a NUMA-capable system
        // - Use with Linux numactl or Windows NUMA API for best results
        // - Monitor with tools like numastat (Linux) to verify NUMA usage
        //
        // Example numactl command (Linux):
        //   numactl --interleave=all java -XX:+UseG1GC -XX:+UseNUMA MyApp
        //
        // Performance considerations:
        // - For small heaps (<4GB), NUMA awareness may not provide significant benefit
        // - For large heaps (>16GB) on multi-socket systems, can improve performance by 10-30%
        // - Thread affinity and memory locality are automatically managed by G1
        //
        // Compatibility:
        // - Works with all G1 GC features (concurrent marking, evacuation, etc.)
        // - Can be combined with other G1 tuning options
        // - No application code changes required
        //
        // To verify NUMA is active, check JVM logs with:
        //   -Xlog:gc+heap+numa=debug
        //
        // This will show NUMA node allocation information during GC cycles.

        System.out.println("\nNUMA-Aware G1 is a JVM-level optimization.");
        System.out.println("Enable with: -XX:+UseG1GC -XX:+UseNUMA");
    }
}

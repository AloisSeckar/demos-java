package org.javademos.java26.jep522;

import org.javademos.commons.IDemo;

/// Demo for JDK 26 feature JEP 522 - G1 GC: Improve Throughput by Reducing Synchronization
///
/// This JEP proposes to increase the application throughput
/// when using G1 garbage collector by reducing the amount of 
/// synchronization required between application threads 
/// and GC threads.
/// 
/// Further reading:
/// - [JEP 522: G1 GC: Improve Throughput by Reducing Synchronization](https://openjdk.org/jeps/522)
/// - [G1 Garbage Collector](https://docs.oracle.com/en/java/javase/25/gctuning/garbage-first-garbage-collector.html)
/// 
/// @author Shivansh-22866


public class ReduceSyncDemo implements IDemo {
    
    @Override
    public void demo() {
        info(522);
        
        // JEP 522 (JDK 26): G1 GC: Improve Throughput by Reducing Synchronization
        //
        // G1 (Garbage-First) GC is designed to provide a balance between
        // application throughput and predictable GC pause times. However,
        // G1 previously required significant synchronization between
        // application threads and GC refinement threads.
        //
        // Before JEP 522 (JDK 26):
        // - G1 used a card table to track references between heap regions
        // - Application threads updated the card table through write barriers
        // - Background refinement threads optimized the card table
        // - Application and refinement threads had to synchronize to avoid
        //   conflicting updates
        // - This synchronization made G1 write barriers relatively expensive
        // - The larger write barriers increased application overhead
        // - Applications that frequently modified object references could
        //   experience reduced throughput
        //
        // After JEP 522 (JDK 26):
        // - G1 introduces a second card table
        // - Application threads update the active card table without
        //   synchronization
        // - Refinement/optimizer threads work on the other card table
        // - G1 atomically swaps the card tables when necessary
        // - Application threads can then continue using the newly active
        //   empty card table
        // - Refinement threads can process the previously active table
        //   without interfering with application threads
        // - G1 write barriers become simpler and faster
        //
        // When G1 determines that scanning the active card table could take
        // longer than the configured pause-time goal, it atomically swaps
        // the two card tables.
        //
        // After the swap:
        // - Application threads use the newly empty card table
        // - Refinement threads process the previously active card table
        // - No fine-grained synchronization is required between them
        //
        // Benefits:
        // 1. Improved throughput - less synchronization overhead between
        //    application and GC threads
        // 2. Faster write barriers - application write barriers contain
        //    significantly less code
        // 3. Better latency - GC spends less time coordinating with
        //    application threads
        // 4. Better scalability - application and refinement threads can
        //    operate more independently
        // 5. No application changes - the optimization is internal to G1
        //
        // Write barrier improvement:
        // - On x64, G1 write barriers are reduced from around 50 instructions
        //   to approximately 12 instructions
        // - Simpler barriers also give the JIT compiler more opportunities
        //   for optimization
        //
        // Performance:
        // - Applications that frequently modify object-reference fields
        //   can see throughput improvements of approximately 5-15%
        // - Applications that do not heavily modify object references can
        //   still see improvements of up to around 5%
        // - GC pause times can also decrease slightly
        //
        // Memory considerations:
        // - The second card table requires additional native memory
        // - Each card table uses approximately 0.2% of Java heap capacity
        // - This corresponds to roughly 2 MB of native memory per 1 GB
        //   of Java heap capacity
        // - The additional memory is considered a reasonable trade-off
        //   for the throughput improvements
        //
        // When to expect the most benefit:
        // - Applications with high object-reference update rates
        // - Applications with high allocation rates
        // - Large, multi-threaded applications
        // - Workloads where G1 throughput is important
        // - Applications where G1 write-barrier overhead is significant
        //
        // Compatibility:
        // - Available with G1 GC in JDK 26 and later
        // - No application code changes are required
        // - No new user-facing GC mode needs to be selected
        // - Existing G1 tuning options remain applicable
        //
        // The existing G1 concurrent refinement controls remain the same as 
        // it is assumed to cover all necessarty use cases:
        //
        //   -XX:-G1UseConcRefinement
        //   -XX:G1ConcRefinementThreads=<number>

        System.out.println("\nJEP 522 improves G1 throughput by reducing synchronization.");
        System.out.println("Available in JDK 26+ with G1 GC.");
        System.out.println("G1 now uses two card tables to reduce write-barrier overhead.");


    }
}

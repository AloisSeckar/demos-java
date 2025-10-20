package org.javademos.java24.jep475;

import org.javademos.commons.IDemo;

/// Demo for JDK 24 feature JEP 475 - Late Barrier Expansion for G1.
///
/// Internal JVM enhancement to reduce compilation overhead and improve maintainability
/// by deferring G1 GC barrier expansion to the code emission phase.
///
/// @see <a href="https://openjdk.org/jeps/475">JEP 475</a>
/// @author Shivansh @Shivansh-22866

public class LateBarrierExpansionG1 implements IDemo {

    @Override
    public void demo() {
        info(475);

        // Since this is a GC/compiler-internal change, we cannot demonstrate it
        // with executable Java code. Instead, we explain the behavior here.


        // This JEP changes when G1 Garbage Collector write/read barriers are expanded during JIT compilation.
        
        // Previously:
        //   - Barriers were expanded early, during bytecode-to-IR phase
        //   - Resulted in 10–20% extra C2 compilation overhead
        //   - Required deep knowledge of C2 compiler internals

        // Now:
        //   - Barriers are expanded late, at code emission stage
        //   - Reduces C2 workload
        //   - Simplifies GC development
        //   - Reuses existing interpreter assembly barrier code

        // Benefits:
        //   - Better performance in C2 compilation
        //   - Easier to maintain and evolve GC barriers
        //   - Lower complexity for future barrier optimizations

        // Limitations:
        //   - No direct way to observe this in regular Java apps
        //   - Testing/benchmarking is internal to HotSpot/JVM developers

    }
}

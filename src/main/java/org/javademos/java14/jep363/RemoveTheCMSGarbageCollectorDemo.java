package org.javademos.java14.jep363;

import org.javademos.commons.IDemo;

/// Demo for JDK 14 feature JEP 363 - Remove the Concurrent Mark Sweep (CMS) Garbage Collector.
///
/// JEP history:
/// - JDK 14: [JEP 363 - Remove the Concurrent Mark Sweep (CMS) Garbage Collector](https://openjdk.org/jeps/363)
/// - JDK 9: [JEP 291 - Deprecate the Concurrent Mark Sweep (CMS) Garbage Collector](https://openjdk.org/jeps/291)
///
/// @author yuuuuuuyu

public class RemoveTheCMSGarbageCollectorDemo implements IDemo {
    @Override
    public void demo() {
        info(363);

        // The Concurrent Mark Sweep (CMS) garbage collector was a low-pause GC
        // designed for applications requiring shorter stop-the-world times.
        // It performed part of its mark-and-sweep phases concurrently with
        // running application threads.
        //
        // However, CMS had several drawbacks:
        // - High maintenance cost and complex code base in HotSpot.
        // - Fragmentation issues due to the non-compacting nature of CMS.
        // - Poor scalability and unpredictable long pauses on large heaps.
        //
        // Because modern GCs like G1 (JEP 248), ZGC (JEP 333), and Shenandoah
        // offer better latency and throughput characteristics,
        // CMS was first deprecated in JDK 9 (JEP 291) and completely removed
        // in JDK 14 under JEP 363.
        //
        // As of JDK 14 and later, the JVM ignores the option
        // "-XX:+UseConcMarkSweepGC" and prints a warning message instead:
        // "Ignoring option UseConcMarkSweepGC; support was removed in 14.0"
        //
        // e.g. (jdk 11) `java -XX:+UseConcMarkSweepGC -version`
        // result:
        //      OpenJDK 64-Bit Server VM warning: Option UseConcMarkSweepGC was deprecated in version 9.0 and will likely be removed in a future release.
        //      openjdk version "11.0.28" 2025-07-15 LTS
        //      OpenJDK Runtime Environment Microsoft-11913448 (build 11.0.28+6-LTS)
        //      OpenJDK 64-Bit Server VM Microsoft-11913448 (build 11.0.28+6-LTS, mixed mode, sharing)
        //
        // e.g. (jdk 17, 25) `java -XX:+UseConcMarkSweepGC -version`
        // result:
        //      Unrecognized VM option 'UseConcMarkSweepGC'
        //      Error: Could not create the Java Virtual Machine.
        //      Error: A fatal exception has occurred. Program will exit
        //
        // Developers migrating from older Java versions should replace CMS
        // with modern collectors such as:
        //   - G1GC (default since JDK 9)
        //   - ZGC for ultra-low latency workloads
        //   - Shenandoah for concurrent compaction
        //
        // No source-level code changes are required — only JVM options and
        // performance tuning scripts need to be updated when upgrading.
    }
}

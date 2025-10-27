package org.javademos.java15.jep377;

import org.javademos.commons.IDemo;

/// Demo for JDK 15 feature JEP 377 – ZGC: A Scalable Low-Latency Garbage Collector.
///
/// JEP history:
/// - JDK 15: [JEP 377 - ZGC: A Scalable Low-Latency Garbage Collector](https://openjdk.org/jeps/377)
/// - JDK 11: [JEP 333 - ZGC: A Scalable Low-Latency Garbage Collector (Experimental)](https://openjdk.org/jeps/333)
///
/// Further reading:
/// - [Java ZGC Overview](https://www.baeldung.com/jvm-zgc)
/// - [Inside Java – The Z Garbage Collector](https://inside.java/2020/06/29/zgc-production/)
///
/// @author  wassef

public class ZGarbageCollectorDemo  implements IDemo {

    @Override
    public void demo() {
        info(377);

        // ZGC (Z Garbage Collector) is a scalable, low-latency garbage collector
        // introduced experimentally in Java 11 (JEP 333) and promoted to production
        // in Java 15 (JEP 377).

        // Its design goal is to keep GC pause times consistently under 10 ms,
        // regardless of heap size — even for multi-terabyte heaps.
        // To achieve this, ZGC performs all heavy operations (marking, relocation,
        // and remapping) concurrently with the running application threads.

        // Core characteristics:
        // - Pause times: typically < 10 ms, independent of heap size
        // - Scalable: supports heaps up to multiple TB
        // - Compacting: prevents fragmentation while staying concurrent
        // - Load-barrier based, using “colored pointers” to track object state

        // Suitable for:
        // - Latency-sensitive systems (e.g. trading, analytics)
        // - Applications requiring large heaps and predictable response times

        // --- Usage examples ---

        // Enable ZGC (basic):
        //   java -XX:+UseZGC -Xmx4g -Xms4g -jar myapp.jar

        // Enable detailed GC logging:
        //   java -XX:+UseZGC -Xlog:gc* -jar myapp.jar

        // Optional tuning flags:
        //   -XX:SoftMaxHeapSize=2g     # soft heap limit for adaptive resizing
        //   -Xlog:gc+heap=debug        # show region allocation details

        // Supported platforms (as of JDK 15):
        //   • Linux/x64
        //   • Windows/x64
        //   • macOS/x64
        //   • Linux/AArch64
    }
}

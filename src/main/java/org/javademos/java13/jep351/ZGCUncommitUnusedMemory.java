package org.javademos.java13.jep351;

import org.javademos.commons.IDemo;

/// Demo for JDK 13 feature JEP 351 - ZGC: Uncommit Unused Memory (Experimental).
///
/// JEP history:
/// - JDK 13: [JEP 351 - ZGC: Uncommit Unused Memory (Experimental)](https://openjdk.org/jeps/351)
///
/// Further reading:
/// - [JEP 333 - ZGC: A Scalable Low-Latency Garbage Collector (Experimental)](https://openjdk.org/jeps/333)
/// - [JEP 377 - ZGC: A Scalable Low-Latency Garbage Collector (Production)](https://openjdk.org/jeps/377)
/// - [The Z Garbage Collector (OpenJDK wiki)](https://wiki.openjdk.org/display/zgc/Main)
///
/// @author alois.seckar@gmail.com
public class ZGCUncommitUnusedMemory implements IDemo {
    @Override
    public void demo() {
        info(351);

        // ZGC garbage collector was introduced as an experimental feature by JEP 333 (Java 11).
        // Until JEP 351, ZGC never returned ("uncommitted") heap memory to the operating
        // system, even if it remained unused for a long time. Other HotSpot collectors
        // such as G1 and Shenandoah already could do that.

        // Keeping memory reserved is wasteful especially in:
        // - container environments where resources are paid by use
        // - environments where an application stays idle for long periods
        //   while competing for resources with other applications
        // - applications whose heap needs vary (e.g. big at startup, smaller later)

        // The ZGC heap consists of regions called "ZPages". When the heap is compacted,
        // freed ZPages are put into a page cache (ZPageCache), ready to be reused for
        // new allocations. The cache keeps ZPages in least-recently-used (LRU) order,
        // so the unused memory can be returned to the OS simply by evicting pages
        // which sat in the cache for too long and uncommitting their memory.

        // The policy is a simple timeout, configurable via command line:
        //   java -XX:+UnlockExperimentalVMOptions -XX:+UseZGC -XX:ZUncommitDelay=<seconds> ...
        // The default delay is 300 seconds (5 minutes).
        // The uncommit capability is enabled by default and can be turned off via:
        //   -XX:-ZUncommit

        // ZGC never uncommits memory below the minimum heap size (-Xms). Therefore,
        // setting -Xms equal to -Xmx effectively disables the feature as well.

        // On Linux, the feature requires fallocate(2) with FALLOC_FL_PUNCH_HOLE
        // support (Linux 3.5+ for tmpfs, 4.3+ for hugetlbfs). On older kernels,
        // ZGC works as before, only without the uncommit capability.

        // ZGC (including this capability) became production-ready in JDK 15 (JEP 377),
        // so -XX:+UnlockExperimentalVMOptions is no longer needed since then.
    }
}

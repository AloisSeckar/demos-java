package org.javademos.java21.jep439;

import org.javademos.commons.IDemo;

/// Demo for JDK 21 feature **JEP 439 - Generational ZGC**.
///
/// JEP history:
/// - JDK 21: [JEP 439 - Generational Mode by Default](https://openjdk.org/jeps/439)
///
/// Further reading:
/// - [Introducing Generational ZGC](https://inside.java/2023/11/28/gen-zgc-explainer/)
///
/// @author alois.seckar@gmail.com
public class GenerationalZGC21 implements IDemo {
    @Override
    public void demo() {
        info(439);

        // ZGC garbage collector was introduced by JEP 333 (Java 11) and made
        // production-ready via JEP 377 (Java 15).
        // This is the further evolution - Generational ZGC.
        // It can be turned on via `-XX:+UseZGC -XX:+ZGenerational`.

        // ZGC is intended to manage very large memory heaps (up to 16TB) with low
        // latency achieved by strong concurrency in exchange for consuming relatively
        // more CPU. Generational ZGC optimization is based on dividing the heap into
        // "young" and "old" generation. New objects appear in "young" generation,
        // which is small and more frequently scanned. Most objects do exists only
        // for a short period of time. After some time of existence, persisting objects
        // are moved into "old" generation. It is more probable they will last longer,
        // so garbage collecting may be performed in longer intervals.

        // This helps to utilize CPU time more effectively, leaving more for the app
        // itself, which improves throughput and latency. Generational ZGC is especially
        // effective in preventing allocation stalls (may happen when the rate of new
        // object allocation is faster than the rate of memory reclaiming).

    }
}

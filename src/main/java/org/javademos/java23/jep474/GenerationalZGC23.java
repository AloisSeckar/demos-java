package org.javademos.java23.jep474;

import org.javademos.commons.IDemo;

/// Demo for JDK 23 feature JEP 474 - ZGC: Generational Mode by Default.
///
/// JEP history:
/// - JDK 23: [JEP 474 - Generational Mode by Default](https://openjdk.org/jeps/474)
///
/// Further reading:
/// - [Generational Mode Now Standard for ZGC in Java](https://www.infoq.com/news/2024/05/java-zgc-update/)
/// - [Introducing Generational ZGC](https://inside.java/2023/11/28/gen-zgc-explainer/)
///
/// @author alois.seckar@gmail.com
public class GenerationalZGC23 implements IDemo {
    @Override
    public void demo() {
        info(474);

        // ZGC garbage collector was introduced by JEP 333 (Java 11) and made
        // production-ready via JEP 377 (Java 15).
        // Further evolution - Generational ZGC - appeared in JEP 439 (Java 21).
        // Now this mode is being marked default in favor over the older solution.
        // Non-generational mode is now deprecated and has to be explicitly turned
        // on via `-XX:+UseZGC -XX:-ZGenerational` (will show warnings).
        // It will be removed in JDK 24 (see JEP 490).

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

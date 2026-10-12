package org.javademos.java16.jep376;

import org.javademos.commons.IDemo;

/// Demo for JDK 16 feature JEP 376 - ZGC: Concurrent Thread-Stack Processing.
///
/// JEP history:
/// - JDK 16: [JEP 376 - ZGC: Concurrent Thread-Stack Processing](https://openjdk.org/jeps/376)
///
/// Further reading:
/// - [ZGC | What's new in JDK 16](https://malloc.se/blog/zgc-jdk16)
/// - [ZGC wiki](https://wiki.openjdk.org/display/zgc/Main)
///
/// @author alois.seckar@gmail.com
public class ConcurrentThreadStackProcessingDemo implements IDemo {
    @Override
    public void demo() {
        info(376);

        // ZGC garbage collector was introduced by JEP 333 (Java 11) and made
        // production-ready via JEP 377 (Java 15). Its goal is to keep GC pauses
        // (so-called "safepoints", when all Java threads are stopped) very short,
        // regardless of the heap size.

        // Before this JEP, most of the GC work (marking, relocation, reference
        // processing, class unloading...) was already done concurrently while
        // the application kept running. But scanning Java thread stacks for
        // object references ("roots") still happened inside the safepoint.
        // The cost of that grows with the number of threads, so applications
        // with many threads could still experience longer pauses.

        // JEP 376 moves thread-stack processing to a concurrent phase using
        // a "stack watermark barrier":
        // - a GC safepoint only logically invalidates all thread stacks
        //   by flipping a global variable
        // - when a thread resumes, it installs a watermark marking how much
        //   of its stack was already processed
        // - when the thread returns into (or walks to) a frame that was not
        //   processed yet, it takes a slow path that fixes this one frame first
        // - concurrent GC threads process the remaining frames in the background

        // As a result, Java threads only process the minimum number of frames
        // they need to continue, and essentially nothing of significance is left
        // inside ZGC pauses. The goal is to keep them below 1 millisecond.

        // There is no API to demonstrate, the improvement is internal to the JVM.
        // To benefit from it, just run the application with ZGC enabled:
        //   java -XX:+UseZGC -jar app.jar
        // Pause times can be observed in GC logs via `-Xlog:gc`.
        // The stack watermark mechanism was designed to be reusable by other
        // HotSpot subsystems, such as Project Loom or JFR.
    }
}

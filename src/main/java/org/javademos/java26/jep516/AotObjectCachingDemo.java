package org.javademos.java26.jep516;

import org.javademos.commons.IDemo;

/// Demo for JDK 26 feature JEP 516 - Ahead-of-Time Object Caching with Any GC.
///
/// JEP history:
/// - JDK 26: [JEP 516 - Ahead-of-Time Object Caching with Any GC](https://openjdk.org/jeps/516)
///
/// Further reading:
/// - [JEP 483 - Ahead-of-Time Class Loading & Linking](https://openjdk.org/jeps/483)
/// - [JEP 514 - Ahead-of-Time Command-Line Ergonomics](https://openjdk.org/jeps/514)
/// - [Project Leyden](https://openjdk.org/projects/leyden/)
/// - [Run AOT Cache Article](https://inside.java/2026/01/09/run-aot-cache/)
///
/// @see org.javademos.java24.jep483.AotLoadingAndLinking
/// @see org.javademos.java25.jep514.AheadOfTimeCLIDemo
///
/// @author Alois Sečkár <alois.seckar@gmail.com>
public class AotObjectCachingDemo implements IDemo {

    @Override
    public void demo() {
        info(516);

        // The AOT cache (JEP 483, Java 24) speeds up startup by storing classes
        // loaded and linked during a training run. Besides class metadata,
        // it also holds Java objects referenced by cached `Class` objects,
        // e.g. strings and byte arrays.

        // Until JDK 26, cached objects were stored in a GC-specific format,
        // bitwise-compatible with the in-memory heap layout, so they could be
        // mapped directly into the heap. This worked for Serial, Parallel and G1,
        // but not for ZGC, which encodes metadata bits into object references
        // and has no global region size. You had to pick between low GC latency
        // (ZGC) and fast startup (AOT cache) - not both.

        // JEP 516 adds a GC-agnostic format: object references are stored
        // as logical indices instead of memory addresses. When the cache
        // is opened, a background thread streams the objects into the heap
        // one by one, allocating memory and resolving the indices via a side table.
        // When a class is first used, the app synchronizes with that thread
        // to make sure its `Class` object is already materialized.

        // Mapping (GC-specific) vs. streaming (GC-agnostic):
        // - mapping is best for warm starts (cache already in the filesystem cache)
        //   on constrained machines without a spare CPU core
        // - streaming is best for cold starts (e.g. cloud deployments), hiding
        //   disk-read latency at the cost of an extra CPU core

        // The format is selected by a heuristic when the cache is created:
        // - streamable if training used ZGC, `-XX:-UseCompressedOops`,
        //   or a heap larger than 32 GB
        // - mappable if training used `-XX:+UseCompressedOops` (small heap, no ZGC)
        // The streamable format can be forced with `-XX:+AOTStreamableObjects`.
        //
        // The JDK also ships two baseline AOT caches (one per format), used
        // when the application does not provide its own cache.

        // Example usage (see JEP 514 for the single-step `-XX:AOTCacheOutput`):
        //   java -XX:+UseZGC -XX:AOTCacheOutput=app.aot -jar app.jar
        //   java -XX:+UseZGC -XX:AOTCache=app.aot -jar app.jar

        // No application code changes are required - it is purely a JVM feature.
    }
}

package org.javademos.java16.jep387;

import org.javademos.commons.IDemo;

/// Demo for JDK 16 feature JEP 387 - Elastic Metaspace.
///
/// JEP history:
/// - JDK 16: [JEP 387 - Elastic Metaspace](https://openjdk.org/jeps/387)
///
/// Further reading:
/// - [What is Metaspace?](https://stuefe.de/posts/metaspace/what-is-metaspace/)
/// - [Metaspace Architecture](https://stuefe.de/posts/metaspace/metaspace-architecture/)
/// - [Analyze Metaspace with jcmd VM.metaspace](https://stuefe.de/posts/metaspace/analyze-metaspace-with-jcmd/)
///
/// @author alois.seckar@gmail.com
public class ElasticMetaspaceDemo implements IDemo {
    @Override
    public void demo() {
        info(387);

        // Metaspace is the native (off-heap) memory region where HotSpot stores
        // class metadata - the JVM's internal representation of loaded classes
        // (methods, bytecode, constant pools, annotations...). It replaced
        // the "PermGen" heap region in JDK 8 (JEP 122).

        // Metaspace memory is owned by class loaders. Each loader has its own
        // "arena" made of chunks, from which it allocates by cheap pointer bumps.
        // When a loader is garbage collected, all its metadata is freed at once.

        // The original allocator had two notable problems:
        // - chunks were coarse-grained, so apps with many small class loaders
        //   (reflection, lambdas, dynamic proxies, scripting...) wasted a lot of memory
        // - chunks of dead loaders went to freelists and were rarely returned
        //   to the OS, because the free memory was usually too fragmented

        // JEP 387 replaced the allocator with a buddy-based allocation scheme
        // (a proven algorithm also used e.g. by the Linux kernel):
        // - chunks can be smaller, reducing per-loader overhead
        // - free neighboring chunks are merged back together, reducing fragmentation
        // - memory is committed lazily, only when a loader actually needs it
        // - memory is divided into uniformly sized "granules" that can be
        //   committed and uncommitted (returned to the OS) independently

        // As a result, metaspace footprint is lower and it is "elastic" - after
        // classes are unloaded, unused memory gets returned to the OS more promptly.
        // The rewrite also simplified the HotSpot code, reducing maintenance costs.

        // There is no Java API related to this change, it is purely a JVM internal
        // improvement. Applications benefit automatically without any changes.

        // JDK 16 also introduced `-XX:MetaspaceReclaimPolicy=(balanced|aggressive|none)`
        // to tune how eagerly memory is returned. The option was removed in later
        // releases, as the default behavior proved to be good enough.

        // To inspect metaspace usage of a running JVM, you can use:
        //   jcmd <pid> VM.metaspace
        // or check the "Metaspace" memory pool via `java.lang.management.MemoryPoolMXBean`.
    }
}

package org.javademos.java12.jep230;

import org.javademos.commons.IDemo;

/// Demo for JDK 12 feature JEP 230 - Microbenchmark Suite.
///
/// JEP history:
/// - JDK 12: [JEP 230 - Microbenchmark Suite](https://openjdk.org/jeps/230)
///
/// Further reading:
/// - [Java Microbenchmark Harness (JMH)](https://github.com/openjdk/jmh)
/// - [JDK microbenchmarks source](https://github.com/openjdk/jdk/tree/master/test/micro)
/// - [Microbenchmarking with Java](https://www.baeldung.com/java-microbenchmark-harness)
///
/// @author alois.seckar@gmail.com
public class MicrobenchmarkSuite implements IDemo {
    @Override
    public void demo() {
        info(230);

        // This JEP changes how the JDK itself is developed, not the Java language
        // or its runtime APIs. A suite of microbenchmarks was added directly into
        // the JDK source code, so there is nothing new to call from application code.

        // The benchmarks are built on top of JMH (Java Microbenchmark Harness), which
        // handles the tricky parts of measuring small pieces of code reliably:
        // JIT warm-up, dead-code elimination, constant folding, forking fresh JVMs, etc.
        // Naive timing via `System.nanoTime()` around a loop is usually misleading.

        // The suite lives in the JDK repository under `test/micro/org/openjdk/bench`,
        // split into `java` (organized like JDK packages/modules) and `vm` (organized
        // like HotSpot components). It originated in the former standalone
        // "JMH JDK Microbenchmarks" project and started with around a hundred benchmarks.

        // It is not part of a regular JDK build, to keep build times low.
        // JDK developers can build and run it explicitly, e.g.:
        //   make build-microbenchmark
        //   make test TEST="micro:java.lang.reflect"
        // JMH filtering allows running only the benchmarks of current interest.

        // Co-location makes it easy to add a benchmark together with the code change
        // it measures, and to compare performance against previous JDK builds/releases.
        // Benchmarks are expected to be small, stable, and finish within about a minute.

        // To benchmark your own code, add JMH as a dependency to your project and
        // annotate methods with `@Benchmark` - the same approach the JDK suite uses.
    }
}

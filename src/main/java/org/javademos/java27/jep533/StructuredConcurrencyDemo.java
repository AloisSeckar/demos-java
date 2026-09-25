package org.javademos.java27.jep533;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.CancelledByTimeoutException;
import java.util.concurrent.StructuredTaskScope.Joiner;
import java.util.concurrent.StructuredTaskScope.Subtask;

import org.javademos.commons.IDemo;

/// Demo for JDK 27 feature JEP 533 - Structured Concurrency (Seventh Preview).
///
/// The status in Java 27 is PREVIEW
///  => JVM option `--enable-preview` is required to use it.
///
/// ### Changes in JDK 26 (JEP 525)
/// - new `Joiner.onTimeout()` method allowing a joiner to return a result when a timeout expires
/// - `Joiner.allSuccessfulOrThrow()` returns a `List` of results instead of a `Stream` of subtasks
/// - `Joiner.anySuccessfulResultOrThrow()` was renamed to `Joiner.anySuccessfulOrThrow()`
/// - `open(Joiner, Function)` now takes a `UnaryOperator` instead of a `Function`
///
/// ### Changes in JDK 27 (JEP 533)
/// - `StructuredTaskScope` and `Joiner` got a third type parameter `R_X` - the exception type `join()` can throw
/// - default `open()` and the built-in "...OrThrow" joiners now make `join()` throw
///   a checked `ExecutionException` instead of `StructuredTaskScope.FailedException`
/// - new overloads of `allSuccessfulOrThrow`, `anySuccessfulOrThrow` and `awaitAllSuccessfulOrThrow`
///   accept a function to produce a custom exception
/// - new `open(UnaryOperator)` method to configure a scope with the default join policy
/// - `Joiner.awaitAll()` was removed
/// - `Joiner.onTimeout()` was replaced by `Joiner.timeout()`; when timeout expires, the exception
///   is thrown with `CancelledByTimeoutException` as the cause (replaces `StructuredTaskScope.TimeoutException`)
///
/// ### JEP history
/// - JDK 27: [JEP 533 - Structured Concurrency (Seventh Preview)](https://openjdk.org/jeps/533)
/// - JDK 26: [JEP 525 - Structured Concurrency (Sixth Preview)](https://openjdk.org/jeps/525)
/// - JDK 25: [JEP 505 - Structured Concurrency (Fifth Preview)](https://openjdk.org/jeps/505)
/// - JDK 24: [JEP 499 - Structured Concurrency (Fourth Preview)](https://openjdk.org/jeps/499)
/// - JDK 23: [JEP 480 - Structured Concurrency (Third Preview)](https://openjdk.org/jeps/480)
/// - JDK 22: [JEP 462 - Structured Concurrency (Second Preview)](https://openjdk.org/jeps/462)
/// - JDK 21: [JEP 453 - Structured Concurrency (Preview)](https://openjdk.org/jeps/453)
/// - JDK 20: [JEP 437 - Structured Concurrency (Second Incubator)](https://openjdk.org/jeps/437)
/// - JDK 19: [JEP 428 - Structured Concurrency (Incubator)](https://openjdk.org/jeps/428)
///
/// ### Further reading
/// - [Inside Java: Structured Concurrency](https://inside.java/2022/03/15/structured-concurrency/)
/// - [Structured Concurrency in Java 26 (JEP 525 Deep Dive)](https://javapro.io/2026/06/09/structured-concurrency-in-java-26-jep-525-deep-dive/)
/// - [JEP 533 Tightens Exception Handling in Java's Structured Concurrency for JDK 27](https://www.infoq.com/news/2026/05/jep-533-jdk-27/)
///
/// @see java.util.concurrent.StructuredTaskScope
///
/// @author Kishan Singh @Kishan_Singh
public class StructuredConcurrencyDemo implements IDemo {

    @Override
    public void demo() {
        info(533);

        System.out.println("Structured concurrency simplifies concurrent programming by treating multiple tasks running in different threads as a single unit of work.");
        System.out.println("This demo shows how to use StructuredTaskScope to run subtasks and aggregate their results.");
        System.out.println();

        defaultPolicyDemo();
        failureDemo();
        anySuccessfulDemo();
        timeoutDemo();

        System.out.println();
        System.out.println("StructuredTaskScope ensures that all started tasks are completed or cancelled together, making error handling and resource management easier.");
        System.out.println();
    }

    // default policy - wait for all subtasks, fail if any of them fails
    private void defaultPolicyDemo() {
        // NOTE: the declaration changed over the time
        // JDK 19-24: new StructuredTaskScope.ShutdownOnFailure()
        // JDK 25+: StructuredTaskScope.open()
        // JDK 27: type is StructuredTaskScope<T, Void, ExecutionException> (third type param added)
        try (var scope = StructuredTaskScope.open()) {
            Subtask<String> taskA = scope.fork(() -> fetchData("DataA", 200));
            Subtask<String> taskB = scope.fork(() -> fetchData("DataB", 300));

            scope.join(); // wait for all subtasks

            System.out.println("Aggregated result: " + taskA.get() + ", " + taskB.get());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted!");
        } catch (ExecutionException e) {
            // JDK 25-26: unchecked StructuredTaskScope.FailedException was thrown instead
            System.out.println("Subtask failed: " + e.getCause());
        }
    }

    // if one subtask fails, the other is cancelled and the exception is propagated
    private void failureDemo() {
        try (var scope = StructuredTaskScope.open()) {
            scope.fork(() -> fetchData("DataA", 1000));
            scope.fork(() -> failingService());

            scope.join();

            System.out.println("This line is never reached");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted!");
        } catch (ExecutionException e) {
            // since JDK 27 compiler forces us to handle the failure (checked exception)
            System.out.println("Subtask failed (the other one was cancelled): " + e.getCause());
        }
    }

    // Joiner allows different completion policies - here the first successful result "wins"
    private void anySuccessfulDemo() {
        // JDK 25: Joiner.anySuccessfulResultOrThrow()
        // JDK 26+: Joiner.anySuccessfulOrThrow()
        try (var scope = StructuredTaskScope.open(Joiner.<String>anySuccessfulOrThrow())) {
            scope.fork(() -> fetchData("SlowMirror", 500));
            scope.fork(() -> fetchData("FastMirror", 100));

            String winner = scope.join(); // returns result of the first successful subtask

            System.out.println("Fastest result: " + winner);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted!");
        } catch (ExecutionException e) {
            System.out.println("All subtasks failed: " + e.getCause());
        }

        // JDK 26+: allSuccessfulOrThrow() returns List of results (was Stream<Subtask> in JDK 25)
        try (var scope = StructuredTaskScope.open(Joiner.<String>allSuccessfulOrThrow())) {
            scope.fork(() -> fetchData("X", 50));
            scope.fork(() -> fetchData("Y", 50));

            List<String> results = scope.join();

            System.out.println("All results: " + results);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted!");
        } catch (ExecutionException e) {
            System.out.println("Subtask failed: " + e.getCause());
        }
    }

    // scope can be configured (name, thread factory, timeout)
    private void timeoutDemo() {
        // JDK 27: new open(UnaryOperator) - configuration with default join policy
        // previously only open(Joiner, Function/UnaryOperator) was available
        try (var scope = StructuredTaskScope.open(cf -> cf.withName("timeout-demo").withTimeout(Duration.ofMillis(100)))) {
            scope.fork(() -> fetchData("TooSlow", 1000));

            scope.join();

            System.out.println("This line is never reached");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted!");
        } catch (ExecutionException e) {
            // JDK 25-26: StructuredTaskScope.TimeoutException was thrown instead
            if (e.getCause() instanceof CancelledByTimeoutException) {
                System.out.println("Scope was cancelled by timeout");
            } else {
                System.out.println("Subtask failed: " + e.getCause());
            }
        }
    }

    // simulated service call
    private String fetchData(String data, long latency) throws InterruptedException {
        Thread.sleep(latency);
        return data;
    }

    // simulated failing service call
    private String failingService() throws InterruptedException {
        Thread.sleep(100);
        throw new IllegalStateException("Service unavailable");
    }
}

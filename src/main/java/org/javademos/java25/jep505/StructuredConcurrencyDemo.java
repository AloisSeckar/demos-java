package org.javademos.java25.jep505;

import java.util.concurrent.StructuredTaskScope;
import org.javademos.commons.IDemo;

/// Demo for JDK 25 feature **JEP 505 - Structured Concurrency (Fifth Preview)**.
///
/// JEP history:
/// - JDK 25: [JEP 505 - Structured Concurrency (Fifth Preview)](https://openjdk.org/jeps/505)
/// - JDK 22: [JEP 462 - Structured Concurrency (Fourth Incubator)](https://openjdk.org/jeps/462)
/// - JDK 21: [JEP 446 - Structured Concurrency (Third Incubator)](https://openjdk.org/jeps/446)
/// - JDK 20: [JEP 437 - Structured Concurrency (Second Incubator)](https://openjdk.org/jeps/437)
/// - JDK 19: [JEP 428 - Structured Concurrency (Incubator)](https://openjdk.org/jeps/428)
///
/// Further reading:
/// - [JEP 505 - Structured Concurrency (Fifth Preview)](https://openjdk.org/jeps/505)
/// - [Inside Java: Structured Concurrency](https://inside.java/2022/03/15/structured-concurrency/)
///
/// @author Kishan Singh @Kishan_Singh
public class StructuredConcurrencyDemo implements IDemo {
    @Override
    public void demo() {
        info(505);
        System.out.println("Structured concurrency simplifies concurrent programming by treating multiple tasks running in different threads as a single unit of work.");
        System.out.println("This demo shows how to use StructuredTaskScope to run subtasks and aggregate their results.");
        System.out.println();

        // --- Structured concurrency demo code ---
        // Note: This requires JDK 25+ with preview features enabled.
        // To run: java --enable-preview ...
        // NOTE: the declaration is now different - in previous iterations it was:
        // (var scope = new java.util.concurrent.StructuredTaskScope.ShutdownOnFailure())
        try (var scope = StructuredTaskScope.open()) {
            var future1 = scope.fork(() -> fetchDataFromServiceA());
            var future2 = scope.fork(() -> fetchDataFromServiceB());

            scope.join();           // Wait for all subtasks

            String result = future1.get() + ", " + future2.get();
            System.out.println("Aggregated result: " + result);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted!");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        // --- Explanation ---
        System.out.println();
        System.out.println("StructuredTaskScope ensures that all started tasks are completed or cancelled together, making error handling and resource management easier.");
        System.out.println("In this example, if either fetchDataFromServiceA or fetchDataFromServiceB fails, the other is cancelled and the exception is propagated.");
    }

    // Simulated service call A
    private String fetchDataFromServiceA() throws InterruptedException {
        Thread.sleep(200); // Simulate latency
        return "DataA";
    }

    // Simulated service call B
    private String fetchDataFromServiceB() throws InterruptedException {
        Thread.sleep(300); // Simulate latency
        return "DataB";
    }
}

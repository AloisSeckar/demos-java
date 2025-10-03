package org.javademos.java23.jep462;

import org.javademos.commons.IDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;

/**
 * # JEP 462: Structured Concurrency (Second Preview)
 *
 * Structured Concurrency simplifies multithreaded programming by treating groups of related tasks
 * running in different threads as a single unit of work.
 *
 * ## History:
 * - Introduced as Incubator API in JDK 19 (JEP 428).
 * - Refined through multiple preview stages (JEP 437, JEP 453).
 * - This is the second preview in JDK 23.
 *
 * ## Key Idea:
 * - Replace unstructured thread management with a structured scope.
 * - Parent tasks manage child tasks with well-defined lifecycles.
 *
 * ## External Resources:
 * - [JEP 462](https://openjdk.org/jeps/462)
 * - [Inside Java Podcast: Structured Concurrency](https://inside.java)
 */
public class StructuredConcurrencyDemo implements IDemo {

    @Override
    public void demo() {
        // Print JEP header info
        info(462);

        // Example: Running tasks in parallel with StructuredTaskScope
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            var future1 = scope.fork(() -> "Result from task 1");
            var future2 = scope.fork(() -> "Result from task 2");

            // Wait for all tasks
            scope.join();
            scope.throwIfFailed();

            System.out.println("Task 1 -> " + future1.get());
            System.out.println("Task 2 -> " + future2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("✅ Structured Concurrency demo completed successfully.");
    }
}

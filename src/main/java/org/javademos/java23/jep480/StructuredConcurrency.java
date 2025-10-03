package org.javademos.java23.jep480;

import org.javademos.commons.IDemo;

import java.util.concurrent.Future;
import java.util.concurrent.StructuredTaskScope;

/**
 * # JEP 480: Structured Concurrency (Third Preview)
 *
 * Introduced in **JDK 23**.
 *
 * Structured Concurrency simplifies concurrent programming by treating
 * a set of related tasks as a single unit of work. This improves:
 *
 * - Error handling: if one task fails, others are cancelled.
 * - Cancellation: tasks are easier to shut down as a group.
 * - Results aggregation: you can safely wait for and combine results.
 *
 * ## History
 * - [JEP 428: Structured Concurrency (First Preview, JDK 19)](https://openjdk.org/jeps/428)
 * - [JEP 453: Structured Concurrency (Second Preview, JDK 21)](https://openjdk.org/jeps/453)
 * - [JEP 480: Structured Concurrency (Third Preview, JDK 23)](https://openjdk.org/jeps/480)
 *
 * ## Example
 * This demo runs two tasks concurrently: one loads a user profile,
 * the other loads a score. The results are combined once both succeed.
 */
public class StructuredConcurrency implements IDemo {

    @Override
    public void demo() {
        info(480); // Print standardized JEP header

        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            // Run two subtasks concurrently
            Future<String> userTask = scope.fork(this::loadUser);
            Future<Integer> scoreTask = scope.fork(this::loadScore);

            scope.join();           // Wait for all subtasks to finish
            scope.throwIfFailed();  // Propagate exceptions if any task failed

            // If successful, combine results
            System.out.println("User: " + userTask.resultNow());
            System.out.println("Score: " + scoreTask.resultNow());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Simulated task: Load user profile
    private String loadUser() throws InterruptedException {
        Thread.sleep(500); // simulate delay
        return "Alice";
    }

    // Simulated task: Load user score
    private int loadScore() throws InterruptedException {
        Thread.sleep(300); // simulate delay
        return 42;
    }
}

package org.javademos.java23.jep462;

import org.javademos.commons.IDemo;
import java.util.concurrent.StructuredTaskScope;

/**
 * # JEP 480: Structured Concurrency (Third Preview in Java 25)
 *
 * Updated for Java 25 (Third Preview).
 */
public class StructuredConcurrencyDemo implements IDemo {

    @Override
    public void demo() {
        info(462); 

        try (var scope = StructuredTaskScope.open()) {
            var userTask = scope.fork(() -> "Result from user task");
            var scoreTask = scope.fork(() -> 42); // example score

            scope.join(); // wait for all subtasks

            // Java 25 style: use get() to retrieve results
            System.out.println("User: " + userTask.get());
            System.out.println("Score: " + scoreTask.get());

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("✅ Structured Concurrency demo completed successfully.");
    }
}

package org.javademos.java23.jep462;

import org.javademos.commons.IDemo;
import java.util.concurrent.StructuredTaskScope;

/// Demo for JDK 23 feature JEP 462 - Structured Concurrency (Second Preview).
///
/// JEP history:
/// - JDK 23: [JEP 462 - Structured Concurrency (Second Preview)](https://openjdk.org/jeps/462)
/// - JDK 22: [JEP 453 - Structured Concurrency (Preview)](https://openjdk.org/jeps/453)
/// - JDK 21: [JEP 428 - Structured Concurrency (Incubator)](https://openjdk.org/jeps/428)
/// - JDK 20: [JEP 437 - Structured Concurrency (Second Incubator)](https://openjdk.org/jeps/437)
/// - JDK 19: [JEP 428 - Structured Concurrency (Incubator)](https://openjdk.org/jeps/428)
///
/// @author alois.seckar@gmail.com
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

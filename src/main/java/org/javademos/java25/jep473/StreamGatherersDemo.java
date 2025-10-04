package org.javademos.java25.jep473;

import org.javademos.commons.IDemo;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

/**
 * # JEP 473: Stream Gatherers (Second Preview)
 *
 * Demonstrates the new Stream Gatherers API introduced in Java 25.
 */
public class StreamGatherersDemo implements IDemo {

    @Override
    public void demo() {
        // Print header
        info(473);

        System.out.println("➡️ Example 1: Using Gatherers.scan()");
        Stream.of(1, 2, 3, 4, 5)
                .gather(Gatherers.scan(() -> 0, Integer::sum)) 
                .forEach(sum -> System.out.println("Running total: " + sum));

        System.out.println("\n➡️ Example 2: Using Gatherers.windowFixed()");
        Stream.of("A", "B", "C", "D", "E")
                .gather(Gatherers.windowFixed(3))
                .forEach(window -> System.out.println("Window: " + window));

        System.out.println("\n✅ Stream Gatherers demo completed successfully.");
    }
}

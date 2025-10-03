package org.javademos.java22.jep461;

import org.javademos.commons.IDemo;

import java.util.stream.Gatherers;
import java.util.stream.IntStream;

/**
 * <p>
 *   Demo for JDK 22 feature <strong>Stream Gatherers (Preview)</strong> (JEP 461).
 * </p>
 *
 * <p>
 *   Stream Gatherers introduce a new intermediate operation
 *   {@code Stream.gather(Gatherer)} that enables custom, stateful
 *   transformations on streams. It allows use cases like windowing,
 *   chunking, and scanning which were previously difficult to implement
 *   with the standard Stream API.
 * </p>
 *
 * <p><strong>Example:</strong></p>
 * <pre>{@code
 *   var numbers = IntStream.rangeClosed(1, 10).boxed();
 *   var windows = numbers.gather(Gatherers.windowFixed(3));
 *   windows.forEach(System.out::println);
 * }</pre>
 *
 * @see <a href="https://openjdk.org/jeps/461">JEP 461: Stream Gatherers (Preview)</a>
 */
public class StreamGatherers461 implements IDemo {
    @Override
    public void demo() {
        info(461);

        // Example 1: fixed-size windows of 3
        var numbers = IntStream.rangeClosed(1, 10).boxed();
        var windows = numbers.gather(Gatherers.windowFixed(3));
        System.out.println("Fixed windows of 3:");
        windows.forEach(window -> System.out.println("  " + window));

        // Example 2: running sum using scan
        var sums = IntStream.rangeClosed(1, 5)
                .boxed()
                .gather(Gatherers.scan(0, Integer::sum));
        System.out.println("\nRunning sums:");
        sums.forEach(sum -> System.out.println("  " + sum));
    }
}

package org.javademos.java22.jep461;

import org.javademos.commons.IDemo;

import java.util.stream.Gatherers;
import java.util.stream.IntStream;

/// Demo for JDK 22 feature **JEP 461 - Stream Gatherers (Preview)**.
///
/// JEP history:
/// - JDK 22: [JEP 461 - Stream Gatherers (Preview)](https://openjdk.org/jeps/461)
///
/// Further reading:
/// - [Stream Gatherers in Java](https://openjdk.org/jeps/461)
///
/// @author shepherdking67
public class StreamGatherers implements IDemo {
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
                .gather(Gatherers.scan(() -> 0, Integer::sum));
        System.out.println("\nRunning sums:");
        sums.forEach(sum -> System.out.println("  " + sum));
    }
}

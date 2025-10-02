package org.javademos.java25.jep515;

import org.javademos.commons.IDemo;

import java.util.List;
import java.util.stream.Collectors;

/// Demo for JDK 25 feature **Ahead-of-Time Method Profiling** (JEP 515)
///
/// JEP history:
/// - JDK 25: [JEP 511 - Ahead-of-Time Method Profiling](delivered in JDK 25)
///
/// Further reading:
/// - [Ahead-of-Time Method Profiling overview](https://openjdk.org/jeps/511)
///
/// @author Shivansh @Shivansh-22866

public class AheadOfTimeMethodProfiling implements IDemo {


    @Override
    public void demo() {
        info(515);

        System.out.println("Starting JEP 515 - AOT Method Profiling Demo...");
        System.out.println("This demo simulates a warmup phase using Stream API to demonstrate profiling benefits.\n");

        long coldStart = runAndMeasure();
        System.out.printf("Cold run duration: %d ms%n", coldStart);

        System.out.println("\nSimulating training run (this would be profiled in real AOT scenario)...");

        long trainingRun = runAndMeasure();
        System.out.printf("Training run duration: %d ms%n", trainingRun);

        System.out.println("\nSimulating production run using cached profiles (JEP 515 feature)...");

        long cachedProfileRun = runAndMeasure();
        System.out.printf("Production run with cached profiles duration: %d ms%n", cachedProfileRun);

        System.out.println("\nNOTE: In real scenarios, profiling would be persisted in the AOT cache and reused automatically.");
    }

    /**
     * Simulates the workload described in the JEP (stream-based CPU load).
     * @return Time in milliseconds to execute the workload
     */
    private long runAndMeasure() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100_000; i++) {
            greeting(i);
        }

        System.out.println(greeting(0));

        long end = System.currentTimeMillis();
        return end - start;
    }

    private String greeting(int n) {
        List<String> words = List.of("Hello", String.valueOf(n), "world!");
        return words.stream()
                .filter(w -> !w.contains("0"))
                .collect(Collectors.joining(", "));
    }
}

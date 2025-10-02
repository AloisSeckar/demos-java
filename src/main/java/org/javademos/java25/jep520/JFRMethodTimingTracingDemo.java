package org.javademos.java25.jep520;

import org.javademos.commons.IDemo;

/// Demo for JDK 25 feature **JFR Method Timing & Tracing** (JEP 520)
///
/// JEP history:
/// - JDK 25: [JEP 520 - JFR Method Timing & Tracing](https://openjdk.org/jeps/520)
///
/// Further reading:
/// - [JEP 520 - JFR Method Timing & Tracing](https://openjdk.org/jeps/520)
/// - [JFR Documentation](https://docs.oracle.com/en/java/javase/25/jfapi/index.html)
///
/// @see jdk.jfr
/// @author <your-name>
public class JFRMethodTimingTracingDemo implements IDemo {
    @Override
    public void demo() {
        info(520);
        System.out.println("JEP 520 enhances Java Flight Recorder (JFR) with method-level timing and tracing.");
        System.out.println("This allows for more precise profiling and tracing of method execution, including entry/exit events and timing.");
        System.out.println();
        System.out.println("This feature is best demonstrated by running a JFR recording and analyzing the output in a JFR viewer.");
        System.out.println("Below is a code example that generates some method activity for JFR to record.");
        System.out.println();

        // Example workload
        for (int i = 0; i < 3; i++) {
            busyMethod(i);
        }

        System.out.println("\nTo see method timing/tracing, run this demo with JFR enabled:");
        System.out.println("  java -XX:StartFlightRecording:filename=demo520.jfr,duration=10s,settings=profile -cp ... JFRMethodTimingTracingDemo");
        System.out.println("Then open demo520.jfr in JDK Mission Control or JFR viewer and look for method entry/exit events.");
        System.out.println();
        System.out.println("Note: JFR method tracing is enabled by default in JDK 25, but can be configured with JVM options.");
    }

    private void busyMethod(int n) {
        helperMethod(n * 2);
        try {
            Thread.sleep(100 + n * 50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void helperMethod(int x) {
        double sum = 0;
        for (int i = 0; i < 10000; i++) {
            sum += Math.sqrt(i + x);
        }
    }
}

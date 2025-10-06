package org.javademos.java25.jep520;

import org.javademos.commons.IDemo;
import java.util.concurrent.TimeUnit;

/// Demo for JDK 25 feature **JEP 520 - JFR Method Timing & Tracing**.
///
/// This demo showcases the new Method Tracing feature introduced in Java 25.
/// This JEP provides a standard, low-overhead way to trace specific method
/// invocations using JDK Flight Recorder (JFR) without any code modifications.
///
/// It introduces two new JFR events: `jdk.MethodTiming` and `jdk.MethodTrace`.
/// This example focuses on `jdk.MethodTrace`.
///
/// ### How to Run This Demo:
///
/// 1. Compile and run this file from the project's root directory.
/// 2. Use the -XX:StartFlightRecording flag to enable JFR and specify the filter
///    for the method you want to trace. The filter syntax is `package.ClassName::methodName`.
///
/// ```
/// java --enable-preview \
/// -XX:StartFlightRecording:method-trace=org.javademos.java25.jep520.Jep520MethodTracingDemo::performComplexCalculation,filename=tracing.jfr \
/// src/main/java/org/javademos/java25/jep520/Jep520MethodTracingDemo.java
/// ```
///
/// 3. This command will run the program and generate a JFR recording file named `tracing.jfr`.
/// 4. Open `tracing.jfr` with JDK Mission Control (JMC). In the Event Browser,
///    look for the "Method Trace" event. You will see a specific entry for our
///    `performComplexCalculation` method, including its exact duration and the stack trace.
///
/// JEP history:
/// - JDK 25: [JEP 520 - JFR Method Timing & Tracing](https://openjdk.org/jeps/520)
///
/// @author alois.seckar@gmail.com
public class Jep520MethodTracingDemo implements IDemo {

    @Override
    public void demo() {
        try {
            System.out.println("Starting the JEP 520 Method Tracing demo.");
            System.out.println("Calling the target method multiple times...");

            // We call the method a few times to generate multiple trace events.
            performComplexCalculation(100);
            performComplexCalculation(50);
            performComplexCalculation(200);

            System.out.println("Demo finished. Check the 'tracing.jfr' file.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Demo was interrupted.");
        }
    }

    /**
     * This is the target method we want to trace with JFR.
     * We make it "slow" by adding a sleep, so its execution time is easy to spot in the recording.
     */
    public static void performComplexCalculation(long sleepMillis) throws InterruptedException {
        System.out.println(" > Performing 'complex' calculation for " + sleepMillis + " ms...");
        TimeUnit.MILLISECONDS.sleep(sleepMillis);
        System.out.println(" > Calculation done.");
    }
}
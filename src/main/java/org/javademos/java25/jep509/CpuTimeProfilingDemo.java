package org.javademos.java25.jep509;

import org.javademos.commons.IDemo;

import jdk.jfr.Recording;
import jdk.jfr.Configuration;
import java.nio.file.Path;

/// Demo for JDK 25 feature **JEP 509 - JFR CPU-Time Profiling**.
///
/// JEP history:
/// - JDK 25: JEP 509 - JFR CPU-Time Profiling (Experimental)
///
/// Further reading:
/// - https://openjdk.org/jeps/509
///
/// Author: @adityamep

public class CpuTimeProfilingDemo implements IDemo {

    @Override
    public void demo() {
        info(509);

        System.out.println("Starting JFR CPU-Time Profiling demo...");

        try (Recording recording = new Recording(Configuration.getConfiguration("profile"))) {
            recording.setToDisk(true);
            recording.setDestination(Path.of("cpu-profile.jfr"));
            recording.start();

            // CPU-intensive workload
            for (int i = 0; i < 5; i++) {
                fibonacci(35);
            }

            recording.stop();
            System.out.println("Recording finished. File 'cpu-profile.jfr' generated.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private long fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

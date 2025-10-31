package org.javademos.java14.jep349;

import org.javademos.commons.IDemo;
import jdk.jfr.consumer.RecordingStream;
import java.time.Duration;

/// Demo for JDK 14 feature JEP 349 - JFR Event Streaming.
///
/// JFR Event Streaming exposes JDK Flight Recorder data for continuous
/// monitoring. RecordingStream allows consumption of JFR events in real-time
/// without needing to stop, dump, and parse recording files.
///
/// Key features demonstrated: - Creating a RecordingStream for in-process
/// monitoring - Enabling events with periods and thresholds - Registering event
/// handlers with onEvent - Extracting typed field values from events - Using
/// onFlush for periodic aggregation
///
/// @author NayanKaushik25 ///
public class JFREventStreamingDemo implements IDemo {

    @Override
    public void demo() {
        info(349);

        System.out.println("=== RecordingStream Basics ===");
        demonstrateBasicStream();

        System.out.println("\n=== Field Extraction ===");
        demonstrateFieldExtraction();

        System.out.println("\n=== Event Configuration ===");
        demonstrateConfiguration();

        System.out.println("\n=== onFlush Handler ===");
        demonstrateFlushHandler();
    }

    /**
     * Demonstrates basic RecordingStream creation and event subscription.
     * RecordingStream automatically starts an in-process recording.
     */
    private void demonstrateBasicStream() {
        System.out.println("Creating RecordingStream with default configuration...");

        Thread thread = new Thread(() -> {
            try (var rs = new RecordingStream()) {
                rs.enable("jdk.GarbageCollection");
                rs.enable("jdk.CPULoad").withPeriod(Duration.ofSeconds(1));

                rs.onEvent("jdk.GarbageCollection", event -> {
                    System.out.println("  [GC] Event: " + event.getEventType().getName());
                });

                rs.onEvent("jdk.CPULoad", event -> {
                    System.out.println("  [CPU] Event received");
                    event.getEventType();
                });

                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Basic stream complete.");
    }

    /**
     * Demonstrates extracting typed fields from RecordedEvent.
     * Events expose methods like getFloat, getString, getDuration, and getClass.
     */
    private void demonstrateFieldExtraction() {
        System.out.println("Extracting event field values...");

        Thread thread = new Thread(() -> {
            try (var rs = new RecordingStream()) {
                rs.enable("jdk.CPULoad").withPeriod(Duration.ofSeconds(1));
                rs.enable("jdk.GarbageCollection");

                rs.onEvent("jdk.CPULoad", event -> {
                    float machineTotal = event.getFloat("machineTotal");
                    float jvmUser = event.getFloat("jvmUser");
                    float jvmSystem = event.getFloat("jvmSystem");
                    System.out.printf("  CPU: Machine %.2f%%, User %.2f%%, System %.2f%%%n",
                            100 * machineTotal, 100 * jvmUser, 100 * jvmSystem);
                });

                rs.onEvent("jdk.GarbageCollection", event -> {
                    String cause = event.getString("cause");
                    Duration duration = event.getDuration("sumOfPauses");
                    System.out.printf("  GC: Cause=%s, Pause=%s%n", cause, duration);
                });

                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Field extraction complete.");
    }

    /**
     * Demonstrates event configuration with periods and thresholds.
     * withPeriod controls sampling frequency, withThreshold sets minimum duration.
     */
    private void demonstrateConfiguration() {
        System.out.println("Configuring events with custom settings...");

        Thread thread = new Thread(() -> {
            try (var rs = new RecordingStream()) {
                // Sample CPU every 2 seconds
                rs.enable("jdk.CPULoad").withPeriod(Duration.ofSeconds(2));

                // Only record lock contention > 10ms
                rs.enable("jdk.JavaMonitorEnter").withThreshold(Duration.ofMillis(10));

                rs.onEvent("jdk.CPULoad", event -> {
                    System.out.println("  [2s period] CPU event");
                    event.getEventType();
                });

                rs.onEvent("jdk.JavaMonitorEnter", event -> {
                    var monitorClass = event.getClass("monitorClass");
                    System.out.println("  [>10ms] Lock on: " +
                            (monitorClass != null ? monitorClass.getName() : "unknown"));
                });

                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Configuration complete.");
    }

    /**
     * Demonstrates onFlush callback for periodic data aggregation.
     * JVM flushes thread-local buffers to disk approximately every second.
     */
    private void demonstrateFlushHandler() {
        System.out.println("Using onFlush for aggregation...");

        final int[] eventCount = { 0 };
        final int[] flushCount = { 0 };

        Thread thread = new Thread(() -> {
            try (var rs = new RecordingStream()) {
                rs.enable("jdk.CPULoad").withPeriod(Duration.ofSeconds(1));

                rs.onEvent("jdk.CPULoad", event -> {
                    eventCount[0]++;
                    event.getEventType();
                });

                rs.onFlush(() -> {
                    flushCount[0]++;
                    System.out.printf("  [Flush %d] Events: %d%n", flushCount[0], eventCount[0]);
                });

                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Flush handler complete.");
    }
}

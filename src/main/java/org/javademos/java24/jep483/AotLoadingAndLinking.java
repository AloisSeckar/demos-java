package org.javademos.java24.jep483;

import org.javademos.commons.IDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/// Demo for JDK 24 feature <strong>JEP 483 - Ahead-of-Time Class Loading & Linking</strong>.
///
/// This JEP introduces an experimental mechanism to improve Java application startup time
/// by performing class loading and linking ahead-of-time (AOT) and caching the results.
/// The cached data (called the "AOT cache") can be reused across multiple JVM invocations,
/// avoiding redundant class loading and linking work.
///
/// Key concepts demonstrated:
/// - First run: Class loading and linking happens at runtime (slower startup)
/// - Subsequent runs: Reuses AOT cache for faster class loading and linking
/// - The AOT cache stores pre-resolved class metadata
///
/// JEP history:
/// - JDK 24: [JEP 483 - Ahead-of-Time Class Loading & Linking (Experimental)](https://openjdk.org/jeps/483)
/// - JDK 25: [JEP 514 - Ahead-of-Time Command-Line Ergonomics](https://openjdk.org/jeps/514)
/// - JDK 25: [JEP 515 - Ahead-of-Time Method Profiling](https://openjdk.org/jeps/515)
///
/// Further reading:
/// - [Run AOT Cache Article](https://inside.java/2026/01/09/run-aot-cache/)
///
/// @see org.javademos.java25.jep514.AheadOfTimeCLIDemo
/// @see org.javademos.java25.jep515.AheadOfTimeMethodProfilingDemo
///
/// @author harshitkumar7525
public class AotLoadingAndLinking implements IDemo {
    
    @Override
    public void demo() {
        info(483);

        System.out.println("=== AOT Cache Concept Demo ===\n");
        
        // Explain the concept
        explainAOTCache();
        
        System.out.println("\n=== Simulating Application Runs ===\n");
        
        // Simulate first run (without AOT cache)
        System.out.println("--- First Run (Cold Start - No AOT Cache) ---");
        long firstRunTime = simulateApplicationRun(false);
        System.out.printf("Time taken: %d ms%n", firstRunTime);
        System.out.println("During this run, the JVM:");
        System.out.println("  - Loads classes from JAR/classpath");
        System.out.println("  - Resolves symbolic references");
        System.out.println("  - Performs linking operations");
        System.out.println("  - Caches this metadata to the AOT cache");
        
        System.out.println("\n--- Second Run (Warm Start - Using AOT Cache) ---");
        long secondRunTime = simulateApplicationRun(true);
        System.out.printf("Time taken: %d ms%n", secondRunTime);
        System.out.println("During this run, the JVM:");
        System.out.println("  - Reuses pre-loaded class metadata from AOT cache");
        System.out.println("  - Skips redundant class loading and linking");
        System.out.println("  - Starts up faster!");
        
        // Show improvement
        long improvement = firstRunTime - secondRunTime;
        double improvementPercent = (improvement * 100.0) / firstRunTime;
        System.out.printf("%nStartup improvement: %d ms (%.1f%% faster)%n", improvement, improvementPercent);
        
        System.out.println("\n=== AOT Cache Location ===");
        System.out.println("The AOT cache is typically stored in:");
        System.out.println("  - User cache directory (e.g., ~/.java/aot-cache on Linux/Mac)");
        System.out.println("  - Managed automatically by the JVM");
        System.out.println("  - Shared across multiple application runs");
        
        System.out.println("\n=== Note ===");
        System.out.println("This demo simulates the timing differences.");
        System.out.println("In actual usage with JDK 24, use: java -XX:+AOTCache YourApp");
    }
    
    /**
     * Explains the AOT cache concept introduced by JEP 483.
     */
    private void explainAOTCache() {
        System.out.println("What is AOT Cache?");
        System.out.println("------------------");
        System.out.println("JEP 483 introduces an Ahead-of-Time (AOT) cache that stores:");
        System.out.println("  1. Pre-loaded class metadata");
        System.out.println("  2. Resolved symbolic references");
        System.out.println("  3. Linked class information");
        System.out.println();
        System.out.println("Benefits:");
        System.out.println("  - Faster application startup");
        System.out.println("  - Reduced class loading overhead");
        System.out.println("  - Improved performance for containerized applications");
        System.out.println("  - Cache is persistent across JVM invocations");
    }
    
    /**
     * Simulates an application run with or without AOT cache.
     * Performs some realistic work (class instantiation, stream operations, etc.)
     * to demonstrate the concept.
     *
     * @param useAOTCache whether to simulate using the AOT cache
     * @return simulated execution time in milliseconds
     */
    private long simulateApplicationRun(boolean useAOTCache) {
        long startTime = System.currentTimeMillis();
        
        // Simulate class loading delay (only if not using AOT cache)
        if (!useAOTCache) {
            simulateClassLoading(50); // 50ms class loading overhead
        } else {
            simulateClassLoading(5); // Only 5ms with AOT cache
        }
        
        // Perform actual work (this would be the same in both cases)
        performApplicationWork();
        
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    
    /**
     * Simulates the time spent on class loading and linking.
     * Without AOT cache: slower (classes need to be loaded and linked)
     * With AOT cache: faster (metadata is pre-loaded)
     *
     * @param delayMs delay in milliseconds to simulate class loading
     */
    private void simulateClassLoading(long delayMs) {
        try {
            Thread.sleep(delayMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    /**
     * Performs some representative application work that would happen after startup.
     * This demonstrates that the actual application logic runs the same regardless
     * of whether AOT cache is used - the benefit is purely in startup time.
     */
    private void performApplicationWork() {
        // Create some objects and process data
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            data.add("Item-" + i);
        }
        
        // Process the data using streams
        String result = data.stream()
                .filter(s -> Integer.parseInt(s.split("-")[1]) % 2 == 0)
                .limit(10)
                .collect(Collectors.joining(", "));
        
        // Ensure the work isn't optimized away
        if (result.isEmpty()) {
            System.out.println("Unexpected empty result");
        }
    }
}
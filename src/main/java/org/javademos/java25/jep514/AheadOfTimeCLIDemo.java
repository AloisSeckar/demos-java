package org.javademos.java25.jep514;

import org.javademos.commons.IDemo;

/// Demo for JDK 25 feature JEP 514 - Ahead-of-Time Command-Line Ergonomics.
/// 
/// This demo shows how JEP 514 improves the command-line experience for Ahead-of-Time compilation.
/// It simulates a CLI workflow with simplified commands and helpful feedback.
///
/// JEP history:
/// - JDK 25: [JEP 514 - Ahead-of-Time Command-Line Ergonomics](https://openjdk.org/jeps/514)
/// - JDK 24: [JEP 483 - Ahead-of-Time Class Loading & Linking](https://openjdk.org/jeps/483)
///
/// Further reading:
/// - [What's New in Project Leyden - JEP 514 and JEP 515 Explained](https://softwaremill.com/whats-new-in-project-leyden-jep-514-and-jep-515-explained/)
///
/// @author Shivansh @Shivansh-22866
public class AheadOfTimeCLIDemo implements IDemo {

    @Override
    public void demo() {
        info(514);

        System.out.println("Starting JEP 514 - Ahead-of-Time Command-Line Ergonomics Demo...");
        System.out.println("This demo simulates simplified 'java -AOT' usage with helpful guidance.\n");

        System.out.println("Step 1: Cold run without any prior AOT compilation.");
        simulateCLICommand("java MyApp.java");
        
        System.out.println("\nStep 2: Training run (simulating profiling hints for AOT).");
        simulateCLICommand("java -AOT MyApp.java --train");

        System.out.println("\nStep 3: Production run with cached AOT data applied.");
        simulateCLICommand("java -AOT MyApp");

        System.out.println("\nNOTE: This demo simulates CLI ergonomics. Actual Ahead-of-Time compilation");
        System.out.println("requires JDK 25 support and may involve native image generation under the hood.");
    }

    /**
     * Simulates a CLI command execution and prints a result as if it ran.
     * @param command the CLI command to simulate
     */
    private void simulateCLICommand(String command) {
        System.out.printf("Running command: %s%n", command);
        try {
            // Simulate some processing time
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("-> Success! Command executed with simplified AOT workflow.");
    }
}
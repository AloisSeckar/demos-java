package org.javademos.java16.jep390;

import org.javademos.commons.IDemo;

/// ## JEP 390: Warnings for Value-Based Classes
///
/// ### History
/// Primitive wrapper classes (like Integer, Double) are now designated as
/// "value-based". This JEP adds new warnings when you try to use them in
/// ways that are not intended, like synchronizing on them.
///
/// ### Links
/// - [Official JEP 390](https://openjdk.org/jeps/390)
///
/// @since Java 16
public class ValueBasedClassesDemo implements IDemo {

    @Override
    @SuppressWarnings("synchronization") // This is needed for mvn clean install to pass
    public void demo() {
        // Call the info helper
        info(390);

        // The Demo
        // This is the code that demonstrates the feature.
        // We create an Integer (a value-based class).
        Integer myLock = 10;

        System.out.println("Attempting to synchronize on an instance of Integer...");
        System.out.println("Compiling this file without '@SuppressWarnings' would produce a warning:");
        System.out.println("\"synchronization on instance of a value-based class\"");

        // This 'synchronized' block IS the demo.
        // It will compile, but the compiler warns against this practice.
        synchronized (myLock) {
            // This code is now flagged by the compiler as a bad practice.
            System.out.println("This code block is inside a synchronized block on an Integer.");
        }
        System.out.println("Demo complete.");
    }
}
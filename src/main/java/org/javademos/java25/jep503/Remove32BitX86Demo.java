package org.javademos.java25.jep503;

import org.javademos.commons.IDemo;

/// Demo for JDK 25 change **Remove the 32-bit x86 Port** (JEP 503)
///
/// ### JEP history
/// - JDK 25: [JEP 503 - Remove the 32-bit x86 Port](https://openjdk.org/jeps/503)  
///
/// ### Further reading
/// - [JEP 503 – Motivation and Discussion](https://openjdk.org/jeps/503)
///
/// @see java.lang.System#getProperty(String)
public class Remove32BitX86Demo implements IDemo {

    @Override
    public void demo() {
        info(503);

        System.out.println("=== Remove 32-bit x86 Port Demo ===");

        String arch = System.getProperty("os.arch");
        System.out.println("Running on architecture: " + arch);

        System.out.println("\nExplanation:");
        System.out.println("- In JDK 25, the 32-bit x86 port has been removed.");
        System.out.println("- You must use a 64-bit JDK build to run Java programs.");
        System.out.println("- This simplifies maintenance and improves performance optimizations.");
    }
}

package org.javademos.java25.jep503;

import org.javademos.commons.IDemo;

/// Demo for JDK 25 change **Remove the 32-bit x86 Port** (JEP 503)
///
/// ### JEP history
/// - JDK 21: [JEP 449 - Deprecate the Windows 32-bit x86 Port](https://openjdk.org/jeps/449)
/// - JDK 24: [JEP 479 - Remove the Windows 32-bit x86 Port](https://openjdk.org/jeps/479)
/// - JDK 24: [JEP 501 - Deprecate the 32-bit x86 Port for Removal](https://openjdk.org/jeps/501)
/// - JDK 25: [JEP 503 - Remove the 32-bit x86 Port](https://openjdk.org/jeps/503)  
///
/// ### Further reading
/// - [JEP 503 – Motivation and Discussion](https://openjdk.org/jeps/503)
///
/// @see java.lang.System#getProperty(String)
///
/// @author @CodeSakshamY
public class Remove32BitX86Demo implements IDemo {

    @Override
    public void demo() {
        info(503);

        // JEP History of Removal 32-bit Port
        // - JDK 21: Marked Windows 32-bit x86 for removal (JEP 449)
        // - JDK 24: Removed Windows 32-bit x86 port (JEP 479)
        // - JDK 24: Marked full 32-bit x86 port for removal (JEP 501)
        // - JDK 25: Fully removed 32-bit x86 port (JEP 503)

        System.out.println("=== Remove 32-bit x86 Port Demo ===");

        String arch = System.getProperty("os.arch");
        System.out.println("Running on architecture: " + arch);

        System.out.println("\nExplanation:");
        System.out.println("- In JDK 25, the 32-bit x86 port has been removed.");
        System.out.println("- You must use a 64-bit JDK build to run Java programs.");
        System.out.println("- This simplifies maintenance and improves performance optimizations.");
    }
}

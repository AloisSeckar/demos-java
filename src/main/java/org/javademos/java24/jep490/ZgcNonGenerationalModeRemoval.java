package org.javademos.java24.jep490;

import org.javademos.commons.IDemo;

/// Demo for JEP 490: **ZGC: Remove the Non-Generational Mode**
///
/// JEP history:
/// - JDK 21: [JEP 439 - Generational ZGC](https://openjdk.org/jeps/439)
/// - JDK 23: [JEP 474 - ZGC: Generational Mode by Default](https://openjdk.org/jeps/474)
/// - JDK 24: [JEP 490 - ZGC: Remove the Non-Generational Mode](https://openjdk.org/jeps/490)
///
/// @author dhruv-git-sys
public class ZgcNonGenerationalModeRemoval implements IDemo {

    @Override
    public void demo() {
        info(490);

        /*
         * This JEP concerns a change in JVM options and internal GC behavior. Such a change
         * cannot be demonstrated with code running inside the main demo runner. Instead,
         * its effects must be observed by running the JVM with specific command-line flags.
         *
         * ---
         * ✅ How to Verify This Change
         * ---
         *
         * 1. Create any simple Java application (e.g., a "Hello, World").
         *
         * 2. Run it from your terminal using the now-obsolete flag to disable generational mode:
         * >> java -XX:+UseZGC -XX:-ZGenerational YourApp.java
         *
         * 3. Observe the console output. You will see a WARNING MESSAGE from the JVM,
         * confirming the flag is obsolete and the non-generational mode is gone.
         */
    }
}
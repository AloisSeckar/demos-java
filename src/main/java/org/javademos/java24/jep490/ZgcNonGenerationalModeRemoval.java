package org.javademos.java24.jep490;

import org.javademos.commons.IDemo;

/**
 * ## JEP 490: ZGC: Remove the Non-Generational Mode
 *
 * ### Summary
 * This JEP finalizes the transition to a generational ZGC by completely removing the old,
 * non-generational mode. As of JDK 24, ZGC operates *exclusively* in its generational
 * configuration, which offers better performance for most applications.
 *
 * ### History
 * - **JEP 439 (JDK 21):** Introduced Generational ZGC as an experimental feature.
 * - **JEP 474 (JDK 23):** Made Generational ZGC the default mode, but allowed users to revert
 * to the non-generational mode using `-XX:-ZGenerational`.
 * - **JEP 490 (JDK 24):** Removes the non-generational code entirely. The `-XX:-ZGenerational`
 * flag is now obsolete and ignored, triggering a warning if used.
 *
 * ### Goal
 * The primary goal is to reduce the maintenance cost of the ZGC codebase by removing one of
 * its two operating modes. This allows the OpenJDK team to focus all efforts on improving
 * the superior generational mode.
 *
 * ### Links
 * - [Official JEP 490 Page](https://openjdk.org/jeps/490)
 * - [Related JEP 439: Generational ZGC](https://openjdk.org/jeps/439)
 */
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
         * 3. Observe the console output. You will see two key things:
         *
         * a) A WARNING MESSAGE from the JVM, indicating the flag is obsolete:
         * "OpenJDK 64-Bit Server VM warning: Option ZGenerational was deprecated...
         * Ignoring option ZGenerational; support was removed in 25.0"
         *
         * b) Your application will still run successfully using GENERATIONAL ZGC.
         *
         * This simple test confirms that the non-generational mode has been completely
         * removed and the flag to access it is no longer functional.
         */
    }
}
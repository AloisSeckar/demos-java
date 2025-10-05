package org.javademos.java24.jep501;

import org.javademos.commons.IDemo;

/// Demo for JDK 24 change **Deprecate the 32-bit x86 Port for Removal** (JEP 501)
///
/// ### JEP history
/// - JDK 21: [JEP 449 - Deprecate the 32-bit x86 Windows Port for Removal](https://openjdk.org/jeps/449)
/// - JDK 24: [JEP 479 - Remove the 32-bit x86 Windows Port](https://openjdk.org/jeps/479)
/// - JDK 24: [JEP 501 - Deprecate the 32-bit x86 Port for Removal](https://openjdk.org/jeps/501)
/// - JDK 25: [JEP 503 - Remove the 32-bit x86 Port](https://openjdk.org/jeps/503)
///
/// ### Key points
/// - JDK 24 marked the **entire 32-bit x86 port** as deprecated.
/// - This was a warning for developers that support would end soon.
/// - The actual removal happened in JDK 25 (JEP 503).
///
/// @author adeelFeroz77

public class Deprecate32BitX86Demo implements IDemo {

    @Override
    public void demo() {
        info(501);

        System.out.println("=== Deprecate 32-bit x86 Port Demo (JEP 501) ===");

        String arch = System.getProperty("os.arch");
        System.out.println("Running on architecture: " + arch);

        System.out.println("\nExplanation:");
        System.out.println("- In JDK 24, the 32-bit x86 port was not removed yet,");
        System.out.println("  but it was marked as DEPRECATED for removal.");
        System.out.println("- Developers were warned to migrate to 64-bit builds.");
        System.out.println("- Final removal occurred in JDK 25 via JEP 503.");
    }
}

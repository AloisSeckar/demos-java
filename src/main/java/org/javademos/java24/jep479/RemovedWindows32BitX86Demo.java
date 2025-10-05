package org.javademos.java24.jep479;

import org.javademos.commons.IDemo;

/// Demo for JDK 24 change **Remove the 32-bit x86 Windows Port** (JEP 479)
///
/// ### JEP history
/// - JDK 21: [JEP 449 - Deprecate the 32-bit x86 Windows Port for Removal](https://openjdk.org/jeps/449)
/// - JDK 24: [JEP 479 - Remove the 32-bit x86 Windows Port](https://openjdk.org/jeps/479)
/// - JDK 24: [JEP 501 - Deprecate the 32-bit x86 Port for Removal](https://openjdk.org/jeps/501)
/// - JDK 25: [JEP 503 - Remove the 32-bit x86 Port](https://openjdk.org/jeps/503)
///
/// ### Key points
/// - JDK 24 removed **Windows-only 32-bit x86 port**.
/// - 32-bit x86 builds for Linux/other OSes were still available.
/// - This was an intermediate step before the full removal in JDK 25 (JEP 503).
///
/// @author adeelFeroz77

public class RemovedWindows32BitX86Demo implements IDemo {

    @Override
    public void demo() {
        info(479);

        System.out.println("=== Remove Windows 32-bit x86 Port Demo (JEP 479) ===");

        String osName = System.getProperty("os.name");
        String arch = System.getProperty("os.arch");
        System.out.println("Running on: " + osName + " (" + arch + ")");

        System.out.println("\nExplanation:");
        System.out.println("- In JDK 24, the 32-bit x86 port was removed for Windows only.");
        System.out.println("- Other operating systems (like Linux) still had 32-bit builds.");
        System.out.println("- Developers on Windows had to migrate to 64-bit JDK.");
        System.out.println("- This set the stage for the complete removal in JDK 25 (JEP 503).");
    }
}

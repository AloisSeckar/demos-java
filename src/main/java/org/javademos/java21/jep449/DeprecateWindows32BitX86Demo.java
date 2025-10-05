package org.javademos.java21.jep449;

import org.javademos.commons.IDemo;

/// Demo for JDK 21 change **Deprecate the 32-bit x86 Windows Port for Removal** (JEP 449)
///
/// ### JEP history
/// - JDK 21: [JEP 449 - Deprecate the 32-bit x86 Windows Port for Removal](https://openjdk.org/jeps/449)
/// - JDK 24: [JEP 479 - Remove the 32-bit x86 Windows Port](https://openjdk.org/jeps/479)
/// - JDK 24: [JEP 501 - Deprecate the 32-bit x86 Port for Removal](https://openjdk.org/jeps/501)
/// - JDK 25: [JEP 503 - Remove the 32-bit x86 Port](https://openjdk.org/jeps/503)
///
/// ### Key points
/// - JDK 21 did **not** remove the Windows 32-bit x86 port.
/// - It was only **deprecated**, meaning developers were warned about future removal.
/// - This was the first formal signal that the port was going away.
///
/// @author adeelFeroz77

public class DeprecateWindows32BitX86Demo implements IDemo {

    @Override
    public void demo() {
        info(449);

        System.out.println("=== Deprecate Windows 32-bit x86 Port Demo (JEP 449) ===");

        String osName = System.getProperty("os.name");
        String arch = System.getProperty("os.arch");
        System.out.println("Running on: " + osName + " (" + arch + ")");

        System.out.println("\nExplanation:");
        System.out.println("- In JDK 21, the Windows 32-bit x86 port was NOT removed.");
        System.out.println("- It was officially marked as DEPRECATED for removal.");
        System.out.println("- Developers were advised to migrate to 64-bit builds.");
        System.out.println("- Actual removal came later in JDK 24 (JEP 479) and full removal in JDK 25 (JEP 503).");

    }
}

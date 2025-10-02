package org.javademos.java25.jep503;

import org.javademos.commons.IDemo;

/// Demo for JDK 25 feature **Remove the 32-bit x86 Port** (JEP 503)
///
/// JEP history:
/// - JDK 25: [JEP 503 - Remove the 32-bit x86 Port](https://openjdk.org/jeps/503)
///
/// Further reading:
/// - [JEP 503 Proposal](https://openjdk.org/jeps/503)
/// - [OpenJDK Mailing List Discussion](https://mail.openjdk.org/pipermail/jdk-dev/2024-October/008000.html)
///
/// @author github-copilot
public class Remove32BitX86PortDemo implements IDemo {
    @Override
    public void demo() {
        info(503);

        // JEP 503 removes the 32-bit x86 port from the JDK source code.
        // This means that starting with Java 25, it is no longer possible to build or run
        // the JDK on 32-bit x86 (IA-32) architectures. Only 64-bit x86 (x86_64),
        // AArch64, and other supported architectures remain.
        //
        // Why was this done?
        // - The 32-bit x86 port was outdated and not widely used anymore.
        // - Maintaining it required extra effort and testing resources.
        // - Removing it simplifies the codebase and allows for more modern optimizations.
        //
        // What does this mean for developers?
        // - You cannot run Java 25+ on 32-bit x86 systems.
        // - If you need to run Java on 32-bit x86, you must use Java 24 or earlier.
        // - Most modern hardware and operating systems are 64-bit, so this change
        //   should not affect the vast majority of users.
        //
        // There is no code to demonstrate for this JEP, as it is a removal of platform support.
        // This demo serves as documentation and explanation only.
        System.out.println("JEP 503 removes the 32-bit x86 (IA-32) port from the JDK.\n" +
            "Java 25 and later cannot be built or run on 32-bit x86 systems.\n" +
            "Use Java 24 or earlier if you require 32-bit x86 support.\n" +
            "Most users are unaffected, as 64-bit systems are now standard.");
    }
}

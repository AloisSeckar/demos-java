package org.javademos.java17.jep391;

import org.javademos.commons.IDemo;

/// Demo for JDK 17 feature JEP 391 - macOS/AArch64 Port.
///
/// This JEP provided a port of the JDK to the macOS operating system running
/// on the AArch64 (ARM64) architecture, primarily for Apple Silicon hardware.
/// This allows the JDK and Java applications to run natively on newer Macs
/// without requiring Rosetta 2 translation, improving performance.
///
/// JEP history:
/// - JDK 17: [JEP 391 - macOS/AArch64 Port](https://openjdk.org/jeps/391)
///
/// Further reading:
/// - [JEP 391 Details](https://openjdk.org/jeps/391)
/// - [Related: JEP 388 - Windows/AArch64 Port](https://openjdk.org/jeps/388)
///
/// @author Adarsh80416
public class MacOsAarch64PortDemo implements IDemo {

    @Override
    public void demo() {
        // Print the standard JEP info header
        info(391);

        // This JEP is about providing a build of the JDK for a specific platform (macOS on ARM64).
        // There isn't specific Java code to demonstrate the port itself within this application.
        // The existence of a downloadable JDK build for macOS/AArch64 is the result of this JEP.

        // Key aspects mentioned in the JEP:
        // - Allows Java applications to run natively on Apple Silicon Macs.
        // - Avoids performance penalties associated with Rosetta 2 translation for x64 JDK builds.
        // - Reused existing AArch64 code from Linux and Windows ports.
        // - Implemented support for macOS/AArch64's W^X (Write-XOR-Execute) memory policy in HotSpot.

        // To benefit from this JEP, users simply download and install the
        // appropriate JDK build for their macOS/AArch64 system.
    }
}
package org.javademos.java16.jep388;

import org.javademos.commons.IDemo;

/// ## JEP 388: Windows/AArch64 Port
///
/// ### History
/// This JEP involved the significant engineering effort required to make the
/// JDK (including the HotSpot JVM) run successfully on the Windows operating
/// system when using ARM64 processors (AArch64 architecture).
///
/// ### Links
/// - [Official JEP 388](https://openjdk.org/jeps/388)
///
/// @since Java 16
public class WindowsPortDemo implements IDemo {

    @Override
    public void demo() {
        // Call info helper
        info(388);

        // This JEP was a porting effort, not a code feature.
        // There are no specific APIs or language changes to demonstrate.
        System.out.println("JEP 388 ported the JDK to the Windows/AArch64 platform.");
        System.out.println("There is no specific Java code or API to demonstrate for this feature.");
        System.out.println("Demo complete.");
    }
}
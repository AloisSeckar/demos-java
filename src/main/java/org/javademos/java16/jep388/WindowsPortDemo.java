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
}
}
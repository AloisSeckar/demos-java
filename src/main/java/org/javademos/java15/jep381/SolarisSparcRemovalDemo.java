package org.javademos.java15.jep381;

import org.javademos.commons.IDemo;

/// ## JEP 381: Remove the Solaris and SPARC Ports
///
/// ### History
/// Support for the Solaris operating system and SPARC processor architecture
/// was costly to maintain and usage had declined significantly. This JEP
/// removed the source code and build support for these platforms.
///
/// ### Links
/// - [Official JEP 381](https://openjdk.org/jeps/381)
///
/// @since Java 15
public class SolarisSparcRemovalDemo implements IDemo {

    @Override
    public void demo() {
        // Call info helper
        info(381);

        // This JEP removed platform support for Solaris/SPARC, Solaris/x64, and Linux/SPARC.
        // There are no Java APIs or language features associated with this change.
        // The primary outcome was a reduction in the JDK's codebase and maintenance effort.
    }
}
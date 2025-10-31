package org.javademos.java14.jep362;

import org.javademos.commons.IDemo;

/// Demo for JDK 14 feature <strong>JEP 362 - Deprecate the Solaris and SPARC Ports</strong>.
///
///
/// Relates to:
/// - JDK 15: [JEP 381 - Remove the Solaris and SPARC Ports](https://openjdk.org/jeps/381)
///
/// Deprecate the Solaris/SPARC, Solaris/x64, and Linux/SPARC ports, with the intent to remove them in a future release.
/// @see org.javademos.java15.jep381.SolarisSparcRemovalDemo
///
/// @author SanjanaMahapatra

public class SolarisSparcRemovalDemo implements IDemo {
    @Override
    public void demo() {
        info(362);
    }
}

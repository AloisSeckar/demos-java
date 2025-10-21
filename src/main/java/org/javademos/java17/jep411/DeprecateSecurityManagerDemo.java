package org.javademos.java17.jep411;

import org.javademos.commons.IDemo;

/// Demo for JDK 17 feature JEP 411 - Deprecate the Security Manager for Removal.
///
/// This was the deprecation step. The feature is permanently disabled in JDK 24 by JEP 486.
/// @see org.javademos.java24.jep486.DisableSecurityManager
///
/// @author Adarsh80416
public class DeprecateSecurityManagerDemo implements IDemo {
    @Override
    public void demo() {
        info(411);
    }
}
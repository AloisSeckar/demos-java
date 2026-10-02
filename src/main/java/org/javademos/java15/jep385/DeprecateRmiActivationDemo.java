package org.javademos.java15.jep385;

import org.javademos.commons.IDemo;

/// Demo for JDK 15 feature JEP 385 - Deprecate RMI Activation for Removal.
///
/// RMI Activation was removed in JDK 17 by JEP 407.
/// @see org.javademos.java17.jep407.RemoveRmiActivationDemo
public class DeprecateRmiActivationDemo implements IDemo {
    @Override
    public void demo() {
        info(385);
    }
}

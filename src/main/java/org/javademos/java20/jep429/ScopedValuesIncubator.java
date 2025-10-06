package org.javademos.java20.jep429;

import org.javademos.commons.IDemo;

/// Demo for JDK 20 feature <strong>Scoped Values (Incubator)</strong> (JEP 429).
///
/// This was an incubator JEP. The feature is finalized in JDK 25 by JEP 506.
/// @see org.javademos.java25.jep506.ScopedValuesDemo
///
/// @author ankitkrshah30
public class ScopedValuesIncubator implements IDemo {
    @Override
    public void demo() {
        info(429);
        System.out.println("This was an incubator JEP. Please see the final implementation in JEP 506.");
    }
}
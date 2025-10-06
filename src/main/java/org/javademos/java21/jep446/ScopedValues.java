package org.javademos.java21.jep446;

import org.javademos.commons.IDemo;

/// Demo for JDK 21 feature <strong>Scoped Values (Preview)</strong> (JEP 446).
///
/// This was a preview JEP. The feature is finalized in JDK 25 by JEP 506.
/// @see org.javademos.java25.jep506.ScopedValuesDemo
///
/// @author ankitkrshah30
public class ScopedValues implements IDemo {
    @Override
    public void demo() {
        info(446);
        System.out.println("This was a preview JEP. Please see the final implementation in JEP 506.");
    }
}
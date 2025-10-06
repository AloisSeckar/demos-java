package org.javademos.java23.jep476;

import org.javademos.commons.IDemo;

/// Demo for JDK 23 feature <strong>Scoped Values (Third Preview)</strong> (JEP 476).
///
/// This was a preview JEP. The feature is finalized in JDK 25 by JEP 506.
/// @see org.javademos.java25.jep506.ScopedValuesDemo
///
/// @author ankitkrshah30
public class ScopedValues implements IDemo {
    @Override
    public void demo() {
        info(476);
        System.out.println("This was a preview JEP. Please see the final implementation in JEP 506.");
    }
}
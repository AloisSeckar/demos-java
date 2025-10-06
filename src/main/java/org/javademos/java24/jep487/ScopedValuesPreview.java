package org.javademos.java24.jep487;

import org.javademos.commons.IDemo;

/// Demo for JDK 24 feature <strong>Scoped Values (Fourth Preview)</strong> (JEP 487).
///
/// This was a preview JEP. The feature is finalized in JDK 25 by JEP 506.
/// @see org.javademos.java25.jep506.ScopedValuesDemo
///
/// @author ankitkrshah30
public class ScopedValuesPreview implements IDemo {
    @Override
    public void demo() {
        info(487);
        System.out.println("This was a preview JEP. Please see the final implementation in JEP 506.");
    }
}
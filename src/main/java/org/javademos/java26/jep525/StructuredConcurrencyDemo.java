package org.javademos.java26.jep525;

import org.javademos.commons.IDemo;

/// Demo for JDK 26 feature JEP 525 - Structured Concurrency (Sixth Preview).
///
/// This was a preview JEP. The feature's latest iteration is in JDK 27 by JEP 533.
/// @see org.javademos.java27.jep533.StructuredConcurrencyDemo
public class StructuredConcurrencyDemo implements IDemo {
    @Override
    public void demo() {
        info(525);
    }
}

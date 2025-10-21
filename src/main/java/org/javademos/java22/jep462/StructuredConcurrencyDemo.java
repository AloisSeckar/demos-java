package org.javademos.java22.jep462;

import org.javademos.commons.IDemo;

/// Demo for JDK 22 feature JEP 462 - Structured Concurrency (Second Preview).
///
/// This was a preview JEP. The feature's latest iteration is in JDK 25 by JEP 505.
/// @see org.javademos.java25.jep505.StructuredConcurrencyDemo
///
/// @author Adarsh80416
public class StructuredConcurrencyDemo implements IDemo {
    @Override
    public void demo() {
        info(462);
    }
}
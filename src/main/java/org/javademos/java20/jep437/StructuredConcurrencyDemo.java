package org.javademos.java20.jep437;

import org.javademos.commons.IDemo;

/// Demo for JDK 20 feature JEP 437 - Structured Concurrency (Second Incubator).
///
/// This was an incubator JEP. The feature's latest iteration is in JDK 25 by JEP 505.
/// @see org.javademos.java25.jep505.StructuredConcurrencyDemo
///
/// @author Adarsh80416
public class StructuredConcurrencyDemo implements IDemo {
    @Override
    public void demo() {
        info(437);
    }
}
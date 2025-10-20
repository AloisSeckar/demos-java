package org.javademos.java19.jep428;

import org.javademos.commons.IDemo;

/// Demo for JDK 19 feature JEP 428 - Structured Concurrency (Incubator).
///
/// This was an incubator JEP. The feature's latest iteration is in JDK 25 by JEP 505.
/// @see org.javademos.java25.jep505.StructuredConcurrencyDemo
///
/// @author Adarsh80416
public class StructuredConcurrencyDemo implements IDemo {
    @Override
    public void demo() {
        info(428);
    }
}
package org.javademos.java24.jep483;

import org.javademos.commons.IDemo;

/// Demo for JDK 24 feature <strong>JEP 483 - Ahead-of-Time Class Loading & Linking</strong>.
///
/// This was an experimental feature.
/// The main demos are for the final implementations in JDK 25 (JEP 514 and JEP 515).
/// @see org.javademos.java25.jep514.AheadOfTimeCLIDemo
/// @see org.javademos.java25.jep515.AheadOfTimeMethodProfilingDemo
///
/// @author harshitkumar7525
public class AotLoadingAndLinking implements IDemo {
    @Override
    public void demo() {
        info(483);
    }
}
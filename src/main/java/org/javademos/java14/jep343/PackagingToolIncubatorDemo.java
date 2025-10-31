package org.javademos.java14.jep343;

import org.javademos.commons.IDemo;

/// Demo for JDK 14 feature <strong>JEP 343 - Packaging Tool (Incubator)</strong>.
///
/// Relates to:
/// - [JEP 311 - Java Packager API & CLI](https://openjdk.org/jeps/311)
/// - JDK 16: [JEP 392 - Packaging Tool (Production)](https://openjdk.org/jeps/392)
///
/// Create a tool for packaging self-contained Java applications.
/// @see org.javademos.java16.jep392.PackagingToolDemo
///
/// @author SanjanaMahapatra

public class PackagingToolIncubatorDemo implements IDemo {
    @Override
    public void demo() {
        info(343);
    }
}

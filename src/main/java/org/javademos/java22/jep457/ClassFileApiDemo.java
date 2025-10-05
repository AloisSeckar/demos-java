package org.javademos.java22.jep457;

import org.javademos.commons.IDemo;

/// Demo for JDK 22 feature <strong>Class-File API (Preview)</strong> (JEP 457).
///
/// Replaced with most recent [JEP 484](https://openjdk.org/jeps/484)
/// @see org.javademos.java24.jep484.ClassFileApiDemo
///
/// @author ankitkrshah30
public class ClassFileApiDemo implements IDemo {
    @Override
    public void demo() {
        info(457);
        System.out.println("This was a preview JEP. Please see the final implementation in JEP 484.");
    }
}
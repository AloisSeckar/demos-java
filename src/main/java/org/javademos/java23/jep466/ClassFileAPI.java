package org.javademos.java23.jep466;

import org.javademos.commons.IDemo;

/**
 * Demo for JDK 23 feature <strong>Class-File API (Second Preview)</strong> (JEP 466).
 * This was the second preview. The feature is finalized in JDK 24 by JEP 484.
 * @see org.javademos.java24.jep484.ClassFileApiDemo
 * @author ankitkrshah30
 */
public class ClassFileAPI implements IDemo {
    @Override
    public void demo() {
        info(466);
        System.out.println("This was a preview JEP. Please see the final implementation in JEP 484.");
    }
}
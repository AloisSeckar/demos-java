package org.javademos.java23.jep457;

import org.javademos.commons.IDemo;

/**
 * Demo for JDK 23 feature <strong>Class-File API (Preview)</strong> (JEP 457).
 * This was the first preview. The feature is finalized in JDK 24 by JEP 484.
 * @see org.javademos.java24.jep484.ClassFileApiDemo
 * @author ankitkrshah30
 */
public class ClassFileApiDemo implements IDemo {
    @Override
    public void demo() {
        info(457);
        System.out.println("This was a preview JEP. Please see the final implementation in JEP 484.");
    }
}
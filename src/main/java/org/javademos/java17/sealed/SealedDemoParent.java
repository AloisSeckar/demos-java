package org.javademos.java17.sealed;

/**
 * Simple class to show 'sealed class' concept from Java 17.
 * If class is 'sealed', it MUST also have 'permits' section with 1-n
 * allowed subclasses. Those subclasses must exist and MUST extend parent.
 * 
 * @see SealedDemoChild
 * @see SealedDemoBastard
 * 
 * @author alois.seckar@gmail.com
 */
public sealed class SealedDemoParent permits SealedDemoChild {
    
    public void foo() {
        System.out.println("Hello from parent class");
    }
    
}

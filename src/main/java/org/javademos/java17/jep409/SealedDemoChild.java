package org.javademos.java17.jep409;

/**
 * Simple class to show 'sealed class' concept from Java 17.
 * If class is declared in super-class' 'permits' section,
 * it MUST extend the parent (otherwise compiler error is raised in parent).
 * The class also MUST be either:
 *   'sealed' - with another 'permits' list
 *   'non-sealed' - all sub-classes allowed again
 *   'final' - standard Java way of disallowing further inheritance
 * 
 * @see SealedDemoParent
 * 
 * @author alois.seckar@gmail.com
 */
public final class SealedDemoChild extends SealedDemoParent {
    
    @Override
    public void foo() {
        super.foo();
        System.out.println("Hello from child class");
    }
    
}

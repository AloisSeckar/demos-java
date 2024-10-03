package org.javademos.java11.j9;

import org.javademos.Main;

/**
 * Sample implementation for private methods in interfaces feature from Java 9.
 * 
 * @see Main
 * 
 * @author alois.seckar@gmail.com
 */
public class IJ9DemoImpl implements IJ9Demo {

    /**
     * This method is implementation-specific.
     */
    @Override
    public void foo() {
        System.out.println("Traditional implementation of interface method");
    }
    
    // we don't want to re-implement default void stuff() from the interface
}

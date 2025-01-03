package org.javademos.java11.j9;

import org.javademos.Main;

/**
 * Demo class for improved try-with-resources in Java 9.
 * 
 * @see Main
 * 
 * @author alois.seckar@gmail.com
 */
public class J9DemoAutoCloseable implements AutoCloseable {
    
    /**
     * Method that we would like to call before working with the resource.
     */
    public void init() {
        System.out.println("Initializing internal state");
    }
    
    /**
     * Here would be the actual load of work.
     */
    public void doStuff() {
        System.out.println("Doing stuff with the resource");
    }

    /**
     * This method ensures proper closing.
     */
    @Override
    public void close() {
        System.out.println("Performing operations required to close the resource");
    }
    
}

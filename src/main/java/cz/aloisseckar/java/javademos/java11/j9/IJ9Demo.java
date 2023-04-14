package cz.aloisseckar.java.javademos.java11.j9;

/**
 * Interface for private methods in interfaces feature from Java 9.
 * 
 * @see cz.aloisseckar.java.javademos.java11.j9.J9Demo
 * 
 * @author alois.seckar@atos.net
 */
public interface IJ9Demo {
    
    /**
     * Method that HAS to be implemented.
     */
    void foo();
    
    /**
     * Default method (Java 8 feature) that CAN be re-implemented.
     */
    default void stuff() {
        System.out.println("Public default method inside interface");
        
        // split longer definitions into private methods
        privateStuff();
    }

    // if you try this in Java < 9, compiler will throw:
    //   "private interface methods are not supported in -source X"
    private void privateStuff() {
        System.out.println("Private method inside interface");
    }
    
}

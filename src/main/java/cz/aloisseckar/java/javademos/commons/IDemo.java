package cz.aloisseckar.java.javademos.commons;

/**
 * Simple interface to unify the process.
 * Override method 'demo()' in your implementation and include new instance
 * into demoPool in Main.java
 * 
 * @see cz.aloisseckar.java.javademos.java11.j9.J9Demo
 * 
 * @author alois.seckar@atos.net
 */
public interface IDemo {
    
    /**
     * Header recommended to display at the beginning of each demo's output.
     * @param demoName Name of the demo feature
     * @param demoDscr Description of the purpose
     */
    default void info(String demoName, String demoDscr) {
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println(demoName);
        System.out.println(demoDscr);
        System.out.println("-------------------------------------------------");
        System.out.println();
    }
    
    /**
     * Method to perform the actual work for each demo feature.
     */
    void demo();
    
}

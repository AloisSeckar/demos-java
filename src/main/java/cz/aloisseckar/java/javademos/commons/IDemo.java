package cz.aloisseckar.java.javademos.commons;

/**
 * Simple interface to unify the process.
 * Override method 'demo()' in your implementation and include new instance
 * into demoPool in Main.java
 *
 * @author alois.seckar@gmail.com
 *
 * -----
 *
 * TEMPLATE for demo implementation class JavaDocs:
 *
 *  * This class shows new <<INSERT FEATURE>> introduced in Java <<JDK VERSION>>
 *  *
 *  * REFERENCES:
 *  * Java <<JDK VERSION>> - <<link to relevant JEP or JBC>> - <<TITLE from linked page>>
 *  *
 *  * Further reading:
 *  * <<LINK to interesting article or tutorial>>
 *  *
 *  * @author alois.seckar@gmail.com
 *
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

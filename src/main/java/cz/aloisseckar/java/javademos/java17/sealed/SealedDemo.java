package cz.aloisseckar.java.javademos.java17.sealed;

import cz.aloisseckar.java.javademos.commons.IDemo;
import java.util.Arrays;

/**
 * This class presents new 'sealed' classes available since Java 17.
 * We can now 'seal' classes (and interfaces) to avoid unwanted extending 
 * (implementing). With new 'sealed' and 'permits' keywords we can limit
 * inheritance (implementation) only to white-listed subclasses.
 * 
 * Introduced: Java 15
 * Finalized: Java 17
 * 
 * Further reading: 
 * https://www.baeldung.com/java-sealed-classes-interfaces
 * 
 * @author alois.seckar@atos.net
 */
public class SealedDemo implements IDemo {

    @Override
    public void demo() {
        info("SEALED CLASSES DEMO", "Examples for 'sealed' classes\nintroduced in Java 15 and finalized in Java 17");
        
        // refer to class declarations for more info
        // cz.aloisseckar.java.javademos.java17.sealed.SealedDemoParent
        // cz.aloisseckar.java.javademos.java17.sealed.SealedDemoChild
        // cz.aloisseckar.java.javademos.java17.sealed.SealedDemoBastard
        
        SealedDemoParent seal = new SealedDemoChild();
        seal.foo();
        
        // TODO sealed interface (works pretty much the same as class inheritance)
        
        // Reflection API (https://www.baeldung.com/java-reflection) provides
        // two new classes:
        //   isSealed() - to check whether 'sealed' rules apply to given class
        //   getPermittedSubclasses() - list of class' 'permits' contents
        System.out.println(SealedDemoParent.class.isSealed());
        System.out.println(Arrays.toString(SealedDemoParent.class.getPermittedSubclasses()));
        System.out.println(SealedDemoChild.class.isSealed());
        System.out.println(Arrays.toString(SealedDemoChild.class.getPermittedSubclasses()));
        
        System.out.println();
    }
    
}

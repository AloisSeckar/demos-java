package org.javademos.java17.sealed;

import org.javademos.commons.IDemo;
import java.util.Arrays;

/// Demo for JDK 17 feature **JEP 409 - Sealed Classes**.
/// 
/// We can now 'seal' classes (and interfaces) to avoid unwanted extending 
/// (implementing). With new 'sealed' and 'permits' keywords we can limit
/// inheritance (implementation) only to white-listed subclasses.
///
/// JEP history:
/// - JDK 17: [JEP 409 - Sealed Classes](https://openjdk.org/jeps/409)
/// - JDK 16: [JEP 397 - Sealed Classes (Second Preview)](https://openjdk.org/jeps/397)
/// - JDK 15: [JEP 360 - Sealed Classes (Preview)](https://openjdk.org/jeps/360)
/// 
/// Further reading: 
/// - [Java Sealed Classes and Interfaces](https://www.baeldung.com/java-sealed-classes-interfaces)
/// 
/// @author alois.seckar@gmail.com
public class SealedDemo implements IDemo {

    @Override
    public void demo() {
        info("SEALED CLASSES DEMO", "Examples for 'sealed' classes\nintroduced in Java 15 and finalized in Java 17");
        
        // refer to class declarations for more info
        // sealed.java17.org.javademos.SealedDemoParent
        // sealed.java17.org.javademos.SealedDemoChild
        // sealed.java17.org.javademos.SealedDemoBastard
        
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

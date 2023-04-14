package cz.aloisseckar.java.javademos.java11.j9;

import cz.aloisseckar.java.javademos.commons.IDemo;
import java.util.ArrayList;
import java.util.List;

/**
 * This class demonstrates some new language features from Java 9.
 * 
 * Introduced: Java 9
 * 
 * Further reading:
 * https://www.baeldung.com/new-java-9#Language
 * 
 * @author alois.seckar@atos.net
 */
public class J9Demo implements IDemo {

    @Override
    public void demo() {
        info("J9 DEMO", "Examples for three little language features\nintroduced in Java 9");
        
        // 1) try-with-resources variable is not limited to live just inside
        //    the try block anymore. It can be instanced and worked with before.
        //    Try-with-resources still ensures closing of the resource.
        
        System.out.println("Try-with-resources on existing resource");
        
        try {
            // Java 7/8 way
            try (J9DemoAutoCloseable oldResource = new J9DemoAutoCloseable()) {
                oldResource.init();     // cannot do that before try-with-resources
                oldResource.doStuff();
            }
            // Java 9+ option
            J9DemoAutoCloseable newResource = new J9DemoAutoCloseable();
            newResource.init();         // now we can
            try (newResource) {
                newResource.doStuff();
            }
        } catch (Exception ex) {
            // this wrapper is required, because
            // .close() from AutoCloseable explicitly throws Exception
            // while our .demo() method is not...
            // so try-with-resources without catch block will yield and error
            
            // setting PrintStream/PrintWriter target here will easily suppress
            // the infamous 'Print Stack Trace' compiler warning
            ex.printStackTrace(System.out);
        }
        
        System.out.println();
        
        ////////////////////////////////////////////////////////////////////////
        
        // 2) diamond operator <> now allows anonymous inner classes
        //    In Java 7 and 8 you can use diamond operator to simplify
        //    right side of generic type declaration, but it has to be 
        //    the class itself. Since Java 9 it is possible to benefit from 
        //    enhancing the class' behaviour via anonymous inner class.
        
        System.out.println("Diamond operator allows anonymous classes");
        
        // if you try this in Java < 9, compiler will throw:
        //   "cannot infer type arguments for ArrayList<E>"
        List<String> fc1 = new ArrayList<>() {
            
            // here we are overriding the default implementation of ArrayList's
            // .size() method and also introducing brand-new method (but it has
            // to be private)
            
            @Override
            public int size() {
                System.out.println("Overridden ArrayList.size() method");
                foo();
                return super.size();
            }
            
            private void foo() {
                System.out.println("Method available just for this anonymous class");
            }
        };
        System.out.println(fc1.size());
        
        System.out.println();
        
        ////////////////////////////////////////////////////////////////////////
        
        // 3) Interface can have private methods.
        //    This is meant to be used for splitting up longer default methods 
        //    (feature from Java 8)
        
        System.out.println("Interface with private methods");
        
        IJ9Demo ij9 = new IJ9DemoImpl();
        
        // this method is implementation-specific
        ij9.foo();
        // this method is default in interface   
        ij9.stuff();    
        
        System.out.println();
    }
}

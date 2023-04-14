package cz.aloisseckar.java.javademos.java17.record;

import cz.aloisseckar.java.javademos.commons.IDemo;

/**
 * This class shows new data type 'record' available since Java 16.
 * Java 'record' is basically a container for transferring immutable data
 * designed to be as short and simple to declare as possible.
 * 
 * Introduced: Java 14
 * Finalized: Java 16
 * 
 * Further reading: 
 * https://dzone.com/articles/what-are-java-records 
 * 
 * @author alois.seckar@atos.net
 */
public class RecordDemo implements IDemo {
    
    @Override
    public void demo() {
        info("RECORD DEMO", "Examples for 'records' feature\nintroduced in Java 14 and finalized in Java 16");
        
        // we can define new 'record' directly inside the code block
        // where we need it
        // arguments in this constructor-alike declaration are auto-transferred
        // to object members, that are 'final' by definition
        // it is not possible to have more non-static members inside record
        // than those declared here
        record MyData(int number, String text) {}
        
        // instancing new 'record'
        var data = new MyData(1, "demo");
        
        // getter methods are auto-generated, their names are equal to member
        // names, no "get" prefix here...
        System.out.println(data.number());
        System.out.println(data.text());
        // it is also possible to address member directly, like it is declared 'public'
        System.out.println(data.number);
        
        // although members are accessible, it is not possible to re-assign 
        // the value, as they are all 'final'
        //   cannot assign a value to final variable number
        // data.number = 2;
        
        
        // 'records' are sub-classes of java.lang.Record
        // they CANNOT extend any class nor being extended
        // record MyExtendedData(int number, String text) extends Record {}
        // record MyExtendedData(int number, String text) extends MyData {}
        // private class MyExtData extends MyData {}
        
        // however 'records' CAN implement interfaces and declare new methods
        // inside {} block, much alike anonymous inner classes
        record MyExtendedData(int number, String text) implements IRecord {
            
            // only static variables allowed here
            // if you need more data, add them to "constructor"
            //   field declaration must be static
            //     (consider replacing field with record component)
            // int anotherNumber; 
            
            // static member can be declared
            static int anotherStaticNumber = 1;

            // interface method implementation
            @Override
            public void foo() {
                System.out.println("Hello from implemented method in record");
            }
            
            // new methods can also be declared
            public void myFoo() {
                // custom static members can be changed
                anotherStaticNumber = 2;
                // 'core' members cannot...
                // number = 2;
                
                System.out.println(number);
                System.out.println(anotherStaticNumber);
                System.out.println("Hello from inside of an record");
            }
        }
        
        // get new 'record' instance and call its methods
        var extData = new MyExtendedData(1, "demo");
        extData.foo();
        extData.myFoo();
        
        System.out.println();
    }
    
}

package org.javademos.java16.jep395; // <<< UPDATED package

import org.javademos.commons.IDemo;

/// Demo for JDK 16 feature JEP 395 - Records.
///
/// Java 'record' is basically a container for transferring immutable data
/// designed to be as short and simple to declare as possible. Records finalize
/// the feature previewed in JDK 14 and 15.
///
/// JEP history:
/// - JDK 16: [JEP 395 - Records](https://openjdk.org/jeps/395) (Final)
/// - JDK 15: [JEP 384 - Records (Second Preview)](https://openjdk.org/jeps/384)
/// - JDK 14: [JEP 359 - Records (Preview)](https://openjdk.org/jeps/359)
///
/// Further reading:
/// - [What are Java Records](https://dzone.com/articles/what-are-java-records)
/// - [JEP 395 Details](https://openjdk.org/jeps/395)
///
/// @author alois.seckar@gmail.com
/// @author Adarsh80416 (Moved and updated)
public class RecordDemo implements IDemo {

    @Override
    public void demo() {
        info(395); // <<< UPDATED JEP number

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
        System.out.println("Data number (accessor): " + data.number());
        System.out.println("Data text (accessor): " + data.text());
        // It's generally better practice to use the accessor methods,
        // even though direct field access might compile locally.
        // System.out.println(data.number); // Avoid direct field access if possible

        // although members are accessible, it is not possible to re-assign
        // the value, as they are all 'final'
        // data.number = 2; // Causes compile error: cannot assign a value to final variable number

        // 'records' are sub-classes of java.lang.Record
        // they CANNOT extend any class nor being extended
        // record MyExtendedData(int number, String text) extends Record {} // Error
        // record MyExtendedData(int number, String text) extends MyData {} // Error
        // private class MyExtData extends MyData {} // Error

        // however 'records' CAN implement interfaces and declare new methods
        // inside {} block, much alike anonymous inner classes
        record MyExtendedData(int number, String text) implements IRecord {

            // only static variables allowed here
            // if you need more data, add them to "constructor" (the record header)
            // int anotherNumber; // Error: field declaration must be static

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
                // 'core' members (components) cannot...
                // number = 2; // Error

                System.out.println("Inside myFoo - number: " + number);
                System.out.println("Inside myFoo - static number: " + anotherStaticNumber);
                System.out.println("Hello from inside of a record method");
            }
        }

        // get new 'record' instance and call its methods
        var extData = new MyExtendedData(10, "extended demo");
        extData.foo();
        extData.myFoo();

        System.out.println();
    }

}
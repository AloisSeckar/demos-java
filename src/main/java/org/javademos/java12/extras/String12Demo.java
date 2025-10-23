package org.javademos.java12.extras;

import org.javademos.commons.IDemo;

/// Demo for JDK 12 **String API** enhancements.
///
/// REFERENCES:
/// - JDK 12: [String::transform](https://bugs.openjdk.org/browse/JDK-8203442)
/// - JDK 12: [String::align, String::indent](https://bugs.openjdk.org/browse/JDK-8200435)
/// 
/// Further reading: 
/// - [Java 12 String API](https://www.baeldung.com/java12-string-api)
/// 
/// @author alois.seckar@gmail.com
public class String12Demo implements IDemo {

    @Override
    public void demo() {
        info("STRING J12 DEMO", "Examples for Java 12 new String methods");

        // String::align
        // NOTE: align() method was removed again before Java 12 was released
        // through https://bugs.openjdk.org/browse/JDK-8215490

        // String::indent
        // Adjusts the indentation of each line of this string based on the value of n,
        // and normalizes line termination characters.

        // here we will intend "a" with 1, 2 and 3 spaces
        System.out.println("String:indent");
        System.out.println("a".indent(1));
        System.out.println("a".indent(2));
        System.out.println("a".indent(3));

        // String::transform
        // This method allows the application of a function to this string.
        // The function should expect a single String argument and produce an R result.

        // here we are turning the original word 'hello' into 'transformed hello world!' text
        System.out.println("String.transform()");
        String result = "hello".transform(input -> "transformed " + input + " world!");
        System.out.println(result);
        
        // NOTE: we have to explicitly cast .transform() result to String
        // before printing it out, because println() accepts many data types,
        // while the output of .transform() may vary.
        // Trying to print the result without casting will throw:
        //   "reference to print is ambiguous
        //     both method print(char[]) in PrintStream and method print(String) in PrintStream match"
        // System.out.print("hello".transform(input -> input + " world!")); 
        
    }
    
}

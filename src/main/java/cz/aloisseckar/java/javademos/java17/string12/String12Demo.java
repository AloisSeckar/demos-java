package cz.aloisseckar.java.javademos.java17.string12;

import cz.aloisseckar.java.javademos.commons.IDemo;

/**
 * This class demonstrates new methods available on java.lang.String.
 * 
 * Introduced: Java 12
 * 
 * Further reading: 
 * https://www.baeldung.com/java12-string-api 
 * 
 * @author alois.seckar@atos.net
 */
public class String12Demo implements IDemo {

    @Override
    public void demo() {
        info("STRING J12 DEMO", "Examples for Java 12 new String methods");
        
        // adds n-level indentation before the String
        System.out.println("String.indent(n)");
        System.out.println("a".indent(1));
        System.out.println("a".indent(2));
        System.out.println("a".indent(3));
        
        // feeds the String to given Function that 'transforms' it to something new
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

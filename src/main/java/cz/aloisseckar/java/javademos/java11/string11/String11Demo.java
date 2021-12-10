package cz.aloisseckar.java.javademos.java11.string11;

import cz.aloisseckar.java.javademos.commons.IDemo;

/**
 * This class demonstrates new methods available on java.lang.String.
 * 
 * Introduced: Java 11
 * 
 * Further reading: 
 * https://dzone.com/articles/applying-new-jdk-11-string-methods 
 * 
 * @author alois.seckar@atos.net
 */
public class String11Demo implements IDemo {

    @Override
    public void demo() {
        info("STRING J11 DEMO", "Examples for Java 11 new String methods");
        
        // true if the String contains at least one non-whitespace character
        System.out.println("String.isBlank()");
        System.out.println("".isBlank());
        System.out.println("    ".isBlank());
        System.out.println("s".isBlank());
              
        // removes whitespaces surrounding the String
        System.out.println("String.strip()");
        System.out.print("|");
        System.out.print("   aaa      ".strip());
        System.out.println("|");
        
        // removes whitespaces BEFORE the String
        System.out.println("String.stripLeading()");
        System.out.print("|");
        System.out.print("   aaa      ".stripLeading());
        System.out.println("|");
        
        // removes whitespaces AFTER the String
        System.out.println("String.stripTrailing()");
        System.out.print("|");
        System.out.print("   aaa      ".stripTrailing());
        System.out.println("|");
        
        // slices the String into Stream<String> by \n characters
        System.out.println("String.lines()");  
        "line1\nline2\nline3".lines().forEach(System.out::println);
        
        // repeats the String n-times
        System.out.println("String.repeat(n)");  
        System.out.println("abc".repeat(5));
        
        System.out.println();

    }
    
}

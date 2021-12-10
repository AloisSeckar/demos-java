package cz.aloisseckar.java.javademos.java17.pattern;

import cz.aloisseckar.java.javademos.commons.IDemo;

/**
 * This class shows new 'instanceof pattern matching' concept from Java 16.
 * The basic idea is to allow 'instanceof' check and re-casting to respective
 * data type within one command.
 * 
 * Introduced: Java 14
 * Finalized: Java 16
 * 
 * Further reading: 
 * https://openjdk.java.net/jeps/394
 * 
 * @author alois.seckar@atos.net
 */
public class InstanceofPatternMatchingDemo implements IDemo {

    @Override
    public void demo() {
        info("PATTERN MATCHING DEMO", "Example of 'instanceof pattern matching'\nintroduced in Java 14");

        Object x = 5;
        System.out.println("X is: " + x);
        
        // Java < 16
        // first we had to perform 'instanceof' check
        // then we explicitly cast the variable to Integer
        if (x instanceof Integer) {
            System.out.println("X is integer");
            System.out.println(((Integer) x).compareTo(10));
        }
        
        // Java 16+
        // 'instanceof' itself provides variable, that is already re-casted 
        if (x instanceof Integer integer) {
            System.out.println("X is integer");
            System.out.println(integer.compareTo(10));
        }
        
        System.out.println();
        
    }

}

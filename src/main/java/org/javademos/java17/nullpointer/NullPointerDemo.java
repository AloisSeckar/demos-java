package org.javademos.java17.nullpointer;

import org.javademos.commons.IDemo;

/**
 * This class introduces new 'helpful' NullPointerExceptions available from Java 14.
 *
 * REFERENCES:
 * Java 14 - https://openjdk.org/jeps/358 - Helpful NullPointerExceptions
 * 
 * Further reading:
 * https://www.baeldung.com/java-14-nullpointerexception
 * 
 * @author alois.seckar@gmail.com
 */
public class NullPointerDemo implements IDemo {

    @Override
    public void demo() {
        info("NULL POINTER DEMO", "Examples of 'helpful NullPointer' errors\nintroduced in Java 14");
        
        try {
            // this will raise NullPointerException, but with helpful hint
            String s = null;
            s.charAt(0);
        } catch (Exception ex) {
            // in Java 8 you will get just:
            // java.lang.NullPointerException
            // with helpful NullPointerExceptions the output is:
            // java.lang.NullPointerException: Cannot invoke "String.charAt(int)" because "s" is null
            ex.printStackTrace(System.out);
        }
        
        try {
            // the benefits can be better seen when applied to chained methods
            var nullPointer = new NullPointerLevel1();
            // how long would you need to spot the 'null' reference
            // by analysing the code yourself?
            nullPointer.getLevel2().getLevel3().getLevel4();
        } catch (Exception ex) {
            // without the hint, you will have to elaborate, which part 
            // of the chain was 'null', but now JVM simply tells you,
            // and you can narrow your point of interest during debugging
            ex.printStackTrace(System.out);
        }
        
        System.out.println();
        
    }
}

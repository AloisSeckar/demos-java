package org.javademos.java14.jep358;

import org.javademos.commons.IDemo;

/// Demo for JDK 14 feature JEP 358 - Helpful NullPointerExceptions.
///
/// JEP history:
/// - JDK 14: [JEP 358 - Helpful NullPointerExceptions](https://openjdk.org/jeps/358)
/// 
/// Further reading:
/// - [Java 14 NullPointerException](https://www.baeldung.com/java-14-nullpointerexception)
/// 
/// @author Abhineshhh
@SuppressWarnings("null") // we are deliberately invoking `NullPointerException` in this demo
public class NullPointerDemo implements IDemo {

    @Override
    public void demo() {
        info(358);
        
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

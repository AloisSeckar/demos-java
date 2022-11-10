package cz.aloisseckar.java.javademos.java17.pattern;

import cz.aloisseckar.java.javademos.commons.IDemo;

/**
 * This class shows new 'switch pattern matching' concept from Java 17.
 * The idea basically is to combine the new 'switch' syntax options with 
 * 'instanceof' pattern matching feature.
 * 
 * @see cz.aloisseckar.java.javademos.java17.newswitch.SwitchDemo
 * @see cz.aloisseckar.java.javademos.java17.pattern.InstanceofPatternMatchingDemo
 * 
 * Introduced: Java 17
 * 
 * Further reading: 
 * https://blogs.oracle.com/javamagazine/post/java-pattern-matching-switch-preview 
 * 
 * @author alois.seckar@atos.net
 */
public class SwitchPatternMatchingDemo implements IDemo {

    @Override
    public void demo() {
        info("PATTERN MATCHING DEMO", "Example for 'switch pattern matching'\nintroduced in Java 17");
        
        // method formatViaSwitchPatternMatching() takes any java.lang.Object
        // as an argument and returns its java.lang.String representation based
        // on rules introduced for each data type
        
        // before switch pattern matching there would be a lot of 'if-then-else'
        // commands together with 'instanceof' checks and re-casting
        // now the syntax is much shorter, cleaner and more compact
        
        System.out.println(formatViaSwitchPatternMatching(5));
        System.out.println(formatViaSwitchPatternMatching(5L));
        System.out.println(formatViaSwitchPatternMatching(5.1));
        System.out.println(formatViaSwitchPatternMatching("5"));
        System.out.println(formatViaSwitchPatternMatching("some long text"));
        System.out.println(formatViaSwitchPatternMatching(null));
        System.out.println(formatViaSwitchPatternMatching(new Object()));
        
        System.out.println();
    }
    
    // NOTE: since this is still a preview feature in Java 17, following steps
    // have to be taken to be able to use it:
    //   - in maven-compiler-plugin settings '<arg>--enable-preview</arg>' must be set to build the program
    //   - in Java options '--enable-preview' must be set to run the program
    //   - for NetBeans prior to 12.6 - 'nb-javac' plugin must not be installed to avoid syntax error being shown
    private static String formatViaSwitchPatternMatching(Object o) {
        
        // this switch basically replaces a series of 
        // 'if (o instanceof Clazz c) {} else ...' commands

        return "turned off for now";
        /*
        return switch (o) {
            
            // we cannot have superclass BEFORE its subclasses,
            // as they would be unreachable
            //   this case label is dominated by a preceding case label
            // case Number n  -> String.format("num %d", n);
                
            case Integer i  -> String.format("int %d", i);
            case Long l     -> String.format("long %d", l);
            case Double d   -> String.format("double %f", d);
            // here the general option is valid
            case Number n  -> String.format("num %d", n);
                
            // we can also perform some other filtering on re-casted object
            // but again remember "more specific rule BEFORE more generic one"
            case String s && (s.length() > 10) -> "Long string";
            case String s   -> String.format("String %s", s);
                
            // null is possible to be treated as a separate option like that
            case null       -> "null";
                
            // default label is required, without it, compiler will throw:
            //   the switch expression does not cover all possible input values    
            default         -> o.toString();
        };
        */
    }

}

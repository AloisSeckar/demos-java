package org.javademos.java21.jep441;

import org.javademos.commons.IDemo;

/// Demo for JDK 21 feature JEP 441 - Pattern Matching for switch.
///
/// JEP history:
/// - JDK 21: [JEP 441 - Pattern Matching for switch](https://openjdk.org/jeps/441)
/// - JDK 20: [JEP 433 - Pattern Matching for switch (Fourth Preview)](https://openjdk.org/jeps/433)
/// - JDK 19: [JEP 427 - Pattern Matching for switch (Third Preview)](https://openjdk.org/jeps/427)
/// - JDK 18: [JEP 420 - Pattern Matching for switch (Second Preview)](https://openjdk.org/jeps/420)
/// - JDK 17: [JEP 406 - Pattern Matching for switch (Preview)](https://openjdk.org/jeps/406)
///
/// Further reading:
/// - [Java 21 Features - Pattern Matching for switch](https://www.happycoders.eu/java/java-21-features/#Pattern_Matching_for_switch_-_JEP_441)
///
/// @author alois.seckar@gmail.com
public class PatternMatchingForSwitchDemo implements IDemo {

    @Override
    public void demo() {
        info(441);

        // method formatViaSwitchPatternMatching() takes any java.lang.Object
        // as an argument and returns its java.lang.String representation based
        // on rules introduced for each data type

        // before switch jep441 matching there would be a lot of 'if-then-else'
        // commands together with 'instanceof' checks and re-casting
        // now the syntax is much shorter, cleaner and more compact

        System.out.println(formatViaSwitchPatternMatching(5));
        System.out.println(formatViaSwitchPatternMatching(5L));
        System.out.println(formatViaSwitchPatternMatching(5.1));
        System.out.println(formatViaSwitchPatternMatching("5"));
        System.out.println(formatViaSwitchPatternMatching("some long text"));
        System.out.println(formatViaSwitchPatternMatching(null));
        System.out.println(formatViaSwitchPatternMatching(new Exception("My custom exception")));
        System.out.println(formatViaSwitchPatternMatching(new Object()));
    }

    private static String formatViaSwitchPatternMatching(Object o) {

        // this switch basically replaces a series of
        // 'if (o instanceof Clazz c) {} else ...' commands

        return switch (o) {

            // we cannot have superclass BEFORE its subclasses,
            // as they would be unreachable
            //   this case label is dominated by a preceding case label
            // case Number n  -> String.format("num %d", n);

            case Integer i  -> String.format("int %d", i);
            case Long l     -> String.format("long %d", l);
            case Double d   -> String.format("double %f", d);
            // here the general option is valid
            case Number n   -> String.format("num %d", n);

            // we can also perform some other filtering on re-casted object
            // but again remember "more specific rule BEFORE more generic one"
            // case String s && (s.length() > 10) -> "Long string"; // old format in JDK 17
            case String s when s.length() > 10 -> "Long string";
            case String s   -> String.format("String %s", s);

            // null is possible to be treated as a separate option like that
            case null       -> "null";

            // until JDK 20 it was also possible to wrap variants in parentheses
            // this was removed in JDK 21 as unnecessary
            // case (Exception e) -> e.getMessage();
            case Exception e -> e.getMessage();

            // default label is required, without it, compiler will throw:
            //   'switch' expression does not cover all possible input values
            default         -> o.toString();
        };

    }
}

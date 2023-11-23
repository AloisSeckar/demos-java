package cz.aloisseckar.java.javademos.java21.pattern;

import cz.aloisseckar.java.javademos.commons.IDemo;

/**
 * This class shows the new 'Record Patterns' feature available in Java 21.
 * The purpose is to allow deconstructing of Java records.
 * @see cz.aloisseckar.java.javademos.java17.record.RecordDemo
 *
 * It can also be used in conjunction with 'instanceof' and 'switch' pattern matching checks.
 * @see cz.aloisseckar.java.javademos.java17.pattern.InstanceofPatternMatchingDemo
 * @see cz.aloisseckar.java.javademos.java21.pattern.PatternMatchingForSwitchDemo
 *
 * REFERENCES:
 * Java 21 - https://openjdk.org/jeps/440 - Record Patterns
 * Java 20 - https://openjdk.org/jeps/432 - Record Patterns (Second Preview)
 * Java 19 - https://openjdk.org/jeps/405 - Record Patterns (Preview)
 *
 * Further reading:
 * https://www.happycoders.eu/java/java-21-features/#Record_Patterns_-_JEP_440
 *
 * @author alois.seckar@gmail.com
 */
public class RecordPatternsDemo implements IDemo {

    public record Position(int x, int y) {}

    @Override
    public void demo() {
        info("RECORD PATTERNS DEMO", "Example of 'Record Patterns'\nintroduced in Java 19");

        var testObject = new Object();
        var testRecord = new Position(10, 20);

        System.out.println("1) Records can be used with `pattern matching` for `instanceof`");
        System.out.println("Test object: new Object()");
        printWithInstanceof(testObject);
        System.out.println("Test object: new Position(10, 20)");
        printWithInstanceof(testRecord);
        System.out.println();

        System.out.println("2) Records can also be used with `pattern matching` for `switch`");
        System.out.println("Test object: new Object()");
        printWithSwitch(testObject);
        System.out.println("Test object: new Position(10, 20)");
        printWithSwitch(testRecord);
        System.out.println();
    }

    public static void printWithInstanceof(Object o) {
        if (o instanceof Position p) {
            System.out.println("Given `o` is a `Position` record");
            // we have the record automatically unwrapped thanks to pattern matching
            System.out.println("x = " + p.x());
            System.out.println("y = " + p.y());
        } else {
            System.out.println("Given `o` is different object");
        }
    }
    public static void printWithSwitch(Object o) {
        switch (o) {
            case Position p -> {
                System.out.println("Given `o` is a `Position` record");
                // we have the record automatically unwrapped thanks to pattern matching
                System.out.println("x = " + p.x());
                System.out.println("y = " + p.y());
            }
            /*
            // this would be also possible to access values directly
            // but only one such label can be active inside one switch
            case Position(int x, int y) -> {
                System.out.println("Given `o` is a `Position` record");
                System.out.println("x = " + x);
                System.out.println("y = " + y);
             }
            */
            default -> System.out.println("Given `o` is different object");
        }
    }

}

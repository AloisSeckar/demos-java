package org.javademos.java21.pattern;

import org.javademos.commons.IDemo;
import org.javademos.java17.pattern.InstanceofPatternMatchingDemo;
import org.javademos.java17.record.RecordDemo;

/**
 * This class shows the new 'Record Patterns' feature available in Java 21.
 * The purpose is to allow deconstructing of Java records.
 * @see RecordDemo
 *
 * It can also be used in conjunction with 'instanceof' and 'switch' pattern matching checks.
 * @see InstanceofPatternMatchingDemo
 * @see PatternMatchingForSwitchDemo
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

    // example record containing one number and one string
    public record MyData(int number, String text) {}
    // example "table" of records
    public record MyTable(MyData first, MyData second) {}

    @Override
    public void demo() {
        info("RECORD PATTERNS DEMO", "Example of 'Record Patterns'\nintroduced in Java 19");

        var testObject = new Object();
        var testRecord = new MyData(10, "hello");
        var testTable = new MyTable(new MyData(1, "row1"), new MyData(2, "row2"));

        System.out.println("1) Records can be used with `pattern matching` for `instanceof`");
        System.out.println("Test object: new Object()");
        printWithInstanceof(testObject);
        System.out.println("Test object: new Position(10, 20)");
        printWithInstanceof(testRecord);
        System.out.println();
        System.out.println("Test object: new MyTable(new MyData(1, \"row1\"), new MyData(2, \"row2\"))");
        printWithInstanceof(testTable);
        System.out.println();

        System.out.println("2) Records can also be used with `pattern matching` for `switch`");
        System.out.println("Test object: new Object()");
        printWithSwitch(testObject);
        System.out.println("Test object: new Position(10, 20)");
        printWithSwitch(testRecord);
        System.out.println();
        System.out.println("Test object: new MyTable(new MyData(1, \"row1\"), new MyData(2, \"row2\"))");
        printWithSwitch(testTable);
        System.out.println();

        // NOTE
        // in JEP 432 in JDK 20 it was possible use record patterns in loops,
        // but it was decided to remove this feature, at least for now
        //
        //   for (MyData(int number, String text) : positions) {
        //      // ...
        //   }
        //
    }

    public static void printWithInstanceof(Object o) {

        // common pattern matching
        // object is auto-typed to a record
        /*
        if (o instanceof MyData d) {
            System.out.println("Given `o` is a `MyData` record");
            System.out.println("number = " + d.number());
            System.out.println("text = " + d.text());
            return;
        }
        if (o instanceof MyTable t) {
            System.out.println("Given `o` is a `MyTable` record");
            System.out.println("number 1 = " + t.first().number());
            System.out.println("number 2 = " + t.second().number());
            System.out.println("text 1 = " + t.first().text());
            System.out.println("text 2 = " + t.second().text());
            return;
        }
        */

        // new record pattern matching
        // the record instance can also be directly unwrapped
        if (o instanceof MyData(int number, String text)) {
            System.out.println("Given `o` is a `MyData` record");
            System.out.println("number = " + number);
            System.out.println("text = " + text);
            return;
        }
        // even within nested records
        if (o instanceof MyTable (MyData (int number1, String text1), MyData (int number2, String text2))) {
            System.out.println("Given `o` is a `MyTable` record");
            System.out.println("number 1 = " + number1);
            System.out.println("number 2 = " + number2);
            System.out.println("text 1 = " + text1);
            System.out.println("text 2 = " + text2);
            return;
        }

        System.out.println("Given `o` is different object");
    }
    public static void printWithSwitch(Object o) {
        switch (o) {

            // common pattern matching
            // object is auto-typed to a record
            /*
            case MyData d -> {
                System.out.println("Given `o` is a `MyData` record");
                System.out.println("number = " + d.number());
                System.out.println("text = " + d.text());
            }
            case MyTable t -> {
                System.out.println("Given `o` is a `MyTable` record");
                System.out.println("number 1 = " + t.first().number());
                System.out.println("number 2 = " + t.second().number());
                System.out.println("text 1 = " + t.first().text());
                System.out.println("text 2 = " + t.second().text());
            }
            */

            // new record pattern matching
            // the record instance can also be directly unwrapped
            case MyData(int number, String text) -> {
                System.out.println("Given `o` is a `MyData` record");
                System.out.println("number = " + number);
                System.out.println("text = " + text);
            }
            // even within nested records
            case MyTable (MyData (int number1, String text1), MyData (int number2, String text2)) -> {
                System.out.println("Given `o` is a `MyTable` record");
                System.out.println("number 1 = " + number1);
                System.out.println("number 2 = " + number2);
                System.out.println("text 1 = " + text1);
                System.out.println("text 2 = " + text2);
            }

            default -> System.out.println("Given `o` is different object");
        }
    }

}

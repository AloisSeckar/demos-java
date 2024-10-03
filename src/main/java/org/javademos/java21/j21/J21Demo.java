package org.javademos.java21.j21;

import org.javademos.commons.IDemo;

import java.math.BigInteger;

/**
 * This class shows some new useful API methods made available in Java 18 - Java 21.
 *
 * REFERENCES:
 * Java 21 - https://bugs.openjdk.org/browse/JDK-8305486 - Add split() variants that keep the delimiters to String and j.u.r.Pattern
 * Java 21 - https://bugs.openjdk.org/browse/JDK-8303648 - Add String.indexOf(String str, int beginIndex, int endIndex)
 * Java 21 - https://bugs.openjdk.org/browse/JDK-8303018 - Unicode Emoji Properties
 * Java 21 - https://bugs.openjdk.org/browse/JDK-8302686 - Add repeat methods to StringBuilder/StringBuffer
 * Java 21 - https://bugs.openjdk.org/browse/JDK-8301226 - Add clamp() methods to java.lang.Math and to StrictMath
 * Java 19 - https://bugs.openjdk.org/browse/JDK-8278886 - Add a parallel multiply method to BigInteger
 * Java 18 - https://bugs.openjdk.org/browse/JDK-8270378 - divideExact is missing in java.lang.Math
 *
 * Further reading:
 * https://www.baeldung.com/java-text-blocks
 * https://www.baeldung.com/java-clamp-function
 * https://www.happycoders.eu/java/java-21-features/#New_String_Methods
 *
 * @author alois.seckar@gmail.com
 */
public class J21Demo implements IDemo {

    @Override
    public void demo() {
        info("JAVA 21 FEATURES DEMO", "Examples for couple of 'hidden' features \nintroduced until Java 21");

        // 1) Math.divideExact (Java 18)
        // unlike regular division operator, it throws an exception, when result overflows

        System.out.println("Math.divideExact - new operation for division");
        System.out.println("Simple division - 'Math.divideExact(10, 2)':");
        System.out.println(Math.divideExact(10, 2));
        System.out.println("Traditionally 'Integer.MIN_VALUE / -1' works:");
        System.out.println(Integer.MIN_VALUE / -1); // IDE may show a warning, but Java will process it
        System.out.println("'Math.divideExact(Integer.MIN_VALUE, -1)' will throw an exception:");
        try {
            System.out.println(Math.divideExact(Integer.MIN_VALUE, -1));
        } catch (ArithmeticException ex) {
            System.out.println("ArithmeticException thrown by .divideExact()");
        }
        System.out.println();

        // 2) BigInteger.parallelMultiply (Java 19)
        // faster than traditional BigInteger.multiply, as it utilizes parallel threads to perform the computation
        // it has to be really large numbers to see the effect (due to multi-thread computing overhead)
        // see this article for benchmark:
        // https://www.javaspecialists.eu/archive/Issue305-Contributing-BigInteger.parallelMultiply-to-OpenJDK.html

        System.out.println("BigInteger.parallelMultiply - faster BigInteger multiplication");

        var value = "1234567891";
        System.out.println("values to be multiplied: " + value + " x10000");

        var number1 = new BigInteger(value.repeat(10000));
        var number2 = new BigInteger(value.repeat(10000));

        var timeS1 = System.nanoTime();
        number1.multiply(number2);
        var timeE1 = System.nanoTime() - timeS1;
        System.out.println(".multiply() took " + timeE1 / 1000 + " ms");

        var timeS2 = System.nanoTime();
        number1.parallelMultiply(number2);
        var timeE2 = System.nanoTime() - timeS2;
        System.out.println(".parallelMultiply() took " + timeE2 / 1000 + " ms");
        System.out.println();


        // 3) Math.clamp function (Java 21)
        // Definition (by Baeldung): A clamp function restricts a value to within a range.
        // It ensures a given value doesn't fall outside specific lower and upper boundaries.
        System.out.println("Math.clamp - new value range limiting function");
        System.out.println("Math.clamp(2 * 2, 1, 5): " + Math.clamp(2 * 2, 1, 5));
        System.out.println("Math.clamp(2 * 2, 1, 3): " + Math.clamp(2 * 2, 1, 3));
        System.out.println("Math.clamp(2 * 2, 5, 9): " + Math.clamp(2 * 2, 5, 9));
        System.out.println();

        // 4) String.indexOf in a substring (Java 21)
        // it is now possible to search for a term only in a given range
        // the method also exists overloaded for char input
        System.out.println("String.indexOf in a substring");
        System.out.println("Standard - \"abcabca\".indexOf(\"a\"): " + "abcabca".indexOf("a"));
        System.out.println("In range - \"abcabca\".indexOf(\"a\", 1, 5): " + "abcabca".indexOf("a", 1, 5));
        System.out.println();


        // 5) String.splitWithDelimiters() (Java 21)
        // enhanced .split() that generates array with both extracted parts and the delimiters between
        // you must also set the upper limit of extracted parts with the 2nd argument (value < 0 means no limit)
        // the method was also added for java.util.regex.Pattern
        System.out.println("String.splitWithDelimiters()");

        var input = "this is a demo string";
        System.out.println("input: " + input);

        System.out.println("input.split(\" \")");
        var split1 = input.split(" ");
        System.out.println(String.join(" | ", split1));
        System.out.println("input.splitWithDelimiters(\" \", 3)");
        var split2 = input.splitWithDelimiters(" ", 3);
        System.out.println(String.join(" | ", split2));
        System.out.println("input.splitWithDelimiters(\" \", -1)");
        var split3 = input.splitWithDelimiters(" ", -1);
        System.out.println(String.join(" | ", split3));
        System.out.println();

        // 6) StringBuilder.repeat (Java 21)
        // String.repeat already exists since Java 11
        // this is a more convenient way to use it directly in StringBuilder

        System.out.println("StringBuilder.repeat - more effective string concatenation");
        System.out.println("sb.repeat(\"abc\", 5);");
        StringBuilder sb = new StringBuilder();
        sb.repeat("abc", 5);
        System.out.println(sb);
        System.out.println();

        // 7) Character.isEmoji (Java 21)
        // detect whether given CharSequence is an emoji or not based on its Unicode code point
        // prior to this, workarounds had to be used for detection (see https://www.baeldung.com/java-check-letter-emoji)

        System.out.println("Character.isEmoji - detecting whether a text contains an emoji");
        System.out.println("(note: emoji character may not be printable on terminal)");
        var codePoint1 = Character.codePointAt("😃", 0);
        System.out.println("😃 isEmoji? " + Character.isEmoji(codePoint1));
        var codePoint2 = Character.codePointAt(":)", 0);
        System.out.println(":) isEmoji? " + Character.isEmoji(codePoint2));

    }
}

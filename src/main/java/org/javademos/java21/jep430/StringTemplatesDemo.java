package org.javademos.java21.jep430;

import org.javademos.commons.IDemo;
// import java.util.FormatProcessor;

/// Demo for JDK 21 feature **JEP 430 - String Templates**.
///
/// JEP history:
/// - JDK 21: [JEP 430 - String Templates (Preview)](https://openjdk.org/jeps/430)
///
/// Further reading:
/// - [Java 21 Features - String Templates](https://www.happycoders.eu/java/java-21-features/#String_Templates_Preview_-_JEP_430)
///
/// @author alois.seckar@gmail.com
public class StringTemplatesDemo implements IDemo {
    @Override
    public void demo() {
        info("STRING TEMPLATES DEMO", "Example of 'String Templates' feature\nbeing previewed in Java 21");
        System.out.println("String Templates were removed in JDK 23");
        /*
        // STR is a default implementation of StringTemplate
        // it is automatically injected in all classes without need of an explicit import
        int a = 1;
        int b = 2;
        System.out.println(STR."\{a} * \{b} = \{a * b}");
        System.out.println("-----");

        // FMT is an implementation for `String.format()` alike formatting
        // it has to be imported manually
        double c = 1.2345678;
        double d = 2.3456789;
        System.out.println(FormatProcessor.FMT."%.3f\{c} * %.3f\{d} = %.2f\{c * d}");
        System.out.println("-----");

        // template processor can also be used together with text blocks
        // @see textblock.java17.org.javademos.TextBlockDemo

        int httpStatus = 404;
        String errorMessage = "Demo not found";
        String json = STR."""
        {
          "httpStatus": \{httpStatus},
          "errorMessage": "\{errorMessage}"
        }
        """;
        System.out.println(json);
         */
    }
}

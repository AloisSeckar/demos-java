package org.javademos.java23.jep455;

import org.javademos.commons.IDemo;

/// Demo for JDK 23 feature **JEP 455 - Primitive Types in Patterns, instanceof, and switch (Preview)**.
///
/// JEP history:
/// - JDK 23: [JEP 455 - Primitive Types in Patterns, instanceof, and switch (Preview)](https://openjdk.org/jeps/455)
///
/// Will have a new implementation in JDK 24 via [JEP 488](https://openjdk.org/jeps/488)
///
/// Further reading:
/// - [Primitive Types in Patterns, instanceof, and switch](https://www.happycoders.eu/java/primitive-type-patterns/)
/// - [Primitive Types in Patterns, instanceof, and switch in Java 23](https://softwaremill.com/primitive-types-in-patterns-instanceof-and-switch-in-java-23/)
///
/// @author alois.seckar@gmail.com
public class PrimitiveTypesInPatterns implements IDemo {
    @Override
    public void demo() {
        info(455);

        // TODO more info

        System.out.println("instanceOfWithPrimitives examples");
        instanceOfWithPrimitives(25);
        instanceOfWithPrimitives(3L);
        instanceOfWithPrimitives(false);
        instanceOfWithPrimitives(0f);

        System.out.println();

        System.out.println("switchWithPrimitives examples");
        switchWithPrimitives(true);
        switchWithPrimitives(0.4);
        switchWithPrimitives('a');
        switchWithPrimitives("text");
    }

    private void instanceOfWithPrimitives(Object value) {
        if (value instanceof byte b) System.out.println(b + " is byte");
        if (value instanceof short s) System.out.println(s + " is short");
        if (value instanceof int i) System.out.println(i + " is int");
        if (value instanceof long l) System.out.println(l + " is long");
        if (value instanceof float f) System.out.println(f + " is float");
        if (value instanceof double d) System.out.println(d + " is double");
        if (value instanceof char c) System.out.println(c + " is char");
        if (value instanceof boolean b) System.out.println(b + " is boolean");
    }

    private void switchWithPrimitives(Object value) {
        switch (value) {
            case byte b -> System.out.println(b + " is byte");
            case short s -> System.out.println(s + " is short");
            case char c -> System.out.println(c + " is char");
            case int i -> System.out.println(i + " is int");
            case long l -> System.out.println(l + " is long");
            case float f -> System.out.println(f + " is float");
            case double d -> System.out.println(d + " is double");
            case boolean b -> System.out.println(b + " is boolean");
            default -> System.out.println(value + " is not a primitive");
        }
    }
}

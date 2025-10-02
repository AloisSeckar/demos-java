package org.javademos.java25.jep507;

import org.javademos.commons.IDemo;

/**
 * Demo for JEP 507 - Primitive Types in Patterns, instanceof, and switch (Third Preview)
 * Java 25
 */
public class PrimitivePatterns507 implements IDemo {
    @Override
    public void demo() {
        info(507);
        System.out.println("\nJEP 507 introduces support for primitive types in pattern matching, instanceof, and switch statements.\n");

        // instanceof with primitive patterns
        Object obj = 42;
        if (obj instanceof int i) {
            System.out.println("obj is an int: " + i);
        } else {
            System.out.println("obj is not an int");
        }

        // switch with primitive patterns
        Object value = 3.14;
        String result = switch (value) {
            case int i -> "It's an int: " + i;
            case double d -> "It's a double: " + d;
            case long l -> "It's a long: " + l;
            case null -> "It's null!";
            default -> "Unknown type";
        };
        System.out.println(result);

        // Pattern matching with arrays of primitives
        Object arr = new int[] {1, 2, 3};
        if (arr instanceof int[] ia) {
            System.out.println("arr is an int array of length: " + ia.length);
        }

        // Comments on limitations and notes
        System.out.println("\nNote: This feature is in preview. Some restrictions may apply, e.g., primitive patterns cannot be used in all contexts, and autoboxing/unboxing rules still apply.\n");
    }
}

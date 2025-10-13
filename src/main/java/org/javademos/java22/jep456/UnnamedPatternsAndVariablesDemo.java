package org.javademos.java22.jep456;

import org.javademos.commons.IDemo;

/// Demo for JDK 22 feature **JEP 456 - Unnamed Patterns and Variables**.
///
/// ## Summary
/// This JEP finalizes the feature to enhance the Java language with unnamed patterns and variables.
/// The underscore character `_` can be used to denote a variable or pattern that is required by syntax
/// but is intentionally unused. This improves code readability and maintainability by making the developer's
/// intent clear and reducing the risk of errors from unused variables.
///
/// ## History
/// - JDK 22: [JEP 456 - Unnamed Patterns and Variables (Final)](https://openjdk.org/jeps/456)
/// - JDK 21: [JEP 443 - Unnamed Patterns and Variables (Preview)](https://openjdk.org/jeps/443)
///
/// ## Links
/// - [Baeldung: Unnamed Patterns and Variables in Java](https://www.baeldung.com/java-unnamed-patterns-variables)
/// @author [Krushit Babariya](https://github.com/Krushit-Babariya)
///
public class UnnamedPatternsAndVariablesDemo implements IDemo {

    // A simple record for pattern matching examples
    record Point(int x, int y) {}

    @Override
    public void demo() {
        info(456);

//        System.out.println("--- 1. Unnamed Variables ---");
//        System.out.println("The underscore `_` can be used when a variable must be declared but its value is not needed.");
//
//        // Example 1: In a catch block where the exception object is ignored
        try {
            int result = Integer.parseInt("not-a-number");
        } catch (NumberFormatException _) {
//            System.out.println("✅ Caught an exception, but the exception object itself is ignored.");
        }
//
//        // Example 2: In a for-each loop where only the side-effect of looping is needed
        int count = 0;
        List<String> orders = List.of("Order1", "Order2", "Order3");
        for (var _ : orders) {
            count++; // We only care about the number of orders, not the orders themselves.
        }
//        System.out.printf("✅ Processed %d orders (loop variable was unnamed).%n", count);
//        System.out.println();
//
//
//        System.out.println("--- 2. Unnamed Patterns ---");
//        System.out.println("An unnamed pattern `_` matches a component of a record or other structure without binding it to a variable.");
//
//        // Example 3: Unnamed pattern in an `instanceof` check
        Object obj = new Point(10, 20);
        if (obj instanceof Point(int x, _)) { // We only care about the 'x' coordinate
//            System.out.printf("✅ Object is a Point with x = %d (y coordinate ignored).%n", x);
        }
//
//        // Example 4: Unnamed patterns in a switch statement
        switch (obj) {
            case Point(int x, 0) ->{/* ... */ } //System.out.printf("✅ Point is on the x-axis at x=%d.%n", x);
            case Point(0, int y) ->{/* ... */ } //System.out.printf("✅ Point is on the y-axis at y=%d.%n", y);
            case Point(int x, int y) when (x == y) -> {/* ... */ } //System.out.printf("✅ Point is on the line y=x at (%d, %d).%n", x, y);
            case Point(_, _) ->{/* ... */ } //System.out.println("✅ Object is some other Point (both coordinates ignored).");
            default ->{/* ... */ } //System.out.println("Object is not a Point.");
        }
    }
}
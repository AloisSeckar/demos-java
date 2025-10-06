package org.javademos.java25.jep507;

import org.javademos.commons.IDemo;

/// Demo for JDK 25 feature **JEP 507 - Primitive Types in Patterns, instanceof, and switch (Third Preview)**.
///
/// Compile and run with --enable-preview (JDK 25).
///
/// JEP history:
/// - JDK 25: [JEP 507 - Primitive Types in Patterns, instanceof, and switch (Third Preview)](https://openjdk.org/jeps/507)
/// - JDK 24: [JEP 488 - Primitive Types in Patterns, instanceof, and switch (Second Preview)](https://openjdk.org/jeps/488)
/// - JDK 23: [JEP 455 - Primitive Types in Patterns, instanceof, and switch (Preview)](https://openjdk.org/jeps/455)
///
/// Further reading:
/// - https://openjdk.org/jeps/507
///
/// Author: Prathamesh @tpmsh

public class PrimitiveTypesDemo implements IDemo {

    // Simple record with a double component to demo nested primitive patterns
    static record JsonNumber(double value) {
    }

    @Override
    public void demo() {
        info(507);
        System.out.println("=== Primitive Types Demo ===");


        demoInstanceOfPrimitives();
        System.out.println();
        demoRecordPatternNarrowing();
        System.out.println();
        demoSwitchPrimitives();
    }

    static void demoInstanceOfPrimitives() {
        System.out.println("== instanceof with primitive patterns ==");

        int[] examples = {42, 1000, 16_777_217}; // last is 2^24 + 1 (not exactly representable as float)
        for (int v : examples) {
            System.out.printf("Value: %d%n", v);

            if (v instanceof byte asByte) {
                System.out.printf("  matches 'byte asByte' -> %d%n", asByte);
            } else {
                System.out.println("  does NOT match 'byte asByte'");
            }

            if (v instanceof float asFloat) {
                System.out.printf("  matches 'float asFloat' -> %f%n", asFloat);
            } else {
                System.out.println("  does NOT match 'float asFloat' (possible precision loss)");
            }
            System.out.println();
        }

        Integer boxed = 1000;
        if (boxed instanceof Integer i) {
            System.out.println("Boxed Integer matched 'Integer i' -> " + i);
        }

        double d = 1000.0;
        if (d instanceof int dblToInt) {
            System.out.println("double 1000.0 matched 'int dblToInt' -> " + dblToInt);
        }

        char ch = 'A';
        if (ch instanceof int i) {
            System.out.println("char 'A' matched 'int i' -> " + i);
        }

        short s = 100;
        if (s instanceof byte b) {
            System.out.println("short 100 matched 'byte b' -> " + b);
        } else {
            System.out.println("short 100 did NOT match 'byte b'");
        }
    }

    static void demoRecordPatternNarrowing() {
        System.out.println("== Record pattern narrowing (double -> int) ==");

        Object j1 = new JsonNumber(30); // double value 30.0 (constructed from int 30)
        Object j2 = new JsonNumber(30.5); // double value with fractional part

        if (j1 instanceof JsonNumber(int age)) {
            System.out.println("j1 matched JsonNumber(int age) -> age = " + age);
        } else {
            System.out.println("j1 did NOT match JsonNumber(int age)");
        }

        if (j2 instanceof JsonNumber(int age)) {
            System.out.println("j2 matched JsonNumber(int age) -> age = " + age);
        } else {
            System.out.println("j2 did NOT match JsonNumber(int age)");
        }
    }

    static void demoSwitchPrimitives() {
        System.out.println("== switch with primitive types and patterns ==");

        long lv = 10_000_000_000L;
        System.out.println("switch on long " + lv);
        switch (lv) {
            case 1L -> System.out.println("  case 1L");
            case 2L -> System.out.println("  case 2L");
            case long x -> System.out.println("  default long x -> " + x);
        }

        float fv = 1f;
        System.out.println("switch on float " + fv);
        switch (fv) {
            case 0f -> System.out.println("  zero");
            case float x when x == 1f -> System.out.println("  one (guard)");
            case float x -> System.out.println("  other float -> " + x);
        }

        boolean bv = false;
        System.out.println("switch on boolean " + bv);
        switch (bv) {
            case true -> System.out.println("  true");
            case false -> System.out.println("  false");
        }

        Byte boxedByte = 10;
        System.out.println("switch on boxed Byte " + boxedByte);
        switch (boxedByte) {
            case int p -> System.out.println("  boxed Byte matched as int p = " + p);
        }

        char c = 'Z';
        switch (c) {
            case 'A' -> System.out.println("char is A");
            case char x -> System.out.println("other char: " + x);
        }

    }
}

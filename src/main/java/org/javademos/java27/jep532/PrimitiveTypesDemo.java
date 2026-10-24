package org.javademos.java27.jep532;

import org.javademos.commons.IDemo;

/// Demo for JDK 27 feature JEP 532 - Primitive Types in Patterns, instanceof, and switch (Fifth Preview).
///
/// The status in JDK 27 is PREVIEW
///  => JVM option `--enable-preview` is required to use it.
///
/// ### API changes in JDK 26 (JEP 530)
/// - unconditional exactness is defined more precisely, including value-based checks for `case` constants
/// - dominance checks are tighter: an unconditional pattern must be the last `case` label
///
/// ### API changes in JDK 27 (JEP 532)
/// - none, the feature is re-previewed without change
///
/// ### JEP history
/// - JDK 27: [JEP 532 - Primitive Types in Patterns, instanceof, and switch (Fifth Preview)](https://openjdk.org/jeps/532)
/// - JDK 26: [JEP 530 - Primitive Types in Patterns, instanceof, and switch (Fourth Preview)](https://openjdk.org/jeps/530)
/// - JDK 25: [JEP 507 - Primitive Types in Patterns, instanceof, and switch (Third Preview)](https://openjdk.org/jeps/507)
/// - JDK 24: [JEP 488 - Primitive Types in Patterns, instanceof, and switch (Second Preview)](https://openjdk.org/jeps/488)
/// - JDK 23: [JEP 455 - Primitive Types in Patterns, instanceof, and switch (Preview)](https://openjdk.org/jeps/455)
///
/// ### Further reading
/// - https://openjdk.org/jeps/532
///
/// @author Prathamesh @tpmsh
/// @author Alois Sečkár <alois.seckar@gmail.com>
public class PrimitiveTypesDemo implements IDemo {

    // Simple record with a double component to demo nested primitive patterns
    static record JsonNumber(double value) {
    }

    @Override
    public void demo() {
        info(532);
        System.out.println("=== Primitive Types Demo ===");

        demoInstanceOfPrimitives();
        System.out.println();
        demoInstanceOfTypeTest();
        System.out.println();
        demoRecordPatternNarrowing();
        System.out.println();
        demoSwitchPrimitives();
        System.out.println();
        demoSwitchDominance();
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

    static void demoInstanceOfTypeTest() {
        System.out.println("== instanceof as a precondition for safe casting (type test, no binding) ==");

        byte b = 42;
        System.out.println("byte 42 instanceof int -> " + (b instanceof int)); // unconditionally exact

        int i = 1000;
        System.out.println("int 1000 instanceof byte -> " + (i instanceof byte)); // not exact

        float f = 1000.0f;
        System.out.println("float 1000.0 instanceof int -> " + (f instanceof int)); // exact

        int big = 16_777_217; // 2^24 + 1
        System.out.println("int 2^24+1 instanceof float -> " + (big instanceof float)); // not exact
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

    static void demoSwitchDominance() {
        System.out.println("== dominance: unconditional pattern must be the last case ==");

        int status = 2;
        String text = switch (status) {
            case 0 -> "okay";
            case 1 -> "warning";
            case 2 -> "error";
            case int i -> "unknown status: " + i; // unconditional, so no label may follow
        };
        System.out.println("status " + status + " -> " + text);

        // Since JDK 26 these are compile-time errors (dominated labels):
        //   case int _ -> ...; case float _ -> ...;
        //   case float f -> ...; case 16_777_216 -> ...; // 16_777_216 converts exactly to float
    }
}

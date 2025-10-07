package org.javademos.java25.jep519;

import org.javademos.commons.IDemo;

 import org.openjdk.jol.info.ClassLayout;

/// Demo for JDK 25 feature **JEP 519 - Compact Object Headers**.
///
/// JEP history:
/// - JDK 25: [JEP 519 - Compact Object Headers](https://openjdk.org/jeps/519)
///
/// Further reading:
/// - [Inside Java - JEP Café: Compact Object Headers](https://inside.java/2024/06/18/jepcafe-compactobjectheaders/)
///
/// @see java.lang.Object
///
/// @author @CodeSakshamY
public class CompactObjectHeaderDemo implements IDemo {

    private static final int SAMPLE_COUNT = 5_000_000;

    @Override
    public void demo() {
        info(519);

        System.out.println("=== Minimal Example Objects ===\n");

        Object obj1 = new Object();
        Object obj2 = new Object();

        System.out.println("Created two Objects:");
        System.out.println("obj1 hash: " + obj1.hashCode());
        System.out.println("obj2 hash: " + obj2.hashCode());

        System.out.println("\nExplanation:");
        System.out.println("- In JDK 24 and older, object headers are usually 128 bits (16 bytes).");
        System.out.println("- In JDK 25 with JEP 519, most objects use compact 64-bit headers (8 bytes).");
        System.out.println("- This reduces memory overhead, especially when many objects exist.");

        // -------------------------------------------------
        // Part 1: Measure memory usage in pure Java
        System.out.println("\n=== Approximate Memory Usage Demo ===");
        Runtime runtime = Runtime.getRuntime();

        long before = runtime.totalMemory() - runtime.freeMemory();

        Object[] objs = new Object[SAMPLE_COUNT];
        for (int i = 0; i < SAMPLE_COUNT; i++) {
            objs[i] = new Object();
        }

        long after = runtime.totalMemory() - runtime.freeMemory();
        System.out.printf("Created %,d objects, approx memory used: %.2f MB%n",
                SAMPLE_COUNT, (after - before) / (1024.0 * 1024.0));

        System.out.println("- Compare running this on JDK 21 vs JDK 25 to see memory savings.");

        // -------------------------------------------------
        // Part 2: Optional JOL object header inspectio
        
        System.out.println("\n=== Object Header Layout (JOL) ===");
        System.out.println("Object 1 layout:\n" + ClassLayout.parseInstance(obj1).toPrintable());
        System.out.println("Object 2 layout:\n" + ClassLayout.parseInstance(obj2).toPrintable());
        System.out.println("- Observe header size reduction in JDK 25 vs older versions.");
        

        System.out.println("\nTip: Use tools like jol-cli or jmap for more precise memory/layout measurements.");
    }
}

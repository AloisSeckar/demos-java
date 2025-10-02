package org.javademos.jdk25.jep519;

import org.javademos.commons.IDemo;

/// Demo for JDK 25 feature **Compact Object Headers** (JEP 519)
///
/// JEP history:
/// - JDK 25: [JEP 519 - Compact Object Headers](https://openjdk.org/jeps/519)
///
/// Further reading:
/// - [Inside Java Newscast #63 - Compact Object Headers](https://inside.java/2024/04/18/insidejava63/)
///
/// @see java.lang.Object
/// @author 
public class CompactObjectHeaderDemo implements IDemo {

    private static final int OBJECT_COUNT = 5_000_000;

    @Override
    public void demo() {
        info(519);

        Runtime runtime = Runtime.getRuntime();

        long before = runtime.totalMemory() - runtime.freeMemory();

        Object[] objects = new Object[OBJECT_COUNT];
        for (int i = 0; i < OBJECT_COUNT; i++) {
            objects[i] = new Object();
        }

        long after = runtime.totalMemory() - runtime.freeMemory();

        System.out.printf("Created %,d objects.%n", OBJECT_COUNT);
        System.out.printf("Approximate memory used: %,.2f MB%n", 
                          (after - before) / (1024.0 * 1024.0));

        System.out.println("\nTip: Run this demo on JDK 21 vs JDK 25 to compare memory usage.");
    }
}

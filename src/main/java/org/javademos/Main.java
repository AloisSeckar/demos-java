package demos.jep519;

import demos.IDemo;

public class CompactObjectHeaderDemo implements IDemo {

    private static final int OBJECT_COUNT = 5_000_000;

    @Override
    public void demo() {
        System.out.println("=== JEP 519: Compact Object Headers ===");

        Runtime runtime = Runtime.getRuntime();

        // Initial memory usage
        long before = runtime.totalMemory() - runtime.freeMemory();

        // Allocate objects
        Object[] objects = new Object[OBJECT_COUNT];
        for (int i = 0; i < OBJECT_COUNT; i++) {
            objects[i] = new Object();
        }

        // Memory after allocation
        long after = runtime.totalMemory() - runtime.freeMemory();

        System.out.printf("Created %,d objects.%n", OBJECT_COUNT);
        System.out.printf("Approximate memory used: %,.2f MB%n", (after - before) / (1024.0 * 1024.0));

        System.out.println("Run this demo on Java 21 vs Java 25 to see the reduced memory footprint.");
    }
}

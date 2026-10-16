package org.javademos.java12.jep346;

import org.javademos.commons.IDemo;

/// Demo for JDK 12 feature JEP 346 - Promptly Return Unused Committed Memory from G1.
public class G1PeriodicGCDemo implements IDemo {

    @Override
    public void demo() {
        info(346);

        System.out.println("G1 Periodic Garbage Collection");
        System.out.println();
        System.out.println("Purpose:");
        System.out.println("G1 can reclaim unused committed heap during idle periods.");
        System.out.println();
        System.out.println("Relevant JVM option:");
        System.out.println("  -XX:G1PeriodicGCInterval=5000");
        System.out.println("The interval is in milliseconds.");
        System.out.println("A value of 0 disables periodic GC.");
        System.out.println("Actual collection depends on JVM runtime conditions.");
        System.out.println();
        System.out.println("Inspect garbage collection activity with:");
        System.out.println("  -Xlog:gc");
    }
}
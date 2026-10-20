package org.javademos.java12.jep346;

import org.javademos.commons.IDemo;

/// Demo for JDK 12 feature JEP 346 - Promptly Return Unused Committed Memory from G1.
///
/// JEP history:
/// - JDK 12: [JEP 346 - Promptly Return Unused Committed Memory from G1](https://openjdk.org/jeps/346)
///
/// G1 can periodically consider garbage collection during idle periods
/// to return unused committed Java heap memory to the operating system.
///
public class G1PeriodicGCDemo implements IDemo {

    @Override
    public void demo() {
        info(346);

        // JEP 346 enhances G1 so it can return unused committed heap
        // memory to the operating system during idle periods.
        //
        // Configure the periodic garbage collection interval with:
        // -XX:G1PeriodicGCInterval=5000
        //
        // The interval is measured in milliseconds.
        // A value of 0 disables periodic garbage collection.
        // Actual collection depends on JVM runtime conditions.
        //
        // Garbage collection activity can be inspected with:
        // -Xlog:gc
    }
}

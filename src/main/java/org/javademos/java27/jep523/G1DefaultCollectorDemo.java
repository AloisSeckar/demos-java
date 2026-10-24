package org.javademos.java27.jep523;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;

import org.javademos.commons.IDemo;

/// Demo for JDK 27 feature JEP 523 - Make G1 the Default Garbage Collector in All Environments.
///
/// JEP history:
/// - JDK 27: [JEP 523 - Make G1 the Default Garbage Collector in All Environments](https://openjdk.org/jeps/523)
///
/// Further reading:
/// - [JEP 248 - Make G1 the Default Garbage Collector](https://openjdk.org/jeps/248)
/// - [JEP 522 - G1: Reduce Synchronization](https://openjdk.org/jeps/522)
///
/// @author Alois Sečkár <alois.seckar@gmail.com>
public class G1DefaultCollectorDemo implements IDemo {
    @Override
    public void demo() {
        info(523);

        // Before JDK 27, the JVM selected Serial when no collector was specified and the machine
        // had a single CPU or less than 1792 MB of memory. Now G1 is always selected.
        // An explicit option such as -XX:+UseSerialGC still overrides this choice.
        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Max heap: " + Runtime.getRuntime().maxMemory() / (1024 * 1024) + " MB");

        // G1 registers beans named "G1 Young Generation", "G1 Old Generation" and "G1 Concurrent GC"
        boolean usesG1 = false;
        for (GarbageCollectorMXBean gc : ManagementFactory.getGarbageCollectorMXBeans()) {
            System.out.println("Garbage collector: " + gc.getName());
            if (gc.getName().startsWith("G1")) {
                usesG1 = true;
            }
        }
        System.out.println("G1 is the active collector: " + usesG1);

        System.out.println();
    }
}

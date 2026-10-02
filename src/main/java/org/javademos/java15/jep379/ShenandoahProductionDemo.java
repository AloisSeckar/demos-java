package org.javademos.java15.jep379;

import org.javademos.commons.IDemo;

/// Demo for JDK 15 feature JEP 379 - Shenandoah: A Low-Pause-Time Garbage Collector (Production).
///
/// JEP history:
/// - JDK 15: [JEP 379 - Shenandoah: A Low-Pause-Time Garbage Collector (Production)](https://openjdk.org/jeps/379)
///
/// Further reading:
/// - [Shenandoah GC wiki](https://wiki.openjdk.org/display/shenandoah/Main)
/// - [JEP 189 - Shenandoah: A Low-Pause-Time Garbage Collector (Experimental)](https://openjdk.org/jeps/189)
///
/// @see org.javademos.java25.jep521.GenerationalShenandoahDemo
///
/// @author alois.seckar@gmail.com
public class ShenandoahProductionDemo implements IDemo {

    @Override
    public void demo() {
        info(379);

        // Shenandoah is a low-pause-time garbage collector developed by Red Hat.
        // It was integrated into JDK 12 by JEP 189 as an experimental feature,
        // matching the status of other new GCs at that time (Epsilon, ZGC).
        // JEP 379 promotes it from "experimental" to "product" feature.

        // Shenandoah reduces GC pauses by performing evacuation (moving live objects)
        // concurrently with running application threads. Pause times therefore
        // do not grow with heap size - a 200 MB heap and a 200 GB heap
        // have similarly short pauses.

        // --- Usage ---

        // JDK 12 - 14 (experimental):
        //   java -XX:+UnlockExperimentalVMOptions -XX:+UseShenandoahGC -jar myapp.jar

        // JDK 15+ (production):
        //   java -XX:+UseShenandoahGC -jar myapp.jar

        // The change is mostly cosmetic - related Shenandoah options were moved
        // from "experimental" to "product" flag class, their default values were kept.
        // G1 remains the default garbage collector.

        // Shenandoah was already shipped as supported GC in Red Hat downstream
        // builds of JDK 8u and 11u, so the practical impact was minimal.

        // Further evolution: Generational Shenandoah (JEP 404 in JDK 24 as experimental,
        // JEP 521 in JDK 25 as product feature).
    }
}

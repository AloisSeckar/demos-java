package org.javademos.java12.jep344;

import java.lang.management.ManagementFactory;

import org.javademos.commons.IDemo;

/// Demo for JDK 12 feature JEP 344 - Abortable Mixed Collections for G1.
///
/// JEP history:
/// - JDK 12: [JEP 344 - Abortable Mixed Collections for G1](https://openjdk.org/jeps/344)
///
/// Further reading:
/// - [JDK-8190269 - JEP 344: Abortable Mixed Collections for G1](https://bugs.openjdk.org/browse/JDK-8190269)
/// - [Garbage-First (G1) Garbage Collector tuning guide](https://docs.oracle.com/en/java/javase/21/gctuning/garbage-first-g1-garbage-collector1.html)
///
/// @author alois.seckar@gmail.com
public class AbortableMixedCollectionsG1 implements IDemo {
    @Override
    public void demo() {
        info(344);

        // This JEP is an internal improvement of the G1 garbage collector (default since JDK 9),
        // so there is no new API to call from application code.

        // G1 tries to meet a user-supplied pause time target (`-XX:MaxGCPauseMillis`, 200 ms by default).
        // Before each pause it uses heuristics to pick a "collection set" - the heap regions to collect.
        // Once started, all live objects in that set had to be evacuated without stopping.
        // If heuristics worked with "stale" data (e.g. application behavior changed), the set
        // could be too large and the pause exceeded the target. This mostly happened during
        // "mixed" collections, which collect young regions plus some old regions.

        // Since JDK 12, when G1 detects it repeatedly picks too much work, it splits
        // the collection set into two parts:
        // - mandatory - must be collected at once (young regions, possibly some old regions)
        // - optional - only old regions (e.g. ~20 % of the predicted set)
        // After the mandatory part is done, G1 processes the optional part in smaller
        // increments (down to a single region) and may stop ("abort") whenever the remaining
        // pause time runs out. Space reclamation still progresses region by region.
        // As predictions become accurate again, the optional part shrinks until G1
        // fully relies on its heuristics once more.

        // The mechanism is automatic and needs no flags; it only applies when G1 is in use.
        // Collector details are visible via `-Xlog:gc+phases=debug`.
        System.out.println("Active garbage collectors:");
        ManagementFactory.getGarbageCollectorMXBeans()
                .forEach(gc -> System.out.println("- " + gc.getName()));
    }
}

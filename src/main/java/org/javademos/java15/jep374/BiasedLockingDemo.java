package org.javademos.java15.jep374;

import org.javademos.commons.IDemo;

/// Demo for JDK 15 feature JEP 374 - Deprecate and Disable Biased Locking.
///
/// JEP history:
/// - JDK 15: [JEP 374 - Deprecate and Disable Biased Locking](https://openjdk.org/jeps/374)
///
/// Further reading:
/// - [Biased Locking in HotSpot](https://wiki.openjdk.org/display/HotSpot/Biased+Locking)
///
/// @author alois.seckar@gmail.com
public class BiasedLockingDemo implements IDemo {
    @Override
    public void demo() {
        info(374);

        // Biased locking was a HotSpot optimization for `synchronized` blocks/methods.
        // It assumed a monitor would keep being locked by the same thread that first
        // acquired it, so the JVM could skip the compare-and-swap atomic instruction on
        // every subsequent lock/unlock by that thread, at the cost of an expensive
        // "revocation" if another thread later tried to acquire the same monitor.

        // This paid off for older, heavily single-threaded-synchronized code (e.g. code
        // relying on `Hashtable` or `Vector`), but modern code favors non-synchronized
        // collections (`HashMap`, `ArrayList`) or `java.util.concurrent` structures, which
        // rarely benefit from it. The optimization also added significant complexity to
        // HotSpot's synchronization subsystem, making it a maintenance burden for little
        // real-world gain.

        // With this JEP, biased locking is disabled by default starting with JDK 15.
        // It can still be re-enabled via the (now deprecated) `-XX:+UseBiasedLocking`
        // flag, together with its related tuning and diagnostic flags, all of which now
        // print a deprecation warning when used:
        // `-XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=... -XX:BiasedLockingBulkRebiasThreshold=...`
        // `-XX:BiasedLockingBulkRevokeThreshold=... -XX:BiasedLockingDecayTime=... -XX:+UseOptoBiasInlining`
        // `-XX:+PrintBiasedLockingStatistics -XX:+PrintPreciseBiasedLockingStatistics`

        // There is no Java API tied to biased locking, so there is nothing to demonstrate
        // in code; its presence (or absence) is only observable through JVM-level tooling
        // such as `jstack` monitor info or JFR events, not through the `synchronized` keyword
        // semantics themselves, which remain unchanged.
    }
}

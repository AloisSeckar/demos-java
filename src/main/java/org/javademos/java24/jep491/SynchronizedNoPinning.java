package org.javademos.java24.jep491;

import org.javademos.commons.IDemo;

/// Demo for JEP 491: **Synchronize Virtual Threads without Pinning**
///
/// JEP history:
/// - JDK 21: [JEP 444 - Virtual Threads](https://openjdk.org/jeps/444) (Introduced pinning issue with `synchronized`)
/// - JDK 24: [JEP 491 - Synchronize Virtual Threads without Pinning](https://openjdk.org/jeps/491)
///
/// @author dhruv-git-sys
public class SynchronizedNoPinning implements IDemo {

    @Override
    public void demo() {
        info(491);

        /*
         * This JEP changes the behavior of `synchronized` blocks for virtual threads.
         * Before this change, a virtual thread blocking on a monitor would "pin" its
         * carrier platform thread, preventing it from running other virtual threads.
         * After this change, the virtual thread unmounts, freeing the platform thread.
         *
         * ---
         * ✅ How to Verify This Change
         * ---
         *
         * You can observe this improved scalability by writing a simple test program:
         *
         * 1. Create a shared object to use as a lock.
         *
         * 2. Start a large number of virtual threads (e.g., 200) using a
         * `VirtualThreadPerTaskExecutor`.
         *
         * 3. Have each virtual thread execute a task that enters a `synchronized`
         * block using the shared lock object and then sleeps for a short duration
         * (e.g., `Thread.sleep(100)`).
         *
         * 4. **Observation**: Monitor the number of platform threads used by the scheduler's
         * underlying pool. Even with 200 virtual threads contending for the lock,
         * the number of active platform threads will remain very low (close to the
         * number of CPU cores). This demonstrates that the waiting virtual threads
         * have unmounted and are not pinning platform threads.
         */
    }
}
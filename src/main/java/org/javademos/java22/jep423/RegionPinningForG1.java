package org.javademos.java22.jep423;

import org.javademos.commons.IDemo;

/// Demo for JDK 22 feature **Region Pinning for G1** (JEP 423)
///
/// JEP history:
/// - JDK 22: [JEP 423 - Region Pinning for G1](https://openjdk.org/jeps/423)
///
/// Further reading:
/// - [Understanding Region Pinning in G1 GC](https://www.kosmadunikowski.com/posts/understanding-region-pinning-in-g1-gc/)
///
/// @author alois.seckar@gmail.com

public class RegionPinningForG1 implements IDemo {
    @Override
    public void demo() {
        info(423);

        // performance improvement for G1 garbage collector
        // this update allows G1 to "pin" certain regions of JVM memory
        // related to JNI native operations
        // those regions are excluded from garbage collection process
        // but GC is not completely disabled as it was before

    }
}

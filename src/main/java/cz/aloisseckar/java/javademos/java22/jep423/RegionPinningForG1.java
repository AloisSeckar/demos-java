package cz.aloisseckar.java.javademos.java22.jep423;

import cz.aloisseckar.java.javademos.commons.IDemo;

/**
 * <p>
 *   This class shows new preview feature from JDK 22 <strong>Region Pinning for G1</strong> (JEP 423)
 * </p>
 * <p>
 *   Further reading:
 *   <a href="https://www.kosmadunikowski.com/posts/understanding-region-pinning-in-g1-gc/">
 *     Understanding Region Pinning in G1 GC
 *   </a>
 * </p>
 *
 * @see <a href="https://openjdk.org/jeps/423">Region Pinning for G1</a>
 * @author alois.seckar@gmail.com
 */
public class RegionPinningForG1 implements IDemo {
    @Override
    public void demo() {
        info("JEP 423 - Region Pinning for G1", "No executable code, see RegionPinningForG1 class for further info");

        // performance improvement for G1 garbage collector
        // this update allows G1 to "pin" certain regions of JVM memory
        // related to JNI native operations
        // those regions are excluded from garbage collection process
        // but GC is not completely disabled as it was before

    }
}

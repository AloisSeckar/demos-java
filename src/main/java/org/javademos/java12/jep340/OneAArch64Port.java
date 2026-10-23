package org.javademos.java12.jep340;

import org.javademos.commons.IDemo;

/// Demo for JDK 12 feature JEP 340 - One AArch64 Port, Not Two.
///
/// JEP history:
/// - JDK 12: [JEP 340 - One AArch64 Port, Not Two](https://openjdk.org/jeps/340)
///
/// Further reading:
/// - [JDK-8209093 - JEP 340: One AArch64 Port, Not Two](https://bugs.openjdk.org/browse/JDK-8209093)
/// - [HotSpot CPU-specific sources](https://github.com/openjdk/jdk/tree/master/src/hotspot/cpu)
///
/// @author alois.seckar@gmail.com
public class OneAArch64Port implements IDemo {
    @Override
    public void demo() {
        info(340);

        // This JEP is a cleanup of HotSpot JVM sources, not a language or API change,
        // so there is no new code to call from application code.

        // Before JDK 12, there were two independent 64-bit ARM ports in the JDK:
        // - `arm64` - contributed by Oracle, sharing `src/hotspot/cpu/arm` with the 32-bit ARM port
        // - `aarch64` - the community port living in `src/hotspot/cpu/aarch64`
        // Both produced JVMs for the same 64-bit ARM hardware, which meant
        // duplicate maintenance work for every CPU-specific JVM change.

        // JDK 12 removed all `arm64`-specific sources, the related 64-bit vs. 32-bit
        // `#ifdef`s and the build option to select it. The `aarch64` port became
        // the only (and default) build for 64-bit ARM, so contributors can focus on one
        // implementation. The 32-bit ARM port was retained and validated to work as before.

        // For Java developers nothing changes - code written for the JVM keeps running
        // the same way on 64-bit ARM machines (servers, Apple Silicon, Raspberry Pi, ...).
        // The value reported in the `os.arch` system property depends on the platform:
        System.out.println("Current architecture (os.arch): " + System.getProperty("os.arch"));
    }
}

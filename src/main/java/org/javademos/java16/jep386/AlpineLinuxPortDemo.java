package org.javademos.java16.jep386;

import org.javademos.commons.IDemo;

/// Demo for JDK 16 feature JEP 386 - Alpine Linux Port.
///
/// JEP history:
/// - JDK 16: [JEP 386 - Alpine Linux Port](https://openjdk.org/jeps/386)
///
/// Further reading:
/// - [JEP 386 Details](https://openjdk.org/jeps/386)
/// - [Alpine Linux](https://alpinelinux.org/)
/// - [musl libc](https://musl.libc.org/)
///
/// @author Shuvam00032
public class AlpineLinuxPortDemo implements IDemo {

    @Override
    public void demo() {
        info(386);

        // JEP 386 provided a port of the JDK to run on Alpine Linux and other Linux distributions
        // that use the musl C standard library (libc).
        //
        // --- Why Alpine Linux and musl? ---
        // - Alpine Linux is a lightweight, security-oriented Linux distribution.
        // - It's very popular for container images due to its small size (often under 10MB).
        // - Alpine uses 'musl' as its C library, unlike most other Linux distributions that use 'glibc'.
        // - Before this JEP, running Java on Alpine required workarounds or specific builds,
        //   as the standard OpenJDK builds primarily targeted glibc.
        //
        // --- What did this JEP achieve? ---
        // - It made the necessary changes in the JDK source code (HotSpot JVM and core libraries)
        //   to compile and run correctly with musl libc.
        // - This allows standard OpenJDK builds (or builds derived from them) to target Alpine Linux directly.
        // - It simplifies deploying Java applications in Alpine-based Docker containers.
        //
        // --- How to observe the effect? ---
        // - The primary outcome is the *availability* of official or community OpenJDK builds
        //   specifically for Alpine Linux (linux-x64-musl or linux-aarch64-musl).
        // - You can run Java applications within an Alpine Linux container using a compatible JDK build.
        //
        // Example (Conceptual - Running in an Alpine Docker container):
        //   docker run -it --rm openjdk:16-jdk-alpine java -version
        //   (This would show the JDK running successfully on Alpine)
        //
        // Since this JEP is about platform support, there's no specific Java code API to demonstrate.
        // The benefit is realized at the deployment and runtime environment level.

        
    }

    
}
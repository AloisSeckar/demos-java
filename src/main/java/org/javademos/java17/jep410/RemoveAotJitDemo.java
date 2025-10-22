package org.javademos.java17.jep410;

import org.javademos.commons.IDemo;

/// Demo for JDK 17 feature JEP 410 - Remove the Experimental AOT and JIT Compiler.
///
/// This JEP removed the experimental Java-based ahead-of-time (AOT) and
/// just-in-time (JIT) Graal compiler from the JDK. These features saw little use
/// and required significant maintenance effort. The Java-Level JVM Compiler
/// Interface (JVMCI) was retained for external compiler usage (like GraalVM).
///
/// JEP history:
/// - JDK 17: [JEP 410 - Remove the Experimental AOT and JIT Compiler](https://openjdk.org/jeps/410)
/// - JDK 10: [JEP 317 - Experimental Java-Based JIT Compiler](https://openjdk.org/jeps/317) (Introduced Graal JIT)
/// - JDK 9: [JEP 295 - Ahead-of-Time Compilation](https://openjdk.org/jeps/295) (Introduced jaotc)
///
/// Further reading:
/// - [JEP 410 Details](https://openjdk.org/jeps/410)
///
/// @author Adarsh80416
public class RemoveAotJitDemo implements IDemo {

    @Override
    public void demo() {
        info(410);

        // Since this JEP is about removing features (jaotc tool, Graal JIT modules),
        // there is no specific code to demonstrate its functionality directly
        // within a standard JDK 17+ environment.

        // JEP 410 removed the experimental AOT (jaotc tool) and Graal JIT compiler modules:
        //  - jdk.aot
        //  - jdk.internal.vm.compiler
        //  - jdk.internal.vm.compiler.management
        // These features were experimental, saw little use, and were costly to maintain.
        // Developers wishing to use Graal for JIT or AOT can use GraalVM builds.
        // The JVMCI (JVM Compiler Interface) remains for external compiler integration.

        // No executable demo code needed for a removal JEP.
        System.out.println(); // Optional: Keep one println for spacing between demos.
    }
}
package org.javademos.java19.jep422;

import org.javademos.commons.IDemo;

/// Demo for JDK 19 feature JEP 422 - Linux/RISC-V Port.
///
/// JEP history:
/// - JDK 19: [JEP 422 - Linux/RISC-V Port](https://openjdk.org/jeps/422)
///
/// Further reading:
/// - [OpenJDK RISC-V Port Project](https://openjdk.org/projects/riscv/)
///
/// @author biswarup.chatterjee@tuta.io
public class LinuxRiscVPort implements IDemo {
    @Override
    public void demo() {
        info(422);
        // This JEP ports the JDK to Linux running on the RISC-V architecture — a
        // free and open instruction set architecture (ISA) that is seeing rapid adoption
        // in both academic and industrial contexts.
        //
        // The goal is to make the Java Platform run efficiently on RISC-V systems
        // without introducing new language features or APIs, ensuring Java applications
        // can execute unmodified on RISC-V hardware.
        // JEP 422 delivers a port of the JDK to Linux on the RISC-V architecture.
        // RISC-V is a modular, open-source instruction set designed to be simple,
        // extensible, and royalty-free — making it ideal for research and industry adoption.

        // The port targets the RV64GV configuration, which includes:
        // - 64-bit general-purpose registers
        // - Floating-point unit
        // - Vector instructions

        // No new Java APIs or language features are introduced.
        // The goal is to provide parity with existing JDK ports (e.g., x64, AArch64)
        // so that developers can run unmodified Java applications on RISC-V systems.

    }
}

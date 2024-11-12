package org.javademos.java23.jep471;

import org.javademos.commons.IDemo;

/// Demo for JDK 23 feature **Deprecate the Memory-Access Methods in sun.misc.Unsafe for Removal** (JEP 471)
///
/// Status: Stable
///
/// Evolution:
/// - JDK 23: [JEP 471 - Deprecate the Memory-Access Methods in sun.misc.Unsafe for Removal](https://openjdk.org/jeps/471)
///
/// Further Reading:
/// - [Embracing Safer Memory Access with JEP 471](https://foojay.io/today/unsafe-is-finally-going-away-embracing-safer-memory-access-with-jep-471/)
///
/// @see sun.misc.Unsafe
/// @author alois.seckar@gmail.com
public class DeprecateMemoryAccessMethods implements IDemo {
    @Override
    public void demo() {
        info(471);

        // methods from sun.misc.Unsafe class are now annotated
        // @Deprecated(since="23", forRemoval=true)
        // this means they are about to be removed in the upcoming versions of JDK
        // the process of removing will continue over next few releases

        // the reason behind the removal is to avoid risks resulting from incorrect usage of provided methods
        // potential problems include:
        // - memory leaks
        // - invalid memory access crashes
        // - buffer overflow security flaws

        // safer alternatives provided
        // JEP 193: Variable Handles (JDK 9)
        // JEP 454: Foreign Function & Memory API (JDK 22)
    }
}

package org.javademos.java16.jep389;

import org.javademos.commons.IDemo;

/// Demo for JDK 16 feature <strong>JEP 389 - Foreign-Linker API (Incubator)</strong>.
///
/// This was an incubator JEP. The feature is finalized in JDK 25 by JEP 454.
/// @see org.javademos.java25.jep454.ForeignFunctionMemoryDemo
///
/// @author Alois Seckar <alois.seckar@gmail.com>
public class ForeignLinkerDemo implements IDemo {
    @Override
    public void demo() {
        info(389);
    }
}

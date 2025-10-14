package org.javademos.java16.jep393;

import org.javademos.commons.IDemo;

/// Demo for JDK 16 feature <strong>JEP 393 - Foreign-Memory Access API (Third Incubator)</strong>.
///
/// This was an incubator JEP. The feature is finalized in JDK 25 by JEP 454.
/// @see org.javademos.java25.jep454.ForeignFunctionMemoryDemo
///
/// @author Alois Seckar <alois.seckar@gmail.com>
public class ForeignMemoryAccessDemo implements IDemo {
    @Override
    public void demo() {
        info(393);
    }
}

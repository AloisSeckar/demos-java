package org.javademos.java15.jep383;

import org.javademos.commons.IDemo;

/// Demo for JDK 15 feature <strong>JEP 383 - Foreign-Memory Access API (Second Incubator)</strong>.
///
/// This was an incubator JEP. The feature is finalized in JDK 25 by JEP 454.
/// @see org.javademos.java25.jep454.ForeignFunctionMemoryDemo
///
/// @author Alois Seckar <alois.seckar@gmail.com>
public class ForeignMemoryAccessDemo implements IDemo {
    @Override
    public void demo() {
        info(383);
    }
}

package org.javademos.java25.jep502;

import org.javademos.commons.IDemo;

// TODO needs to be fixed for JDK 26, since the "Stable Values" were replaced by "Lazy Constants"

/// Demo for JDK 25 feature JEP 502 - Stable Values (Preview).
///
/// Replaced with most recent [JEP 526](https://openjdk.org/jeps/526)
/// @see org.javademos.java26.jep526.LazyConstantsDemo
///
/// @author alois.seckar@gmail.com
public class StableValuesDemo implements IDemo {

    @Override
    public void demo() {
        info(502);
    }

}

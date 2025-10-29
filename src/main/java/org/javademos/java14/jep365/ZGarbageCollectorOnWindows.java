package org.javademos.java14.jep365;

import org.javademos.commons.IDemo;

/// Demo for JDK 14 feature <strong>JEP 365 - ZGC on Windows (Experimental)</strong>.
///
/// Depends on:
/// - JDK 11: [JEP 333 - ZGC: A Scalable Low-Latency Garbage Collector (Experimental)](https://openjdk.org/jeps/333)
///
/// Relates to:
/// - JDK 15: [JEP 377 - ZGC: A Scalable Low-Latency Garbage Collector (Production)](https://openjdk.org/jeps/377)
///
/// Port the ZGC garbage collector to Windows
/// @see org.javademos.java15.jep377.ZGarbageCollectorDemo
///
/// @author SanjanaMahapatra

public class ZGarbageCollectorOnWindows implements IDemo {
    @Override
    public void demo() {
        info(365);
    }
}

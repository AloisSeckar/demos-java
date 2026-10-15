package org.javademos.java12.jep189;

import org.javademos.commons.IDemo;

/// Demo for JDK 12 feature JEP 189 - Shenandoah: A Low-Pause-Time Garbage Collector (Experimental).
///
/// This was an experimental version of the feature.
/// The main demo is for the production implementation in JDK 15 (JEP 379).
/// @see org.javademos.java15.jep379.ShenandoahProductionDemo
///
/// @author alois.seckar@gmail.com
public class ShenandoahExperimental implements IDemo {
    @Override
    public void demo() {
        info(189);
    }
}

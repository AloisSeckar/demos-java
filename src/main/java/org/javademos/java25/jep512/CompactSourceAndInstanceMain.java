package org.javademos.java25.jep512;

import org.javademos.commons.IDemo;

/// Demo for JDK 25 feature **Compact Source Files and Instance Main Methods** (JEP 512)
///
/// JEP history:
/// - JDK 25: [JEP 512 - Compact Source Files and Instance Main Methods](https://openjdk.org/jeps/512)
///
/// Further reading:
/// - [Inside Java: JEP 512 Overview](https://openjdk.org/jeps/512)
///
/// @author shepherdking67
public class CompactSourceAndInstanceMain implements IDemo {

    @Override
    public void demo() {
        info(512);

        System.out.println("Compact Source Files allow simpler, smaller Java source files with default settings.");
        System.out.println("Instance main methods let you define a main method without using static.");
    }

    // Example of instance main (JEP 512 feature)
    void main(String[] args) {
        new CompactSourceAndInstanceMain().demo();
    }
}

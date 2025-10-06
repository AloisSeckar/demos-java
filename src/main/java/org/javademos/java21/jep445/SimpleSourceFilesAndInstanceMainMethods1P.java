package org.javademos.java21.jep445;

import org.javademos.commons.IDemo;

/// Demo for JDK 21 feature **JEP 445 - Unnamed Classes and Instance Main Methods (Preview)**.
///
/// This was the first preview that kicked off the effort to simplify the language for beginners,
/// allowing them to write a main method without `public static` and without an explicit class.
///
/// Finalized by **[JEP 512](https://openjdk.org/jeps/512)** in JDK 25.
///
/// @see org.javademos.java25.jep512.CompactSourceFilesAndInstanceMainMethods
///
public class SimpleSourceFilesAndInstanceMainMethods1P implements IDemo {

    @Override
    public void demo() {
        info(445);
        System.out.println("This was the first preview. See JEP 512 for the final implementation and demo.");
    }

}
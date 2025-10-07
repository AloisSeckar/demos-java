package org.javademos.java23.jep463;

import org.javademos.commons.IDemo;

/// Demo for JDK 22 feature **JEP 463 - Implicitly Declared Classes and Instance Main Methods (Second Preview)**.
///
/// This was the second preview of the feature, which simplifies writing basic Java programs
/// by removing the need for an explicit class declaration and a static main method.
///
/// Finalized by **[JEP 512](https://openjdk.org/jeps/512)** in JDK 25.
///
/// @see org.javademos.java25.jep512.CompactSourceFilesAndInstanceMainMethods
///
/// @author kishansingh956196@gmail.com
public class ImplicitlyDeclaredClassesDemo implements IDemo {

    @Override
    public void demo() {
        info(463);
//        System.out.println("This was the second preview. See JEP 512 for the final implementation and demo.");
    }

}
package org.javademos.java23.jep477;

import org.javademos.commons.IDemo;

/// Demo for JDK 23 feature **JEP 477 - Implicitly Declared Classes and Instance Main Methods (Third Preview)**.
///
/// This was the third preview of the feature, continuing the effort to provide a smoother
/// on-ramp for Java beginners.
///
/// Finalized by **[JEP 512](https://openjdk.org/jeps/512)** in JDK 25.
///
/// @see org.javademos.java25.jep512.CompactSourceFilesAndInstanceMainMethods
///
/// @author Ankit Kumar Shah @ankitkrshah30
public class ImplicitlyDeclaredClasses implements IDemo {

    @Override
    public void demo() {
        info(477);
        System.out.println("This was the third preview. See JEP 512 for the final implementation and demo.");
    }

}
package org.javademos.java23.jep477;

import org.javademos.commons.IDemo;

/// Demo for JDK 23 feature **JEP 477 - Implicitly Declared Classes and Instance Main Methods (Third Preview)**.
///
/// JEP history:
/// - JDK 23: [JEP 477 - Implicitly Declared Classes and Instance Main Methods (Third Preview)](https://openjdk.org/jeps/477)
///
/// This feature, often called "Java's simplified Hello, World!", allows beginners to write
/// programs without the formal boilerplate of class and static main method declarations.
///
/// Author: Ankit Kumar Shah @ankitkrshah30

public class ImplicitlyDeclaredClasses implements IDemo {
    @Override
    public void demo() {
        info(477);

        // With this JEP, you can create a .java file with just:
        //
        // void main() {
        //     println("Hello, Simplified World!");
        // }
        //
        // And run it with 'java MyFile.java' command.
        // The 'println' method is even auto-imported for convenience.
    }
}

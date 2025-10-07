package org.javademos.java25.jep512;

import org.javademos.commons.IDemo;
import java.util.List;

/// Demo for JDK 25 feature **JEP 512 - Compact Source Files and Instance Main Methods**.
///
/// This JEP finalizes the feature that simplifies writing beginner-level Java programs.
/// It aims to provide a smooth on-ramp for newcomers by reducing ceremony, allowing them
/// to focus on core programming concepts before diving into advanced, large-scale constructs.
///
/// JEP history:
/// This feature evolved through several preview stages:
/// - [JEP 445 (JDK 21)](https://openjdk.org/jeps/445)
/// - [JEP 463 (JDK 22)](https://openjdk.org/jeps/463)
/// - [JEP 477 (JDK 23)](https://openjdk.org/jeps/477)
/// - [JEP 495 (JDK 24)](https://openjdk.org/jeps/495)
///
/// ### Key Features Finalized
/// 1.  **Instance `main` Methods:** The `main` method no longer needs to be `public static`
///     and can omit the `String[] args` parameter.
/// 2.  **Compact Source Files:** For single-file programs, the enclosing `class` declaration
///     can be omitted. The compiler implicitly wraps the code in a class.
/// 3.  **`java.lang.IO` Class:** A new standard class for simple console I/O, available
///     without any imports.
/// 4.  **Automatic Imports:** In compact source files, all public top-level classes from
///     the `java.base` module are automatically imported.
///
/// @see org.javademos.java24.jep495.SimpleSourceFilesDemo
/// @see org.javademos.java23.jep477.ImplicitlyDeclaredClassesDemo
/// @see org.javademos.java23.jep463.ImplicitlyDeclaredClassesDemo
/// @see org.javademos.java21.jep445.UnnamedClassesDemo
///
/// @author dhruv-git-sys
public class CompactSourceFilesDemo implements IDemo {

    // A field belonging to the instance of this class.
    private final String world = "World";

    // An instance method that can be called from the instance main method.
    private String greeting() {
        return "Hello, " + this.world + "!";
    }

    // This is a launchable "instance" main method.
    // The `public static` modifiers and `String[] args` are no longer required.
    // The launcher will instantiate the class and then invoke this method.
    void main() {
//        System.out.println("--- 1. Instance main Method ---");
//        System.out.println("This `main` method is not static!");
//        System.out.println("It can directly access instance fields and methods.");
//        System.out.println(greeting());
//        System.out.println();
    }

    @Override
    public void demo() {
        info(512);

        // Run the instance main method to demonstrate its behavior.
        main();

//        System.out.println("--- 2. Compact Source Files ---");
//        System.out.println("A source file can now omit the class declaration.");
//        System.out.println("The following code could be saved in `HelloWorld.java` and run directly:");
//        System.out.println(
//                """
//                ------------------------------------------
//                // File: HelloWorld.java
//                void main() {
//                    IO.println("Hello from a compact source file!");
//                }
//                ------------------------------------------
//                """);
//
//        System.out.println("--- 3. Console I/O with `java.lang.IO` ---");
//        System.out.println("The new `java.lang.IO` class simplifies console interaction.");
//        System.out.println("Instead of `System.out.println`, we can use `IO.println`.");
//        // Note: We avoid calling IO.readln() here to prevent blocking the demo runner.
//        System.out.println("Example of reading input: String name = IO.readln(\"Enter name: \");");
//        System.out.println();
//
//
//        System.out.println("--- 4. Automatic Imports ---");
//        System.out.println("In compact source files, classes from `java.base` are auto-imported.");
//        System.out.println("For example, `java.util.List` can be used without an import statement.");
//        // In this regular class file, an import is needed. But in a compact file, it would not be.
//        List<String> names = List.of("Gavin", "Jim", "Ron");
//        System.out.println("Used `java.util.List` to create: " + names);
//        System.out.println(
//                """
//                ------------------------------------------
//                // File: NamePrinter.java (Compact Source File)
//                // No import for `List` is needed!
//                void main() {
//                    var authors = List.of("James", "Bill", "Guy");
//                    for (var name : authors) {
//                        IO.println(name);
//                    }
//                }
//                ------------------------------------------
//                """);
//
//        System.out.println("--- 5. Growing a Program ---");
//        System.out.println("A program in a compact file can be easily evolved into a regular class.");
//        System.out.println("Just wrap the code in a class declaration and add `import module java.base;`.");
    }
}
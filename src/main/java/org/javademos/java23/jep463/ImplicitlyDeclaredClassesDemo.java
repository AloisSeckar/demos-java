package org.javademos.java23.jep463;

import org.javademos.commons.IDemo;

/// Demo for JDK 23 feature **Implicitly Declared Classes and Instance Main Methods** (JEP 463)
///
/// JEP history:
/// - JDK 23 (Preview): [JEP 463 - Implicitly Declared Classes and Instance Main Methods](https://openjdk.org/jeps/463)
///
/// Further reading:
/// - [Inside Java: Implicit Classes & Instance Main](https://inside.java/2024/04/implicit-classes-instance-main/)
/// - [InfoQ: Java 23 Implicit Classes](https://www.infoq.com/news/2024/05/java-23-implicit-classes/)
///
/// @author kishansingh956196@gmail.com

public class ImplicitlyDeclaredClassesDemo implements IDemo {
    @Override
    public void demo() {
        info(463);
        System.out.println("JEP 463 allows Java source files with no explicit class declaration and supports instance main methods.");
        System.out.println("Example: The following code can be placed in a file and run directly, even without a class declaration:");
        System.out.println();
        System.out.println("void main() {\n    System.out.println(\"Hello from instance main!\");\n}");
        System.out.println();
        System.out.println("This feature is preview and requires --enable-preview flag to run.");
        System.out.println("Try it with: java --enable-preview ImplicitMain.java");
        System.out.println();
        System.out.println("For demonstration, here is a simulated invocation:");
        // Simulate what would happen if the above code was run
        new ImplicitMain().main();
    }

    // Simulated implicitly declared class
    static class ImplicitMain {
        void main() {
            System.out.println("Hello from instance main!");
        }
    }
}

package org.javademos.java23.jep463;
import org.javademos.commons.IDemo;

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

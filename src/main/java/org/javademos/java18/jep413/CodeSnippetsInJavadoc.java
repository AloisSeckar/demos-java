package org.javademos.java18.jep413;

import org.javademos.commons.IDemo;

///
/// # JEP 413: Code Snippets in Java API Documentation
///
/// @author mayankvyas1306
///
/// ## Summary
/// This JEP introduced the `@snippet` tag for Javadoc to simplify the inclusion of example
/// source code in API documentation. It provides better validation, modern styling like syntax
/// highlighting, and improved IDE support compared to the old `<pre>{@code ...}</pre>` blocks.
///
/// ## Release Information
/// - **JEP:** 413
/// - **Status:** Delivered
/// - **Release:** JDK 18
/// - **Component:** tools/javadoc(tool)
///
/// ## Resources
/// - [JEP 413: Code Snippets in Java API Documentation](https://openjdk.org/jeps/413)
///
public class CodeSnippetsInJavadoc implements IDemo {

    /**
     * An example method showing Javadoc with an inline snippet.
     * The {@code @snippet} tag makes including code examples cleaner and safer.
     * <p>
     * The following code shows how to use this method:
     * {@snippet :
     * var list = List.of("a", "b", "c");
     * var demo = new CodeSnippetsInJavadoc();
     * demo.exampleMethod(list);
     * }
     */
    public void exampleMethod(java.util.List<String> items) {
        // This method is for demonstration purposes.
    }

    @Override
    public void demo() {
        info(413);

        // System.out.println("""
        //     JEP 413 introduced the `@snippet` tag in Javadoc to modernize how code examples
        //     are embedded in documentation, replacing the cumbersome `<pre>{@code ...}</pre>`.

        //     --- Key Features ---

        //     1.  **Inline Snippets:** Code can be placed directly inside the Javadoc comment.
        //         The Javadoc for the `exampleMethod()` in this class contains an inline snippet.

        //         // This is what the Javadoc for 'exampleMethod()' looks like:
        //         /**
        //          * ...
        //          * {@snippet :
        //          * var list = List.of("a", "b", "c");
        //          * var demo = new CodeSnippetsInJavadoc();
        //          * demo.exampleMethod(list);
        //          * }
        //          */

        //     2.  **External Snippets:** You can include code from an external file, which is great
        //         for larger examples that you can validate and test separately.

        //         // An external snippet would look like this in the Javadoc:
        //         // {@snippet file="ExampleFile.java" region="some-region"}

        //     3.  **Markup Tags:** Snippets support special tags within comments to enhance the output,
        //         such as highlighting code, replacing text, or linking to other parts of the API.

        //         // Example of highlighting a line in a snippet:
        //         // class HelloWorld {
        //         //     public static void main(String... args) {
        //         //         System.out.println("Hello, World!"); // @highlight
        //         //     }
        //         // }

        //     The `@snippet` tag allows for better tooling, validation, and presentation (like
        //     syntax highlighting) in the final generated documentation.
        //     """);
    }
}
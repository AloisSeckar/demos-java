package org.javademos.java25.jep477;

import org.javademos.commons.IDemo;

/**
 * Demo for JDK 25 feature <strong>Implicitly Declared Classes and Instance Main Methods</strong> (JEP 477).
 * This feature, often called "Java's simplified Hello, World!", allows beginners to write
 * programs without the formal boilerplate of class and static main method declarations.
 *
 * @see <a href="https://openjdk.org/jeps/477">JEP 477</a>
 * @author alois.seckar@gmail.com
 */
public class ImplicitlyDeclaredClasses implements IDemo {
    @Override
    public void demo() {
        info(477);

        System.out.println("This demo doesn't run a 'Hello, World!' example directly here.");
        System.out.println("Instead, it explains the concept.");
        System.out.println("With this JEP, you can create a .java file with just:");
        System.out.println();
        System.out.println("void main() {");
        System.out.println("    println(\"Hello, Simplified World!\");");
        System.out.println("}");
        System.out.println();
        System.out.println("And run it with 'java MyFile.java'.");
        System.out.println("The 'println' method is even auto-imported for convenience.");
    }
}
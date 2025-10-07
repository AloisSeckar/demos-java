package org.javademos.java22.jep456;

import org.javademos.commons.IDemo;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/// Demo for JDK 22 feature **JEP 456 - Unnamed Patterns and Variables**.
///
/// JEP history:
/// - JDK 22: [JEP 456 - Unnamed Patterns and Variables](https://openjdk.org/jeps/456)
/// - JDK 21: [JEP 443 - Unnamed Patterns and Variables (preview)](https://openjdk.org/jeps/443)
///
/// Further reading:
/// - [Unnamed Patterns and Variables in Java](https://www.baeldung.com/java-unnamed-patterns-variables)
///
/// @author [Krushit Babariya](https://github.com/Krushit-Babariya)
///
public class UnnamedPatternsAndVariablesDemo implements IDemo {
    @Override
    public void demo() {
        info("UNNAMED PATTERNS AND VARIABLES DEMO", "Examples of 'Unnamed Patterns and Variables' feature\navailable since Java 21");

        // Unnamed variable in a try-with-resources block
        try (var _ = ScopedContext.acquire()) { 
            System.out.println("Context acquired and released automatically.");
        } catch (Exception e) {
            System.out.println("Failed to acquire context.");
        }

        // Unnamed variable in a catch block
        var str = "not a number";
        try {
            System.out.println(Integer.parseInt(str));
        } catch (NumberFormatException _) {
            System.out.println("Not a number (jep443 exception).");
        }

        // Unnamed variable in an enhanced for loop
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        for (int _ : numbers) {  
            System.out.println("Processing item in list (value ignored).");
        }

        // Unnamed variable in a queue processing
        Queue<Integer> queue = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6));
        while (queue.size() >= 3) {
            var x = queue.remove();
            var _ = queue.remove();  
            var y = queue.remove();
            System.out.println("Processed Point(" + x + ", " + y + ")");
        }
    }

    static class ScopedContext implements AutoCloseable {
        public static ScopedContext acquire() {
            return new ScopedContext();
        }

        @Override
        public void close() {
            System.out.println("Context released.");
        }
    }
}

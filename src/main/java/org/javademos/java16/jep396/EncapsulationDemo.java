package org.javademos.java16.jep396;

import org.javademos.commons.IDemo;
import java.lang.reflect.Field;
import java.lang.reflect.InaccessibleObjectException; // The key exception

/// ## JEP 396: Strongly Encapsulate JDK Internals by Default
///
/// ### History
/// Before Java 16, it was possible (though discouraged) to use Reflection to
/// access internal, private parts of the JDK. This JEP changed the default
/// behavior to block such access unless specifically permitted via command-line flags.
///
/// ### Links
/// - [Official JEP 396](https://openjdk.org/jeps/396)
///
/// @since Java 16
public class EncapsulationDemo implements IDemo {

    @Override
    public void demo() {
        //Call the info helper
        info(396);

        // The Demo: Attempt to access an internal field
        System.out.println("Attempting to access the private 'value' field of java.lang.String using Reflection...");

        try {
            // Get the private 'value' field (which holds the string's bytes)
            Field stringValueField = String.class.getDeclaredField("value");

            // Try to make it accessible (this is what JEP 396 blocks by default)
            stringValueField.setAccessible(true);

            // If we reached here without an exception, the encapsulation is not strong (e.g., older Java or --illegal-access used)
            System.out.println("WARN: Access was granted. This might happen on older Java versions or if illegal access is permitted.");
            // Example of accessing it if allowed:
            // byte[] bytes = (byte[]) stringValueField.get("hello");
            // System.out.println("Accessed internal bytes (length): " + bytes.length);

        } catch (NoSuchFieldException e) {
            System.err.println("Error: Could not find the 'value' field. Internal structure might have changed.");
            e.printStackTrace();
        } catch (InaccessibleObjectException e) {
            // SUCCESS! Catching this exception is the expected outcome in Java 16+
            System.out.println("SUCCESS: Caught InaccessibleObjectException as expected!");
            System.out.println("Message: " + e.getMessage());
            System.out.println("This demonstrates that JDK internals are strongly encapsulated by default.");
        } catch (Exception e) {
            // Catch any other unexpected exceptions
            System.err.println("An unexpected error occurred during reflection:");
            e.printStackTrace();
        }
        System.out.println("Demo complete.");
    }
}
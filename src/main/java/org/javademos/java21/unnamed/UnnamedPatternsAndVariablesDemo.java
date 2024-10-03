package org.javademos.java21.unnamed;

import org.javademos.commons.IDemo;

/**
 * This class demonstrates new feature called 'Unnamed Patterns and Variables'.
 *
 * REFERENCES:
 * Java 21 - https://openjdk.org/jeps/443 - Unnamed Patterns and Variables (Preview)
 *
 * Further reading:
 * https://www.baeldung.com/java-unnamed-patterns-variables
 *
 * NOTE:
 * This demo REQUIRES at least JDK 21.0.1 to run.
 * Initial version of JDK 21 has some issue that may cause compilation to fail.
 * https://softwaregarden.dev/en/posts/new-java/curious-case-of-jep443/
 *
 * @author alois.seckar@gmail.com
 */
public class UnnamedPatternsAndVariablesDemo implements IDemo {
    @Override
    public void demo() {
        info("UNNAMED PATTERNS AND VARIABLES DEMO", "Examples for 'Unnamed Patterns and Variables' feature\nbeing evolved since Java 20");

        var str = "not a number";

        // prior to this feature there were a lot of cases,
        // where a variable had to be declared, but its value was not required

        // before Java 21
        try {
            System.out.println(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            // "e" is unused, IDEs may complain
            System.out.println("Not a number (exception = 'e')");
        }

        // since Java 21
        try {
            System.out.println(Integer.parseInt(str));
        } catch (NumberFormatException _) {
            // marked as underscore such pseudo-variable is being ignored
            System.out.println("Not a number (unnamed exception)");
            // it is not possible to reference it
            // System.err.println(_); // compiler error - Using '_' as a reference is not allowed
        }
    }
}

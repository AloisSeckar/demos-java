package org.javademos.java17.jep403;

import org.javademos.commons.IDemo;

/// Demo for JDK 17 feature JEP 403 - Strongly Encapsulate JDK Internals.
///
/// JEP history:
/// - JDK 17: [JEP 403 - Strongly Encapsulate JDK Internals](https://openjdk.org/jeps/403)
/// - JDK 9: [JEP 260 - Encapsulate Most Internal APIs](https://openjdk.org/jeps/260) (Initial step)
///
/// Further reading:
/// - [Understanding JEP 403: Strongly Encapsulate JDK Internals](https://www.baeldung.com/java-internal-apis-strong-encapsulation)
///
/// @author Shuvam00032
public class StronglyEncapsulateInternalsDemo implements IDemo {

    @Override
    public void demo() {
        info(403);
        /*System.out.println("This feature restricts access to internal JDK APIs by default.");
        System.out.println();
        System.out.println("Why was this done?");
        System.out.println("- Improve JDK Security: Prevents unintended use of internal classes.");
        System.out.println("- Improve Maintainability: Allows JDK developers to change internal APIs without breaking user code.");
        System.out.println();
        System.out.println("What does it mean in practice?");
        System.out.println("- Code using reflection or `setAccessible(true)` to access internal packages (like `sun.*`, `jdk.internal.*`) will fail by default.");
        System.out.println("- Examples of internal APIs include classes within packages like `sun.misc`.");
        System.out.println("- If access is truly needed (discouraged), command-line flags like `--add-opens` must be used.");
        System.out.println();
        System.out.println("This demo doesn't execute restricted code, as that would require specific (and discouraged) JVM configurations.");
        System.out.println("The goal is to understand the *concept* of encapsulation enforcement.");*/

        // You could add an example comment block showing code that *would* fail:
        /*
        // Example of code that would likely fail by default under JEP 403:
        try {
            // Attempting to access an internal class via reflection
            Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
            // ... further operations would likely throw InaccessibleObjectException ...
        } catch (Exception e) {
           System.out.println("Access to internal API sun.misc.Unsafe is restricted: " + e.getMessage());
        }
        */
    }
}
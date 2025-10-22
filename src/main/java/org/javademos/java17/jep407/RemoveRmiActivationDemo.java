package org.javademos.java17.jep407;

import org.javademos.commons.IDemo;

/// Demo for JDK 17 feature JEP 407 - Remove RMI Activation.
///
/// JEP history:
/// - JDK 17: [JEP 407 - Remove RMI Activation](https://openjdk.org/jeps/407)
/// - JDK 15: [JEP 385 - Deprecate RMI Activation for Removal](https://openjdk.org/jeps/385)
///
/// Further reading:
/// - [Oracle: RMI Activation Removed](https://docs.oracle.com/en/java/javase/17/migrate/removed-apis.html#GUID-4BAD9F56-54CA-4C41-AD0F-974F87483B46)
///
/// @author Shuvam00032
public class RemoveRmiActivationDemo implements IDemo {

    @Override
    public void demo() {
        info(407);

        // JEP 407 removed the RMI Activation mechanism from Java 17.
        // RMI Activation was an older part of RMI (Remote Method Invocation) that allowed
        // objects to be automatically activated (started) on demand when a remote method call arrived.

        // Why was it removed?
        // - Obsolete Technology: RMI Activation was rarely used in modern applications.
        // - Complexity and Maintenance: It added significant complexity to the RMI system and was hard to maintain.
        // - Security Concerns: Activation mechanisms can introduce security vulnerabilities if not managed carefully.
        // - Alternatives Exist: Modern distributed systems use different approaches for service lifecycle management (e.g., containers, service discovery).

        // What was actually removed?
        // - The `java.rmi.activation` package and all its classes (like ActivationSystem, Activatable, etc.).
        // - The `rmid` tool, which was the activation system daemon.

        // IMPORTANT: Core RMI functionality (remote object interfaces, registry, remote calls) was NOT removed and still works.
        // This JEP only removed the *Activation* part.

        // Since the relevant classes and tools are gone, there's no runnable code to demonstrate.
        // Attempting to import or use classes from `java.rmi.activation` will result in a compile-time error in JDK 17+.

        /*
        // Example code that would FAIL to compile in JDK 17+:
        import java.rmi.activation.*; // <-- This import fails

        public class ActivationExample {
            // Using Activatable or ActivationSystem would cause compile errors
            // public static void main(String[] args) throws Exception {
            //     ActivationSystem system = ActivationGroup.getSystem(); // <-- Class not found
            // }
        }
        */
    }
}
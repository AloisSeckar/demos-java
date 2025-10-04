package org.javademos.java24.jep486;

import org.javademos.commons.IDemo;

/**
 * JEP 486 - Permanently Disable the Security Manager
 *
 * Demonstrates that the Security Manager has been permanently disabled.
 */
public class DisableSecurityManager implements IDemo {

    @Override
    public int runDemo() {
        System.out.println("Running JEP 486 - Permanently Disable the Security Manager demo...");

        try {
            // Attempt to set a SecurityManager
            System.setSecurityManager(new SecurityManager());
            System.out.println("SecurityManager successfully set (unexpected in JDK 24/25).");
        } catch (UnsupportedOperationException e) {
            System.out.println("Expected: Security Manager cannot be set. It is permanently disabled.");
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        return 0;
    }

    @Override
    public String getName() {
        return "JEP 486 - Permanently Disable the Security Manager";
    }

    @Override
    public String getDescription() {
        return "Demonstrates that the Security Manager has been permanently disabled in JDK 24/25.";
    }
}

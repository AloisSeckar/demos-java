package org.javademos.java24.jep486;

import org.javademos.commons.IDemo;

/**
 * JEP 486 - Permanently Disable the Security Manager
 *
 * The Security Manager API has been permanently removed.
 * This demo serves as an educational placeholder, explaining
 * that attempts to use or set a SecurityManager are no longer supported.
 */
public class DisableSecurityManager implements IDemo {

    @Override
    public void demo() {
        // JEP reference info
        info(486);

        // The Security Manager was deprecated for removal in earlier releases
        // and is now permanently disabled as of JDK 24.
        //
        // Any attempt to call System.setSecurityManager(...) results in an
        // UnsupportedOperationException.
        try {
            System.setSecurityManager(new SecurityManager()); // this is removed
        } catch (UnsupportedOperationException e) {
            System.out.println("SecurityManager is permanently disabled: " + e);
        }
    }
}

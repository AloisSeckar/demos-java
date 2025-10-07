package org.javademos.java24.jep486;

import org.javademos.commons.IDemo;

/// Demo for JDK 24 feature **JEP 486 - Permanently Disable the Security Manager**.
///
/// JEP history:
/// - JDK 24: [JEP 486 - Permanently Disable the Security Manager](https://openjdk.org/jeps/486)
///
/// Further reading:
/// - [JEP 411 (Deprecate the Security Manager)](https://openjdk.org/jeps/411)
/// - [JEP 486 - Details](https://openjdk.org/jeps/486)
///
/// @author shepherdking67
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
            System.setSecurityManager(new SecurityManager()); // removed in JDK 24+
        } catch (UnsupportedOperationException e) {
            System.out.println("SecurityManager is permanently disabled: " + e);
        }
    }
}

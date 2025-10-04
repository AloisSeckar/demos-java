package org.javademos.java24.jep493;

import org.javademos.commons.IDemo;

/// Demo for JDK 24 feature **Linking Run-Time Images without JMODs** (JEP 493)
///
/// JEP history:
/// - JDK 24: [JEP 493 - Linking Run-Time Images without JMODs](https://openjdk.org/jeps/493)
///
/// Further reading:
/// - [Inside Java: JEP 493 Overview](https://openjdk.org/jeps/493)
///
/// @author shepherdking67
public class LinkingRunTimeImages493 implements IDemo {

    @Override
    public void demo() {
        info(493);

        // JEP 493 enhances the jlink tool to allow linking run-time images
        // without requiring JMOD files. Previously, jlink depended on JMODs
        // shipped with the JDK, but now it can directly consume the class and
        // resource files from the JDK installation.
        //
        // Why this matters:
        // - Simplifies creation of custom JDK runtime images.
        // - Removes dependency on JMOD packaging.
        // - Makes jlink usage more flexible and straightforward.
        //
        // Example (shell, not Java code):
        //   jlink --add-modules java.base --output myimage
        //
        // The above works even if JMOD files are not present in the JDK.
    }
}

package org.javademos.java14.jep367;

import org.javademos.commons.IDemo;

/// Demo for JDK 14 feature JEP 367 - Remove the Pack200 Tools and API.
///
/// JEP 367 removed the Pack200 API and tools from the JDK. This demo documents the
/// removal and shows a small runtime check that the `java.util.jar.Pack200` class is
/// no longer available on the classpath of modern JDKs. Since Pack200 was removed,
/// attempting to reference the API may fail at runtime (NoClassDefFoundError) when
/// running on a JDK that no longer contains it.
///
/// JEP link: https://openjdk.org/jeps/367
/// 
/// @author adripo
public class Pack200Demo implements IDemo {

    @Override
    public void demo() {
        info(367);

        System.out.println("Checking availability of Pack200 classes at runtime...");

        try {
            // Try to load the Pack200 class reflectively. On JDKs where Pack200
            // has been removed this will throw ClassNotFoundException.
            Class.forName("java.util.jar.Pack200");
            // If the class is present, show a short note:
            System.out.println("java.util.jar.Pack200 is present on this JVM. Pack200 APIs are available.");
        } catch (ClassNotFoundException | NoClassDefFoundError ex) {
            // Expected on JDKs that removed Pack200 (JDK 14 removal)
            System.out.println("Pack200 classes are NOT available on this JVM (removed by JEP 367).");
            System.out.println("If you still need Pack200 functionality consider using an external library or alternate packaging/compression.");
            System.out.println("Pack200 was deprecated for removal earlier and removed by JEP 367 in JDK 14.");
        }

        System.out.println();
    }

}

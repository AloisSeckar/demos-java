package org.javademos.java16.jep392;

import org.javademos.commons.IDemo;

/// Demo for JDK 16 feature JEP 392 - Packaging Tool.
///
/// This JEP finalized the `jpackage` tool, which was incubated in JDK 14 (JEP 343).
/// `jpackage` creates native application bundles (installers/packages) for different platforms.
///
/// JEP history:
/// - JDK 16: [JEP 392 - Packaging Tool](https://openjdk.org/jeps/392) (Final)
/// - JDK 14: [JEP 343 - Packaging Tool (Incubator)](https://openjdk.org/jeps/343)
///
/// Further reading:
/// - [jpackage User Guide (JDK 21)](https://docs.oracle.com/en/java/javase/21/jpackage/packaging-tool-user-guide.html)
/// - [Baeldung: Guide to jpackage](https://www.baeldung.com/java-jpackage)
///
/// @author Shuvam00032
public class PackagingToolDemo implements IDemo {

    @Override
    public void demo() {
        info(392);

        // JEP 392 promoted the `jpackage` tool from incubator to a standard feature.
        // `jpackage` allows developers to create platform-specific application bundles
        // that include the Java application code, dependencies, and optionally a
        // bundled Java Runtime Environment (JRE).

        // --- What does `jpackage` do? ---
        // - Creates native installers/packages:
        //      - Windows: MSI, EXE
        //      - macOS: DMG, PKG
        //      - Linux: DEB, RPM
        // - Can bundle a custom JRE using `jlink` internally.
        // - Simplifies distribution of Java desktop applications.
        // - Allows customization of installer appearance, license files, icons, etc.

        // --- How is it used? ---
        // `jpackage` is a command-line tool. You typically run it after compiling your application.
        //
        // Example (Conceptual - Command Line):
        //   jpackage --name MyApp --input target/ --main-jar myapp.jar --main-class com.example.Main --type app-image
        //   jpackage --name MyApp --app-image <path_to_app_image> --type msi  (for Windows MSI)
        //   jpackage --name MyApp --app-image <path_to_app_image> --type dmg  (for macOS DMG)
        //
        // Required Options:
        //   --name: Name of the application.
        //   --input: Directory containing application JARs and resources.
        //   --main-jar: The primary JAR file.
        //   --main-class: The main class to launch.
        //   --type: The type of package to create (e.g., app-image, msi, dmg, deb, rpm).
        //
        // Common Optional Options:
        //   --java-options: JVM options for the bundled runtime.
        //   --runtime-image: Path to a pre-built JRE created with `jlink`. If omitted, `jpackage` can create one.
        //   --icon: Path to an application icon.
        //   --app-version: Application version string.
        //   --vendor: Application vendor string.
        //   --license-file: Path to a license file.

        // Since `jpackage` is a command-line tool executed outside the JVM process running this demo,
        // we cannot demonstrate its execution directly here. The explanation and examples focus
        // on its purpose and usage.

        
    }

    
}
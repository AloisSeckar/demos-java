package org.javademos.java23.jep458;

import org.javademos.commons.IDemo;

/// Demo for JDK 23 feature **Launch Multi-File Source-Code Programs** (JEP 458)
///
/// JEP history:
/// - JDK 23 (final): [JEP 458 - Launch Multi-File Source-Code Programs](https://openjdk.org/jeps/458)
///
/// Further reading:
/// - [Inside Java: Launch Multi-File Source Programs](https://inside.java/2024/06/launch-multi-file-source-programs/)
///
/// @author kishansingh956196@gmail.com
public class LaunchMultiFileSourceDemo implements IDemo {
    @Override
    public void demo() {
        info(458);

        // Demonstrable feature: You can run multiple source files directly without compilation.
        // Example (requires separate files in the same directory):
        // java Main.java Helper.java
        //
        // Main.java
        // public class Main { public static void main(String[] args) { Helper.greet(); } }
        //
        // Helper.java
        // public class Helper { public static void greet() { System.out.println("Hello from Helper!"); } }
    }
}

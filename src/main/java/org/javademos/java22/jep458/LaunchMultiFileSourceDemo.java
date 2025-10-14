package org.javademos.java22.jep458;

import org.javademos.commons.IDemo;

/// Demo for JDK 22 feature **JEP 458 - Launch Multi-File Source-Code Programs**.
///
/// JEP history:
/// - JDK 22 (final): [JEP 458 - Launch Multi-File Source-Code Programs](https://openjdk.org/jeps/458)
///
/// Further reading:
/// - [Introducing Multi-File Program Launching](https://www.infoq.com/news/2024/02/multi-file-program-launching/)
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
        //
        // When running `java Main.java`, both classes will be compiled and executed out of the box.
    }
}

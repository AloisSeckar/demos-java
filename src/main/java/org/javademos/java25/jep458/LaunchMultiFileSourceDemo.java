package org.javademos.java25.jep458;

import org.javademos.commons.IDemo;

/// Demo for JDK 25 feature **Launch Multi-File Source-Code Programs** (JEP 458)
///
/// JEP history:
/// - JDK 25 (final): [JEP 458 - Launch Multi-File Source-Code Programs](https://openjdk.org/jeps/458)
///
/// Further reading:
/// - [JEP 458](https://openjdk.org/jeps/458)
/// - [Inside Java: Launch Multi-File Source Programs](https://inside.java/2024/06/launch-multi-file-source-programs/)
///
/// @author kishansingh956196@gmail.com

public class LaunchMultiFileSourceDemo implements IDemo {
    @Override
    public void demo() {
        info(458);
        System.out.println("JEP 458 allows launching Java programs composed of multiple source files directly, without prior compilation.");
        System.out.println("You can now run: java Main.java Helper.java Utils.java");
        System.out.println();
        System.out.println("Example: Suppose you have these files in the same directory:");
        System.out.println();
        System.out.println("// Main.java\npublic class Main {\n    public static void main(String[] args) {\n        Helper.greet();\n    }\n}");
        System.out.println();
        System.out.println("// Helper.java\npublic class Helper {\n    public static void greet() {\n        System.out.println(\"Hello from Helper!\");\n    }\n}");
        System.out.println();
        System.out.println("You can run both files together with: java Main.java Helper.java");
        System.out.println("No need to compile first or use a jar file.");
        System.out.println();
        System.out.println("This feature is available in JDK 25 and later.");
    }
}

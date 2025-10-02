package org.javademos.java25.jep457;

import org.javademos.commons.IDemo;

/**
 * Demo for JDK 25 feature **Class-File API (Preview)** (JEP 457)
 *
 * JEP history:
 * - JDK 25: [JEP 457 - Class-File API (Preview)](https://openjdk.org/jeps/457)
 *
 * Further reading:
 * - [Inside Java - JEP Café: Class-File API](https://inside.java/2024/06/18/jepcafe-classfileapi/)
 * - [JEP 457 Specification](https://openjdk.org/jeps/457)
 *
 * @see java.lang.classfile
 * @author KishanSingh
 */

public class ClassFileApiDemo implements IDemo {
    @Override
    public void demo() {
        info(457);
        System.out.println("JEP 457 introduces a new standard API for parsing, generating, and transforming Java class files.");
        System.out.println("This API is in preview and available in the java.lang.classfile package.");
        System.out.println();
        System.out.println("--- Example: List major version of a class file ---");
        System.out.println("// The following code requires JDK 25 and --enable-preview flag.");
        System.out.println("// It demonstrates reading a class file and printing its major version.");
        System.out.println("// Uncomment and run with JDK 25 Preview:");
        System.out.println("/*");
        System.out.println("import java.lang.classfile.ClassFile;");
        System.out.println("import java.nio.file.Files;");
        System.out.println("import java.nio.file.Path;");
        System.out.println();
        System.out.println("Path path = Path.of(\"/path/to/SomeClass.class\");");
        System.out.println("byte[] bytes = Files.readAllBytes(path);");
        System.out.println("ClassFile cf = ClassFile.of().parse(bytes);");
        System.out.println("System.out.println(\"Major version: \" + cf.majorVersion());");
        System.out.println("*/");
        System.out.println();
        System.out.println("--- API Highlights ---");
        System.out.println("- Parse class files: ClassFile.of().parse(byte[])");
        System.out.println("- Inspect structure: cf.majorVersion(), cf.constantPool(), cf.methods(), etc.");
        System.out.println("- Generate/transform class files programmatically");
        System.out.println();
        System.out.println("See JEP 457 and official documentation for more advanced usage and examples.");
    }
}

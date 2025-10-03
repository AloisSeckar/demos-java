package org.javademos.java23.jep457;

import org.javademos.commons.IDemo;
import java.lang.classfile.ClassFile;
import java.nio.file.Files;
import java.nio.file.Path;

/// Demo for JDK 23 feature **Class-File API (Preview)** (JEP 457)
///
/// JEP history:
/// - JDK 23: [JEP 457 - Class-File API (Preview)](https://openjdk.org/jeps/457)
///
/// Further reading:
/// - [Inside Java - JEP Café: Class-File API](https://inside.java/2024/06/18/jepcafe-classfileapi/)
/// - [JEP 457 Specification](https://openjdk.org/jeps/457)
///
/// @see java.lang.classfile
/// @author kishansingh956196@gmail.com
public class ClassFileApiDemo implements IDemo {

    @Override
    public void demo() throws Exception {
        info(457);

        // JEP 457 introduces a standard API for parsing, generating, and transforming Java class files.
        // The API is in preview in java.lang.classfile package.

        // Example: Parse a class file and print its major version
        Path path = Path.of("path/to/SomeClass.class"); // adjust the path
        byte[] bytes = Files.readAllBytes(path);
        ClassFile cf = ClassFile.of().parse(bytes);

        // Output the major version of the class file
        System.out.println("Major version: " + cf.majorVersion());

        // You can also inspect constant pool, methods, fields, and generate/transform class files
        // e.g., cf.constantPool(), cf.methods(), cf.fields()
    }
}

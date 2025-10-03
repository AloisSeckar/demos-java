package org.javademos.java23.jep457;

import org.javademos.commons.IDemo;
import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassModel;
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
    public void demo() {
        info(457);

        // JEP 457 introduces a standard API for parsing, generating, and transforming Java class files.
        // The API is in preview in java.lang.classfile package.

        try {
            // Example: Parse a class file and print its major version
            // Using a real class file from the current project
            Path path = Path.of("target/classes/org/javademos/Main.class");
            if (!Files.exists(path)) {
                System.out.println("Class file not found. Please run 'mvn compile' first.");
                return;
            }
            
            byte[] bytes = Files.readAllBytes(path);
            // ClassFile.of().parse() returns ClassModel in JDK 25
            ClassModel classModel = ClassFile.of().parse(bytes);

            // Output the major version of the class file
            System.out.println("Major version: " + classModel.majorVersion());
            System.out.println("Minor version: " + classModel.minorVersion());
            System.out.println("Class name: " + classModel.thisClass().asInternalName());

            // You can also inspect constant pool, methods, fields, and generate/transform class files
            // System.out.println("Number of methods: " + classModel.methods().size());
            // System.out.println("Number of fields: " + classModel.fields().size());
            
        } catch (Exception e) {
            System.out.println("Error reading class file: " + e.getMessage());
        }
    }
}

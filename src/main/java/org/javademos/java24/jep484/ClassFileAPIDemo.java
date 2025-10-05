package org.javademos.java24.jep484;

import org.javademos.commons.IDemo;
import java.lang.classfile.ClassFile;
import java.nio.file.Files;
import java.nio.file.Path;

/// Demo for JDK 24 feature <strong>JEP 484 - Class-File API</strong>.
///
/// This JEP finalizes the Class-File API, which was previously in preview.
/// It provides a standard API for parsing, generating, and transforming Java class files.
///
/// @see <a href="https://openjdk.org/jeps/484">JEP 484</a>
/// @author ankitkrshah30

public class ClassFileAPIDemo implements IDemo {

    @Override
    public void demo() {
        info(484);

        try {
            // Example: Parse a class file and print its version and name.
            Path path = Path.of("target/classes/org/javademos/Main.class");
            if (!Files.exists(path)) {
                System.out.println("Class file not found. Please run 'mvn compile' first.");
                return;
            }

            byte[] bytes = Files.readAllBytes(path);
            var classModel = ClassFile.of().parse(bytes);

            System.out.println("Major version: " + classModel.majorVersion());
            System.out.println("Class name: " + classModel.thisClass().asInternalName());

        } catch (Exception e) {
            System.out.println("Error reading class file: " + e.getMessage());
        }
    }
}
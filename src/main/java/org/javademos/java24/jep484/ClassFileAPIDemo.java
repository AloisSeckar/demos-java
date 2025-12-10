package org.javademos.java24.jep484;

import org.javademos.commons.IDemo;
import java.lang.classfile.*;
import java.lang.classfile.attribute.SourceFileAttribute;
import java.lang.constant.ClassDesc;
import java.lang.constant.MethodTypeDesc;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.classfile.ClassFile.*;
import static java.lang.constant.ConstantDescs.*;

/// # Demo for JDK 24 feature JEP 484 - Class-File API
///
/// This JEP introduces a standard API for parsing, generating, and transforming Java class files.
/// 
/// ## JEP history
/// - JDK 24: [JEP 484 - Class-File API](https://openjdk.org/jeps/484)
/// - JDK 23: [JEP 466 - Class-File API (Second preview)](https://openjdk.org/jeps/466)
/// - JDK 22: [JEP 457 - Class-File API (Preview)](https://openjdk.org/jeps/457)
///
/// ## Further reading
/// - [Introduction to the Class-File API](https://www.baeldung.com/java-class-file-api)
///
/// @author ankitkrshah30 / alois.seckar@gmail.com
public class ClassFileAPIDemo implements IDemo {

    @Override
    public void demo() {
        info(484);
        
        // Example 1: Parse an existing class file
        parseClassFile();
        
        // Example 2: Generate a new class
        generateClass();
        
        // Example 3: Transform an existing class
        transformClass();
    }

    /**
     * Example 1: Parse a class file and print its details
     */
    private void parseClassFile() {
        System.out.println("1) PARSING A CLASS FILE");
        System.out.println("------------------------");
        
        try {
            Path path = Path.of("target/classes/org/javademos/Main.class");
            if (!Files.exists(path)) {
                System.out.println("Class file not found. Please run 'mvn clean install' first.");
                return;
            }

            byte[] bytes = Files.readAllBytes(path);
            var classModel = ClassFile.of().parse(bytes);

            System.out.println("Class name: " + classModel.thisClass().asInternalName());
            System.out.println("Major version: " + classModel.majorVersion());
            System.out.println("Minor version: " + classModel.minorVersion());
            System.out.println("Access flags: " + classModel.flags().flagsMask());
            System.out.println("Methods count: " + classModel.methods().size());

        } catch (Exception e) {
            System.out.println("Error reading class file: " + e.getMessage());
        }
        
        System.out.println();
    }

    /**
     * Example 2: Generate a simple class from scratch
     * Creates: public class GeneratedHello { public String sayHello() { return "Hello from generated class!"; } }
     */
    private void generateClass() {
        System.out.println("2) GENERATING A NEW CLASS");
        System.out.println("-------------------------");
        
        try {
            // Define class descriptor
            ClassDesc generatedClass = ClassDesc.of("org.javademos.jep484.GeneratedHello");
            
            // Build the class
            byte[] classBytes = ClassFile.of().build(generatedClass, classBuilder -> {
                // Add class metadata
                classBuilder.withFlags(ACC_PUBLIC);
                classBuilder.with(SourceFileAttribute.of("GeneratedHello.java"));
                
                // Add default constructor
                classBuilder.withMethod(INIT_NAME, MTD_void, ACC_PUBLIC, methodBuilder ->
                    methodBuilder.withCode(codeBuilder -> {
                        codeBuilder.aload(0);
                        codeBuilder.invokespecial(CD_Object, INIT_NAME, MTD_void);
                        codeBuilder.return_();
                    })
                );
                
                // Add sayHello() method that returns a String
                classBuilder.withMethod("sayHello", MethodTypeDesc.of(CD_String), ACC_PUBLIC, methodBuilder ->
                    methodBuilder.withCode(codeBuilder -> {
                        codeBuilder.ldc("Hello from generated class!");
                        codeBuilder.areturn();
                    })
                );
            });

            System.out.println("Generated class: " + generatedClass.displayName());
            System.out.println("Class bytes size: " + classBytes.length + " bytes");
            System.out.println("Class structure:");
            System.out.println("  - Constructor: <init>()");
            System.out.println("  - Method: sayHello() returns String");
            
            // Optionally save to file
            Path outputPath = Path.of("target/jep484/GeneratedHello.class");
            Files.createDirectories(outputPath.getParent());
            Files.write(outputPath, classBytes);
            System.out.println("Saved to: " + outputPath.toAbsolutePath());

        } catch (Exception e) {
            System.out.println("Error generating class: " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println();
    }

    /**
     * Example 3: Transform an existing class by adding a method
     */
    private void transformClass() {
        System.out.println("3) TRANSFORMING AN EXISTING CLASS");
        System.out.println("---------------------------------");
        
        try {
            Path sourcePath = Path.of("target/classes/org/javademos/Main.class");
            if (!Files.exists(sourcePath)) {
                System.out.println("Source class file not found. Please run 'mvn compile' first.");
                return;
            }

            byte[] originalBytes = Files.readAllBytes(sourcePath);
            
            // Transform: Add a new method to the existing class
            ClassFile classFile = ClassFile.of();
            byte[] transformedBytes = classFile.transformClass(classFile.parse(originalBytes),
                ClassTransform.ofStateful(() -> new ClassTransform() {
                    @Override
                    public void accept(ClassBuilder classBuilder, ClassElement classElement) {
                        // Copy all existing elements
                        classBuilder.with(classElement);
                    }
                    
                    @Override
                    public void atEnd(ClassBuilder classBuilder) {
                        // Add new method at the end
                        classBuilder.withMethod("getInfo", MethodTypeDesc.of(CD_String), ACC_PUBLIC | ACC_STATIC, methodBuilder ->
                            methodBuilder.withCode(codeBuilder -> {
                                codeBuilder.ldc("This class was transformed by Class-File API!");
                                codeBuilder.areturn();
                            })
                        );
                    }
                })
            );

            System.out.println("Original class size: " + originalBytes.length + " bytes");
            System.out.println("Transformed class size: " + transformedBytes.length + " bytes");
            System.out.println("Added method: public static String getInfo()");
            
            // Save transformed class
            Path outputPath = Path.of("target/jep484/TransformedMain.class");
            Files.createDirectories(outputPath.getParent());
            Files.write(outputPath, transformedBytes);
            System.out.println("Saved to: " + outputPath.toAbsolutePath());

        } catch (Exception e) {
            System.out.println("Error transforming class: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
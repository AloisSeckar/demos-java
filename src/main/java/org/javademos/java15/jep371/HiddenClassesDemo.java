package org.javademos.java15.jep371;

import java.lang.invoke.MethodHandles;

import org.javademos.commons.IDemo;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/// Demo for JDK 15 feature JEP 371 - Hidden Classes.
///
/// JEP history:
/// - JDK 15: [JEP 371 - Hidden Classes](https://openjdk.org/jeps/371)
///
/// Hidden classes are classes that cannot be used directly by the bytecode of other classes.
/// They are intended for use by frameworks that generate classes at runtime and use them indirectly, via reflection.
/// A hidden class may be defined as a member of an access control nest, and may be unloaded independently of other classes.
///
/// Key features:
/// - Not discoverable: cannot be linked by the JVM or discovered by Class.forName()
/// - Unloadable: can be unloaded even if their defining class loader is still reachable
/// - Access control: can be nestmates with other classes
/// - Use case: language implementations (lambdas, proxies, etc.)
///
/// Further reading:
/// - [JEP 371 Specification](https://openjdk.org/jeps/371)
/// - [Hidden Classes Tutorial](https://www.baeldung.com/java-hidden-classes)
///
/// @see java.lang.invoke.MethodHandles.Lookup#defineHiddenClass
/// @author alois.seckar@gmail.com
public class HiddenClassesDemo implements IDemo {

    @Override
    public void demo() {
        info(371);

        try {
            // Generate bytecode for a simple class with a greet() method
            byte[] classBytes = generateSimpleClass();

            // Get a Lookup object for defining hidden classes
            MethodHandles.Lookup lookup = MethodHandles.lookup();

            // Define a hidden class from the bytecode
            MethodHandles.Lookup hiddenClassLookup = lookup.defineHiddenClass(
                    classBytes,
                    true, // initialize the class
                    MethodHandles.Lookup.ClassOption.NESTMATE
            );

            // Get the Class object for the hidden class
            Class<?> hiddenClass = hiddenClassLookup.lookupClass();

            System.out.println("✓ Hidden class created successfully!");
            System.out.println("  Class name: " + hiddenClass.getName());
            System.out.println("  Is hidden: " + hiddenClass.isHidden());
            System.out.println("  Simple name: " + hiddenClass.getSimpleName());
            
            // Demonstrate that hidden classes cannot be discovered by Class.forName()
            System.out.println("\n✓ Attempting to discover hidden class by name...");
            boolean discovered = canBeDiscovered(hiddenClass.getName());
            System.out.println("  Can be discovered by Class.forName(): " + discovered);
            System.out.println("  (Expected: false - this is the key feature!)");

            // Create an instance and invoke the greet() method
            System.out.println("\n✓ Creating instance and invoking method...");
            Object instance = hiddenClass.getDeclaredConstructor().newInstance();
            var method = hiddenClass.getDeclaredMethod("greet");
            method.invoke(instance);

            // Demonstrate nest membership
            System.out.println("\n✓ Demonstrating nest membership:");
            System.out.println("  Hidden class nest host: " + hiddenClass.getNestHost().getName());
            System.out.println("  This class nest host: " + HiddenClassesDemo.class.getNestHost().getName());
            System.out.println("  Are nest mates: " + hiddenClass.getNestHost().equals(HiddenClassesDemo.class.getNestHost()));

            System.out.println("\n✓ Hidden class demonstration completed successfully!");

        } catch (Throwable e) {
            System.err.println("✗ Error demonstrating hidden classes: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /// Generates bytecode for a simple class using ASM library.
    /// This creates a class equivalent to:
    /// ```java
    /// public class HiddenExample {
    ///     public HiddenExample() {}
    ///     public void greet() {
    ///         System.out.println("  → Hello from Hidden Class!");
    ///     }
    /// }
    /// ```
    ///
    /// @return byte array containing the class file bytecode
    private byte[] generateSimpleClass() {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        
        // Define the class: public class HiddenExample extends Object
        cw.visit(
                Opcodes.V15,                    // Java 15
                Opcodes.ACC_PUBLIC,             // public class
                "HiddenExample",                // class name
                null,                           // signature (null = not generic)
                "java/lang/Object",            // superclass
                null                            // interfaces (none)
        );

        // Generate default constructor: public HiddenExample()
        MethodVisitor constructor = cw.visitMethod(
                Opcodes.ACC_PUBLIC,             // public
                "<init>",                       // constructor name
                "()V",                          // descriptor: no args, void return
                null,                           // signature
                null                            // exceptions
        );
        constructor.visitCode();
        constructor.visitVarInsn(Opcodes.ALOAD, 0);                    // load 'this'
        constructor.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                "java/lang/Object",
                "<init>",
                "()V",
                false
        );
        constructor.visitInsn(Opcodes.RETURN);
        constructor.visitMaxs(1, 1);
        constructor.visitEnd();

        // Generate greet() method: public void greet()
        MethodVisitor greetMethod = cw.visitMethod(
                Opcodes.ACC_PUBLIC,             // public
                "greet",                        // method name
                "()V",                          // descriptor: no args, void return
                null,                           // signature
                null                            // exceptions
        );
        greetMethod.visitCode();
        
        // System.out.println("  → Hello from Hidden Class!");
        greetMethod.visitFieldInsn(
                Opcodes.GETSTATIC,
                "java/lang/System",
                "out",
                "Ljava/io/PrintStream;"
        );
        greetMethod.visitLdcInsn("  → Hello from Hidden Class!");
        greetMethod.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                "java/io/PrintStream",
                "println",
                "(Ljava/lang/String;)V",
                false
        );
        greetMethod.visitInsn(Opcodes.RETURN);
        greetMethod.visitMaxs(2, 1);
        greetMethod.visitEnd();

        cw.visitEnd();
        return cw.toByteArray();
    }

    /// Attempts to discover a class by name using Class.forName().
    /// Hidden classes should NOT be discoverable this way.
    ///
    /// @param className the name of the class to look up
    /// @return true if the class can be found, false otherwise
    private boolean canBeDiscovered(String className) {
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}

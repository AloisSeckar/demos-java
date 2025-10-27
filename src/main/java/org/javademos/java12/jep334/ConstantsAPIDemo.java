package org.javademos.java12.jep334;

import java.lang.constant.ClassDesc;
import java.lang.constant.ConstantDescs;
import java.lang.constant.DirectMethodHandleDesc;
import java.lang.constant.DynamicConstantDesc;
import java.lang.constant.MethodHandleDesc;
import java.lang.constant.MethodTypeDesc;
import java.lang.invoke.MethodHandles;

import org.javademos.commons.IDemo;

/// Demo for JDK 12 feature JEP 334 - JVM Constants API.
///
/// JEP history:
/// - JDK 12: [JEP 334 - JVM Constants API](https://openjdk.org/jeps/334)
///
/// The JVM Constants API provides a set of interfaces and classes to model nominal descriptions
/// of class file and runtime artifacts, particularly constants that are loadable from the constant pool.
/// This API is useful for frameworks and libraries that generate bytecode or manipulate class files.
///
/// Key concepts:
/// - **Nominal Descriptors**: Symbolic references to classes, methods, fields, etc.
/// - **ClassDesc**: Describes a class or interface type
/// - **MethodTypeDesc**: Describes a method type signature
/// - **MethodHandleDesc**: Describes a method handle
/// - **DynamicConstantDesc**: Describes a dynamically-computed constant
///
/// Main package: java.lang.constant
///
/// Further reading:
/// - [JEP 334 Specification](https://openjdk.org/jeps/334)
/// - [java.lang.constant package](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/constant/package-summary.html)
///
/// @see java.lang.constant.ClassDesc
/// @see java.lang.constant.MethodTypeDesc
/// @see java.lang.constant.MethodHandleDesc
/// @author Abhineshhh
public class ConstantsAPIDemo implements IDemo {

    @Override
    public void demo() {
        info(334);

        try {
            demonstrateClassDesc();
            System.out.println();
            demonstrateMethodTypeDesc();
            System.out.println();
            demonstrateMethodHandleDesc();
            System.out.println();
            demonstrateDynamicConstants();
        } catch (Exception e) {
            System.err.println("✗ Error demonstrating Constants API: " + e.getMessage());
        }
    }

    /// Demonstrates ClassDesc - nominal descriptor for Class constants.
    /// ClassDesc represents a class or interface type symbolically.
    private void demonstrateClassDesc() {
        System.out.println("=== ClassDesc - Nominal Class Descriptors ===");
        System.out.println();

        // Describe primitive types
        ClassDesc intDesc = ClassDesc.of("int");
        ClassDesc stringDesc = ClassDesc.ofDescriptor("Ljava/lang/String;");
        
        // Using pre-defined constants
        ClassDesc objectDesc = ConstantDescs.CD_Object;
        ClassDesc listDesc = ConstantDescs.CD_List;

        System.out.println("✓ Primitive type descriptor:");
        System.out.println("  int descriptor: " + intDesc.descriptorString());
        System.out.println();

        System.out.println("✓ Reference type descriptors:");
        System.out.println("  String descriptor: " + stringDesc.descriptorString());
        System.out.println("  Object descriptor: " + objectDesc.descriptorString());
        System.out.println("  List descriptor: " + listDesc.descriptorString());
        System.out.println();

        // Array types
        ClassDesc stringArrayDesc = stringDesc.arrayType();
        ClassDesc intArrayDesc = ClassDesc.ofDescriptor("[I");

        System.out.println("✓ Array type descriptors:");
        System.out.println("  String[] descriptor: " + stringArrayDesc.descriptorString());
        System.out.println("  int[] descriptor: " + intArrayDesc.descriptorString());
        System.out.println();

        // Resolving to actual Class
        try {
            Class<?> resolvedClass = stringDesc.resolveConstantDesc(MethodHandles.lookup());
            System.out.println("✓ Resolved ClassDesc to actual class:");
            System.out.println("  Resolved: " + resolvedClass.getName());
        } catch (ReflectiveOperationException e) {
            System.err.println("  Failed to resolve: " + e.getMessage());
        }
    }

    /// Demonstrates MethodTypeDesc - nominal descriptor for MethodType constants.
    /// MethodTypeDesc represents a method signature symbolically.
    private void demonstrateMethodTypeDesc() {
        System.out.println("=== MethodTypeDesc - Method Type Descriptors ===");
        System.out.println();

        // Method with no parameters returning int
        MethodTypeDesc noArgsInt = MethodTypeDesc.of(ConstantDescs.CD_int);
        
        // Method taking String and returning void
        MethodTypeDesc stringToVoid = MethodTypeDesc.of(
            ConstantDescs.CD_void,
            ConstantDescs.CD_String
        );
        
        // Method taking two ints and returning int (e.g., int add(int, int))
        MethodTypeDesc binaryOp = MethodTypeDesc.of(
            ConstantDescs.CD_int,
            ConstantDescs.CD_int,
            ConstantDescs.CD_int
        );

        System.out.println("✓ Method type descriptors:");
        System.out.println("  ()int descriptor: " + noArgsInt.descriptorString());
        System.out.println("  (String)void descriptor: " + stringToVoid.descriptorString());
        System.out.println("  (int,int)int descriptor: " + binaryOp.descriptorString());
        System.out.println();

        // Changing return type
        MethodTypeDesc modifiedType = binaryOp.changeReturnType(ConstantDescs.CD_long);
        System.out.println("✓ Modified method type:");
        System.out.println("  Original: " + binaryOp.descriptorString());
        System.out.println("  Changed to return long: " + modifiedType.descriptorString());
    }

    /// Demonstrates MethodHandleDesc - nominal descriptor for MethodHandle constants.
    /// MethodHandleDesc represents a method handle symbolically.
    private void demonstrateMethodHandleDesc() throws NoSuchMethodException {
        System.out.println("=== MethodHandleDesc - Method Handle Descriptors ===");
        System.out.println();

        // Describe a static method: String.valueOf(int)
        DirectMethodHandleDesc valueOfDesc = MethodHandleDesc.ofMethod(
            DirectMethodHandleDesc.Kind.STATIC,
            ConstantDescs.CD_String,
            "valueOf",
            MethodTypeDesc.of(ConstantDescs.CD_String, ConstantDescs.CD_int)
        );

        System.out.println("✓ Static method handle descriptor:");
        System.out.println("  Method: String.valueOf(int)");
        System.out.println("  Owner: " + valueOfDesc.owner().displayName());
        System.out.println("  Name: " + valueOfDesc.methodName());
        System.out.println("  Type: " + valueOfDesc.invocationType().descriptorString());
        System.out.println();

        // Describe an instance method: String.length()
        DirectMethodHandleDesc lengthDesc = MethodHandleDesc.ofMethod(
            DirectMethodHandleDesc.Kind.VIRTUAL,
            ConstantDescs.CD_String,
            "length",
            MethodTypeDesc.of(ConstantDescs.CD_int)
        );

        System.out.println("✓ Instance method handle descriptor:");
        System.out.println("  Method: String.length()");
        System.out.println("  Kind: " + lengthDesc.kind());
        System.out.println("  Owner: " + lengthDesc.owner().displayName());
        System.out.println("  Type: " + lengthDesc.invocationType().descriptorString());
    }

    /// Demonstrates DynamicConstantDesc - nominal descriptor for dynamic constants.
    /// DynamicConstantDesc represents a constant that will be computed at runtime.
    private void demonstrateDynamicConstants() {
        System.out.println("=== DynamicConstantDesc - Dynamic Constants ===");
        System.out.println();

        // Create a bootstrap method handle for a simple constant
        DirectMethodHandleDesc bootstrapMethod = ConstantDescs.BSM_INVOKE;

        // Create a dynamic constant descriptor
        DynamicConstantDesc<Integer> dynamicInt = DynamicConstantDesc.ofNamed(
            bootstrapMethod,
            "myConstant",
            ConstantDescs.CD_Integer
        );

        System.out.println("✓ Dynamic constant descriptor:");
        System.out.println("  Constant name: myConstant");
        System.out.println("  Constant type: " + dynamicInt.constantType().displayName());
        System.out.println("  Bootstrap method: " + dynamicInt.bootstrapMethod().methodName());
        System.out.println();

        System.out.println("=== Use Cases ===");
        System.out.println("The JVM Constants API is primarily used by:");
        System.out.println("  • Bytecode generation frameworks (ASM, ByteBuddy, etc.)");
        System.out.println("  • Language implementations (Kotlin, Scala, Groovy)");
        System.out.println("  • JVM tooling and instrumentation");
        System.out.println("  • Reflection and metaprogramming libraries");
        System.out.println();
        System.out.println("It provides a type-safe way to describe constant pool entries");
        System.out.println("without directly manipulating bytecode.");
    }
}

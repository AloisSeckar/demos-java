package org.javademos.init;

import org.javademos.commons.IDemo;
import org.javademos.java23.jep455.PrimitiveTypesInPatterns;
import org.javademos.java23.jep458.LaunchMultiFileSourceDemo;
import org.javademos.java23.jep462.StructuredConcurrencyDemo;
import org.javademos.java23.jep463.ImplicitlyDeclaredClassesDemo;
import org.javademos.java23.jep466.ClassFileAPIDemo;
import org.javademos.java23.jep467.MarkdownComments;
import org.javademos.java23.jep469.VectorAPIDemo;
import org.javademos.java23.jep471.DeprecateMemoryAccessMethods;
import org.javademos.java23.jep473.StreamGatherersDemo;
import org.javademos.java23.jep474.GenerationalZGC23;
import org.javademos.java23.jep477.ImplicitlyDeclaredClasses;
import org.javademos.java23.jep480.StructuredConcurrency;
import org.javademos.java23.jep482.FlexibleConstructorBodies;

import java.util.ArrayList;

public class Java23 {

    /// @return list of demos available for JDK 23
    public static ArrayList<IDemo> getDemos() {
        var java23DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now

        // JEP 455
        java23DemoPool.add(new PrimitiveTypesInPatterns());
        // JEP 458
        java23DemoPool.add(new LaunchMultiFileSourceDemo());
        // JEP 462
        java23DemoPool.add(new StructuredConcurrencyDemo());
        // JEP 463
        java23DemoPool.add(new ImplicitlyDeclaredClassesDemo());
        // JEP 466
        java23DemoPool.add(new ClassFileAPIDemo());
        // JEP 467
        java23DemoPool.add(new MarkdownComments());
        // JEP 469
        java23DemoPool.add(new VectorAPIDemo());
        // JEP 471
        java23DemoPool.add(new DeprecateMemoryAccessMethods());
        // JEP 473
        java23DemoPool.add(new StreamGatherersDemo());
        // JEP 474
        java23DemoPool.add(new GenerationalZGC23());
        // JEP 476 - Using the full path to the class
        java23DemoPool.add(new org.javademos.java23.jep476.ScopedValues());
        // JEP 477
        java23DemoPool.add(new ImplicitlyDeclaredClasses());
        // JEP 480
        java23DemoPool.add(new StructuredConcurrency());
        // JEP 481 - Using the full path to the class
        java23DemoPool.add(new org.javademos.java23.jep481.ScopedValues());
        // JEP 482
        java23DemoPool.add(new FlexibleConstructorBodies());

        return java23DemoPool;
    }

}

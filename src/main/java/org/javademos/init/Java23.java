package org.javademos.init;

import org.javademos.commons.IDemo;
import org.javademos.java23.jep455.PrimitiveTypesInPatterns;
import org.javademos.java23.jep460.JEP460VectorApiDemo;
import org.javademos.java23.jep463.ImplicitlyDeclaredClassesDemo;
import org.javademos.java23.jep466.ClassFileAPI;
import org.javademos.java23.jep467.MarkdownComments;
import org.javademos.java23.jep469.VectorApiDemo;
import org.javademos.java23.jep471.DeprecateMemoryAccessMethods;
import org.javademos.java23.jep473.StreamGatherers;
import org.javademos.java23.jep474.GenerationalZGC23;
import org.javademos.java23.jep476.ModuleImportDeclarations;
import org.javademos.java23.jep477.ImplicitlyDeclaredClasses;
import org.javademos.java23.jep480.StructuredConcurrency;
import org.javademos.java23.jep481.ScopedValues;
import org.javademos.java23.jep482.FlexibleConstructorBodies;
import org.javademos.java23.jep457.ClassFileApiDemo;
import org.javademos.java23.jep458.LaunchMultiFileSourceDemo;
import org.javademos.java23.jep462.StructuredConcurrencyDemo;

import java.util.ArrayList;

public class Java23 {

    /// @return list of demos available for JDK 23
    public static ArrayList<IDemo> getDemos() {
        var java23DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now

        // JEP 457
        java23DemoPool.add(new ClassFileApiDemo());
        // JEP 455
        java23DemoPool.add(new PrimitiveTypesInPatterns());
        // JEP 458
        java23DemoPool.add(new LaunchMultiFileSourceDemo());
        // JEP 460
        java23DemoPool.add(new JEP460VectorApiDemo());
        // JEP 462
        java23DemoPool.add(new StructuredConcurrencyDemo());
        // JEP 463
        java23DemoPool.add(new ImplicitlyDeclaredClassesDemo());
        // JEP 466
        java23DemoPool.add(new ClassFileAPI());
        // JEP 467
        java23DemoPool.add(new MarkdownComments());
        // JEP 469
        java23DemoPool.add(new VectorApiDemo());
        // JEP 471
        java23DemoPool.add(new DeprecateMemoryAccessMethods());
        // JEP 473
        java23DemoPool.add(new StreamGatherers());
        // JEP 474
        java23DemoPool.add(new GenerationalZGC23());
        // JEP 476
        java23DemoPool.add(new ModuleImportDeclarations());
        // JEP 477
        java23DemoPool.add(new ImplicitlyDeclaredClasses());
        // JEP 480
        java23DemoPool.add(new StructuredConcurrency());
        // JEP 481
        java23DemoPool.add(new ScopedValues());
        // JEP 482
        java23DemoPool.add(new FlexibleConstructorBodies());

        return java23DemoPool;
    }

}

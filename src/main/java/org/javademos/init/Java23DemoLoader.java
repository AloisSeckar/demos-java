package org.javademos.init;

import java.util.Map;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;

import org.javademos.java23.jep455.PrimitiveTypesInPatterns;
import org.javademos.java23.jep466.ClassFileAPIDemo;
import org.javademos.java23.jep467.MarkdownComments;
import org.javademos.java23.jep469.VectorAPIDemo;
import org.javademos.java23.jep471.DeprecateMemoryAccessMethods;
import org.javademos.java23.jep473.StreamGatherersDemo;
import org.javademos.java23.jep474.GenerationalZGC23;
import org.javademos.java23.jep476.ModuleImportDeclarations;
import org.javademos.java23.jep477.ImplicitlyDeclaredClassesDemo;
import org.javademos.java23.jep480.StructuredConcurrency;
import org.javademos.java23.jep481.ScopedValuesDemo;
import org.javademos.java23.jep482.FlexibleConstructorBodies;

/**
 * Loads demos for Java 23.
 */
public class Java23DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(455, new PrimitiveTypesInPatterns());
        demos.put(466, new ClassFileAPIDemo());
        demos.put(467, new MarkdownComments());
        demos.put(469, new VectorAPIDemo());
        demos.put(471, new DeprecateMemoryAccessMethods());
        demos.put(473, new StreamGatherersDemo());
        demos.put(474, new GenerationalZGC23());
        demos.put(476, new ModuleImportDeclarations());
        demos.put(477, new ImplicitlyDeclaredClassesDemo());
        demos.put(480, new StructuredConcurrency());
        demos.put(481, new ScopedValuesDemo());
        demos.put(482, new FlexibleConstructorBodies());
    }
}

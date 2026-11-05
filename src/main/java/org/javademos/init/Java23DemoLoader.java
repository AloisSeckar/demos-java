package org.javademos.init;

import java.util.Map;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;

import org.javademos.java23.jep455.PrimitiveTypesInPatternsDemo;
import org.javademos.java23.jep466.ClassFileAPIDemo;
import org.javademos.java23.jep467.MarkdownCommentsDemo;
import org.javademos.java23.jep469.VectorAPIDemo;
import org.javademos.java23.jep471.DeprecateMemoryAccessMethodsDemo;
import org.javademos.java23.jep473.StreamGatherersDemo;
import org.javademos.java23.jep474.GenerationalZGC23Demo;
import org.javademos.java23.jep476.ModuleImportDeclarationsDemo;
import org.javademos.java23.jep477.ImplicitlyDeclaredClassesDemo;
import org.javademos.java23.jep480.StructuredConcurrencyDemo;
import org.javademos.java23.jep481.ScopedValuesDemo;
import org.javademos.java23.jep482.FlexibleConstructorBodiesDemo;

/**
 * Loads demos for Java 23.
 */
public class Java23DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(455, new PrimitiveTypesInPatternsDemo());
        demos.put(466, new ClassFileAPIDemo());
        demos.put(467, new MarkdownCommentsDemo());
        demos.put(469, new VectorAPIDemo());
        demos.put(471, new DeprecateMemoryAccessMethodsDemo());
        demos.put(473, new StreamGatherersDemo());
        demos.put(474, new GenerationalZGC23Demo());
        demos.put(476, new ModuleImportDeclarationsDemo());
        demos.put(477, new ImplicitlyDeclaredClassesDemo());
        demos.put(480, new StructuredConcurrencyDemo());
        demos.put(481, new ScopedValuesDemo());
        demos.put(482, new FlexibleConstructorBodiesDemo());
    }
}

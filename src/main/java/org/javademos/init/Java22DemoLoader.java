package org.javademos.init;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;
import org.javademos.java22.jep423.RegionPinningForG1;
import org.javademos.java22.jep447.StatementsBeforeSuper;
import org.javademos.java22.jep454.ForeignFunctionMemoryDemo;
import org.javademos.java22.jep456.UnnamedPatternsAndVariablesDemo;
import org.javademos.java22.jep457.ClassFileAPIDemo;
import org.javademos.java22.jep458.LaunchMultiFileSourceDemo;
import org.javademos.java22.jep459.StringTemplatesSecondPreview;
import org.javademos.java22.jep460.VectorAPIDemo;
import org.javademos.java22.jep461.StreamGatherersDemo;
import org.javademos.java22.jep462.StructuredConcurrencyDemo;
import org.javademos.java22.jep463.ImplicitlyDeclaredClassesDemo;
import org.javademos.java22.jep464.ScopedValuesDemo;

import java.util.Map;

/**
 * Loads demos for Java 22.
 */
public class Java22DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(423, new RegionPinningForG1());
        demos.put(447, new StatementsBeforeSuper());
        demos.put(454, new ForeignFunctionMemoryDemo());
        demos.put(456, new UnnamedPatternsAndVariablesDemo());
        demos.put(457, new ClassFileAPIDemo());
        demos.put(458, new LaunchMultiFileSourceDemo());
        demos.put(459, new StringTemplatesSecondPreview());
        demos.put(460, new VectorAPIDemo());
        demos.put(461, new StreamGatherersDemo());
        demos.put(462, new StructuredConcurrencyDemo());
        demos.put(463, new ImplicitlyDeclaredClassesDemo());
        demos.put(464, new ScopedValuesDemo());
    }
}

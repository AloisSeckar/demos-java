package org.javademos.init;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;
import org.javademos.java20.jep429.ScopedValuesDemo;
import org.javademos.java20.jep432.RecordPatterns;
import org.javademos.java20.jep433.PatternMatchingForSwitchFourthPreview;
import org.javademos.java20.jep434.ForeignFunctionMemoryDemo;
import org.javademos.java20.jep436.VirtualThreads;
import org.javademos.java20.jep437.StructuredConcurrencyDemo;
import org.javademos.java20.jep438.VectorAPIDemo;

import java.util.Map;

/**
 * Loads demos for Java 20.
 */
public class Java20DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(429, new ScopedValuesDemo());
        demos.put(432, new RecordPatterns());
        demos.put(433, new PatternMatchingForSwitchFourthPreview());
        demos.put(434, new ForeignFunctionMemoryDemo());
        demos.put(436, new VirtualThreads());
        demos.put(437, new StructuredConcurrencyDemo());
        demos.put(438, new VectorAPIDemo());
    }
}

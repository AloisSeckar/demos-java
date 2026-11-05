package org.javademos.init;

import java.util.Map;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;

import org.javademos.java19.jep405.RecordPatternsDemo;
import org.javademos.java19.jep422.LinuxRiscVPortDemo;
import org.javademos.java19.jep424.ForeignFunctionMemoryDemo;
import org.javademos.java19.jep425.VirtualThreadsDemo;
import org.javademos.java19.jep426.VectorAPIDemo;
import org.javademos.java19.jep427.PatternMatchingForSwitchThirdPreviewDemo;
import org.javademos.java19.jep428.StructuredConcurrencyDemo;

/**
 * Loads demos for Java 19.
 */
public class Java19DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(405, new RecordPatternsDemo());
        demos.put(422, new LinuxRiscVPortDemo());
        demos.put(424, new ForeignFunctionMemoryDemo());
        demos.put(425, new VirtualThreadsDemo());
        demos.put(426, new VectorAPIDemo());
        demos.put(427, new PatternMatchingForSwitchThirdPreviewDemo());
        demos.put(428, new StructuredConcurrencyDemo());
    }
}

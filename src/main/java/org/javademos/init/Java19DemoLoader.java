package org.javademos.init;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;
import org.javademos.java19.jep405.RecordPatterns;
import org.javademos.java19.jep422.LinuxRiscVPort;
import org.javademos.java19.jep424.ForeignFunctionMemoryDemo;
import org.javademos.java19.jep425.VirtualThreads;
import org.javademos.java19.jep426.VectorAPIDemo;
import org.javademos.java19.jep427.PatternMatchingForSwitchThirdPreview;
import org.javademos.java19.jep428.StructuredConcurrencyDemo;

import java.util.Map;

/**
 * Loads demos for Java 19.
 */
public class Java19DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(405, new RecordPatterns());
        demos.put(422, new LinuxRiscVPort());
        demos.put(424, new ForeignFunctionMemoryDemo());
        demos.put(425, new VirtualThreads());
        demos.put(426, new VectorAPIDemo());
        demos.put(427, new PatternMatchingForSwitchThirdPreview());
        demos.put(428, new StructuredConcurrencyDemo());
    }
}

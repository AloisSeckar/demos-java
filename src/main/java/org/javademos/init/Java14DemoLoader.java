package org.javademos.init;

import org.javademos.commons.IDemo;
import org.javademos.java14.jep305.InstanceofPatternMatchingPreview;
import org.javademos.java14.jep359.RecordsPreviewDemo;
import org.javademos.java14.jep370.ForeignMemoryAccessDemo;

import java.util.Map;

/**
 * Loads demos for Java 14.
 */
public class Java14DemoLoader implements DemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(305, new InstanceofPatternMatchingPreview());
        demos.put(359, new RecordsPreviewDemo());
        demos.put(370, new ForeignMemoryAccessDemo());
    }
}

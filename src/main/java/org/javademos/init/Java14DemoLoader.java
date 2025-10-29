package org.javademos.init;

import java.util.Map;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;
import org.javademos.java14.jep305.InstanceofPatternMatchingPreview;
import org.javademos.java14.jep358.NullPointerDemo;
import org.javademos.java14.jep359.RecordsPreviewDemo;
import org.javademos.java14.jep361.SwitchExpressionsDemo;
import org.javademos.java14.jep365.ZGarbageCollectorOnWindows;
import org.javademos.java14.jep368.TextBlockSecondPreviewDemo;
import org.javademos.java14.jep370.ForeignMemoryAccessDemo;

/**
 * Loads demos for Java 14.
 */
public class Java14DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(305, new InstanceofPatternMatchingPreview()); // JEP 305
        demos.put(358, new NullPointerDemo()); // JEP 358
        demos.put(359, new RecordsPreviewDemo()); // JEP 359
        demos.put(361, new SwitchExpressionsDemo()); // JEP 361
        demos.put(365, new ZGarbageCollectorOnWindows()); // JEP 365
        demos.put(368, new TextBlockSecondPreviewDemo()); // JEP 368
        demos.put(370, new ForeignMemoryAccessDemo()); // JEP 370
    }
}

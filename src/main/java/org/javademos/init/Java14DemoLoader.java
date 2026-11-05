package org.javademos.init;

import java.util.Map;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;
import org.javademos.java14.jep305.InstanceofPatternMatchingDemo;
import org.javademos.java14.jep343.PackagingToolDemo;
import org.javademos.java14.jep345.NumaAwareG1Demo;
import org.javademos.java14.jep349.JFREventStreamingDemo;
import org.javademos.java14.jep352.NonVolatileMappedByteBuffersDemo;
import org.javademos.java14.jep358.NullPointerDemo;
import org.javademos.java14.jep359.RecordsDemo;
import org.javademos.java14.jep361.SwitchExpressionsDemo;
import org.javademos.java14.jep362.SolarisSparcRemovalDemo;
import org.javademos.java14.jep363.RemoveTheCMSGarbageCollectorDemo;
import org.javademos.java14.jep364.ZGarbageCollectorOnMacOSDemo;
import org.javademos.java14.jep365.ZGarbageCollectorOnWindowsDemo;
import org.javademos.java14.jep366.ParallelScavengeGCCombinationDemo;
import org.javademos.java14.jep367.Pack200Demo;
import org.javademos.java14.jep368.TextBlockDemo;
import org.javademos.java14.jep370.ForeignMemoryAccessDemo;

/**
 * Loads demos for Java 14.
 */
public class Java14DemoLoader implements IDemoLoader {

    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(305, new InstanceofPatternMatchingDemo());
        demos.put(343, new PackagingToolDemo());
        demos.put(345, new NumaAwareG1Demo());
        demos.put(349, new JFREventStreamingDemo());
        demos.put(352, new NonVolatileMappedByteBuffersDemo());
        demos.put(358, new NullPointerDemo());
        demos.put(359, new RecordsDemo());
        demos.put(361, new SwitchExpressionsDemo());
        demos.put(362, new SolarisSparcRemovalDemo());
        demos.put(363, new RemoveTheCMSGarbageCollectorDemo());
        demos.put(364, new ZGarbageCollectorOnMacOSDemo());
        demos.put(365, new ZGarbageCollectorOnWindowsDemo());
        demos.put(366, new ParallelScavengeGCCombinationDemo());
        demos.put(367, new Pack200Demo());
        demos.put(368, new TextBlockDemo());
        demos.put(370, new ForeignMemoryAccessDemo());
    }
}

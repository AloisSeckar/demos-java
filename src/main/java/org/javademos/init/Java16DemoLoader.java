package org.javademos.init;

import org.javademos.commons.IDemo;
import org.javademos.java16.jep338.VectorAPIDemo;
import org.javademos.java16.jep347.Cpp14FeaturesDemo;
import org.javademos.java16.jep380.UnixDomainSocketsDemo;
import org.javademos.java16.jep386.AlpineLinuxPortDemo;
import org.javademos.java16.jep388.WindowsPortDemo;
import org.javademos.java16.jep389.ForeignLinkerDemo;
import org.javademos.java16.jep390.ValueBasedClassesDemo;
import org.javademos.java16.jep392.PackagingToolDemo;
import org.javademos.java16.jep393.ForeignMemoryAccessDemo;
import org.javademos.java16.jep394.InstanceofPatternMatchingDemo;
import org.javademos.java16.jep395.RecordDemo;
import org.javademos.java16.jep396.EncapsulationDemo;
import org.javademos.java16.jep397.SealedClassesDemo;

import java.util.Map;

/**
 * Loads demos for Java 16.
 */
public class Java16DemoLoader implements DemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(338, new VectorAPIDemo());
        demos.put(347, new Cpp14FeaturesDemo());
        demos.put(380, new UnixDomainSocketsDemo());
        demos.put(386, new AlpineLinuxPortDemo());
        demos.put(388, new WindowsPortDemo());
        demos.put(389, new ForeignLinkerDemo());
        demos.put(390, new ValueBasedClassesDemo());
        demos.put(392, new PackagingToolDemo());
        demos.put(393, new ForeignMemoryAccessDemo());
        demos.put(394, new InstanceofPatternMatchingDemo());
        demos.put(395, new RecordDemo());
        demos.put(396, new EncapsulationDemo());
        demos.put(397, new SealedClassesDemo());
    }
}

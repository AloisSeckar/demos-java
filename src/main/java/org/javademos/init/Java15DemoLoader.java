package org.javademos.init;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;
import org.javademos.java15.jep339.EdDSADemo;
import org.javademos.java15.jep360.SealedClassesDemo;
import org.javademos.java15.jep371.HiddenClassesDemo;
import org.javademos.java15.jep372.NashornRemovalDemo;
import org.javademos.java15.jep373.DatagramSocketDemo;
import org.javademos.java15.jep375.InstanceofPatternMatchingSecondPreview;
import org.javademos.java15.jep381.SolarisSparcRemovalDemo;
import org.javademos.java15.jep383.ForeignMemoryAccessDemo;
import org.javademos.java15.jep384.RecordsSecondPreviewDemo;

import java.util.Map;

/**
 * Loads demos for Java 15.
 */
public class Java15DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(339, new EdDSADemo());
        demos.put(360, new SealedClassesDemo());
        demos.put(371, new HiddenClassesDemo());
        demos.put(372, new NashornRemovalDemo());
        demos.put(373, new DatagramSocketDemo());
        demos.put(375, new InstanceofPatternMatchingSecondPreview());
        demos.put(381, new SolarisSparcRemovalDemo());
        demos.put(383, new ForeignMemoryAccessDemo());
        demos.put(384, new RecordsSecondPreviewDemo());
    }
}

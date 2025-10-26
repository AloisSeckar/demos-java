package org.javademos.init;

import org.javademos.commons.IDemo;
import org.javademos.java17.jep306.RestoreAlwaysStrictFloatingPointSemanticsDemo;
import org.javademos.java17.jep356.RandomGeneratorsDemo;
import org.javademos.java17.jep382.MacosRenderingPipelineDemo;
import org.javademos.java17.jep391.MacOsAarch64PortDemo;
import org.javademos.java17.jep398.DeprecateAppletApiForRemovalDemo;
import org.javademos.java17.jep403.StronglyEncapsulateInternalsDemo;
import org.javademos.java17.jep406.PatternMatchingForSwitchPreview;
import org.javademos.java17.jep407.RemoveRmiActivationDemo;
import org.javademos.java17.jep409.SealedDemo;
import org.javademos.java17.jep410.RemoveAotJitDemo;
import org.javademos.java17.jep411.DeprecateSecurityManagerDemo;
import org.javademos.java17.jep412.ForeignFunctionMemoryDemo;
import org.javademos.java17.jep414.VectorAPIDemo;
import org.javademos.java17.jep415.ContextSpecificDeserializationFiltersDemo;

import java.util.Map;

/**
 * Loads demos for Java 17.
 */
public class Java17DemoLoader implements DemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(356, new RandomGeneratorsDemo());
        demos.put(306, new RestoreAlwaysStrictFloatingPointSemanticsDemo());
        demos.put(382, new MacosRenderingPipelineDemo());
        demos.put(391, new MacOsAarch64PortDemo());
        demos.put(398, new DeprecateAppletApiForRemovalDemo());
        demos.put(403, new StronglyEncapsulateInternalsDemo());
        demos.put(406, new PatternMatchingForSwitchPreview());
        demos.put(407, new RemoveRmiActivationDemo());
        demos.put(409, new SealedDemo());
        demos.put(410, new RemoveAotJitDemo());
        demos.put(411, new DeprecateSecurityManagerDemo());
        demos.put(412, new ForeignFunctionMemoryDemo());
        demos.put(414, new VectorAPIDemo());
        demos.put(415, new ContextSpecificDeserializationFiltersDemo());
    }
}

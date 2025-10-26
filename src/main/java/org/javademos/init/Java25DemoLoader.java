package org.javademos.init;

import org.javademos.commons.IDemo;
import org.javademos.java25.jep470.PemEncodingsDemo;
import org.javademos.java25.jep502.StableValuesDemo;
import org.javademos.java25.jep503.Remove32BitX86Demo;
import org.javademos.java25.jep505.StructuredConcurrencyDemo;
import org.javademos.java25.jep506.ScopedValuesDemo;
import org.javademos.java25.jep507.PrimitiveTypesDemo;
import org.javademos.java25.jep508.VectorAPIDemo;
import org.javademos.java25.jep509.CpuTimeProfilingDemo;
import org.javademos.java25.jep510.KeyDerivationFunctionDemo;
import org.javademos.java25.jep511.ModuleImportDeclarationsDemo;
import org.javademos.java25.jep512.CompactSourceFilesDemo;
import org.javademos.java25.jep513.FlexibleConstructorBodiesDemo;
import org.javademos.java25.jep514.AheadOfTimeCLIDemo;
import org.javademos.java25.jep515.AheadOfTimeMethodProfilingDemo;
import org.javademos.java25.jep518.JFRCooperativeSamplingDemo;
import org.javademos.java25.jep519.CompactObjectHeaderDemo;
import org.javademos.java25.jep520.Jep520MethodTracingDemo;
import org.javademos.java25.jep521.GenerationalShenandoahDemo;

import java.util.Map;

/**
 * Loads demos for Java 25.
 */
public class Java25DemoLoader implements DemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(470, new PemEncodingsDemo());
        demos.put(502, new StableValuesDemo());
        demos.put(503, new Remove32BitX86Demo());
        demos.put(505, new StructuredConcurrencyDemo());
        demos.put(506, new ScopedValuesDemo());
        demos.put(507, new PrimitiveTypesDemo());
        demos.put(508, new VectorAPIDemo());
        demos.put(509, new CpuTimeProfilingDemo());
        demos.put(510, new KeyDerivationFunctionDemo());
        demos.put(511, new ModuleImportDeclarationsDemo());
        demos.put(512, new CompactSourceFilesDemo());
        demos.put(513, new FlexibleConstructorBodiesDemo());
        demos.put(514, new AheadOfTimeCLIDemo());
        demos.put(515, new AheadOfTimeMethodProfilingDemo());
        demos.put(518, new JFRCooperativeSamplingDemo());
        demos.put(519, new CompactObjectHeaderDemo());
        demos.put(520, new Jep520MethodTracingDemo());
        demos.put(521, new GenerationalShenandoahDemo());
    }
}

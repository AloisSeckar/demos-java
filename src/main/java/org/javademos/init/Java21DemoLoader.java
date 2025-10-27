package org.javademos.init;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;
import org.javademos.java21.jep430.StringTemplatesDemo;
import org.javademos.java21.jep431.SequencedCollectionsDemo;
import org.javademos.java21.jep439.GenerationalZGC21;
import org.javademos.java21.jep440.RecordPatternsDemo;
import org.javademos.java21.jep441.PatternMatchingForSwitchDemo;
import org.javademos.java21.jep442.ForeignFunctionMemoryDemo;
import org.javademos.java21.jep443.UnnamedPatternsAndVariablesPreview;
import org.javademos.java21.jep444.VirtualThreadsDemo;
import org.javademos.java21.jep445.UnnamedClassesDemo;
import org.javademos.java21.jep446.ScopedValuesDemo;
import org.javademos.java21.jep448.VectorAPIDemo;
import org.javademos.java21.jep449.DeprecateWindows32BitX86Demo;
import org.javademos.java21.jep451.DisallowDynamicAgentLoading;
import org.javademos.java21.jep452.KeyEncapsulationMechanismAPIDemo;
import org.javademos.java21.jep453.StructuredConcurrencyDemo;

import java.util.Map;

/**
 * Loads demos for Java 21.
 */
public class Java21DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(430, new StringTemplatesDemo());
        demos.put(431, new SequencedCollectionsDemo());
        demos.put(439, new GenerationalZGC21());
        demos.put(440, new RecordPatternsDemo());
        demos.put(441, new PatternMatchingForSwitchDemo());
        demos.put(442, new ForeignFunctionMemoryDemo());
        demos.put(443, new UnnamedPatternsAndVariablesPreview());
        demos.put(444, new VirtualThreadsDemo());
        demos.put(445, new UnnamedClassesDemo());
        demos.put(446, new ScopedValuesDemo());
        demos.put(448, new VectorAPIDemo());
        demos.put(449, new DeprecateWindows32BitX86Demo());
        demos.put(451, new DisallowDynamicAgentLoading());
        demos.put(452, new KeyEncapsulationMechanismAPIDemo());
        demos.put(453, new StructuredConcurrencyDemo());
    }
}

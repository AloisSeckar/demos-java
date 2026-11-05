package org.javademos.init;

import java.util.Map;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;

import org.javademos.java12.jep189.ShenandoahExperimentalDemo;
import org.javademos.java12.jep230.MicrobenchmarkSuiteDemo;
import org.javademos.java12.jep325.SwitchExpressionsDemo;
import org.javademos.java12.jep334.ConstantsAPIDemo;
import org.javademos.java12.jep340.OneAArch64PortDemo;
import org.javademos.java12.jep341.DefaultCDSArchivesDemo;
import org.javademos.java12.jep344.AbortableMixedCollectionsG1Demo;
import org.javademos.java12.jep346.PromptlyReturnMemoryG1Demo;

/**
 * Loads demos for Java 12.
 */
public class Java12DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(189, new ShenandoahExperimentalDemo());
        demos.put(230, new MicrobenchmarkSuiteDemo());
        demos.put(325, new SwitchExpressionsDemo());
        demos.put(334, new ConstantsAPIDemo());
        demos.put(340, new OneAArch64PortDemo());
        demos.put(341, new DefaultCDSArchivesDemo());
        demos.put(344, new AbortableMixedCollectionsG1Demo());
        demos.put(346, new PromptlyReturnMemoryG1Demo());
    }
}

package org.javademos.init;

import java.util.Map;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;

import org.javademos.java12.jep189.ShenandoahExperimental;
import org.javademos.java12.jep230.MicrobenchmarkSuite;
import org.javademos.java12.jep325.SwitchExpressionsPreview;
import org.javademos.java12.jep334.ConstantsAPIDemo;
import org.javademos.java12.jep340.OneAArch64Port;
import org.javademos.java12.jep341.DefaultCDSArchives;

/**
 * Loads demos for Java 12.
 */
public class Java12DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(189, new ShenandoahExperimental());
        demos.put(230, new MicrobenchmarkSuite());
        demos.put(325, new SwitchExpressionsPreview());
        demos.put(334, new ConstantsAPIDemo());
        demos.put(340, new OneAArch64Port());
        demos.put(341, new DefaultCDSArchives());
    }
}

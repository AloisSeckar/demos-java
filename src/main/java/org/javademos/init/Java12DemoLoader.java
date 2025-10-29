package org.javademos.init;

import java.util.Map;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;

import org.javademos.java12.jep325.SwitchExpressionsPreview;
import org.javademos.java12.jep334.ConstantsAPIDemo;

/**
 * Loads demos for Java 12.
 */
public class Java12DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(325, new SwitchExpressionsPreview());
        demos.put(334, new ConstantsAPIDemo());
    }
}

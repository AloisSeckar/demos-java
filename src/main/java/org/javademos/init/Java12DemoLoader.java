package org.javademos.init;

import java.util.Map;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;
import org.javademos.java12.jep334.ConstantsAPIDemo;

/**
 * Loads demos for Java 12.
 */
public class Java12DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        // JEP 334
        demos.put(334, new ConstantsAPIDemo());
    }
}

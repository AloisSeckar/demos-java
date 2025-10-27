package org.javademos.init;

import java.util.Map;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;
import org.javademos.java13.jep354.SwitchExpressionsSecondPreview;

/**
 * Loads demos for Java 13.
 */
public class Java13DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        // JEP 354
        demos.put(354, new SwitchExpressionsSecondPreview());
    }
}

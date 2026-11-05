package org.javademos.init;

import java.util.Map;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;

import org.javademos.java13.jep350.DynamicCDSArchivesDemo;
import org.javademos.java13.jep351.ZGCUncommitUnusedMemoryDemo;
import org.javademos.java13.jep353.NioSocketImplDemo;
import org.javademos.java13.jep354.SwitchExpressionsSecondPreviewDemo;
import org.javademos.java13.jep355.TextBlockFirstPreviewDemo;

/**
 * Loads demos for Java 13.
 */
public class Java13DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(350, new DynamicCDSArchivesDemo());
        demos.put(351, new ZGCUncommitUnusedMemoryDemo());
        demos.put(353, new NioSocketImplDemo());
        demos.put(354, new SwitchExpressionsSecondPreviewDemo());
        demos.put(355, new TextBlockFirstPreviewDemo());
    }
}

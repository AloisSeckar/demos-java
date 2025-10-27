package org.javademos.init;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;
import org.javademos.java14.jep370.ForeignMemoryAccessDemo;

import java.util.Map;

/**
 * Loads demos for Java 13.
 */
public class Java13DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        //TODO add demos for java 13

        //demos.put(123, new FutureDemo());
    }
}

package org.javademos.init;

import java.util.Map;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;

import org.javademos.java27.jep537.VectorAPIDemo;

/**
 * Loads demos for Java 27.
 */
public class Java27DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(537, new VectorAPIDemo());
    }
}

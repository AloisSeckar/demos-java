package org.javademos.init;

import java.util.Map;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;

import org.javademos.java26.jep517.Http3Demo;
import org.javademos.java26.jep522.ReduceSyncDemo;
import org.javademos.java26.jep526.LazyConstantsDemo;
import org.javademos.java26.jep529.VectorAPIDemo;

/**
 * Loads demos for Java 26.
 */
public class Java26DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(517, new Http3Demo());
        demos.put(522, new ReduceSyncDemo());
        demos.put(526, new LazyConstantsDemo());
        demos.put(529, new VectorAPIDemo());
    }
}

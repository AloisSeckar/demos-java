package org.javademos.init;

import org.javademos.commons.IDemo;

import java.util.Map;

/**
 * Loads demos for Java 12.
 */
public class Java12DemoLoader implements DemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        //TODO align old demos and add necessary JDKInfo.json

        // Java 12
//        demos.put(12, new String12Demo());
    }
}

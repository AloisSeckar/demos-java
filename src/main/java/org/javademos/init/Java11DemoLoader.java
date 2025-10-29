package org.javademos.init;

import java.util.Map;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;

/**
 * Loads demos for Java 11.
 */
public class Java11DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        //TODO align old demos and add necessary JDKInfo.json

        // Java 11
//        demos.put(11, new J9Demo());
//        demos.put(11, new VarDemo());
//        demos.put(11, new HttpDemo());
//        demos.put(11, new String11Demo());
    }
}

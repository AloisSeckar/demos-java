package org.javademos.init;

import java.util.ArrayList;

import org.javademos.commons.IDemo;
import org.javademos.java15.jep383.ForeignMemoryAccessDemo;

public class Java15 {

    /**
     * @return list of demos available for JDK 15
     */
    public static ArrayList<IDemo> getDemos() {
        var java15DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now

        // JEP 383
        java15DemoPool.add(new ForeignMemoryAccessDemo());

        return java15DemoPool;
    }
}

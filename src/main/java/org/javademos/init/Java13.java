package org.javademos.init;

import org.javademos.commons.IDemo;

import java.util.ArrayList;

public class Java13 {

    /**
     * @return list of demos available for JDK 13
     */
    public static ArrayList<IDemo> getDemos() {
        var java13DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now
        
        // JEP xxx
        // java13DemoPool.add(new xyz());

        return java13DemoPool;
    }

}

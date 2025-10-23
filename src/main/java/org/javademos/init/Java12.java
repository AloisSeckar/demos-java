package org.javademos.init;

import org.javademos.commons.IDemo;

import java.util.ArrayList;

public class Java12 {

    /**
     * @return list of demos available for JDK 12
     */
    public static ArrayList<IDemo> getDemos() {
        var java12DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now
        
        // JEP xxx
        // java12DemoPool.add(new xyz());

        return java12DemoPool;
    }

}

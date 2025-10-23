package org.javademos.init;

import org.javademos.commons.IDemo;
import org.javademos.java12.extras.String12Demo;

import java.util.ArrayList;

public class Java12 {

    /**
     * @return list of demos available for JDK 12
     */
    public static ArrayList<IDemo> getDemos() {
        var java12DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now
        
        // extra features not related to any JEP
        java12DemoPool.add(new String12Demo());
        // JEP xxx
        // java12DemoPool.add(new xyz());

        return java12DemoPool;
    }

}

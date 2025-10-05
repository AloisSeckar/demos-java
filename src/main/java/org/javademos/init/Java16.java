package org.javademos.init;

import java.util.ArrayList;

import org.javademos.commons.IDemo;
import org.javademos.java16.jep338.VectorAPIDemo;

public class Java16 {

    /**
     * @return list of demos available for JDK 16
     */
    public static ArrayList<IDemo> getDemos() {
        var java16DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now

        // JEP 338
        java16DemoPool.add(new VectorAPIDemo());

        return java16DemoPool;
    }
}
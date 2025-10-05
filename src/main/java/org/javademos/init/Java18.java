package org.javademos.init;

import java.util.ArrayList;

import org.javademos.commons.IDemo;
import org.javademos.java18.jep417.VectorAPIDemo;

public class Java18 {

    /**
     * @return list of demos available for JDK 18
     */
    public static ArrayList<IDemo> getDemos() {
        var java18DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now

        // JEP 417
        java18DemoPool.add(new VectorAPIDemo());

        return java18DemoPool;
    }
}
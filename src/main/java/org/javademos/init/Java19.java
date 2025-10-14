package org.javademos.init;

import java.util.ArrayList;

import org.javademos.commons.IDemo;
import org.javademos.java19.jep424.ForeignFunctionMemoryDemo;
import org.javademos.java19.jep426.VectorAPIDemo;

public class Java19 {

    /**
     * @return list of demos available for JDK 19
     */
    public static ArrayList<IDemo> getDemos() {
        var java19DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now

        // JEP 424
        java19DemoPool.add(new ForeignFunctionMemoryDemo());
        // JEP 426
        java19DemoPool.add(new VectorAPIDemo());

        return java19DemoPool;
    }
}
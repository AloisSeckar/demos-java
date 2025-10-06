package org.javademos.init;

import java.util.ArrayList;

import org.javademos.commons.IDemo;
import org.javademos.java20.jep429.ScopedValuesIncubator;
import org.javademos.java20.jep438.VectorAPIDemo;

public class Java20 {

    /**
     * @return list of demos available for JDK 20
     */
    public static ArrayList<IDemo> getDemos() {
        var java20DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now

        // JEP 429
        java20DemoPool.add(new ScopedValuesIncubator());
        // JEP 438
        java20DemoPool.add(new VectorAPIDemo());

        return java20DemoPool;
    }
}
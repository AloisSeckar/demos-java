package org.javademos.init;

import org.javademos.commons.IDemo;
import org.javademos.java22.jep423.RegionPinningForG1;
import org.javademos.java22.jep447.StatementsBeforeSuper;
import org.javademos.java22.jep454.ForeignFunctionMemoryDemo;
import org.javademos.java22.jep456.UnnamedPatternsAndVariablesDemo;
import org.javademos.java22.jep461.StreamGatherers;
import org.javademos.java22.jep464.ScopedValues;

import java.util.ArrayList;

public class Java22 {

    /**
     * @return list of demos available for JDK 22
     */
    public static ArrayList<IDemo> getDemos() {
        var java22DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now
        java22DemoPool.add(new RegionPinningForG1());
        java22DemoPool.add(new StatementsBeforeSuper());
        java22DemoPool.add(new ForeignFunctionMemoryDemo());
        java22DemoPool.add(new UnnamedPatternsAndVariablesDemo());
        java22DemoPool.add(new StreamGatherers());
        java22DemoPool.add(new ScopedValues());

        return java22DemoPool;
    }
}

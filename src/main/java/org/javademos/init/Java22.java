package org.javademos.init;

import org.javademos.commons.IDemo;
import org.javademos.java22.jep423.RegionPinningForG1;
import org.javademos.java22.jep447.StatementsBeforeSuper;
import org.javademos.java22.jep454.ForeignFunctionMemoryDemo;
import org.javademos.java22.jep456.UnnamedPatternsAndVariablesDemo;
import org.javademos.java22.jep457.ClassFileAPIDemo;
import org.javademos.java22.jep459.StringTemplatesSecondPreview;
import org.javademos.java22.jep460.VectorAPIDemo;
import org.javademos.java22.jep461.StreamGatherersDemo;
import org.javademos.java22.jep463.ImplicitlyDeclaredClassesDemo;
import org.javademos.java22.jep464.ScopedValuesDemo;

import java.util.ArrayList;

public class Java22 {

    /**
     * @return list of demos available for JDK 22
     */
    public static ArrayList<IDemo> getDemos() {
        var java22DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now

        // JEP 423
        java22DemoPool.add(new RegionPinningForG1());
        // JEP 447
        java22DemoPool.add(new StatementsBeforeSuper());
        // JEP 454
        java22DemoPool.add(new ForeignFunctionMemoryDemo());
        // JEP 456
        java22DemoPool.add(new UnnamedPatternsAndVariablesDemo());
        // JEP 457
        java22DemoPool.add(new ClassFileAPIDemo());
        // JEP 459
        java22DemoPool.add(new StringTemplatesSecondPreview());
        // JEP 460
        java22DemoPool.add(new VectorAPIDemo());
        // JEP 461
        java22DemoPool.add(new StreamGatherersDemo());
        // JEP 463
        java22DemoPool.add(new ImplicitlyDeclaredClassesDemo());
        // JEP 464
        java22DemoPool.add(new ScopedValuesDemo());

        return java22DemoPool;
    }
}
package org.javademos.init;

import java.util.ArrayList;

import org.javademos.commons.IDemo;
import org.javademos.java20.jep432.RecordPatterns;
import org.javademos.java20.jep429.ScopedValuesDemo;
import org.javademos.java20.jep433.PatternMatchingForSwitchFourthPreview;
import org.javademos.java20.jep434.ForeignFunctionMemoryDemo;
import org.javademos.java20.jep436.VirtualThreads;
import org.javademos.java20.jep438.VectorAPIDemo;
import org.javademos.java20.jep437.StructuredConcurrencyDemo;

public class Java20 {

    /**
     * @return list of demos available for JDK 20
     */
    public static ArrayList<IDemo> getDemos() {
        var java20DemoPool = new ArrayList<IDemo>();

        // JEP 429
        java20DemoPool.add(new ScopedValuesDemo());
        // JEP 432
        java20DemoPool.add(new RecordPatterns());
        // JEP 433
        java20DemoPool.add(new PatternMatchingForSwitchFourthPreview());
        // JEP 434
        java20DemoPool.add(new ForeignFunctionMemoryDemo());
        // JEP 436
        java20DemoPool.add(new VirtualThreads());
        // JEP 437
        java20DemoPool.add(new StructuredConcurrencyDemo());
        // JEP 438
        java20DemoPool.add(new VectorAPIDemo());

        return java20DemoPool;
    }
}
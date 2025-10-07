package org.javademos.init;

import org.javademos.commons.IDemo;
import org.javademos.java21.extras.J21Demo;
import org.javademos.java21.jep430.StringTemplatesDemo;
import org.javademos.java21.jep431.SequencedCollectionsDemo;
import org.javademos.java21.jep439.GenerationalZGC21;
import org.javademos.java21.jep440.RecordPatternsDemo;
import org.javademos.java21.jep441.PatternMatchingForSwitchDemo;
import org.javademos.java21.jep443.UnnamedPatternsAndVariablesDemo;
import org.javademos.java21.jep444.VirtualThreadsDemo;
import org.javademos.java21.jep445.UnnamedClassesDemo;
import org.javademos.java21.jep446.ScopedValues;
import org.javademos.java21.jep448.VectorAPIDemo;
import org.javademos.java21.jep449.DeprecateWindows32BitX86Demo;

import java.util.ArrayList;

public class Java21 {

    /**
     * @return list of demos available for JDK 21
     */
    public static ArrayList<IDemo> getDemos() {
        var java21DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now

        // extra features not related to any JEP
        java21DemoPool.add(new J21Demo());

        // JEP 430
        java21DemoPool.add(new StringTemplatesDemo());
        // JEP 431
        java21DemoPool.add(new SequencedCollectionsDemo());
        // JEP 439
        java21DemoPool.add(new GenerationalZGC21());
        // JEP 440
        java21DemoPool.add(new RecordPatternsDemo());
        // JEP 441
        java21DemoPool.add(new PatternMatchingForSwitchDemo());
        // JEP 443
        java21DemoPool.add(new UnnamedPatternsAndVariablesDemo());
        // JEP 444
        java21DemoPool.add(new VirtualThreadsDemo());
        // JEP 445
        java21DemoPool.add(new UnnamedClassesDemo());
        // JEP 446
        java21DemoPool.add(new ScopedValues());
        // JEP 448
        java21DemoPool.add(new VectorAPIDemo());
        // JEP 449
        java21DemoPool.add(new DeprecateWindows32BitX86Demo());

        return java21DemoPool;
    }

}
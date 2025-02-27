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
import org.javademos.java21.jep446.ScopedValues;
import org.javademos.java21.jep448.VectorAPIDemo;

import java.util.ArrayList;

public class Java21 {

    /**
     * @return list of demos available for JDK 21
     */
    public static ArrayList<IDemo> getDemos() {
        var java21DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now
        java21DemoPool.add(new J21Demo());
        java21DemoPool.add(new StringTemplatesDemo());
        java21DemoPool.add(new VirtualThreadsDemo());
        java21DemoPool.add(new RecordPatternsDemo());
        java21DemoPool.add(new PatternMatchingForSwitchDemo());
        java21DemoPool.add(new ScopedValues());
        java21DemoPool.add(new SequencedCollectionsDemo());
        java21DemoPool.add(new VectorAPIDemo());
        java21DemoPool.add(new UnnamedPatternsAndVariablesDemo());
        java21DemoPool.add(new GenerationalZGC21());

        return java21DemoPool;
    }

}

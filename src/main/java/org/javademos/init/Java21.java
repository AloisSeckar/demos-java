package org.javademos.init;

import org.javademos.commons.IDemo;
import org.javademos.java21.j21.J21Demo;
import org.javademos.java21.pattern.PatternMatchingForSwitchDemo;
import org.javademos.java21.pattern.RecordPatternsDemo;
import org.javademos.java21.scopedvalues.ScopedValuesDemo;
import org.javademos.java21.sequenced.SequencedCollectionsDemo;
import org.javademos.java21.stringtemplates.StringTemplatesDemo;
import org.javademos.java21.unnamed.UnnamedPatternsAndVariablesDemo;
import org.javademos.java21.vectorapi.VectorAPIDemo;
import org.javademos.java21.virtualthreads.VirtualThreadsDemo;

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
        java21DemoPool.add(new ScopedValuesDemo());
        java21DemoPool.add(new SequencedCollectionsDemo());
        java21DemoPool.add(new VectorAPIDemo());
        java21DemoPool.add(new UnnamedPatternsAndVariablesDemo());

        return java21DemoPool;
    }

}

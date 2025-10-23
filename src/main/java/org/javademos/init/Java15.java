package org.javademos.init;

import java.util.ArrayList;

import org.javademos.commons.IDemo;
import org.javademos.java15.jep360.SealedClassesDemo;
import org.javademos.java15.jep375.InstanceofPatternMatchingSecondPreview;
import org.javademos.java15.jep383.ForeignMemoryAccessDemo;
import org.javademos.java15.jep384.RecordsSecondPreviewDemo;
public class Java15 {

    /**
     * @return list of demos available for JDK 15
     */
    public static ArrayList<IDemo> getDemos() {
        var java15DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now

        // JEP 360
        java15DemoPool.add(new SealedClassesDemo());
        // JEP 375
        java15DemoPool.add(new InstanceofPatternMatchingSecondPreview());
        // JEP 383
        java15DemoPool.add(new ForeignMemoryAccessDemo());
        // JEP 384
        java15DemoPool.add(new RecordsSecondPreviewDemo());

        return java15DemoPool;
    }
}

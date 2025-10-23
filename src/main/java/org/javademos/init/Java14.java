package org.javademos.init;

import java.util.ArrayList;

import org.javademos.commons.IDemo;
import org.javademos.java14.jep305.InstanceofPatternMatchingPreview;
import org.javademos.java14.jep359.RecordsPreviewDemo;
import org.javademos.java14.jep370.ForeignMemoryAccessDemo;

public class Java14 {

    /**
     * @return list of demos available for JDK 14
     */
    public static ArrayList<IDemo> getDemos() {
        var java14DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now

        //JEP 305
        java14DemoPool.add(new InstanceofPatternMatchingPreview());
        // JEP 359
        java14DemoPool.add(new RecordsPreviewDemo());
        // JEP 370
        java14DemoPool.add(new ForeignMemoryAccessDemo());

        return java14DemoPool;
    }
}

package org.javademos.init;

import java.util.ArrayList;

import org.javademos.commons.IDemo;
import org.javademos.java15.jep360.SealedClassesDemo;
import org.javademos.java15.jep371.HiddenClassesDemo;
import org.javademos.java15.jep372.NashornRemovalDemo;
import org.javademos.java15.jep373.DatagramSocketDemo15;
import org.javademos.java15.jep375.InstanceofPatternMatchingSecondPreview;
import org.javademos.java15.jep381.SolarisSparcRemovalDemo;
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
        // JEP 371
        java15DemoPool.add(new HiddenClassesDemo());
        // JEP 372
        java15DemoPool.add(new NashornRemovalDemo());
        // JEP 373
        java15DemoPool.add(new DatagramSocketDemo15());
        // JEP 375
        java15DemoPool.add(new InstanceofPatternMatchingSecondPreview());
        // JEP 381
        java15DemoPool.add(new SolarisSparcRemovalDemo());
        // JEP 383
        java15DemoPool.add(new ForeignMemoryAccessDemo());
        // JEP 384
        java15DemoPool.add(new RecordsSecondPreviewDemo());

        return java15DemoPool;
    }
}

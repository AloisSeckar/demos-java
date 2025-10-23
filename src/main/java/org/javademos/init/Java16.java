package org.javademos.init;

import java.util.ArrayList;

import org.javademos.commons.IDemo;
import org.javademos.java16.jep338.VectorAPIDemo;
import org.javademos.java16.jep380.UnixDomainSocketsDemo;
import org.javademos.java16.jep388.WindowsPortDemo;
import org.javademos.java16.jep389.ForeignLinkerDemo;
import org.javademos.java16.jep390.ValueBasedClassesDemo;
import org.javademos.java16.jep393.ForeignMemoryAccessDemo;
import org.javademos.java16.jep394.InstanceofPatternMatchingDemo;
import org.javademos.java16.jep395.RecordDemo;
import org.javademos.java16.jep396.EncapsulationDemo;
import org.javademos.java16.jep397.SealedClassesDemo;

public class Java16 {

    /**
     * @return list of demos available for JDK 16
     */
    public static ArrayList<IDemo> getDemos() {
        var java16DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now

        // JEP 338
        java16DemoPool.add(new VectorAPIDemo());
        // JEP 380
        java16DemoPool.add(new UnixDomainSocketsDemo());
        // JEP 388
        java16DemoPool.add(new WindowsPortDemo());
        // JEP 389
        java16DemoPool.add(new ForeignLinkerDemo());
        // JEP 390
        java16DemoPool.add(new ValueBasedClassesDemo());
        // JEP 393
        java16DemoPool.add(new ForeignMemoryAccessDemo());
        // JEP 394
        java16DemoPool.add(new InstanceofPatternMatchingDemo());
        // JEP 395
        java16DemoPool.add(new RecordDemo());
        // JEP 396
        java16DemoPool.add(new EncapsulationDemo());
        // JEP 397
        java16DemoPool.add(new SealedClassesDemo());
      
        return java16DemoPool;
    }
}
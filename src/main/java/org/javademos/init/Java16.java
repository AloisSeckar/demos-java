package org.javademos.init;

import java.util.ArrayList;

import org.javademos.commons.IDemo;
import org.javademos.java16.jep338.VectorAPIDemo;
import org.javademos.java16.jep380.UnixDomainSocketsDemo;
import org.javademos.java16.jep389.ForeignLinkerDemo;
import org.javademos.java16.jep393.ForeignMemoryAccessDemo;
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
        // JEP 389
        java16DemoPool.add(new ForeignLinkerDemo());
        // JEP 393
        java16DemoPool.add(new ForeignMemoryAccessDemo());
        // JEP 397
        java16DemoPool.add(new SealedClassesDemo());
        return java16DemoPool;
    }
}
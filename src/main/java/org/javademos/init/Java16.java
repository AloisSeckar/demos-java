package org.javademos.init;

import java.util.ArrayList;

import org.javademos.commons.IDemo;
import org.javademos.java16.extras.J16Demo;
import org.javademos.java16.jep338.VectorAPIDemo;
import org.javademos.java16.jep347.Cpp14FeaturesDemo;
import org.javademos.java16.jep380.UnixDomainSocketsDemo;
import org.javademos.java16.jep386.AlpineLinuxPortDemo;
import org.javademos.java16.jep388.WindowsPortDemo;
import org.javademos.java16.jep389.ForeignLinkerDemo;
import org.javademos.java16.jep390.ValueBasedClassesDemo;
import org.javademos.java16.jep392.PackagingToolDemo;
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

        // extra features not related to any JEP
        java16DemoPool.add(new J16Demo());
        // JEP 338
        java16DemoPool.add(new VectorAPIDemo());
        // JEP 347
        java16DemoPool.add(new Cpp14FeaturesDemo());
        // Inside the list/map initialization in the JDK 16 helper file
            // ... other demos ...
        demos.add(new org.javademos.java16.jep357.MercurialToGitMigration()); // JEP 357
        // ... other demos ...
        // JEP 380
        java16DemoPool.add(new UnixDomainSocketsDemo());
        // JEP 386 
        java16DemoPool.add(new AlpineLinuxPortDemo());
        // JEP 388
        java16DemoPool.add(new WindowsPortDemo());
        // JEP 389
        java16DemoPool.add(new ForeignLinkerDemo());
        // JEP 390
        java16DemoPool.add(new ValueBasedClassesDemo());
        // JEP 392
        java16DemoPool.add(new PackagingToolDemo());
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
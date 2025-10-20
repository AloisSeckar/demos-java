package org.javademos.init;

import java.util.ArrayList;

import org.javademos.commons.IDemo;
import org.javademos.java24.jep404.GenerationalShenandoahExperimental;
import org.javademos.java24.jep450.CompactObjectHeadersExperimental;
import org.javademos.java24.jep472.PrepareToRestrictJNI;
import org.javademos.java24.jep475.LateBarrierExpansionG1;
import org.javademos.java24.jep478.KeyDerivationApiPreview;
import org.javademos.java24.jep479.RemovedWindows32BitX86Demo;
import org.javademos.java24.jep484.ClassFileAPIDemo;
import org.javademos.java24.jep485.StreamGatherersDemo;
import org.javademos.java24.jep486.DisableSecurityManager;
import org.javademos.java24.jep487.ScopedValuesDemo;
import org.javademos.java24.jep488.PrimitiveTypesSecondPreview;
import org.javademos.java24.jep489.VectorAPIDemo;
import org.javademos.java24.jep490.ZgcNonGenerationalModeRemoval;
import org.javademos.java24.jep491.SynchronizedNoPinning;
import org.javademos.java24.jep493.LinkingRunTimeImages493;
import org.javademos.java24.jep494.ModuleImportSecondPreview;
import org.javademos.java24.jep495.SimpleSourceFilesDemo;
import org.javademos.java24.jep496.QuantumResistantModuleLatticeBasedKeyEncapsulation;
import org.javademos.java24.jep497.QuantumResistantModuleLatticeBasedDigitalSignature;
import org.javademos.java24.jep498.MemoryAccessMethods;
import org.javademos.java24.jep501.Deprecate32BitX86Demo;

public class Java24 {

    /**
     * @return list of demos available for JDK 24
     */
    public static ArrayList<IDemo> getDemos() {
        var java24DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now

        // JEP 404
        java24DemoPool.add(new GenerationalShenandoahExperimental());
        // JEP 450
        java24DemoPool.add(new CompactObjectHeadersExperimental());
        // JEP 472
        java24DemoPool.add(new PrepareToRestrictJNI());
        // JEP 475
        java24DemoPool.add(new LateBarrierExpansionG1());
        // JEP 478
        java24DemoPool.add(new KeyDerivationApiPreview());
        // JEP 479
        java24DemoPool.add(new RemovedWindows32BitX86Demo());
        // JEP 484
        java24DemoPool.add(new ClassFileAPIDemo());
        // JEP 485
        java24DemoPool.add(new StreamGatherersDemo());
        // JEP 486
        java24DemoPool.add(new DisableSecurityManager());
        // JEP 487
        java24DemoPool.add(new ScopedValuesDemo());
        // JEP 488
        java24DemoPool.add(new PrimitiveTypesSecondPreview());
        // JEP 489
        java24DemoPool.add(new VectorAPIDemo());
        // JEP 490
        java24DemoPool.add(new ZgcNonGenerationalModeRemoval());
        // JEP 491
        java24DemoPool.add(new SynchronizedNoPinning());
        // JEP 493
        java24DemoPool.add(new LinkingRunTimeImages493());
        // JEP 494
        java24DemoPool.add(new ModuleImportSecondPreview());
        // JEP 495
        java24DemoPool.add(new SimpleSourceFilesDemo());
        // JEP 496
        java24DemoPool.add(new QuantumResistantModuleLatticeBasedKeyEncapsulation());
        // JEP 497
        java24DemoPool.add(new QuantumResistantModuleLatticeBasedDigitalSignature());
        // JEP 498
        java24DemoPool.add(new MemoryAccessMethods());
        // JEP 501
        java24DemoPool.add(new Deprecate32BitX86Demo());

        return java24DemoPool;
    }
}
package org.javademos.init;

import java.util.Map;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;

import org.javademos.java24.jep404.GenerationalShenandoahExperimental;
import org.javademos.java24.jep450.CompactObjectHeadersExperimental;
import org.javademos.java24.jep472.PrepareToRestrictJNI;
import org.javademos.java24.jep475.LateBarrierExpansionG1;
import org.javademos.java24.jep478.KeyDerivationApiPreview;
import org.javademos.java24.jep479.RemovedWindows32BitX86Demo;
import org.javademos.java24.jep483.AotLoadingAndLinking;
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
import org.javademos.java24.jep499.StructuredConcurrencyDemo;
import org.javademos.java24.jep501.Deprecate32BitX86Demo;

/**
 * Loads demos for Java 24.
 */
public class Java24DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(404, new GenerationalShenandoahExperimental());
        demos.put(450, new CompactObjectHeadersExperimental());
        demos.put(472, new PrepareToRestrictJNI());
        demos.put(475, new LateBarrierExpansionG1());
        demos.put(478, new KeyDerivationApiPreview());
        demos.put(479, new RemovedWindows32BitX86Demo());
        demos.put(483, new AotLoadingAndLinking());
        demos.put(484, new ClassFileAPIDemo());
        demos.put(485, new StreamGatherersDemo());
        demos.put(486, new DisableSecurityManager());
        demos.put(487, new ScopedValuesDemo());
        demos.put(488, new PrimitiveTypesSecondPreview());
        demos.put(489, new VectorAPIDemo());
        demos.put(490, new ZgcNonGenerationalModeRemoval());
        demos.put(491, new SynchronizedNoPinning());
        demos.put(493, new LinkingRunTimeImages493());
        demos.put(494, new ModuleImportSecondPreview());
        demos.put(495, new SimpleSourceFilesDemo());
        demos.put(496, new QuantumResistantModuleLatticeBasedKeyEncapsulation());
        demos.put(497, new QuantumResistantModuleLatticeBasedDigitalSignature());
        demos.put(498, new MemoryAccessMethods());
        demos.put(499, new StructuredConcurrencyDemo());
        demos.put(501, new Deprecate32BitX86Demo());
    }
}

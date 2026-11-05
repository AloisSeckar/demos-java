package org.javademos.init;

import java.util.Map;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;

import org.javademos.java24.jep404.GenerationalShenandoahExperimentalDemo;
import org.javademos.java24.jep450.CompactObjectHeadersExperimentalDemo;
import org.javademos.java24.jep472.PrepareToRestrictJNIDemo;
import org.javademos.java24.jep475.LateBarrierExpansionG1Demo;
import org.javademos.java24.jep478.KeyDerivationApiPreviewDemo;
import org.javademos.java24.jep479.RemovedWindows32BitX86Demo;
import org.javademos.java24.jep483.AotLoadingAndLinkingDemo;
import org.javademos.java24.jep484.ClassFileAPIDemo;
import org.javademos.java24.jep485.StreamGatherersDemo;
import org.javademos.java24.jep486.DisableSecurityManagerDemo;
import org.javademos.java24.jep487.ScopedValuesDemo;
import org.javademos.java24.jep488.PrimitiveTypesSecondPreviewDemo;
import org.javademos.java24.jep489.VectorAPIDemo;
import org.javademos.java24.jep490.ZgcNonGenerationalModeRemovalDemo;
import org.javademos.java24.jep491.SynchronizedNoPinningDemo;
import org.javademos.java24.jep493.LinkingRunTimeImages493Demo;
import org.javademos.java24.jep494.ModuleImportSecondPreviewDemo;
import org.javademos.java24.jep495.SimpleSourceFilesDemo;
import org.javademos.java24.jep496.QuantumResistantModuleLatticeBasedKeyEncapsulationDemo;
import org.javademos.java24.jep497.QuantumResistantModuleLatticeBasedDigitalSignatureDemo;
import org.javademos.java24.jep498.MemoryAccessMethodsDemo;
import org.javademos.java24.jep499.StructuredConcurrencyDemo;
import org.javademos.java24.jep501.Deprecate32BitX86Demo;

/**
 * Loads demos for Java 24.
 */
public class Java24DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(404, new GenerationalShenandoahExperimentalDemo());
        demos.put(450, new CompactObjectHeadersExperimentalDemo());
        demos.put(472, new PrepareToRestrictJNIDemo());
        demos.put(475, new LateBarrierExpansionG1Demo());
        demos.put(478, new KeyDerivationApiPreviewDemo());
        demos.put(479, new RemovedWindows32BitX86Demo());
        demos.put(483, new AotLoadingAndLinkingDemo());
        demos.put(484, new ClassFileAPIDemo());
        demos.put(485, new StreamGatherersDemo());
        demos.put(486, new DisableSecurityManagerDemo());
        demos.put(487, new ScopedValuesDemo());
        demos.put(488, new PrimitiveTypesSecondPreviewDemo());
        demos.put(489, new VectorAPIDemo());
        demos.put(490, new ZgcNonGenerationalModeRemovalDemo());
        demos.put(491, new SynchronizedNoPinningDemo());
        demos.put(493, new LinkingRunTimeImages493Demo());
        demos.put(494, new ModuleImportSecondPreviewDemo());
        demos.put(495, new SimpleSourceFilesDemo());
        demos.put(496, new QuantumResistantModuleLatticeBasedKeyEncapsulationDemo());
        demos.put(497, new QuantumResistantModuleLatticeBasedDigitalSignatureDemo());
        demos.put(498, new MemoryAccessMethodsDemo());
        demos.put(499, new StructuredConcurrencyDemo());
        demos.put(501, new Deprecate32BitX86Demo());
    }
}

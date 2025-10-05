package org.javademos.init;

import java.util.ArrayList;

import org.javademos.commons.IDemo;
import org.javademos.java24.jep478.KeyDerivationApiPreview;
import org.javademos.java24.jep485.StreamGatherers;
import org.javademos.java24.jep498.MemoryAccessMethods;
import org.javademos.java24.jep486.DisableSecurityManager;
import org.javademos.java24.jep490.ZgcNonGenerationalModeRemoval;
import org.javademos.java24.jep493.LinkingRunTimeImages493;


public class Java24 {

    /**
     * @return list of demos available for JDK 24
     */
    public static ArrayList<IDemo> getDemos() {
        var java24DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now

        // JEP 478
        java24DemoPool.add(new KeyDerivationApiPreview());

        // JEP 485
        java24DemoPool.add(new StreamGatherers());

        // JEP-498
        java24DemoPool.add(new MemoryAccessMethods());
        // JEP 486
        java24DemoPool.add(new DisableSecurityManager());
        // JEP 490
        java24DemoPool.add(new ZgcNonGenerationalModeRemoval());
        // JEP 493
        java24DemoPool.add(new LinkingRunTimeImages493());

        // JEP 486
        java24DemoPool.add(new DisableSecurityManager());
        // JEP 490
        java24DemoPool.add(new ZgcNonGenerationalModeRemoval());
        // JEP 493
        java24DemoPool.add(new LinkingRunTimeImages493());

        return java24DemoPool;
    }
}
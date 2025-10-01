package org.javademos.init;

import org.javademos.commons.IDemo;
import org.javademos.java25.jep511.ModuleImportDeclarations;
import org.javademos.java25.jep470.PemEncodings;
import org.javademos.java25.jep518.JFRCooperativeSampling;
import org.javademos.java25.jep509.CpuTimeProfilingDemo;

import java.util.ArrayList;

public class Java25 {

    /**
     * @return list of demos available for JDK 25
     */
    public static ArrayList<IDemo> getDemos() {
        var java25DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now

        // JEP 511
        java25DemoPool.add(new ModuleImportDeclarations());
        // JEP 470
        java25DemoPool.add(new PemEncodings());
        // JEP 518
        java25DemoPool.add(new JFRCooperativeSampling());
        // JEP 509
        java25DemoPool.add(new CpuTimeProfilingDemo());

        return java25DemoPool;
    }

}

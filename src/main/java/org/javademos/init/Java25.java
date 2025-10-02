package org.javademos.init;

import org.javademos.commons.IDemo;
import org.javademos.java25.jep470.PemEncodingsDemo;
import org.javademos.java25.jep502.StableValuesDemo;
import org.javademos.java25.jep503.Remove32BitX86Demo;
import org.javademos.java25.jep505.StructuredConcurrencyDemo;
import org.javademos.java25.jep506.ScopedValuesDemo;
import org.javademos.java25.jep507.PrimitiveTypesDemo;
import org.javademos.java25.jep508.VectorApiDemo;
import org.javademos.java25.jep509.CpuTimeProfilingDemo;
import org.javademos.java25.jep510.KeyDerivationFunctionDemo;
import org.javademos.java25.jep511.ModuleImportDeclarationsDemo;
import org.javademos.java25.jep514.AheadOfTimeCLIDemo;
import org.javademos.java25.jep515.AheadOfTimeMethodProfilingDemo;
import org.javademos.java25.jep518.JFRCooperativeSamplingDemo;
import org.javademos.java25.jep519.CompactObjectHeaderDemo;
import org.javademos.java25.jep506.ScopedValuesDemo;
import org.javademos.java25.jep503.Remove32BitX86Demo;
import org.javademos.java25.jep502.StableValuesDemo;
import org.javademos.java25.jep521.GenerationalShenandoahDemo;
import java.util.ArrayList;

public class Java25 {

    /**
     * @return list of demos available for JDK 25
     */
    public static ArrayList<IDemo> getDemos() {
        var java25DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now

        // JEP 470
        java25DemoPool.add(new PemEncodingsDemo());
        // JEP 502
        java25DemoPool.add(new StableValuesDemo());
        //JEP 503
        java25DemoPool.add(new Remove32BitX86Demo());
        // JEP 505
        java25DemoPool.add(new StructuredConcurrencyDemo());
        // JEP 506
        java25DemoPool.add(new ScopedValuesDemo());
        // JEP 507
        java25DemoPool.add(new PrimitiveTypesDemo());
        // JEP 508
        java25DemoPool.add(new VectorApiDemo());
        // JEP 509
        java25DemoPool.add(new CpuTimeProfilingDemo());
        // JEP 510
        java25DemoPool.add(new KeyDerivationFunctionDemo());
        // JEP 506
        java25DemoPool.add(new ScopedValuesDemo());
        // JEP 502
        java25DemoPool.add(new StableValuesDemo());
        //JEP 503
        java25DemoPool.add(new Remove32BitX86Demo());

        //JEP 521
        java25DemoPool.add(new GenerationalShenandoahDemo());
        return java25DemoPool;
    }
}

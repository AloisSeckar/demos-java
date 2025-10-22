package org.javademos.init;

import org.javademos.commons.IDemo;
import org.javademos.java17.jep306.RestoreAlwaysStrictFloatingPointSemanticsDemo;
import org.javademos.java17.jep403.StronglyEncapsulateInternalsDemo;
import org.javademos.java17.jep406.PatternMatchingForSwitchPreview;
import org.javademos.java17.jep407.RemoveRmiActivationDemo;
import org.javademos.java17.jep409.SealedDemo;
import org.javademos.java17.jep411.DeprecateSecurityManagerDemo;
import org.javademos.java17.jep412.ForeignFunctionMemoryDemo;
import org.javademos.java17.jep414.VectorAPIDemo;
import org.javademos.java17.jep415.ContextSpecificDeserializationFiltersDemo;
// older demos created with "non-JEP" style
import org.javademos.java17.deprecated.DeprecatedDemo;
import org.javademos.java17.j16.J16Demo;
import org.javademos.java17.newswitch.SwitchDemo;
import org.javademos.java17.nullpointer.NullPointerDemo;
import org.javademos.java17.pattern.InstanceofPatternMatchingDemo;
import org.javademos.java17.record.RecordDemo;
import org.javademos.java17.string12.String12Demo;
import org.javademos.java17.textblock.TextBlockDemo;
import java.util.ArrayList;

public class Java17 {

    /**
     * @return list of demos available for JDK 17
     */
    public static ArrayList<IDemo> getDemos() {
        var java17DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now
        // JEP 306
        java17DemoPool.add(new RestoreAlwaysStrictFloatingPointSemanticsDemo());
        // JEP 403
        java17DemoPool.add(new StronglyEncapsulateInternalsDemo());
        // JEP 406
        java17DemoPool.add(new PatternMatchingForSwitchPreview());
        // JEP 407
        java17DemoPool.add(new RemoveRmiActivationDemo());
        // JEP 411
        java17DemoPool.add(new DeprecateSecurityManagerDemo());
        // JEP 412
        java17DemoPool.add(new ForeignFunctionMemoryDemo());
        // JEP 414
        java17DemoPool.add(new VectorAPIDemo());
        // JEP 415
        java17DemoPool.add(new ContextSpecificDeserializationFiltersDemo());

        // older demos created with "non-JEP" style
        java17DemoPool.add(new String12Demo());
        java17DemoPool.add(new SwitchDemo());
        java17DemoPool.add(new NullPointerDemo());
        java17DemoPool.add(new TextBlockDemo());
        java17DemoPool.add(new J16Demo());
        java17DemoPool.add(new RecordDemo());
        java17DemoPool.add(new InstanceofPatternMatchingDemo());
        java17DemoPool.add(new SealedDemo());
        java17DemoPool.add(new DeprecatedDemo());

        return java17DemoPool;
    }

}
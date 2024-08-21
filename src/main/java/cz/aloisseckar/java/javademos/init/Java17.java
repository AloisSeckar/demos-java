package cz.aloisseckar.java.javademos.init;

import cz.aloisseckar.java.javademos.commons.IDemo;
import cz.aloisseckar.java.javademos.java17.deprecated.DeprecatedDemo;
import cz.aloisseckar.java.javademos.java17.j16.J16Demo;
import cz.aloisseckar.java.javademos.java17.newswitch.SwitchDemo;
import cz.aloisseckar.java.javademos.java17.nullpointer.NullPointerDemo;
import cz.aloisseckar.java.javademos.java17.pattern.InstanceofPatternMatchingDemo;
import cz.aloisseckar.java.javademos.java17.record.RecordDemo;
import cz.aloisseckar.java.javademos.java17.sealed.SealedDemo;
import cz.aloisseckar.java.javademos.java17.string12.String12Demo;
import cz.aloisseckar.java.javademos.java17.textblock.TextBlockDemo;

import java.util.ArrayList;

public class Java17 {

    /**
     * @return list of demos available for JDK 17
     */
    public static ArrayList<IDemo> getDemos() {
        var java17DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now
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

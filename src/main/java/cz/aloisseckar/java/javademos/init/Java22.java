package cz.aloisseckar.java.javademos.init;

import cz.aloisseckar.java.javademos.commons.IDemo;
import cz.aloisseckar.java.javademos.java22.jep423.RegionPinningForG1;
import cz.aloisseckar.java.javademos.java22.jep447.StatementsBeforeSuperDemo;

import java.util.ArrayList;

public class Java22 {

    /**
     * @return list of demos available for JDK 22
     */
    public static ArrayList<IDemo> getDemos() {
        var java22DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now
        java22DemoPool.add(new RegionPinningForG1());
        java22DemoPool.add(new StatementsBeforeSuperDemo());

        return java22DemoPool;
    }

}

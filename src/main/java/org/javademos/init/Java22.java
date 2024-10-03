package org.javademos.init;

import org.javademos.commons.IDemo;
import org.javademos.java22.jep423.RegionPinningForG1;
import org.javademos.java22.jep447.StatementsBeforeSuper;

import java.util.ArrayList;

public class Java22 {

    /**
     * @return list of demos available for JDK 22
     */
    public static ArrayList<IDemo> getDemos() {
        var java22DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now
        java22DemoPool.add(new RegionPinningForG1());
        java22DemoPool.add(new StatementsBeforeSuper());

        return java22DemoPool;
    }

}

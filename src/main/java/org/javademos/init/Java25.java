package org.javademos.init;

import org.javademos.commons.IDemo;
import org.javademos.java25.jep511.ModuleImportDeclarations;

import java.util.ArrayList;

public class Java25 {

    /**
     * @return list of demos available for JDK 25
     */
    public static ArrayList<IDemo> getDemos() {
        var java25DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now
        java25DemoPool.add(new ModuleImportDeclarations());

        return java25DemoPool;
    }

}

package org.javademos.init;

import java.util.ArrayList;

import org.javademos.commons.IDemo;
import org.javademos.java18.jep413.CodeSnippetsInJavadoc;
import org.javademos.java18.jep417.VectorAPIDemo;
import org.javademos.java18.jep418.InternetAddressResolutionSPI;
import org.javademos.java18.jep419.ForeignFunctionMemoryDemo;

public class Java18 {

    /**
     * @return list of demos available for JDK 18
     */
    public static ArrayList<IDemo> getDemos() {
        var java18DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now

        // JEP 413
        java18DemoPool.add(new CodeSnippetsInJavadoc());
        // JEP 417
        java18DemoPool.add(new VectorAPIDemo());
        // JEP 418
        java18DemoPool.add(new InternetAddressResolutionSPI());
        // JEP 419
        java18DemoPool.add(new ForeignFunctionMemoryDemo());

        return java18DemoPool;
    }
}
package cz.aloisseckar.java.javademos.init;

import cz.aloisseckar.java.javademos.commons.IDemo;
import cz.aloisseckar.java.javademos.java11.http.HttpDemo;
import cz.aloisseckar.java.javademos.java11.j9.J9Demo;
import cz.aloisseckar.java.javademos.java11.string11.String11Demo;
import cz.aloisseckar.java.javademos.java11.var.VarDemo;

import java.util.ArrayList;

public class Java11 {

    /**
     * @return list of demos available for JDK 11
     */
    public static ArrayList<IDemo> getDemos() {
        var java11DemoPool = new ArrayList<IDemo>();

        // feel free to comment out demos you are not interested in right now
        java11DemoPool.add(new J9Demo());
        java11DemoPool.add(new VarDemo());
        java11DemoPool.add(new HttpDemo());
        java11DemoPool.add(new String11Demo());

        return java11DemoPool;
    }

}

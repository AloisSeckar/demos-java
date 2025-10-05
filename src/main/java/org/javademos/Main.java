package org.javademos;

import org.javademos.commons.IDemo;
import org.javademos.init.*;

import java.util.ArrayList;

/**
 * This application helps to show some new features from Java 11 to Java 21.
 * The 'demoPool' array consists of simple IDemo interface implementations.
 * Code logic is being implemented inside .demo() methods.
 * 
 * @see IDemo
 * 
 * You can try switching the compile/build settings back to Java 1.8 to see
 * that the most of the stuff used here cannot be compiled and run under old
 * versions of Java.
 * 
 * @author alois.seckar@gmail.com
 */
public class Main {
    
    /**
     * Simple main method.
     * No complex logic - all available demo implementations are being put
     * inside a list, and then being executed one by one.
     * 
     * @param args not supported (ignored) in this application
     */
    public static void main(String[] args) {

        // https://stackoverflow.com/a/19165338/3204544
        System.out.println("JVM INFO");
        System.out.println(System.getProperty("java.vm.name"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("java.vendor"));
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.specification.vendor"));
        //
        
        var demoPool = new ArrayList<IDemo>();
        
        // you may find useful to comment out other JDKs except the one
        // you are about to examine
        // it may be confusing to search the actual output of particular
        // demo class implementation you are currently interested in

        // older demos - not all JEPs covered yet
        demoPool.addAll(Java11.getDemos());
        demoPool.addAll(Java16.getDemos());
        demoPool.addAll(Java17.getDemos());
        demoPool.addAll(Java18.getDemos());
        demoPool.addAll(Java19.getDemos());
        demoPool.addAll(Java20.getDemos());
        demoPool.addAll(Java21.getDemos());
        demoPool.addAll(Java22.getDemos());
        // newer demos - each JEP has separate file with info/examples
        demoPool.addAll(Java23.getDemos());
        demoPool.addAll(Java24.getDemos());
        demoPool.addAll(Java25.getDemos());
        
        // run method .demo() on each entry to see the output
        demoPool.forEach(IDemo::demo);
        
    }
    
}

package org.javademos;

import org.javademos.commons.IDemo;

import static org.javademos.init.JEPInfo.JEP_DEMO;

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

        JEP_DEMO.values().forEach(IDemo::demo);

        // run method .demo() on each entry to see the output
        JEP_DEMO.values().forEach(IDemo::demo);
    }
}

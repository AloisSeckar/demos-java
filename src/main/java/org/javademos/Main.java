package org.javademos;

import org.javademos.commons.IDemo;
import org.javademos.util.ArgsFilterUtil;

import java.util.Comparator;
import java.util.Map;

import static org.javademos.init.JEPInfo.JEP_DEMO;
import static org.javademos.init.JEPInfo.JEP_DATA;

/**
 * This application helps to show some new features from Java 11 to Java 21.
 * The 'JEP_DATA' map consists of simple IDemo interface implementations.
 * Code logic is being implemented inside .demo() methods.
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
     * Main method supports filtering demos based on command line arguments.
     * Supported arguments and examples:
     * --skip-links: Skip demos that are link-only to other JEP
     * --code-only: Only run demos that contain code
     * --jdk=17,25: Only run demos from specific JDK versions
     * --only=382,409: Only run specific JEP numbers
     * @see ArgsFilterUtil
     * */
    public static void main(String[] args) {

        // https://stackoverflow.com/a/19165338/3204544
        System.out.println("JVM INFO");
        System.out.println(System.getProperty("java.vm.name"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("java.vendor"));
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.specification.vendor"));

        var filteredJepData = ArgsFilterUtil.getFilteredJepData(args, JEP_DATA);

        // Run only filtered demos, sorted by JDK version and JEP number
        JEP_DEMO.entrySet().stream()
                .filter(e -> filteredJepData.containsKey(e.getKey()))
                .sorted(
                        Comparator
                                .comparingInt((Map.Entry<Integer, IDemo> e) -> JEP_DATA.get(e.getKey()).jdk())
                                .thenComparingInt(Map.Entry::getKey)
                )
                .map(Map.Entry::getValue)
                .forEach(IDemo::demo);
    }
}

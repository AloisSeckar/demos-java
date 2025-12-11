package org.javademos;

import java.util.Comparator;
import java.util.Map;
import org.javademos.commons.IDemo;
import org.javademos.commons.ArgsFilterUtil;
import static org.javademos.init.JEPInfo.JEP_DEMO;
import static org.javademos.init.JEPInfo.JEP_DATA;

/// This application helps to show some new features from Java 11 to Java 21.
/// The `JEP_DATA` map consists of simple `IDemo` interface implementations.
/// Code logic is being implemented inside each `.demo()` method.
/// 
/// @see IDemo
/// @author alois.seckar@gmail.com
public class Main {

    /// Main method supports filtering demos based on command line arguments.
    /// 
    /// Supported arguments and examples:
    /// - `--skip-links`: Skip demos that are link-only to other JEP
    /// - `--code-only`: Only run demos that contain code
    /// - `--jdk=17,25`: Only run demos from specific JDK versions
    /// - `--only=382,409`: Only run specific JEP numbers
    /// 
    /// @see ArgsFilterUtil
    public static void main(String[] args) {
        // get list of demos to run(possibly filtered by args)
        // sorted by JDK version and JEP number
        var filteredJepData = ArgsFilterUtil.getFilteredJepData(args, JEP_DATA);

        // run selected demos
        System.out.println("\n-------------------------------------------------");
        System.out.println("\n=== EXECUTING JAVA DEMOS ===");

        JEP_DEMO.entrySet().stream()
                .filter(e -> filteredJepData.containsKey(e.getKey()))
                .sorted(
                        Comparator
                                .comparingInt((Map.Entry<Integer, IDemo> e) -> JEP_DATA.get(e.getKey()).jdk())
                                .thenComparingInt(Map.Entry::getKey)
                )
                .map(Map.Entry::getValue)
                .forEach(IDemo::demo);
        
        System.out.println("\n=== EXECUTION COMPLETE ===");
        System.out.println("\n-------------------------------------------------");
    }
}

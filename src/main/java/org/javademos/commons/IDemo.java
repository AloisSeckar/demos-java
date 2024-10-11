package org.javademos.commons;

/// Simple interface to unify the demo building process.
///
/// Override method 'demo()' in your implementation and include new instance
/// into demoPool in Main.java
///
/// Last review: 2024-09-22
///
/// TEMPLATE for demo implementation class JavaDocs:
/// ```
/// /// Demo for JDK <VER> feature **<JEP_NAME>** (JEP <NUM>)
/// ///
/// /// Status: [Stable|Preview|Incubator]
/// ///
/// /// Evolution:
/// /// - JDK <VER>: [JEP <NUM> - <JEP_NAME>](https://openjdk.org/jeps/<NUM>)
/// /// - (repeat 1-n)
/// ///
/// /// Further Reading:
/// /// - [<ARTICLE_TITLE>](<ARTICLE_URL>)
/// /// - (repeat 1-n)
/// ///
/// /// @author alois.seckar@gmail.com
/// ```
///
/// @author alois.seckar@gmail.com
public interface IDemo {
    
    /// Header recommended to be displayed at the beginning of each demo's output.
    ///
    /// @param demoName Name of the demo feature
    /// @param demoDscr Description of the purpose
    default void info(String demoName, String demoDscr) {
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println(demoName);
        System.out.println(demoDscr);
        System.out.println("-------------------------------------------------");
        System.out.println();
    }

    /// Header recommended to be displayed at the beginning of each demo's output.
    ///
    /// This method accepts intended number of JEP and looks for data in DEMO_INFO map.
    ///
    /// @param jepNumber JEP number to be displayed
    /// @see JEPInfo#JEP_INFO
    default void info (int jepNumber) {
        var demoInfo = JEPInfo.JEP_INFO.get(jepNumber);
        if (demoInfo != null) {
            info(demoInfo.name(), demoInfo.dscr());
        } else {
            info (String.valueOf(jepNumber), "No description available");
        }
    }
    
    /// Method to perform the actual work for each demo feature.
    void demo();
    
}

package org.javademos.java15.jep372;

import org.javademos.commons.IDemo;

/// ## JEP 372: Remove the Nashorn JavaScript Engine
///
/// ### History
/// Nashorn was introduced in Java 8 (JEP 174) as a replacement for the older
/// Rhino engine. However, with the rapid evolution of ECMAScript (JavaScript),
/// maintaining Nashorn became difficult. It was deprecated in Java 11 (JEP 335)
/// and removed entirely by this JEP.
///
/// ### Links
/// - [Official JEP 372](https://openjdk.org/jeps/372)
///
/// @since Java 15
public class NashornRemovalDemo implements IDemo {

    @Override
    public void demo() {
        // Call info helper
        info(372);

        // This JEP removed the Nashorn JavaScript engine, APIs, and the jjs tool.
        // There are no specific APIs or language features to demonstrate its absence.
        // Trying to import or use classes from the jdk.nashorn package would now
        // result in a compilation error. For example:
        // import jdk.nashorn.api.scripting.NashornScriptEngineFactory; // This import fails in JDK 15+
    }
}
package org.javademos.java20.jep432;

import org.javademos.commons.IDemo;
import org.javademos.java21.jep440.RecordPatternsDemo;

/// Demo for JDK 20 feature <strong>JEP 432 - Record Patterns(Second Preview)</strong>.
///
/// This was an incubator JEP. The feature is finalized in JDK 21 by JEP 440.
/// 
/// @see org.javademos.java21.jep440.RecordPatternsDemo
///
/// @author @Rossville
public class RecordPatterns implements IDemo {
    @Override
    public void demo() {
        System.out.println("JEP 432 - Record Patterns (Second Preview)");
        System.out.println("This feature was finalized in JEP 440 (JDK 21).");
        System.out.println("Redirecting to the latest demo...\n");
        new RecordPatternsDemo().demo();
    }
}

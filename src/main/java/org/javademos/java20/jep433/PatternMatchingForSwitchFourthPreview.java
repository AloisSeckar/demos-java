package org.javademos.java20.jep433;

import org.javademos.commons.IDemo;

///
/// # JEP 433: Pattern Matching for switch (Fourth Preview)
///
/// @author mayankvyas1306
///
/// ## Summary
/// This was the fourth and final preview of Pattern Matching for switch.
/// The final version of this feature is delivered in JDK 21 by JEP 441.
///
/// ## Resources
/// - [JEP 433: Pattern Matching for switch (Fourth Preview)](https://openjdk.org/jeps/433)
///
public class PatternMatchingForSwitchFourthPreview implements IDemo {

    @Override
    public void demo() {
        info(433);
        System.out.println("""
            Pattern Matching for switch continued as a preview feature in JDK 20.

            This was the final preview before the feature was finalized in JDK 21.

            Please see the demo for JEP 441 for the final implementation and examples.
            """);
    }
}
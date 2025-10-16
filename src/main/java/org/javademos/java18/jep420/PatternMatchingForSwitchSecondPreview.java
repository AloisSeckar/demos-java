package org.javademos.java18.jep420;

import org.javademos.commons.IDemo;

///
/// # JEP 420: Pattern Matching for switch (Second Preview)
///
/// @author mayankvyas1306
///
/// ## Summary
/// This was the second preview of Pattern Matching for switch.
/// The final version of this feature is delivered in JDK 21 by JEP 441.
///
/// ## Resources
/// - [JEP 420: Pattern Matching for switch (Second Preview)](https://openjdk.org/jeps/420)
///
public class PatternMatchingForSwitchSecondPreview implements IDemo {

    @Override
    public void demo() {
        info(420);
        System.out.println("""
            Pattern Matching for switch continued as a preview feature in JDK 18.

            This feature evolved through several previews before being finalized in JDK 21.

            Please see the demo for JEP 441 for the final implementation and examples.
            """);
    }
}
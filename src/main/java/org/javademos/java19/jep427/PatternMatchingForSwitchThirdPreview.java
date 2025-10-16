package org.javademos.java19.jep427;

import org.javademos.commons.IDemo;

///
/// # JEP 427: Pattern Matching for switch (Third Preview)
///
/// @author mayankvyas1306
///
/// ## Summary
/// This was the third preview of Pattern Matching for switch.
/// The final version of this feature is delivered in JDK 21 by JEP 441.
///
/// ## Resources
/// - [JEP 427: Pattern Matching for switch (Third Preview)](https://openjdk.org/jeps/427)
///
public class PatternMatchingForSwitchThirdPreview implements IDemo {

    @Override
    public void demo() {
        info(427);
        System.out.println("""
            Pattern Matching for switch continued as a preview feature in JDK 19.

            This feature evolved through several previews before being finalized in JDK 21.

            Please see the demo for JEP 441 for the final implementation and examples.
            """);
    }
}
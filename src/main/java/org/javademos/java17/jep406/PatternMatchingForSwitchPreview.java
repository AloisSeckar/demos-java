package org.javademos.java17.jep406;

import org.javademos.commons.IDemo;

///
/// # JEP 406: Pattern Matching for switch (Preview)
///
/// @author mayankvyas1306
///
/// ## Summary
/// This was the first preview of Pattern Matching for switch.
/// The final version of this feature is delivered in JDK 21 by JEP 441.
///
/// ## Evolution of the Feature
/// - First Preview: JEP 406 (JDK 17)
/// - Second Preview: JEP 420 (JDK 18)
/// - Third Preview: JEP 427 (JDK 19)
/// - Fourth Preview: JEP 433 (JDK 20)
/// - **Final:** JEP 441 (JDK 21)
///
/// ## Resources
/// - [JEP 406: Pattern Matching for switch (Preview)](https://openjdk.org/jeps/406)
///
public class PatternMatchingForSwitchPreview implements IDemo {

    @Override
    public void demo() {
        info(406);
        System.out.println("""
            Pattern Matching for switch was introduced as a preview feature in JDK 17.

            This feature evolved through several previews before being finalized in JDK 21.

            Please see the demo for JEP 441 for the final implementation and examples.
            """);
    }
}
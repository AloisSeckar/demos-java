package org.javademos.java24.jep488;

import org.javademos.commons.IDemo;

///
/// # JEP 488: Primitive Types in Patterns, instanceof, and switch (Second Preview)
///
/// ## Summary
/// This JEP represents the second preview of primitive type patterns. It continued to
/// refine the feature based on feedback from the first preview (JEP 455).
///
/// Since this feature is still in preview, the main, up-to-date demonstration
/// is located in the class for the latest iteration of this JEP.
///
/// ## JEP History
/// - JDK 25: [JEP 507 - Third Preview](https://openjdk.org/jeps/507)
/// - JDK 24: [JEP 488 - Second Preview](https://openjdk.org/jeps/488)
/// - JDK 23: [JEP 455 - First Preview](https://openjdk.org/jeps/455)
///
public class PrimitiveTypesSecondPreview implements IDemo {

    @Override
    public void demo() {
        info(488);
        System.out.println("""
            This feature was in its second preview in JDK 24.
            
            The latest implementation and the full, runnable demo can be found
            in the class for JEP 507 (JDK 25).
            """);
    }
}
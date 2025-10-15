package org.javademos.java21.jep430;

import org.javademos.commons.IDemo;

///
/// # JEP 430: String Templates (First Preview)
///
/// @author mayankvyas1306
///
/// ## Summary
/// This JEP introduced String Templates as a preview feature in JDK 21. It aimed to simplify
/// string composition by combining literal text with embedded expressions in a safe and
/// flexible way.
///
/// ## Evolution of the Feature
/// This feature received a second preview in JEP 459 (JDK 22) and was subsequently
/// **REMOVED** in JDK 23 for further review.
///
/// ## Release Information
/// - **JEP:** 430
/// - **Status:** Delivered (as preview)
/// - **Release:** JDK 21
///
/// ## Resources
/// - [JEP 430: String Templates (First Preview)](https://openjdk.org/jeps/430)
///
public class StringTemplatesDemo implements IDemo {

    @Override
    public void demo() {
        info(430);

        // System.out.println("""
        //     String Templates were introduced as a preview feature in JDK 21.

        //     This feature evolved into a second preview in JEP 459 (JDK 22) before being
        //     withdrawn from the language in JDK 23.

        //     Please see the demo for JEP 459 for a more detailed explanation of how this
        //     feature worked during its preview period.
        //     """);
    }
}
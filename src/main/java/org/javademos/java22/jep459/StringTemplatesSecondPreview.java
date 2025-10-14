package org.javademos.java22.jep459;

import org.javademos.commons.IDemo;

///
/// # JEP 459: String Templates (Second Preview)
///
/// @author mayankvyas1306
///
/// ## Summary
/// This JEP provided a second preview of String Templates, a feature designed to simplify string
/// composition in Java. It followed the first preview in JEP 430 (JDK 21).
///
/// ## IMPORTANT NOTE
/// String Templates were a preview feature in JDK 21 and 22 but were **REMOVED** from the language
/// in JDK 23. They do not exist in JDK 23 or later. This demo is for historical and educational
/// purposes only.
///
/// ## Resources
/// - [JEP 459: String Templates (Second Preview)](https://openjdk.org/jeps/459)
///
public class StringTemplatesSecondPreview implements IDemo {

    @Override
    public void demo() {
        info(459);

        System.out.println("""
            --- JEP 459: String Templates (Second Preview) ---

            IMPORTANT: This feature was a preview in JDK 21/22 and was REMOVED in JDK 23.
            The following information is for historical and educational purposes only.

            The feature introduced processors (e.g., STR) to embed expressions into strings.

            // Example from the preview (this code will not compile):
            // int value = 10;
            // String s = STR."The result is \\{value}";
            // This would have produced the string: "The result is 10"

            The goal was to create safer, more readable strings than using simple '+' concatenation.
            """);
    }
}
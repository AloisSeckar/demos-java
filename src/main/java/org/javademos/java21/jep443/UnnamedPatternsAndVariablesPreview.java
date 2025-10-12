package org.javademos.java21.jep443;

import org.javademos.commons.IDemo;

/// Demo for JDK 21 feature **JEP 443 - Unnamed Patterns and Variables (preview)**.
///
/// **New version of this JEP exists: JEP 456 in JDK 22**
/// This was the preview JEP for unnamed patterns and variables. The feature was
/// finalized in JDK 22 by JEP 456.
///
/// This demo is a placeholder. For the full implementation, see the final JEP.
///
/// Superseded by [JEP 456](https://openjdk.org/jeps/456).
/// @author [Krushit Babariya](https://github.com/Krushit-Babariya)
/// @see org.javademos.java22.jep456.UnnamedPatternsAndVariablesDemo
///
public class UnnamedPatternsAndVariablesPreview implements IDemo {

    @Override
    public void demo() {
        info(443);
        System.out.println("This feature was finalized in JDK 22.");
//        System.out.println("Please see the demo for JEP 456 for the complete explanation and examples. 🔗");
    }
}
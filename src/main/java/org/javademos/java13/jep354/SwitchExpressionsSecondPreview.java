package org.javademos.java13.jep354;

import org.javademos.commons.IDemo;

/// Demo for JDK 13 feature JEP 354 - Switch Expressions (Second Preview).
///
/// This was the second preview of switch expressions. The main change from JEP 325
/// was replacing the `break` statement with the new `yield` statement for returning
/// values from switch expressions.
///
/// The feature was finalized in JDK 14 by JEP 361.
/// @see org.javademos.java12.jep325.SwitchExpressionsPreview
/// @see org.javademos.java14.jep361.SwitchExpressionsDemo
///
/// @author Abhineshhh
public class SwitchExpressionsSecondPreview implements IDemo {
    @Override
    public void demo() {
        info(354);
    }
}

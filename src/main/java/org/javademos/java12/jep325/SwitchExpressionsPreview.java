package org.javademos.java12.jep325;

import org.javademos.commons.IDemo;

/// Demo for JDK 12 feature JEP 325 - Switch Expressions (Preview).
///
/// This was the first preview of switch expressions, introducing the arrow label syntax
/// and the ability to use switch as an expression. In this preview, values were returned
/// using `break <value>`, which was later changed to `yield <value>` in JEP 354.
///
/// The feature was finalized in JDK 14 by JEP 361.
/// @see org.javademos.java13.jep354.SwitchExpressionsSecondPreview
/// @see org.javademos.java14.jep361.SwitchExpressionsDemo
///
/// @author Abhineshhh
public class SwitchExpressionsPreview implements IDemo {
    @Override
    public void demo() {
        info(325);
    }
}

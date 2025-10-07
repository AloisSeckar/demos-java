package org.javademos.java22.jep447;

import org.javademos.commons.IDemo;

/// Demo for JDK 22 feature **Statements before super(...)** (JEP 447)
///
/// This was a preview JEP. The feature is finalized in JDK 25 by JEP 513.
/// Replaced with [JEP 513](https://openjdk.org/jeps/513)
/// @see org.javademos.java25.jep513.FlexibleConstructorBodiesDemo
///
/// @author alois.seckar@gmail.com

public class StatementsBeforeSuper implements IDemo {

    @Override
    public void demo() {
        info(447);
    }

}

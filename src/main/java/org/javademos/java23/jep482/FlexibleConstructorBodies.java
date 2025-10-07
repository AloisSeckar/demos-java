package org.javademos.java23.jep482;

import org.javademos.commons.IDemo;

/// Demo for JDK 23 feature **JEP 482 - Flexible Constructor Bodies (Second Preview)**.
///
/// JEP history:
/// - JDK 23: [JEP 482 - Flexible Constructor Bodies (Second Preview)](https://openjdk.org/jeps/482)
/// - JDK 22: [JEP 447 - Statements before super(...) (Preview)](https://openjdk.org/jeps/447)
///
/// Further reading:
/// - [Flexible Constructors in Java](https://medium.com/@nabeeltariqbhatti/flexible-constructors-in-java-e882a98de46c)
/// - [Constructor Makeover in Java 22](https://blog.jetbrains.com/idea/2024/02/constructor-makeover-in-java-22/)
///
/// This was a preview JEP. The feature is finalized in JDK 25 by JEP 513.
/// Replaced with [JEP 513](https://openjdk.org/jeps/513)
/// @see org.javademos.java25.jep513.FlexibleConstructorBodiesDemo
///
/// @author alois.seckar@gmail.com
public class FlexibleConstructorBodies implements IDemo {
    @Override
    public void demo() {
        info(482);
        
    }

}

package org.javademos.java23.jep482;

import lombok.Getter;
import org.javademos.commons.IDemo;

/// Demo for JDK 23 feature **Flexible Constructor Bodies (Second Preview)** (JEP 482)
///
/// JEP history:
/// - JDK 23: [JEP 482 - Flexible Constructor Bodies (Second Preview)](https://openjdk.org/jeps/482)
/// - JDK 22: [JEP 447 - Statements before super(...) (Preview)](https://openjdk.org/jeps/447)
///
/// - Will have new implementation in JDK 23 via [JEP 492](https://openjdk.org/jeps/492)
///
/// Further reading:
/// - [Flexible Constructors in Java](https://medium.com/@nabeeltariqbhatti/flexible-constructors-in-java-e882a98de46c)
/// - [Constructor Makeover in Java 22](https://blog.jetbrains.com/idea/2024/02/constructor-makeover-in-java-22/)
///
/// @author alois.seckar@gmail.com

public class FlexibleConstructorBodies implements IDemo {
    @Override
    public void demo() {
        info(482);
        var x = new FlexibleConstructorBodies.SuperChildOld();
        var y = new FlexibleConstructorBodies.SuperChildNew();
    }

    private static class SuperParent {
    }

    /// Traditional way - super() must be first the first call.
    private static class SuperChildOld extends FlexibleConstructorBodies.SuperParent {
        public SuperChildOld() {
            // System.out.println("You can't do this before Java 22...");
            super();
        }
    }

    /// Statements before super in action - you can have Java code before calling parent constructor.
    /// Since JDK 23 it is also possible to initialize local variables prior to super(...) statement.
    @Getter // just to avoid "unused variable" IDE warning
    private static class SuperChildNew extends FlexibleConstructorBodies.SuperParent {

        private final int value;

        public SuperChildNew() {
            System.out.println("You can do this now in Java 22 and on!");

            // since Java 23 it is also possible to assign local variables before calling parent constructor
            // however, you can't read them before you do
            this.value = 1;
            // System.out.println(this.value); // this would produce compiler error

            super();
        }
    }
}

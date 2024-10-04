package org.javademos.java22.jep447;

import org.javademos.commons.IDemo;

/// Demo for JDK 22 feature **Statements before super(...)** (JEP 447)
///
/// Status: Preview
///
/// Evolution:
/// - JDK 22: [JEP 447 - Statements before super(...)](https://openjdk.org/jeps/447)
///
/// Further Reading:
/// - [Constructor Makeover in Java 22](https://blog.jetbrains.com/idea/2024/02/constructor-makeover-in-java-22/)
///
/// @author alois.seckar@gmail.com

public class StatementsBeforeSuper implements IDemo {

    @Override
    public void demo() {
        info(447);
        var x = new SuperChildOld();
        var y = new SuperChildNew();
    }

    private static class SuperParent {
    }

    /// Traditional way - super() must be first the first call.
    private static class SuperChildOld extends SuperParent {
        public SuperChildOld() {
            // System.out.println("You can't do this before Java 22...");
            super();
        }
    }

    /// Statements before super in action - you can have Java code before calling parent constructor.
    private static class SuperChildNew extends SuperParent {
        public SuperChildNew() {
            System.out.println("You can do this now in Java 22!");
            super();
        }
    }
}

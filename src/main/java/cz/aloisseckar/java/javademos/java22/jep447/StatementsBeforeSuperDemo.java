package cz.aloisseckar.java.javademos.java22.jep447;

import cz.aloisseckar.java.javademos.commons.IDemo;

/**
 * This class shows new preview feature from Java 22
 * <a href="https://openjdk.org/jeps/447">
 *     Statements before super(...) (Preview)
 * </a>
 *
 * Further reading:
 * <a href="https://blog.jetbrains.com/idea/2024/02/constructor-makeover-in-java-22/">
 *     Constructor Makeover in Java 22
 * </a>
 *
 * @author alois.seckar@gmail.com
 */
public class StatementsBeforeSuperDemo implements IDemo {

    @Override
    public void demo() {
        info("STATEMENTS BEFORE SUPER DEMO", "Since Java 22, super() it is no longer required\nto be placed as first statement in constructor");
        var x = new SuperChildOld();
        var y = new SuperChildNew();
    }

    private static class SuperParent {
    }

    private static class SuperChildOld extends SuperParent {
        public SuperChildOld() {
            // System.out.println("you can't do this before Java 22");
            super();
        }
    }

    private static class SuperChildNew extends SuperParent {
        public SuperChildNew() {
            System.out.println("you can do this now in Java 22");
            super();
        }
    }
}

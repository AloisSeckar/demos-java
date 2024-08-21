package cz.aloisseckar.java.javademos.java22.jep447;

import cz.aloisseckar.java.javademos.commons.IDemo;

/**
 * <p>
 *   Demo for JDK 22 preview feature <strong>Statements before super(...)</strong> (JEP 447)
 * </p>
 * <p>
 *   Further reading:
 *   <a href="https://blog.jetbrains.com/idea/2024/02/constructor-makeover-in-java-22/">
 *     Constructor Makeover in Java 22
 *   </a>
 * </p>
 *
 * @see <a href="https://openjdk.org/jeps/447">Statements before super(...) (Preview)</a>
 * @author alois.seckar@gmail.com
 */
public class StatementsBeforeSuper implements IDemo {

    @Override
    public void demo() {
        info("JEP 447 - Statements before super(...)", "Since Java 22, super() it is no longer required\nto be placed as first statement in constructor");
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

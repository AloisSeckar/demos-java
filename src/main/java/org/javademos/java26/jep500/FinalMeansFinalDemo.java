package org.javademos.java26.jep500;

import java.lang.reflect.Field;

import org.javademos.commons.IDemo;

/// Demo for JDK 26 feature JEP 500 - Prepare to Make Final Mean Final.
///
/// Since JDK 5, deep reflection (`Field.setAccessible` + `Field.set`) could reassign `final` fields.
/// Since JDK 26, doing so issues a runtime warning by default. A future release will throw
/// `IllegalAccessException` instead, unless final field mutation is explicitly enabled at startup.
///
/// ### JEP history
/// - JDK 26: [JEP 500 - Prepare to Make Final Mean Final](https://openjdk.org/jeps/500)
///
/// ### Further reading
/// - [Integrity by Default](https://openjdk.org/jeps/8305968)
/// - [Field.set Javadoc](https://docs.oracle.com/en/java/javase/26/docs/api/java.base/java/lang/reflect/Field.html#set(java.lang.Object,java.lang.Object))
///
/// @author Alois Sečkár <alois.seckar@gmail.com>
public class FinalMeansFinalDemo implements IDemo {

    @Override
    public void demo() {
        info(500);

        // JVM options controlling the new restriction:
        //
        // --enable-final-field-mutation=ALL-UNNAMED (or =M1,M2 for named modules)
        //   allows the given code to mutate final fields without a warning
        //   (executable JARs can use the `Enable-Final-Field-Mutation: ALL-UNNAMED` manifest entry)
        //
        // --illegal-final-field-mutation=allow|warn|debug|deny
        //   decides what happens on an illegal mutation:
        //   - allow - mutation proceeds silently
        //   - warn  - mutation proceeds, one warning per module is printed to stderr (default in JDK 26)
        //   - debug - like warn, but a warning with a stack trace is printed for every mutation
        //   - deny  - Field.set throws IllegalAccessException (planned future default)
        //
        // To find code mutating final fields, use the `debug` mode or record the
        // `jdk.FinalFieldMutation` JFR event (-XX:StartFlightRecording)

        mutateFinalField();
        mutateRecordField();
        useConstructorInstead();

        System.out.println();
    }

    private static void mutateFinalField() {
        System.out.println("1) Mutating final field of a normal class via deep reflection");
        Point point = new Point(100);
        System.out.println("Original value: " + point.x);
        try {
            Field field = Point.class.getDeclaredField("x");
            // setAccessible behaves the same as before JDK 26
            field.setAccessible(true);
            // Field.set is where the new check happens - unless mutation is enabled for this
            // module, the JVM prints a "WARNING: Final field x in ... has been mutated" to stderr
            field.set(point, 200);
            System.out.println("Mutated value: " + point.x + " (check stderr for JVM warning)");
        } catch (IllegalAccessException ex) {
            // this happens when running with --illegal-final-field-mutation=deny
            System.out.println("Mutation denied: " + ex.getMessage());
        } catch (NoSuchFieldException ex) {
            throw new IllegalStateException(ex);
        }
        // note: static final fields could never be mutated via Field.set,
        // and compile-time constants (e.g. `final int x = 100;`) are inlined by javac,
        // so a mutation would not even be visible in code reading them
    }

    private static void mutateRecordField() {
        System.out.println("2) Mutating final field of a record via deep reflection");
        // records (JDK 16) and hidden classes (JDK 15) never allowed this
        // JEP 500 aligns normal classes with them
        PointRecord point = new PointRecord(100);
        try {
            Field field = PointRecord.class.getDeclaredField("x");
            field.setAccessible(true);
            field.set(point, 200);
            System.out.println("Mutated value: " + point.x());
        } catch (IllegalAccessException ex) {
            System.out.println("Mutation denied: " + ex.getMessage());
        } catch (NoSuchFieldException ex) {
            throw new IllegalStateException(ex);
        }
    }

    private static void useConstructorInstead() {
        System.out.println("3) Recommended approach - create a new instance instead");
        // libraries are advised to stop mutating final fields - e.g. dependency injection
        // should use constructors and clone() should call a constructor instead of super.clone()
        // serialization libraries should use sun.reflect.ReflectionFactory (Serializable classes only)
        Point original = new Point(100);
        Point changed = original.withX(300);
        System.out.println("Original value: " + original.x + ", new instance value: " + changed.x);
    }

    private static class Point {
        // assigned in constructor, so reads are not inlined by the compiler
        final int x;

        Point(int x) {
            this.x = x;
        }

        Point withX(int newX) {
            return new Point(newX);
        }
    }

    private record PointRecord(int x) {}
}

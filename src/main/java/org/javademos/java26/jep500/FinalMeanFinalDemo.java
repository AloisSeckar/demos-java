package org.javademos.java26.jep500;

import java.lang.reflect.Field;

import org.javademos.commons.IDemo;

/// Demo for JDK 26 feature JEP 500 - Prepare to Make Final Mean Final.
///
/// Since JDK 5, deep reflection (`Field.setAccessible` + `Field.set`) can reassign `final` fields.
/// JDK 26 starts the process of disallowing that - by default, such a mutation still succeeds,
/// but the JVM prints a warning. A future release will throw `IllegalAccessException` instead.
///
/// Relevant JVM options:
/// - `--enable-final-field-mutation=ALL-UNNAMED` (or `=M1,M2` for named modules)
///   explicitly allows the mutation for the selected code and silences the warning
///   (executable JARs may use the `Enable-Final-Field-Mutation: ALL-UNNAMED` manifest entry)
/// - `--illegal-final-field-mutation=allow|warn|debug|deny` controls what happens
///   on an illegal mutation (`warn` is the default in JDK 26, `deny` will be the future default)
///
/// ### JEP history
/// - JDK 26: [JEP 500 - Prepare to Make Final Mean Final](https://openjdk.org/jeps/500)
///
/// ### Further reading
/// - [Integrity by Default](https://openjdk.org/jeps/8305968)
/// - [Field.set Javadoc](https://docs.oracle.com/en/java/javase/26/docs/api/java.base/java/lang/reflect/Field.html#set(java.lang.Object,java.lang.Object))
///
/// @author Alois Sečkár <ellrohir@seznam.cz>
public class FinalMeanFinalDemo implements IDemo {

    @Override
    public void demo() {
        info(500);

        // 1) a final field in a normal class
        // since JDK 5 deep reflection was allowed to reassign it
        // in JDK 26 it still works, but the JVM issues a warning to the standard error stream:
        //   WARNING: Final field value in ...Holder has been mutated reflectively by class ...FinalMeanFinalDemo ...
        //   WARNING: Use --enable-final-field-mutation=ALL-UNNAMED to avoid a warning
        // (the warning is printed at most once per module, so it may be missing if other code
        //  in the unnamed module already triggered it before)
        // with `--illegal-final-field-mutation=deny`, `Field.set` throws `IllegalAccessException`
        var holder = new Holder(100);
        System.out.println("Holder value before mutation: " + holder.value);
        try {
            Field field = Holder.class.getDeclaredField("value");
            field.setAccessible(true); // the behavior of `setAccessible` itself is unchanged
            field.set(holder, 200);    // this is where JDK 26 checks the new restrictions
            System.out.println("Holder value after mutation: " + holder.value + " (check stderr for the warning)");
        } catch (ReflectiveOperationException ex) {
            System.out.println("Final field mutation denied: " + ex);
        }

        // 2) record components were never mutable via deep reflection (since JDK 16)
        // JEP 500 aims to align final fields in normal classes with this behavior
        var point = new Point(1, 2);
        try {
            Field field = Point.class.getDeclaredField("x");
            field.setAccessible(true);
            field.set(point, 42);
        } catch (ReflectiveOperationException ex) {
            System.out.println("Record field mutation denied: " + ex.getClass().getSimpleName());
        }

        // 3) the recommended way - do not mutate, create a new instance with the desired value instead
        // (e.g. via constructor, static factory or "wither" method)
        var updated = holder.withValue(300);
        System.out.println("New Holder created instead of mutation: " + updated.value);

        // Notes:
        // - to find the code mutating final fields, run with `--illegal-final-field-mutation=debug`
        //   (prints a stack trace for every mutation) or record a JFR file and look for
        //   `jdk.FinalFieldMutation` events: `jfr print --events jdk.FinalFieldMutation recording.jfr`
        // - serialization libraries should use `sun.reflect.ReflectionFactory` instead of deep reflection
        // - `MethodHandles.Lookup.unreflectSetter` on a final field is restricted the same way as `Field.set`
        // - mutating final fields via JNI `Set<type>Field` is undefined behavior; `-Xcheck:jni` now warns about it
        // - once final means final, the JVM may trust final fields and apply optimizations like constant folding

        System.out.println();
    }

    static class Holder {
        final int value;

        Holder(int value) {
            this.value = value;
        }

        Holder withValue(int newValue) {
            return new Holder(newValue);
        }
    }

    record Point(int x, int y) {}
}

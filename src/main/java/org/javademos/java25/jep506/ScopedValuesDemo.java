package org.javademos.java25.jep506;

import org.javademos.commons.IDemo;

/// Demo for JDK 25 feature JEP 506 - Scoped Values.
///
/// ### JEP history
/// - JDK 25: [JEP 506 - Scoped Values](https://openjdk.org/jeps/506)
/// - JDK 23: [JEP 481 - Scoped Values (Third Preview)](https://openjdk.org/jeps/481)
/// - JDK 22: [JEP 464 - Scoped Values (Second Preview)](https://openjdk.org/jeps/464)
/// - JDK 21: [JEP 446 - Scoped Values (Preview)](https://openjdk.org/jeps/446)
/// - JDK 20: [JEP 429 - Scoped Values (Incubator)](https://openjdk.org/jeps/429)
///
/// ### Further reading
/// - [Inside Java – Scoped Values](https://inside.java/tag/scoped-values/)
///
/// @see java.lang.ScopedValue
///
/// @author @CodeSakshamY
public class ScopedValuesDemo implements IDemo {

    private static final ScopedValue<String> USER = ScopedValue.newInstance();

    @Override
    public void demo() {
        info(506);

        // Scoped values allow sharing immutable data safely across threads
        // Unlike ThreadLocal, ScopedValue avoids accidental leaks

        // USER is defined with value "Alice"
        ScopedValue.where(USER, "Alice").run(() -> {
            System.out.println("Inside scope: " + USER.get());

            // Nested USER will be "Bob" within this block
            ScopedValue.where(USER, "Bob").run(() -> {
                System.out.println("Nested scope: " + USER.get());
            });

            // USER is "Alice again"
            System.out.println("Back to outer scope: " + USER.get());
        });

        // USER is not defined here anymore
        // would result into `java.util.NoSuchElementException: ScopedValue not bound`
        // System.out.println("Outside of scope: " + USER.get());
    }
}

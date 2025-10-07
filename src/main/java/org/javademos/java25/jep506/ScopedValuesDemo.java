package org.javademos.java25.jep506;

import org.javademos.commons.IDemo;

/// Demo for JDK 25 feature **JEP 506 - Scoped Values**.
///
/// ### JEP history
/// - JDK 25: [JEP 506 - Scoped Values (Final)](https://openjdk.org/jeps/506)
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

        System.out.println("=== Scoped Values Demo ===");

        ScopedValue.where(USER, "Alice").run(() -> {
            System.out.println("Inside scope: " + USER.get());

            // Nested scope override
            ScopedValue.where(USER, "Bob").run(() -> {
                System.out.println("Nested scope: " + USER.get());
            });

            System.out.println("Back to outer scope: " + USER.get());
        });

        System.out.println("\nExplanation:");
        System.out.println("- Scoped values allow sharing immutable data safely across threads.");
        System.out.println("- Unlike ThreadLocal, ScopedValue avoids accidental leaks.");
        System.out.println("- In JDK 25, Scoped Values are finalized (no longer preview).");
    }
}

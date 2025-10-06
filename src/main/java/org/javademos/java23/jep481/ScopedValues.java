package org.javademos.java23.jep481;

import org.javademos.commons.IDemo;

/// Demo for JDK 23 feature **JEP 481 - Scoped Values (Third Preview)**.
///
/// JEP history:
/// - JDK 23: [JEP 482 - Scoped Values (Third Preview)](https://openjdk.org/jeps/482)
/// - JDK 22: [JEP 464 - Scoped Values (Second Preview)](https://openjdk.org/jeps/464)
/// - JDK 21: [JEP 446 - Scoped Values (Preview)](https://openjdk.org/jeps/446)
/// - JDK 20: [JEP 429 - Scoped Values (Incubator)](https://openjdk.org/jeps/429)
///
/// Will have a new implementation in JDK 24 via [JEP 487](https://openjdk.org/jeps/487)
///
/// Further reading:
/// - [Third Preview of Scoped Values API Brings Key Enhancements in JDK 23](https://www.infoq.com/news/2024/07/jep-481-enhanced-scoped-values/)
/// - [Scoped values (Java 23)](https://javarubberduck.com/java/news-02-08-2024/)
/// - [Scoped Values in Java – What They Are and How to Use Them](https://www.happycoders.eu/java/scoped-values/)
/// - [Understanding Java’s new ScopedValue]( https://www.infoworld.com/article/2336255/understanding-javas-new-scopedvalue.html)
///
/// @author alois.seckar@gmail.com
public class ScopedValues implements IDemo {

    // instance of scoped value to be used
    public final static ScopedValue<String> SCOPED_TEST = ScopedValue.newInstance();

    @Override
    public void demo() {
        info(481);

        // TODO add more detailed info

        // EVOLUTION
        // JDK 23
        // - ScopedValue.callWhere method changed parameter to functional interface
        // - ScopedValue.getWhere method removed
        // JDK 22
        // - no change
        // JDK 21
        // - TODO what changes since JEP 429?

        // define and run in separate thread
        ScopedValue.where(SCOPED_TEST, "test-value-1").run(this::run);
        ScopedValue.where(SCOPED_TEST, "test-value-2").run(this::run);

    }

    private void run() {
        System.out.println("Thread " + Thread.currentThread().threadId());
        System.out.println("Scoped value: " + SCOPED_TEST.get());
        ScopedValue.where(SCOPED_TEST, "nested-value").run(this::nestedRun);
    }

    private void nestedRun() {
        System.out.println("Nested thread " + Thread.currentThread().threadId());
        System.out.println("Scoped value: " + SCOPED_TEST.get());
    }
}

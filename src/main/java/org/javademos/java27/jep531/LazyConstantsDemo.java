package org.javademos.java27.jep531;

import java.util.Set;

import org.javademos.commons.IDemo;

/// Demo for JDK 27 feature JEP 531 - Lazy Constants (Third Preview).
///
/// The status in Java 27 is PREVIEW
///  => JVM option `--enable-preview` is required to use it.
///
/// ### Changes in JDK 26 (JEP 526)
/// - the API was renamed from `StableValue` to `LazyConstant`
/// - low-level methods `orElseSet`, `setOrThrow` and `trySet` were removed, leaving only
///   factory methods that take value-computing functions
/// - the factory methods for lazy lists and maps moved to `List.ofLazy` and `Map.ofLazy`
/// - the `function` and `intFunction` factory methods were removed
/// - `null` is no longer allowed as a computed value
///
/// ### Changes in JDK 27 (JEP 531)
/// - the low-level `isInitialized` and `orElse` methods were removed
/// - a new `Set.ofLazy(...)` factory creates a lazy `Set`, completing lazy versions of
///   the three fundamental collection types: `List`, `Set` and `Map`
///
/// ### JEP history
/// - JDK 27: [JEP 531 - Lazy Constants (Third Preview)](https://openjdk.org/jeps/531)
/// - JDK 26: [JEP 526 - Lazy Constants (Second Preview)](https://openjdk.org/jeps/526)
/// - JDK 25: [JEP 502 - Stable Values (Preview)](https://openjdk.org/jeps/502)
///
/// ### Further reading
/// - [Lazy Constants in Java](https://www.baeldung.com/java-lazy-constants)
/// - [Lazy Constants in Java 26](https://javapro.io/2026/07/22/lazy-constants-in-java-26-deferred-immutability-and-jvm-trust/)
///
/// @author @CodeSakshamY / alois.seckar@gmail.com
public class LazyConstantsDemo implements IDemo {

    // this is the classic constant declaration in JDK <= 24
    // it gets initialized immediately during class loading
    // you will find the console log at the very begining of the program execution
    private static final ExpensiveObject AS_CONSTANT = new ExpensiveObject(1);

    // in JDK 25, new "stable value" feature was introduced
    // in JDK 26, the feature was renamed to "lazy constants"

    // since JDK 26 we can init a "lazy constant" like this
    // the variable is also treated as "private static final"
    // but its initialization is deferred until the first time it is requested
    private final LazyConstant<ExpensiveObject> AS_LAZY_CONSTANT = LazyConstant.of(() -> new ExpensiveObject(2));

    @Override
    public void demo() {
        info(531);

        System.out.println("Lazy Constants demo started");

        // this instance was already created when the whole demo application started
        System.out.println(AS_CONSTANT);
        // this instance will be created on-demand at this moment
        System.out.println(AS_LAZY_CONSTANT.get());

        // since JDK 27 a lazy Set joins the existing lazy List and Map, so every membership
        // test below only pays for computing its own element, the first time it is checked
        Set<String> lazyOptions = Set.ofLazy(Set.of("VERBOSE", "DRY_RUN", "STRICT"), LazyConstantsDemo::isEnabled);
        System.out.println("DRY_RUN enabled: " + lazyOptions.contains("DRY_RUN"));
        System.out.println("STRICT enabled: " + lazyOptions.contains("STRICT"));

        System.out.println();
    }

    // simulates an expensive check, e.g. parsing a config file or command line
    private static boolean isEnabled(String option) {
        System.out.println("JEP 531 Demo - evaluating option " + option + "...");
        return "DRY_RUN".equals(option);
    }
}

class ExpensiveObject {
    private final int id;

    public ExpensiveObject(int id) {
        this.id = id;
        // imagine this class instance takes long to load 
        // or consumes a lot of resources during that
        System.out.println( "JEP 531 Demo - New ExpensiveObject " + id + " created!");
    }

    @Override
    public String toString() {
        return "ExpensiveObject{id=" + id + "}";
    }
}

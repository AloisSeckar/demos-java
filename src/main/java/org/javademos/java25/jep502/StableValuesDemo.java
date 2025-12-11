package org.javademos.java25.jep502;

import org.javademos.commons.IDemo;

/// Demo for JDK 25 feature JEP 502 - Stable Values (Preview).
///
/// ### JEP history
/// - JDK 25: [JEP 502 - Stable Values (Preview)](https://openjdk.org/jeps/502)  
///
/// ### Further reading
/// - [JEP 502 - Stable Values. New Feature of Java 25 Explained](https://softwaremill.com/jep-502-stable-values-new-feature-of-java-25-explained/)
///
/// @author @CodeSakshamY / alois.seckar@gmail.com
public class StableValuesDemo implements IDemo {

    // this is the classic constant declaration in JDK <= 24
    // it gets initialized immediately during class loading
    // you will find the console log at the very begining of the program execution
    private static final ExpensiveObject AS_CONSTANT = new ExpensiveObject(1);

    // since JDK 25 we can init a "stable value" like this
    // the variable is also treated as "private static final"
    // but its initialization is deferred until the first time it is requested
    private static final StableValue<ExpensiveObject> AS_STABLE_OBJECT = StableValue.of();

    // the initialization of stable object will happen ONCE when values are requested the first time
    // "orElseSet" accepts a lambda supplier function to initialize the stable value with data
    public static ExpensiveObject getExpensiveObject() {
        return AS_STABLE_OBJECT.orElseSet(() -> new ExpensiveObject(2));
    }

    @Override
    public void demo() {
        info(502);

        System.out.println("Stable Values demo started");

        // here we ask for the stable value for the first time during runtime
        getExpensiveObject();

        System.out.println(AS_CONSTANT);
        System.out.println(AS_STABLE_OBJECT);
        System.out.println();
    }
}

class ExpensiveObject {
    public ExpensiveObject(int id) {
        // imagine this class instance takes long to load 
        // or consumes a lot of resources during that
        System.out.println( "JEP 502 Demo - New ExpensiveObject " + id + " created!");
    }
}

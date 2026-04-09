package org.javademos.java26.jep526;

import org.javademos.commons.IDemo;

/// Demo for JDK 26 feature JEP 526 - Lazy Constants (Second preview).
///
/// ### JEP history
/// - JDK 26: [JEP 526 - Lazy Constants (Second Preview)](https://openjdk.org/jeps/526)  
/// - JDK 25: [JEP 502 - Stable Values (Preview)](https://openjdk.org/jeps/502)  
///
/// ### Further reading
/// - [Lazy Constants in Java](https://www.baeldung.com/java-lazy-constants)
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
        info(526);

        System.out.println("Lazy Constants demo started");

        // this instance was already created when the whole demo application started
        System.out.println(AS_CONSTANT);
        // this instance will be created on-demand at this moment
        System.out.println(AS_LAZY_CONSTANT.get());
        System.out.println();
    }
}

class ExpensiveObject {
    private final int id;

    public ExpensiveObject(int id) {
        this.id = id;
        // imagine this class instance takes long to load 
        // or consumes a lot of resources during that
        System.out.println( "JEP 526 Demo - New ExpensiveObject " + id + " created!");
    }

    @Override
    public String toString() {
        return "ExpensiveObject{id=" + id + "}";
    }
}

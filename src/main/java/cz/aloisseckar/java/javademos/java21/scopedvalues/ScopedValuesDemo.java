package cz.aloisseckar.java.javademos.java21.scopedvalues;

import cz.aloisseckar.java.javademos.commons.IDemo;
import jdk.incubator.concurrent.ScopedValue;

/**
 * This class demonstrates new feature called Scoped Values.
 * 
 * Introduced: Java 20
 * 
 * Further reading: 
 * https://www.happycoders.eu/java/scoped-values/
 * https://openjdk.org/jeps/429
 * 
 * @author alois.seckar@atos.net
 */
public class ScopedValuesDemo implements IDemo {

    // instance of scoped value to be used
    public final static ScopedValue<String> SCOPED_TEST = ScopedValue.newInstance();

    @Override
    public void demo() {
        info("SCOPED VALUES DEMO", "Examples for 'Scoped Values'");

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

package org.javademos.java25.jep513;

import org.javademos.commons.IDemo;

/// Demo for JDK 25 feature JEP 513 - Flexible Constructors Bodies.
///
/// JEP history:
/// - JDK 25 (preview): 
/// [JEP 513 - Flexible Constructors Bodies](https://openjdk.org/jeps/513)
///
/// Further reading:
/// - [JEP 513](https://openjdk.org/jeps/513)
/// - [JEP 492](https://openjdk.org/jeps/492) (Third Preview)
///
/// @author Ashutosh Singh @Rossville
public class FlexibleConstructorBodiesDemo implements IDemo{
    @Override
    public void demo(){
        info(513);
        
        new SubClass(1, 2); 
    }
}

class SuperClass {
    public SuperClass(int x) {
        if (x<0) {
            throw new IllegalArgumentException();
        }

        // WARNING - This is technically possible, but rather a bad practice.
        // Calling a overridden method in the constructor body
        // may result into unpredictable behavior.
        // In this case, SubClass.show() would be actually called (see the demo output).
        show();
    }

    protected void show() {
        System.out.println("Show in SuperClass");
    }
}

class SubClass extends SuperClass {

    private int b;

    // In JDK <= 24, the compiler performs implicit constructor invocation i.e super(...) or this(...).
    // If parent constructor call isn't there as a first line of statement [explicit invocation],
    // compilation errors occurs.
    public SubClass(int x, int b) {

        // in JDK <= 24, you were required to call parent constructor here 
        // as the first statement in child constructor body
        // super(x);

        // since JDK 25 this allows to fail fast
        if (x<0) {
            throw new IllegalArgumentException();
        }

        // you can also initialize child class members here
        this.b = b;

        // and make the explicit parent constructor invocation later
        super(x); // would throw compilation error in JDK <= 24
    }

    @Override
    public void show() {
        System.out.println("Show in SubClass - B:" + b);
    }
}
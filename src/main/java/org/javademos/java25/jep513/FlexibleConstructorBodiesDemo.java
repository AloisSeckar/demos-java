package org.javademos.java25.jep513;

import org.javademos.commons.IDemo;

/// Demo for JDK 25 feature **Flexible Constructors Bodies ** (JEP 513)
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

class Super{
    Super(int x){
        if(x<0)
            throw new IllegalArgumentException();
        // Bad Practise: calling a overidden method in the constructor body
        // can result in dynamic method dispatching
        show();
    }
    void show(){
        System.out.println("This is demo text");
    }
}

class sub extends Super{
    int age;
    /*
     *  In Pre-JDK 25 ,the compiler performs implicit constructor invocation i.e super(...) or this(...)
     *  compile-time errors : if constructor call isn't there as a first line of statement [explicit invocation]
    */
    sub(int x, int age){
        if(x<0)
            throw new IllegalArgumentException(); // this allows to fail fast.
        this.age = age;
        // explicit constructor invocation can be done at the end (JDK >= 25).
        super(x); // throws compile-time error if JDK <= 24
        System.out.println("Constructor Body continues normally");
    }
    @Override
    void show() {
        System.out.println("Age :"+age);
    }
}

public class FlexibleConstructorBodiesDemo implements IDemo{
    @Override
    public void demo(){
        info(513);
        // the constructor invocation is done at the time of object creation.
        new sub(5,20); 
    }
}

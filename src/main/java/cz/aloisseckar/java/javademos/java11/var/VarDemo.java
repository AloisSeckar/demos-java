package cz.aloisseckar.java.javademos.java11.var;

import cz.aloisseckar.java.javademos.commons.IDemo;
import java.util.stream.Stream;

/**
 * This class demonstrates new 'var' keyword introduced in Java 10.
 * You can use 'var' on left side of variable declaration to simplify the code.
 * Compiler will internally translate 'var' into respective data type appearing
 * on the right side. This assignment is final and cannot be changed later.
 * 
 * Introduced: Java 10
 * Finalized: Java 11
 * 
 * Further reading:
 * https://developers.redhat.com/blog/2018/05/25/simplify-local-variable-type-definition-using-the-java-10-var-keyword
 * 
 * @author alois.seckar@atos.net
 */
public class VarDemo implements IDemo {
    
    // you cannot use 'var' for object members
    //   'var' is not allowed here
    // private var variable;
    
    // even with immediate assignment
    // private var variable = "v";
    
    @Override
    public void demo() {
        info("VAR DEMO", "Examples for 'var' keyword introduced in Java 10");
        
        System.out.println("BASICS");
        
        // you can use 'var' to shorten variable declaration
        String s1 = "hello";
        var s2 = "world";
        
        // you cannot assign another data type into variable instanced as 'var'
        // trying this will throw:
        //   incompatible types: int cannot be converted to String
        // s2 = 3 + 5; 
        
        // you can see both variables are java.lang.String
        System.out.println(s1.getClass());
        System.out.println(s2.getClass());
        
        // here you can see how 'var' shortens variable declaration
        VarDemoVeryLongClassNameThatWeDoNotWantToRepeat v1 = new VarDemoVeryLongClassNameThatWeDoNotWantToRepeat();
        System.out.println(v1.getClass());
        var v2 = new VarDemoVeryLongClassNameThatWeDoNotWantToRepeat();
        System.out.println(v2.getClass());
        
        // it can be also useful when using method chaining
        // you don't have to bother analysing what is the final outcome, 
        // the compiler will just decide for you...
        var res = Stream.of("1","2","3").map(x -> Integer.valueOf(x)).findAny().map(x -> Double.valueOf(0 - x)).get();
        System.out.println(res);
        System.out.println(res.getClass());
        
        System.out.println();
        
        ////////////////////////////////////////////////////////////////////////
        
        System.out.println("INHERITANCE");
        
        // normally, we can benefit from polymorphism in Java
        // if we declare your variable as 'parent', it allows all 'children'
        // to be assigned into, as subclass always resolves to its parent
        VarDemoParent p1 = new VarDemoSon();
        p1.foo();
        System.out.println(p1.getClass());
        p1 = new VarDemoDaughter();
        p1.foo();
        System.out.println(p1.getClass());
        
        // using 'var' unfortunately disables this possibility
        // because compiler will recognize 'p2' as VarDemoSon
        // and then obviously doesn't allow swapping to VarDemoDaughter
        /*
        var p2 = new VarDemoSon();
        p2.foo();
        System.out.println(p2.getClass());
        p2 = new VarDemoDaughter(); // incompatible types: VarDemoDaughter cannot be converted to VarDemoSon
        p2.foo();
        System.out.println(p2.getClass());
        */
        
        // same effect applies to interfaces
        // while you can assign any implementation into variable declared as
        // the interface itself, using 'var' will resolve 'if2' as the first
        // implementation, and you won't be able to change it later
        IVarDemo if1 = new IVarDemoImpl1();
        if1.foo();
        System.out.println(if1.getClass());
        if1 = new IVarDemoImpl2();
        if1.foo();
        System.out.println(if1.getClass());
        
        /*
        var if2 = new IVarDemoImpl1();
        if2.foo();
        System.out.println(if2.getClass());
        if2 = new IVarDemoImpl2(); // incompatible types: IVarDemoImpl2 cannot be converted to IVarDemoImpl1
        if2.foo();
        System.out.println(if2.getClass());
        */
        
        System.out.println();
        
        ////////////////////////////////////////////////////////////////////////
        
        System.out.println("VAR IN LAMBDA EXPRESSIONS");
        System.out.println("(since Java 11)");
        
        // originally it wasn't allowed to use 'var' inside lambdas
        // now the only requirement is not to mix var and non-var declarations
        // https://openjdk.java.net/jeps/323
        
        // simple functional interface to be implemented by our lambdas
        @FunctionalInterface
        interface MyFunction {
            String operation(Object a, Object b);
        }
        
        // lambda function declared with explicit data types
        MyFunction myFunction1 = (Object x, Object y) -> x.toString() + y.toString();
        System.out.println(myFunction1.operation("x", Integer.MAX_VALUE));
        
        // equivalent lambda function declared with 'var' keywords
        MyFunction myFunction2 = (var x, var y) -> x.toString() + y.toString();
        System.out.println(myFunction2.operation("x", Integer.MAX_VALUE));
        
        // this is not allowed - attempt will throw:
        //  'Cannot mix 'var' and explicitly typed parameters in lambda expression'
        // MyFunction myFunction3 = (var x, Object y) -> x.toString() + y.toString();
        
        // however, you can also omit data types declaration at all as the
        // data types implicitly result from functional interface declaration
        // therefore allowing 'var' for lambda variables just avoids confusion
        // and doesn't bring anything new
        MyFunction myFunction3 = (x,y) -> x.toString() + y.toString();
        System.out.println(myFunction3.operation("x", Integer.MAX_VALUE));

        // you also cannot 'var' the lambda definition:
        //  'Cannot infer type: lambda expression requires an explicit target type'
        // var myFunction4 = (Object x, Object y) -> x.toString() + y.toString();
        
        System.out.println();
    }
    
}

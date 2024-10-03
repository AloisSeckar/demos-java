package org.javademos.java11.var;

/**
 * Simple implementation of IVarDemo to show 'var' keyword behavior.
 * 
 * @see IVarDemo
 * @see VarDemo
 * 
 * @author alois.seckar@gmail.com
 */
public class IVarDemoImpl1 implements IVarDemo {

    @Override
    public void foo() {
        System.out.println("Hello from IVarDemoImpl1");
    }
    
}

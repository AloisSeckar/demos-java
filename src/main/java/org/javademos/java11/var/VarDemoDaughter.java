package org.javademos.java11.var;

/**
 * Simple subclass of VarDemoParent to show 'var' keyword behavior.
 * 
 * @see VarDemoParent
 * @see VarDemo
 * 
 * @author alois.seckar@gmail.com
 */
public class VarDemoDaughter extends VarDemoParent {
    
    @Override
    public void foo() {
        super.foo();
        System.out.println("And I am his daughter");
    }
    
}

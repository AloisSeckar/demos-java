package cz.aloisseckar.java.javademos.java11.var;

/**
 * Simple subclass of VarDemoParent to show 'var' keyword behavior.
 * 
 * @see cz.aloisseckar.java.javademos.java11.var.VarDemoParent
 * @see cz.aloisseckar.java.javademos.java11.var.VarDemo
 * 
 * @author alois.seckar@atos.net
 */
public class VarDemoDaughter extends VarDemoParent {
    
    @Override
    public void foo() {
        super.foo();
        System.out.println("And I am his daughter");
    }
    
}

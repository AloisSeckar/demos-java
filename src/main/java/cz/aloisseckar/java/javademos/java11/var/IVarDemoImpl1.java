package cz.aloisseckar.java.javademos.java11.var;

/**
 * Simple implementation of IVarDemo to show 'var' keyword behavior.
 * 
 * @see cz.aloisseckar.java.javademos.java11.var.IVarDemo
 * @see cz.aloisseckar.java.javademos.java11.var.VarDemo
 * 
 * @author alois.seckar@atos.net
 */
public class IVarDemoImpl1 implements IVarDemo {

    @Override
    public void foo() {
        System.out.println("Hello from IVarDemoImpl1");
    }
    
}

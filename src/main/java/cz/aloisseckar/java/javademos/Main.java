package cz.aloisseckar.java.javademos;

import cz.aloisseckar.java.javademos.commons.IDemo;
import cz.aloisseckar.java.javademos.java11.http.HttpDemo;
import cz.aloisseckar.java.javademos.java11.j9.J9Demo;
import cz.aloisseckar.java.javademos.java11.string11.String11Demo;
import cz.aloisseckar.java.javademos.java11.var.VarDemo;
import cz.aloisseckar.java.javademos.java17.deprecated.DeprecatedDemo;
import cz.aloisseckar.java.javademos.java17.j16.J16Demo;
import cz.aloisseckar.java.javademos.java17.newswitch.SwitchDemo;
import cz.aloisseckar.java.javademos.java17.nullpointer.NullPointerDemo;
import cz.aloisseckar.java.javademos.java17.pattern.InstanceofPatternMatchingDemo;
import cz.aloisseckar.java.javademos.java17.record.RecordDemo;
import cz.aloisseckar.java.javademos.java17.sealed.SealedDemo;
import cz.aloisseckar.java.javademos.java17.string12.String12Demo;
import cz.aloisseckar.java.javademos.java17.textblock.TextBlockDemo;
import cz.aloisseckar.java.javademos.java21.j21.J21Demo;
import cz.aloisseckar.java.javademos.java21.pattern.PatternMatchingForSwitchDemo;
import cz.aloisseckar.java.javademos.java21.pattern.RecordPatternsDemo;
import cz.aloisseckar.java.javademos.java21.sequenced.SequencedCollectionsDemo;
import cz.aloisseckar.java.javademos.java21.virtualthreads.VirtualThreadsDemo;
import cz.aloisseckar.java.javademos.java21.scopedvalues.ScopedValuesDemo;
import cz.aloisseckar.java.javademos.java21.vectorapi.VectorAPIDemo;

import java.util.ArrayList;

/**
 * This application helps to show some new features from Java 11 to Java 21.
 * 
 * The 'demoPool' array consists of simple IDemo interface implementations.
 * Code logic is being implemented inside .demo() methods.
 * 
 * @see cz.aloisseckar.java.javademos.commons.IDemo
 * 
 * You can try switching the compile/build settings back to Java 1.8 to see
 * that the most of the stuff used here cannot be compiled and run under old
 * versions of Java.
 * 
 * @author alois.seckar@gmail.com
 */
public class Main {
    
    /**
     * Simple main method.
     * No complex logic - all available demo implementations are being put
     * inside a list, and then being executed one by one.
     * 
     * @param args not supported (ignored) in this application
     */
    public static void main(String[] args) {

        // https://stackoverflow.com/a/19165338/3204544
        System.out.println("JVM INFO");
        System.out.println(System.getProperty("java.vm.name"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("java.vendor"));
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.specification.vendor"));
        //
        
        var demoPool = new ArrayList<IDemo>();
        
        // you may find useful to comment out all entries except the one
        // you are about to examine
        // it may be confusing to search the actual output of particular
        // demo class implementation you are currently interested in

        // Java 11
        demoPool.add(new J9Demo());
        demoPool.add(new VarDemo());
        demoPool.add(new HttpDemo());
        demoPool.add(new String11Demo());
        
        // Java 17
        demoPool.add(new String12Demo());
        demoPool.add(new SwitchDemo());
        demoPool.add(new NullPointerDemo());
        demoPool.add(new TextBlockDemo());
        demoPool.add(new J16Demo());
        demoPool.add(new RecordDemo());
        demoPool.add(new InstanceofPatternMatchingDemo());
        demoPool.add(new SealedDemo());
        demoPool.add(new DeprecatedDemo());

        // Java 21
        demoPool.add(new VirtualThreadsDemo());
        demoPool.add(new RecordPatternsDemo());
        demoPool.add(new PatternMatchingForSwitchDemo());
        demoPool.add(new ScopedValuesDemo());
        demoPool.add(new VectorAPIDemo());
        demoPool.add(new SequencedCollectionsDemo());
        demoPool.add(new J21Demo());
        
        // run method .demo() on each entry to see the output
        demoPool.forEach(IDemo::demo);
        
    }
    
}

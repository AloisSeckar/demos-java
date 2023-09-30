package cz.aloisseckar.java.javademos.java21.sequenced;

import cz.aloisseckar.java.javademos.commons.IDemo;

import java.util.*;

/**
 * This class shows examples of new 'Sequenced Collections'.
 * They are defined as collections whose elements have a defined encounter order.
 *
 * Introduced: Java 21 (JEP 431)
 *
 * Further reading:
 * https://openjdk.org/jeps/431
 * https://www.baeldung.com/java-21-sequenced-collections
 *
 * @author alois.seckar@atos.net
 */
public class SequencedCollectionsDemo implements IDemo {

    @Override
    public void demo() {
        info("SEQUENCED COLLECTIONS DEMO", "Examples of new 'sequenced' collections \nintroduced in Java 21");

        // all 'Lists' now implements 'SequencedCollection' interface
        // except reversed(), the interface methods have default implementation

        System.out.println("Source array: [1,2,3,4,5]");
        var arrayList = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        // we can get first and last element
        System.out.println("getFirst(): " + arrayList.getFirst());
        System.out.println("getLast(): " + arrayList.getLast());

        // we can add to first/last position
        arrayList.addFirst(0);
        System.out.println("addFirst():" + arrayList);
        arrayList.addLast(6);
        System.out.println("addLast(): " + arrayList);

        // we can remove from first/last position
        arrayList.removeFirst();
        System.out.println("removeFirst(): " + arrayList);
        arrayList.removeLast();
        System.out.println("removeLast(): " + arrayList);

        // we can reverse whole list
        System.out.println("reversed(): " + arrayList.reversed());

        // TODO example for Set and Map

        // KNOWN PROBLEMS
        // implementing both List<T> and Deque<T> interface will result into override clash,
        // as both interfaces now have reversed() method with different return types.
        // public class ThisWontWorkInJava21 implements List<T>, Deque<T>

    }

}

package org.javademos.java21.jep431;

import org.javademos.commons.IDemo;

import java.util.*;

/// Demo for JDK 21 feature **JEP 431 - Sequenced Collections**.
/// 
/// They are defined as collections whose elements have a defined encounter order.
///
/// JEP history:
/// - JDK 21: [JEP 431 - Sequenced Collections](https://openjdk.org/jeps/431)
///
/// Further reading:
/// - [Java 21 Sequenced Collections](https://www.baeldung.com/java-21-sequenced-collections)
///
/// @author alois.seckar@gmail.com
public class SequencedCollectionsDemo implements IDemo {

    @Override
    public void demo() {
        info("SEQUENCED COLLECTIONS DEMO", "Examples of new 'Sequenced' collections \nintroduced in Java 21");

        // --------------------------------
        System.out.println("1) LIST");

        // 'Lists' now implement 'SequencedCollection' interface
        // the interface methods have default implementation except for `reversed()`
        // built-in classes: ArrayList, Vector, Stack, LinkedList
        // + ArrayDeque (implements 'SequencedCollection' through Deque interface)

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

        // KNOWN PROBLEMS
        // implementing both List<T> and Deque<T> interface will result into override clash,
        // as both interfaces now have `reversed()` method with different return types.
        // public class ThisWontWorkInJava21 implements List<T>, Deque<T>

        System.out.println();
        // --------------------------------
        System.out.println("2) SET");

        // 'Sets' now implement 'SequencedSet' that implements 'SequencedCollection' interface
        // 'SequencedSet' interface has override for `reversed()`
        // built-in classes: TreeSet, LinkedHashSet

        var hashSet = new LinkedHashSet<>(Arrays.asList(1,2,3,4,5));

        System.out.println("< JDK 21");
        var iterator = hashSet.iterator();
        var firstOld = iterator.next();
        System.out.println("first item: " + firstOld);
        // getting last was a bit complicated
        int lastOld = 0;
        while(iterator.hasNext()) {
            lastOld = iterator.next();
        }
        System.out.println("last item (iterator): " + lastOld);
        // easier with StreamAPI, but still...
        @SuppressWarnings("unused") // `first` is not used and can be replaced with `_`, but is kept here for clarity
        var lastStream = hashSet.stream().reduce((first, second) -> second).get();
        System.out.println("last item (stream): " + lastStream);

        System.out.println("JEP 431");
        var firstNew = hashSet.getFirst();
        System.out.println("getFirst(): " + firstNew);
        var lastNew = hashSet.getLast();
        System.out.println("getLast(): " + lastNew);

        System.out.println();
        // --------------------------------
        System.out.println("3) MAP");

        // 'Maps' now implement 'SequencedMap' interface
        // built-in classes: TreeMap, ConcurrentSkipListMap, LinkedHashMap

        var hashMap = new LinkedHashMap<Integer, String>();
        hashMap.put(1, "one");
        hashMap.put(2, "two");
        hashMap.put(3, "three");

        System.out.print("MAP: ");
        hashMap.forEach((k, v) -> {
            System.out.print(k + "=" + v + "; ");

        });
        System.out.println();

        System.out.println("firstEntry(): " + hashMap.firstEntry());

        // returns the first key-value pair of the map
        System.out.println("firstEntry(): " + hashMap.firstEntry());
        // returns the last key-value pair of the map
        System.out.println("lastEntry(): " + hashMap.lastEntry());

        // removes the first key-value pair and returns it
        System.out.println("pollFirstEntry(): " + hashMap.pollFirstEntry());
        // removes the last key-value pair and returns it
        System.out.println("pollLastEntry(): " + hashMap.pollLastEntry());

        System.out.print("MAP: ");
        hashMap.forEach((k, v) -> {
            System.out.print(k + "=" + v + "; ");

        });
        System.out.println();

        // inserts a key-value pair at the beginning of the map
        System.out.println("putFirst(): " + hashMap.putFirst(3, "three"));
        // appends a key-value pair to the end of the map
        System.out.println("putLast(): " + hashMap.putLast(1, "one"));

        // returns a view on the map in reverse order
        var reversedMap = hashMap.reversed();

        System.out.print("REVERSED MAP: ");
        reversedMap.forEach((k, v) -> {
            System.out.print(k + "=" + v + "; ");

        });
        System.out.println();

        // BONUS
        // extra 'SequencedMap' methods
        // SequencedSet sequencedKeySet() – returns the keys of the map
        // SequencedCollection<V> sequencedValues() – returns the values of the map
        // SequencedSet<Entry<K,V>> sequencedEntrySet() – returns all entries of the map

    }

}

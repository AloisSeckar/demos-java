package org.javademos.java20.jep436;

import org.javademos.commons.IDemo;
import org.javademos.java21.jep444.VirtualThreadsDemo;
/// Demo for JDK 20 feature JEP 436 - Virtual Threads.
///
/// JEP history:
/// - JDK 21: [JEP 444 - Virtual Threads](https://openjdk.org/jeps/444)
/// - JDK 20: [JEP 436 - Virtual Threads (Second Preview)](https://openjdk.org/jeps/436)
/// - JDK 19: [JEP 425 - Virtual Threads (Preview)](https://openjdk.org/jeps/425)
///
/// Further reading:
/// - [Java Loom: Virtual Threads vs Platform Threads](https://blogs.oracle.com/javamagazine/post/java-loom-virtual-threads-platform-threads)
///
/// @author @Rossville
public class VirtualThreads implements IDemo {
    public void demo() {
        System.out.println("JEP 436 - Virtual Threads (Second Preview)");
        System.out.println("This feature was finalized in JEP 444 (JDK 21).");
        System.out.println("Redirecting to the latest demo...\n");
        new VirtualThreadsDemo().demo();
    }
}

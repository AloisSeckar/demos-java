package cz.aloisseckar.java.javademos.java21.virtualthreads;

import cz.aloisseckar.java.javademos.commons.IDemo;

/**
 * This class shows new preview feature finalized in Java 21 - Virtual Threads.
 *
 * REFERENCES:
 * Java 21 - https://openjdk.org/jeps/444 - Virtual Threads
 * Java 20 - https://openjdk.org/jeps/436 - Virtual Threads (Second Preview)
 * Java 19 - https://openjdk.org/jeps/425 - Virtual Threads (Preview)
 *
 * Further reading:
 * https://blogs.oracle.com/javamagazine/post/java-loom-virtual-threads-platform-threads
 *
 * @author alois.seckar@gmail.com
 */
public class VirtualThreadsDemo implements IDemo {

    @Override
    public void demo() {
        info("VIRTUAL THREADS DEMO", "Examples for 'virtual threads' feature\nintroduced in Java 19");

        // so far, all java.lang.Thread instances were directly connected to underlying OS thread
        // the consequences:
        //  - the actual thread is out of JVM's control
        //  - there are platform-dependant limits (typically the maximum number of system threads is limited)

        // 'virtual threads' are an abstraction
        // you can create basically unlimited number of them while they only exist inside JVM memory
        // there is a build-in Scheduler

        // CREATING THREADS
        // old-fashioned threads (aka 'platform threads') still exist
        // old ways of creating Thread instances will always produce a platform thread
        // virtual thread has to be created via special factory method
        // there is a new factory method for platform threads as well

        var oldThread = new Thread(new SimpleTask());
        oldThread.setName("oldThread");

        var newOldThread = Thread.ofPlatform().name("newOldThread").unstarted(new SimpleTask());

        var newVirtualThread = Thread.ofVirtual().name("newVirtualThread").unstarted(new SimpleTask());

        System.out.println("IS THE THREAD VIRTUAL?");
        System.out.println("oldThread: " + oldThread.isVirtual());
        System.out.println("newOldThread: " + newOldThread.isVirtual());
        System.out.println("newVirtualThread: " + newVirtualThread.isVirtual());
        System.out.println();

        // DAEMON THREAD
        // see https://www.baeldung.com/java-daemon-thread
        // platform thread is not a 'daemon' unless you tell it to be
        // virtual thread is always a 'daemon' and you cannot change it

        System.out.println("IS THE THREAD DAEMON?");
        System.out.println("oldThread: " + oldThread.isDaemon());
        System.out.println("newOldThread: " + newOldThread.isDaemon());
        System.out.println("newVirtualThread: " + newVirtualThread.isDaemon());

        oldThread.setDaemon(true);
        System.out.println("oldThread is " + (oldThread.isDaemon() ? "DAEMON" : "NORMAL") + " thread now");
        newOldThread.setDaemon(true);
        System.out.println("newOldThread is " + (oldThread.isDaemon() ? "DAEMON" : "NORMAL") + " thread now");

        System.out.println("newVirtualThread will always be a 'daemon'");
        System.out.println();

        // this would throw a runtime exception:
        //  Exception in thread "main" java.lang.IllegalArgumentException: 'false' not legal for virtual threads
        // newVirtualThread.setDaemon(false);

        // THREAD PRIORITY
        // virtual thread always has 'NORM_PRIORITY' and you cannot change it

        System.out.println("WHAT IS THE THREAD PRIORITY?");
        System.out.println("oldThread: " + oldThread.getPriority());
        System.out.println("newOldThread: " + newOldThread.getPriority());
        System.out.println("newVirtualThread: " + newVirtualThread.getPriority());

        oldThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("oldThread has priority " + oldThread.getPriority() + " now");
        newOldThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("newOldThread has priority " + newOldThread.getPriority() + " now");

        // trying to change virtual thread's priority is allowed, but will have no effect
        newVirtualThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("newVirtualThread has priority " + newVirtualThread.getPriority() + " now");
        newVirtualThread.setPriority(Thread.MIN_PRIORITY);
        System.out.println("newVirtualThread has priority " + newVirtualThread.getPriority() + " now");
        System.out.println();

        // RUNNING THREADS
        System.out.println("Following 3 threads will be started manually");
        oldThread.start();
        newOldThread.start();
        newVirtualThread.start();
        waitForThreads();
        System.out.println();

        // if you want to start your virtual thread directly, you have two options:

        System.out.println("Following 2 threads will auto-start");
        Thread.ofVirtual().name("quickVirtualThread").start(new SimpleTask());
        Thread.startVirtualThread(new SimpleTask()); // no implicit name => ID will be displayed
        waitForThreads();
        System.out.println();

        // NOTE: you shouldn't try to pool your virtual threads
        // TODO some more info / example

    }

    // to avoid possibility of 'main' thread finishing before generated threads will get a chance to show up
    private void waitForThreads() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.err.println("Sleep interrupted!");
        }
    }

    // simple task to be performed by our threads
    // prints out the name of the current thread invoking it
    private static class SimpleTask implements Runnable {
        @Override
        public void run() {
            var threadName = Thread.currentThread().getName();
            if (threadName != null && !threadName.isBlank()) {
                System.out.println(threadName);
            } else {
                System.out.println("Thread " + Thread.currentThread().threadId());
            }
        }
    }

}

package org.javademos.java25.jep518;

import org.javademos.commons.IDemo;

/// Demo for JDK 25 feature **JFR Cooperative Sampling** (JEP 518)
///
/// JEP history:
/// - JDK 25: [JEP 518 - JFR Cooperative Sampling](https://openjdk.org/jeps/518)
///
/// Further reading:
/// - [JFR Cooperative Sampling overview](https://openjdk.org/jeps/518)
///
/// @author Arjun Vijay Prakash @ArjunCodess

public class JFRCooperativeSampling implements IDemo {

    @Override
    public void demo() {
        info(518);

        System.out.println("this jep introduces cooperative sampling for java flight recorder (jfr).");
        System.out.println("it enables the jvm and java libraries to participate in sampling decisions,");
        System.out.println("reducing safepoint bias and overhead compared to purely timer-based sampling.");
        System.out.println();

        System.out.println("key ideas:");
        System.out.println("- jvm cooperates by sampling at allocation and other yield points.");
        System.out.println("- libraries can expose sampling hooks to mark interesting regions.");
        System.out.println("- improves representativeness of profiles on highly concurrent workloads.");
        System.out.println();

        System.out.println("note: there is no public java se api to call here; this is a jvm/jfr runtime change.");
        System.out.println("use `jfr` tooling (e.g., `jcmd <pid> JFR.start` and `jfr print`) to observe behavior under load.");
    }
}

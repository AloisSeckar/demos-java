package org.javademos.java25.jep518;

import org.javademos.commons.IDemo;

/// Demo for JDK 25 feature **JEP 518 - JFR Cooperative Sampling**.
///
/// JEP history:
/// - JDK 25: [JEP 518 - JFR Cooperative Sampling](https://openjdk.org/jeps/518)
///
/// Further reading:
/// - [JFR Cooperative Sampling overview](https://openjdk.org/jeps/518)
///
/// @author Arjun Vijay Prakash @ArjunCodess
public class JFRCooperativeSamplingDemo implements IDemo {

    @Override
    public void demo() {
        info(518);

        // explanation:
        // jep 518 introduces cooperative sampling for java flight recorder (jfr).
        // the jvm and java libraries participate in sampling decisions to reduce
        // safepoint bias and profiling overhead compared to timer-only sampling.
        //
        // this is a jvm/jfr runtime change; there is no public java se api call
        // to demonstrate here. to observe behavior, run a workload and capture
        // a jfr recording using tooling like `jcmd <pid> JFR.start` and analyze it.
    }
}

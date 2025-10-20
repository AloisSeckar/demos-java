package org.javademos.java21.jep451;

import org.javademos.commons.IDemo;

/// Demo for JDK 21 feature JEP 451 - Prepare to Disallow the Dynamic Loading of Agents.
///
/// This JEP introduces warnings when Java or JVM TI agents are loaded dynamically into a running
/// JVM. This change prepares the ecosystem for a future release where dynamic agent loading will be
/// disallowed by default, enhancing the platform's integrity.  
///
/// JEP history:
/// - [JEP 451: Prepare to Disallow the Dynamic Loading of Agents](https://openjdk.org/jeps/451)
///
/// @author mayankvyas1306
public class DisallowDynamicAgentLoading implements IDemo {

    @Override
    public void demo() {
        info(451);

        //     JEP 451 addresses the security and integrity risks of dynamically loading Java agents
        //     into a running JVM. While agents are powerful for tools like profilers, their ability
        //     to alter application code on-the-fly can be misused by libraries to bypass encapsulation.

        //     --- WHAT IS CHANGING IN JDK 21 ---

        //     Starting in JDK 21, when an agent is loaded into a running JVM (e.g., via the Attach API),
        //     the JVM will issue a warning to the console.

        //     Example Warning:
        //     WARNING: A Java agent has been loaded dynamically (file:/path/to/agent.jar)
        //     WARNING: If a serviceability tool is in use, please run with -XX:+EnableDynamicAgentLoading to hide this warning
        //     WARNING: If a serviceability tool is not in use, please run with -Djdk.instrument.traceUsage for more information
        //     WARNING: Dynamic loading of agents will be disallowed by default in a future release

        //     --- KEY POINTS ---

        //     1.  **Loading agents at startup is NOT affected.**
        //         Using command-line flags like `-javaagent:myagent.jar` or `-agentlib:myagent`
        //         remains perfectly fine and will not produce warnings. This is the recommended
        //         approach for libraries that require agents.

        //     2.  **This is a preparation step.**
        //         The goal is to alert developers and operators about dynamic agent usage. In a
        //         future JDK release, this behavior will be *disallowed* by default and will throw
        //         an exception unless explicitly enabled.

        //     3.  **How to manage this behavior:**
        //         - To **suppress the warning** in JDK 21 (and enable dynamic loading in the future),
        //           start the JVM with the flag: `-XX:+EnableDynamicAgentLoading`.
        //         - To **identify which code is loading an agent**, use the flag:
        //           `-Djdk.instrument.traceUsage`.

        //     This change moves the Java Platform toward a model of "integrity by default," requiring
        //     explicit user consent for powerful, potentially risky operations like modifying running code.

    }
}
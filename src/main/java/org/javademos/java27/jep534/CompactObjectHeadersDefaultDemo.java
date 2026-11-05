package org.javademos.java27.jep534;

import java.lang.management.ManagementFactory;

import com.sun.management.HotSpotDiagnosticMXBean;

import org.javademos.commons.IDemo;

/// Demo for JDK 27 feature JEP 534 - Compact Object Headers by Default.
///
/// JEP history:
/// - JDK 27: [JEP 534 - Compact Object Headers by Default](https://openjdk.org/jeps/534)
///
/// Further reading:
/// - [JEP 450 - Compact Object Headers (Experimental)](https://openjdk.org/jeps/450)
/// - [JEP 519 - Compact Object Headers](https://openjdk.org/jeps/519)
///
/// @author Alois Sečkár <alois.seckar@gmail.com>
public class CompactObjectHeadersDefaultDemo implements IDemo {
    @Override
    public void demo() {
        info(534);

        // Object headers shrink from 96 to 64 bits on 64-bit platforms, reducing heap usage.
        // Since JDK 27 this layout is the default; the old layout can be restored with
        // -XX:-UseCompactObjectHeaders, and the flag itself is no longer needed to enable it.
        HotSpotDiagnosticMXBean diagnostics = ManagementFactory.getPlatformMXBean(HotSpotDiagnosticMXBean.class);
        String value = diagnostics.getVMOption("UseCompactObjectHeaders").getValue();

        System.out.println("UseCompactObjectHeaders: " + value);
        System.out.println("Compact object headers active: " + Boolean.parseBoolean(value));

        System.out.println();
    }
}

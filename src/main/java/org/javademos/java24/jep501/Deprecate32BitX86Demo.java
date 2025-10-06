package org.javademos.java24.jep501;

import org.javademos.commons.IDemo;

/// Demo for JDK 24 change **Deprecate the 32-bit x86 Port for Removal** (JEP 501)
///
/// ### JEP history
/// - JDK 21: [JEP 449 - Deprecate the 32-bit x86 Windows Port for Removal](https://openjdk.org/jeps/449)
/// - JDK 24: [JEP 479 - Remove the 32-bit x86 Windows Port](https://openjdk.org/jeps/479)
/// - JDK 24: [JEP 501 - Deprecate the 32-bit x86 Port for Removal](https://openjdk.org/jeps/501)
/// - JDK 25: [JEP 503 - Remove the 32-bit x86 Port](https://openjdk.org/jeps/503)
///
/// ### Key points
/// - JDK 24 marked the **entire 32-bit x86 port** as deprecated.
/// - This was a warning for developers that support would end soon.
/// - The actual removal happened in JDK 25 (JEP 503).
///
/// Replaced with most recent [JEP 503 - Remove the 32-bit x86 Port](https://openjdk.org/jeps/503)
/// @see org.javademos.java25.jep503.Remove32BitX86Demo
///
/// @author adeelFeroz77

public class Deprecate32BitX86Demo implements IDemo {

    @Override
    public void demo() {
        info(501);
    }
}

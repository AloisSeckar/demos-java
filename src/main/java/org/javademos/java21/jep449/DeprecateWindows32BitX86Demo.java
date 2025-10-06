package org.javademos.java21.jep449;

import org.javademos.commons.IDemo;

/// Demo for JDK 21 change **Deprecate the 32-bit x86 Windows Port for Removal** (JEP 449)
///
/// ### JEP history
/// - JDK 21: [JEP 449 - Deprecate the 32-bit x86 Windows Port for Removal](https://openjdk.org/jeps/449)
/// - JDK 24: [JEP 479 - Remove the 32-bit x86 Windows Port](https://openjdk.org/jeps/479)
/// - JDK 24: [JEP 501 - Deprecate the 32-bit x86 Port for Removal](https://openjdk.org/jeps/501)
/// - JDK 25: [JEP 503 - Remove the 32-bit x86 Port](https://openjdk.org/jeps/503)
///
/// ### Key points
/// - JDK 21 did **not** remove the Windows 32-bit x86 port.
/// - It was only **deprecated**, meaning developers were warned about future removal.
/// - This was the first formal signal that the port was going away.
///
/// Replaced with most recent [JEP 503 - Remove the 32-bit x86 Port](https://openjdk.org/jeps/503)
/// @see org.javademos.java25.jep503.Remove32BitX86Demo
///
/// @author adeelFeroz77

public class DeprecateWindows32BitX86Demo implements IDemo {

    @Override
    public void demo() {
        info(449);
    }
}

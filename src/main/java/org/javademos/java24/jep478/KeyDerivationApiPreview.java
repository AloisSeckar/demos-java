package org.javademos.java24.jep478;

import org.javademos.commons.IDemo;

/// Demo for JDK 24 feature <strong>Key Derivation Function API (Preview)</strong> (JEP 478).
///
/// This JEP was a preview and is finalized in JDK 25 by JEP 510.
/// The working demo is in the JEP 510 class.
///
/// @see org.javademos.java25.jep510.KeyDerivationFunctionDemo
/// @see <a href="https://openjdk.org/jeps/478">JEP 478</a>
/// @author ankitkrshah30
public class KeyDerivationApiPreview implements IDemo {
    @Override
    public void demo() {
        info(478);
        System.out.println("This was a preview JEP. Please see the final implementation in JEP 510.");
    }
}
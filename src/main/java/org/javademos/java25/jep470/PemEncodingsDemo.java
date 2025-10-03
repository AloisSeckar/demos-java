package org.javademos.java25.jep470;

import org.javademos.commons.IDemo;

/// Demo for JDK 25 feature **PEM Encodings of Cryptographic Objects (Preview)** (JEP 470)
///
/// JEP history:
/// - JDK 25 (preview): [JEP 470 - PEM Encodings of Cryptographic Objects](https://openjdk.org/jeps/470)
///
/// Further reading:
/// - [JEP 470](https://openjdk.org/jeps/470)
///
/// NOTE: this is a preview feature; run with --enable-preview
///
/// @author Arjun Vijay Prakash @ArjunCodess

public class PemEncodingsDemo implements IDemo {
    @Override
    public void demo() {
        info(470);

        // todo: consider adding a real pem encode/decode sample using jdk 25 preview apis

        // the actual crypto apis for pem encoding/decoding are part of the preview jdk 25 api surface.
        // to keep this demo portable across environments and jdks, we only print guidance here.
        System.out.println("this demo illustrates the new pem encoding/decoding support introduced in jdk 25 (preview).");
        System.out.println("to try it, use jdk 25 with --enable-preview and the new pem apis in java.security to read/write keys and certs.");
    }
}

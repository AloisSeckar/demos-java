package org.javademos.java24.jep472;

import org.javademos.commons.IDemo;

///
/// # JEP 472: Prepare to Restrict the Use of JNI
///
/// @author mayankvyas1306
///
/// ## Summary
/// This JEP introduces warnings for uses of the Java Native Interface (JNI) to prepare developers
/// for a future release that will restrict native code interaction by default. The goal is to enhance
/// the integrity and security of the Java Platform by requiring explicit opt-ins for running native code.
/// This change aligns JNI with the Foreign Function & Memory (FFM) API's approach to safety.
///
/// ## Release Information
/// - **JEP:** 472
/// - **Status:** Delivered
/// - **Release:** JDK 24
/// - **Component:** core-libs
///
/// ## Resources
/// - [JEP 472: Prepare to Restrict the Use of JNI](https://openjdk.org/jeps/472)
///
public class PrepareToRestrictJNI implements IDemo {

    @Override
    public void demo() {
        info(472);

        // JNI allows Java to call native code (e.g., C/C++ libraries).
        // This is powerful but can compromise the JVM's integrity and security.
        // JEP 472 prepares the ecosystem for future restrictions by issuing warnings.
        System.out.println("""
                Starting with JDK 24, the JVM will issue warnings by default when an application performs
                a restricted native access operation without being granted explicit permission.

                These operations include:
                1. Loading a native library (e.g., via System.loadLibrary()).
                2. Binding a native method for the first time (the first call to a `native` method).

                --- CONCEPTUAL EXAMPLE ---

                Consider a class that uses a native library:
                public class NativeLibraryWrapper {
                    static {
                        // This call would trigger a warning in JDK 24 by default.
                        System.loadLibrary("my-native-lib");
                    }
                    // The first invocation of this method would also trigger a warning.
                    public native void performNativeAction();
                }

                When running code that uses this class without any special flags, a warning like
                the following would appear:

                WARNING: A restricted method in java.lang.System has been called
                WARNING: System::loadLibrary has been called by com.example.NativeLibraryWrapper
                WARNING: Use --enable-native-access=... to avoid a warning for callers in this module
                WARNING: Restricted methods will be blocked in a future release unless native access is enabled

                --- MANAGING NATIVE ACCESS ---

                To manage these restrictions, developers can use new command-line options:

                1. --enable-native-access=<module-name | ALL-UNNAMED>
                   - Grants permission to a specific module or all code on the classpath.
                   - Example: java --enable-native-access=ALL-UNNAMED com.example.Main

                2. --illegal-native-access=<warn|deny|allow>
                   - Controls the runtime's behavior for unauthorized native access.
                   - `warn`: (Default in JDK 24) Allows the operation but prints a warning once per module.
                   - `deny`: Throws an IllegalCallerException. This will become the default in a future release.

                This JEP doesn't deprecate or remove JNI but moves the platform towards a more
                secure "integrity by default" model.
                """);
    }
}
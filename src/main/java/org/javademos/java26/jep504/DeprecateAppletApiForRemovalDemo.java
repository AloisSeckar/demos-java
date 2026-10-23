package org.javademos.java26.jep504;

import org.javademos.commons.IDemo;

/// Demo for JDK 26 feature JEP 504 - Remove the Applet API.
///
/// The Applet API, deprecated for removal in JDK 17, is removed in JDK 26.
/// Required runtime flags: none.
///
/// API changes:
/// - JDK 26: removed the `java.applet` package (`Applet`, `AppletContext`, `AppletStub`, `AudioClip`),
///   `javax.swing.JApplet` and `java.beans.AppletInitializer`; `java.beans.Beans` and `javax.swing.RepaintManager`
///   no longer reference them.
/// - JDK 26: `URL.getContent()` and `URLConnection.getContent()` no longer return `AudioClip` for audio content.
/// - JDK 11: removed the `appletviewer` tool.
///
/// JEP history:
/// - JDK 26: [JEP 504 - Remove the Applet API](https://openjdk.org/jeps/504)
/// - JDK 17: [JEP 398 - Deprecate the Applet API for Removal](https://openjdk.org/jeps/398)
/// - JDK 9: [JEP 289 - Deprecate the Applet API](https://openjdk.org/jeps/289) (Initial step)
///
/// Further reading:
/// - [Java applet - wiki page](https://en.wikipedia.org/wiki/Java_applet)
///
/// @author Alexander Schneider @ab-schneider
/// @author Alois Sečkár <alois.seckar@gmail.com>
public class DeprecateAppletApiForRemovalDemo implements IDemo {
    @Override
    public void demo() {
        info(504);

        checkRemoved("java.applet.Applet");
        checkRemoved("java.applet.AudioClip");
        checkRemoved("javax.swing.JApplet");
        checkRemoved("java.beans.AppletInitializer");
    }

    private static void checkRemoved(String className) {
        try {
            Class.forName(className);
            System.out.println(className + " is still available");
        } catch (ClassNotFoundException e) {
            System.out.println(className + " is removed");
        }
    }
}

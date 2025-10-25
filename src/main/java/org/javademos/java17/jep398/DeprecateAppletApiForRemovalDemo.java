package org.javademos.java17.jep398;

import org.javademos.commons.IDemo;

/// Demo for JDK 17 feature JEP 398 - Deprecate the Applet API for Removal.
///
/// JEP history:
/// - JDK 17: [JEP 398 - Deprecate the Applet API for Removal](https://openjdk.org/jeps/398)
/// - JDK 9: [JEP 289 - Deprecate the Applet API](https://openjdk.org/jeps/289) (Initial step)
///
/// Further reading:
/// - [Java applet - wiki page](https://en.wikipedia.org/wiki/Java_applet)
///
/// @author Alexander Schneider @ab-schneider
public class DeprecateAppletApiForRemovalDemo implements IDemo {
    @Override
    public void demo() {
        info(398);

        // The Applet API (java.applet.Applet) existed to run Java code inside browsers via the NPAPI plug-in.
        // As all major browsers removed NPAPI (Chrome 2015, Firefox 2017, Edge never),
        // the API became unusable: deprecated in JDK 9 (JEP 289), marked for removal in JDK 17 (JEP 398),
        // and removed in JDK 26 (JEP 504).
        //
        // In case remaining uses of these APIs do exist, developers can suppress compiler warnings
        // via the @SuppressWarnings("removal") annotation or the -Xlint:-removal command-line option of the javac compiler.
    }
}

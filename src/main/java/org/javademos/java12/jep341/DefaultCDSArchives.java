package org.javademos.java12.jep341;

import java.nio.file.Files;
import java.nio.file.Path;

import org.javademos.commons.IDemo;

/// Demo for JDK 12 feature JEP 341 - Default CDS Archives.
///
/// JEP history:
/// - JDK 12: [JEP 341 - Default CDS Archives](https://openjdk.org/jeps/341)
///
/// Further reading:
/// - [JDK-8204247 - JEP 341: Default CDS Archives](https://bugs.openjdk.org/browse/JDK-8204247)
/// - [Class Data Sharing (Java SE 12 docs)](https://docs.oracle.com/en/java/javase/12/vm/class-data-sharing.html)
///
/// @author alois.seckar@gmail.com
public class DefaultCDSArchives implements IDemo {
    @Override
    public void demo() {
        info(341);

        // Class Data Sharing (CDS) stores pre-parsed metadata of commonly used JDK classes
        // in an archive file. The JVM memory-maps this archive at startup instead of loading
        // and verifying those classes from scratch, which reduces startup time and allows
        // the mapped memory to be shared between multiple JVM processes.

        // Before JDK 12, the JDK only shipped a default class list (`lib/classlist`),
        // and users had to run `java -Xshare:dump` themselves to create the archive.
        // Since JDK 12, the build runs this step and puts the resulting `classes.jsa`
        // archive into the JDK image. Together with `-Xshare:auto` (default since JDK 11),
        // every app gets CDS "for free" - e.g. ~32% faster startup for a `HelloWorld`.

        // When CDS is in use, the `java.vm.info` property contains the word "sharing":
        String vmInfo = System.getProperty("java.vm.info");
        System.out.println("JVM info (java.vm.info): " + vmInfo);
        System.out.println("CDS active: " + vmInfo.contains("sharing"));

        // The default archive lives next to the JVM library
        // (`lib/server` on Linux/macOS, `bin/server` on Windows):
        Path javaHome = Path.of(System.getProperty("java.home"));
        for (String dir : new String[] {"lib", "bin"}) {
            Path archive = javaHome.resolve(dir).resolve("server").resolve("classes.jsa");
            if (Files.exists(archive)) {
                System.out.println("Default CDS archive found: " + archive);
            }
        }

        // Useful command-line options:
        // - `-Xshare:off` - disable CDS (e.g. to compare startup time)
        // - `-Xshare:on`  - require CDS, fail if the archive cannot be used
        // - `-Xlog:cds`   - log details about CDS archive usage
        // Users with advanced needs (e.g. archiving application classes) can still create
        // custom archives - see AppCDS (JEP 310), dynamic archives (JEP 350)
        // or the AOT cache (JEP 483).
    }
}

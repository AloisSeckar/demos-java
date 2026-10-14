package org.javademos.java13.jep350;

import org.javademos.commons.IDemo;

/// Demo for JDK 13 feature JEP 350 - Dynamic CDS Archives.
///
/// JEP history:
/// - JDK 13: [JEP 350 - Dynamic CDS Archives](https://openjdk.org/jeps/350)
///
/// Further reading:
/// - [JEP 310 - Application Class-Data Sharing](https://openjdk.org/jeps/310)
/// - [JEP 341 - Default CDS Archives](https://openjdk.org/jeps/341)
/// - [Class Data Sharing (Oracle docs)](https://docs.oracle.com/en/java/javase/21/vm/class-data-sharing.html)
///
/// @author alois.seckar@gmail.com
public class DynamicCDSArchives implements IDemo {
    @Override
    public void demo() {
        info(350);

        // Class-Data Sharing (CDS) stores parsed class metadata in an archive file
        // that can be memory-mapped by the JVM at startup. This skips parsing and
        // verifying the same classes again and lets multiple JVM processes share
        // the read-only part of the archive, saving startup time and memory.
        // JDK 10 (JEP 310) extended CDS to application classes (AppCDS) and
        // JDK 12 (JEP 341) shipped a default CDS archive for core JDK classes.

        // Before JEP 350, using AppCDS required three manual steps:
        // 1) a trial run to produce a class list (-XX:DumpLoadedClassList=app.lst)
        // 2) dumping the archive from that list (-Xshare:dump -XX:SharedClassListFile=app.lst ...)
        // 3) running the application with the archive (-XX:SharedArchiveFile=app.jsa)

        // JEP 350 removes the trial run. The archive is created dynamically when
        // the application exits, containing all loaded application and library
        // classes that are not already present in the default (base) CDS archive:
        //   java -XX:ArchiveClassesAtExit=app.jsa -cp app.jar App
        // Subsequent runs then use it:
        //   java -XX:SharedArchiveFile=app.jsa -cp app.jar App

        // The dynamic archive is a "top layer" on top of the default "base layer"
        // archive. It records CRC values of the base archive, and if they do not
        // match at runtime, only the dynamic archive is disabled while the base
        // archive keeps working. Classes loaded by user-defined class loaders are
        // supported as well.

        // Limitations: only classes actually loaded during the run are archived,
        // heap objects are not archived and nothing is written if the JVM crashes.

        // Follow-ups: JDK 19 (JDK-8261455) added -XX:+AutoCreateSharedArchive to
        // create/refresh the dynamic archive automatically, and JDK 24 (JEP 483)
        // started the "AOT cache" evolution of CDS within Project Leyden.
    }
}

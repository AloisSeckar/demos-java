package org.javademos.java27.jep536;

import org.javademos.commons.IDemo;

/// Demo for JDK 27 feature JEP 536 - JFR In-Process Data Redaction.
///
/// JEP history:
/// - JDK 27: [JEP 536 - JFR In-Process Data Redaction](https://openjdk.org/jeps/536)
///
/// Further reading:
/// - [JDK Flight Recorder](https://dev.java/learn/jvm/jfr/)
/// - [jfr command reference](https://docs.oracle.com/en/java/javase/27/docs/specs/man/jfr.html)
///
/// @author Alois Sečkár <alois.seckar@gmail.com>
public class JFRDataRedactionDemo implements IDemo {
    @Override
    public void demo() {
        info(536);

        // JFR records command-line arguments, environment variables and system
        // properties into recording files. Before JDK 27 these values were written
        // verbatim, so secrets (tokens, passwords) could leak when recordings were
        // shared or archived.

        // Since JDK 27 JFR redacts such values inside the JVM, before they are
        // written to the recording. Matched values are stored as [REDACTED].
        // Redaction is enabled by default, using built-in filter lists.

        // Default key filters (redact-key) match environment variables and system
        // properties, e.g. *token*, *password*, *secret*, *api*key*.
        // Default argument filters (redact-argument) match command-line arguments,
        // e.g. -*password * matches both "-password SECRET" and "--password SECRET".

        // Customize via -XX:FlightRecorderOptions, separated by commas:
        // $ java -XX:FlightRecorderOptions:'redact-key=confidential,redact-argument=https://*:*@*' ...
        // Prefix a list with "+" to add to the defaults, e.g. redact-key=+confidential.
        // Filter files are loaded with "@", e.g. redact-argument=@args.txt.
        // Use "none" to disable redaction: -XX:FlightRecorderOptions:'redact-argument=none,redact-key=none'

        // To verify the result, print the recording with: jfr print --events InitialSystemProperty dump.jfr
        // To debug filter matching, use the -Xlog:jfr+redact=debug option.
    }
}

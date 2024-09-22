package cz.aloisseckar.java.javademos.java23.jep467;

import cz.aloisseckar.java.javademos.commons.IDemo;

/// Demo for JDK 23 feature **Markdown Documentation Comments** (JEP 467)
///
/// Status: Stable
///
/// Evolution:
/// - JDK 23: [JEP 467 - Markdown Documentation Comments](https://openjdk.org/jeps/467)
///
/// Further Reading:
/// - [Java Enhances Documentation with Markdown Support](https://www.infoq.com/news/2024/05/jep467-markdown-in-javadoc/)
///
/// @author alois.seckar@gmail.com

@SuppressWarnings("DanglingJavadoc") // because of the example on line 24
public class MarkdownComments implements IDemo {
    @Override
    public void demo() {
        info(467);
    }

    // Markdown syntax is now possible in Javadoc comments
    // It has to be started with different prefix - /// instead of /**

    // BEFORE JDK 23 - Javadoc header

    /**
     * <p>
     *   Demo for JDK 23 feature <strong>Markdown Documentation Comments</strong> (JEP 467)
     * </p>
     *
     * @see <a href="https://openjdk.org/jeps/467">JEP 467</a>
     * @author alois.seckar@gmail.com
     */

    // AFTER JDK 23 - Javadoc header

    /// Demo for JDK 23 feature **Markdown Documentation Comments** (JEP 467)
    ///
    /// @see <a href="https://openjdk.org/jeps/467">JEP 467</a>
    /// @author alois.seckar@gmail.com

    // ISSUES / LIMITATIONS

    // @see and external link
    // ----------------------
    // /// @see [JEP 467](https://openjdk.org/jeps/467)
    // md syntax is currently not possible
    // /// @see <a href="https://openjdk.org/jeps/467">JEP 467</a>
    // html <a> tag renders fine...

}

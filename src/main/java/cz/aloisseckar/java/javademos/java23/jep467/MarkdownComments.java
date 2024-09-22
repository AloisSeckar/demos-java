package cz.aloisseckar.java.javademos.java23.jep467;

import cz.aloisseckar.java.javademos.commons.IDemo;

/**
 * <p>
 *   Demo for JDK 23 feature <strong>Markdown Documentation Comments</strong> (JEP 467)
 * </p>
 * <p>
 *   Further reading: TBA
 * </p>
 *
 * @see <a href="https://openjdk.org/jeps/467">Markdown Documentation Comments</a>
 * @author alois.seckar@gmail.com
 */
public class MarkdownComments implements IDemo {
    @Override
    public void demo() {
        info("JEP 467 - Markdown Documentation Comments", "See MarkdownComments class for further info");
    }
}

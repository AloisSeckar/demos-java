package cz.aloisseckar.java.javademos.java23.jep471;

import cz.aloisseckar.java.javademos.commons.IDemo;

/**
 * <p>
 *   Demo for JDK 23 feature <strong>Deprecate the Memory-Access Methods in sun.misc.Unsafe for Removal</strong> (JEP 471)
 * </p>
 * <p>
 *   Further reading: TBA
 * </p>
 *
 * @see <a href="https://openjdk.org/jeps/471">Deprecate the Memory-Access Methods in sun.misc.Unsafe for Removal</a>
 * @author alois.seckar@gmail.com
 */
public class DeprecateMemoryAccessMethods implements IDemo {
    @Override
    public void demo() {
        info("JEP 471 - Deprecate the Memory-Access Methods in sun.misc.Unsafe for Removal", "See DeprecateMemoryAccessMethods class for further info");
    }
}

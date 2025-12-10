package org.javademos.java25.jep511;

import org.javademos.commons.IDemo;

import module java.base;

/// Demo for JDK 25 feature JEP 511 - Module Import Declarations.
///
/// JEP history:
/// - JDK 25: [JEP 511 - Module Import Declarations](https://openjdk.org/jeps/511)
/// - JDK 24: [JEP 494 - Module Import Declarations (Second Preview)](https://openjdk.org/jeps/494)
/// - JDK 23: [JEP 476 - Module Import Declarations (Preview)](https://openjdk.org/jeps/476)
///
/// Further reading:
/// - [Simplifying Java Development with Module Import](https://www.infoq.com/news/2024/05/simplifying-java-module-import/)
///
/// @author Arjun Vijay Prakash @ArjunCodess
public class ModuleImportDeclarationsDemo implements IDemo {

    @Override
    public void demo() {
        info(511);

        // all exported memberes of a Java module can be imported in a single statement
        // no explicit package imports are required

        // PRIOR to JDK 25:
        // import java.nio.file.Path;
        // import java.util.List;
        // import java.util.ArrayList;
        // import java.util.Arrays;

        // SINCE JDK 25:
        // import module java.base;

        // examples of types from multiple packages within module java.base
        List<String> values = new ArrayList<>(Arrays.asList("a", "b", "c"));
        System.out.println("values: " + values);
        System.out.println("random: " + Math.random());
        System.out.println("path:   " + Path.of("/tmp"));

        // in case of name conflicts across modules, add explicit class imports
        // or use fully-qualified names for the ambiguous types
    }

}

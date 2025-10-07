package org.javademos.java25.jep511;

import org.javademos.commons.IDemo;

import module java.base;

/// Demo for JDK 25 feature **JEP 511 - Module Import Declarations**.
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

        System.out.println("using 'import module java.base;' to bring exported types into scope");
        System.out.println("no explicit package imports for List/ArrayList/Arrays/Math/Path are needed\n");

        // examples of types from multiple packages within module java.base
        List<String> values = new ArrayList<>(Arrays.asList("a", "b", "c"));
        System.out.println("values: " + values);
        System.out.println("random: " + Math.random());
        System.out.println("path:   " + Path.of("/tmp"));

        // in case of name conflicts across modules, add explicit class imports
        // or use fully-qualified names for the ambiguous types
    }

}

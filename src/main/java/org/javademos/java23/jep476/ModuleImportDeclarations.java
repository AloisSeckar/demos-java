package org.javademos.java23.jep476;

import org.javademos.commons.IDemo;

// with JEP 476, this single-line import:
import module java.base;

// is equal to former:
// import java.lang.Math;
// import java.nio.file.Path;
// import java.util.List;
// import java.util.ArrayList;
// import java.util.Arrays;

// just be careful with possible name conflicts
// using this would make "List" ambiguous:
// import module java.desktop;
// the solution is the to import the concrete class to make things clear

/// Demo for JDK 23 feature **JEP 476 - Module Import Declarations (Preview)**.
///
/// JEP history:
/// - JDK 23: [JEP 486 - Module Import Declarations (Preview)](https://openjdk.org/jeps/476)
///
/// Will have a new implementation in JDK 24 via [JEP 494](https://openjdk.org/jeps/494)
///
/// Is related to [JEP 477](https://openjdk.org/jeps/477)
///
/// Further reading:
/// - [Simplifying Java Development with Module Import](https://www.infoq.com/news/2024/05/simplifying-java-module-import/)
///
/// @author alois.seckar@gmail.com
public class ModuleImportDeclarations implements IDemo {
    @Override
    public void demo() {
        info(476);

        // it is no longer required to explicitly state all classes (or at least packages)
        // you are importing from
        // import statements can be replaced only with corresponding "import module" statement

        System.out.println("5 classes from 3 different packages were imported ");
        System.out.println("using just one 'import module java.base;' statement");
        System.out.println();

        List<String> myList = new ArrayList<>(Arrays.asList("1", "2", "3"));
        System.out.println("Value in list: " + myList.stream().findAny());

        System.out.println("Random number: " + Math.random());

        System.out.println("URL: " + Path.of("www.alois-seckar.cz"));

        // however, in case of name conflicts (more classes with the same name in different modules)
        // explicit "import <class>" statement must be added
        // (which is quite similar to ".*" imports)

    }
}

package org.javademos.java16.jep394;

import org.javademos.commons.IDemo;

/// Demo for JDK 16 feature JEP 394 - Pattern Matching for instanceof.
/// 
/// The basic idea is to allow 'instanceof' check and re-casting to respective
/// data type within one command.
///
/// JEP history:
/// - JDK 16: [JEP 394 - Pattern Matching for instanceof](https://openjdk.org/jeps/394)
/// - JDK 15: [JEP 375 - Pattern Matching for instanceof (Second Preview)](https://openjdk.org/jeps/375)
/// - JDK 14: [JEP 305 - Pattern Matching for instanceof (Preview)](https://openjdk.org/jeps/305)
/// 
/// Further reading: 
/// - [Using New Pattern Matching Feature in Java 16](https://www.agileconnection.com/article/using-new-pattern-matching-feature-java-16)
/// 
/// @author alois.seckar@gmail.com
public class InstanceofPatternMatchingDemo implements IDemo {

    @Override
    public void demo() {
        info(394);

        Object x = 5;
        System.out.println("X is: " + x);
        
        // Java < 16
        // first we had to perform 'instanceof' check
        // then we explicitly cast the variable to Integer
        if (x instanceof Integer) {
            System.out.println("X is integer");
            System.out.println(((Integer) x).compareTo(10));
        }
        
        // Java 16+
        // 'instanceof' itself provides variable, that is already re-casted 
        if (x instanceof Integer integer) {
            System.out.println("X is integer");
            System.out.println(integer.compareTo(10));
        }
        
        System.out.println();
        
    }

}

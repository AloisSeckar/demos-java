package org.javademos.java17.extras;

import org.javademos.commons.IDemo;

/// Demo for JDK 17 **deprecated APIs**.
///
/// This class shows some examples of deprecated APIs from Java 17 Platform.
///
/// REFERENCES:
/// - JDK 17: TODO specify relevant JEP(s) / JBS(s)
/// 
/// Further reading: 
/// - [Java 17 Deprecated List](https://docs.oracle.com/en/java/javase/17/docs/api/deprecated-list.html) - full list of DEPRECATED features still present in Java 17
/// - [Removed Tools and Components](https://docs.oracle.com/en/java/javase/17/migrate/removed-tools-and-components.html) - list of DEPRECATED and REMOVED from platform features until Java 17
/// 
/// @author alois.seckar@gmail.com
public class J17DeprecatedDemo implements IDemo {

    @Override
    public void demo() {
        info("DEPRECATED DEMO", "What is deprecated in Java 17");
        
        System.out.println("There is nothing to display in this demo");
        System.out.println("Go and check DeprecatedDemo.java class");
        System.out.println("to see what is not meant to be used anymore");
        System.out.println();
        
        
        // natural primitive-wrapping classes' constructors 
        // @Deprecated(since="9", forRemoval = true)
        // var i = new Integer("5");
        // use static factory method instead
        // var j = Integer.valueOf("5");
        
        
        // Applet API
        // @deprecated + forRemoval = true
        // Applet lastTryOfApplet = new Applet();
        // DO NOT seek for replacement, do it differently
        // https://www.oracle.com/technetwork/java/javase/migratingfromapplets-2872444.pdf
        
        
        // SecurityManager 
        // @Deprecated(since="17", forRemoval=true)
        // SecurityManager secMan = new SecurityManager();
        //
        // disabled by default and not widely used
        // however, can be found e.g. in Tomcat or ElasticSearch
        //
        // (dis)allows almost all JVM actions based on white-list policies
        //
        // .policy file 
        // grant codeBase "file:${{java.ext.dirs}}/*" {
        //    permission java.security.AllPermission;
        // };
        //
        // read https://openjdk.org/jeps/411 to know more
        //
    }
    
}

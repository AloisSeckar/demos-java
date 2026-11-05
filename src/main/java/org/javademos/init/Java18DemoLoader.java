package org.javademos.init;

import java.util.Map;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;

import org.javademos.java18.jep400.DefaultUTF8Demo;
import org.javademos.java18.jep408.SimpleWebServerDemo;
import org.javademos.java18.jep413.CodeSnippetsInJavadocDemo;
import org.javademos.java18.jep416.CoreReflectionWithMethodHandlesDemo;
import org.javademos.java18.jep417.VectorAPIDemo;
import org.javademos.java18.jep418.InternetAddressResolutionSPIDemo;
import org.javademos.java18.jep419.ForeignFunctionMemoryDemo;
import org.javademos.java18.jep420.PatternMatchingForSwitchDemo;
import org.javademos.java18.jep421.DeprecateFinalizationDemo;
/**
 * Loads demos for Java 18.
 */
public class Java18DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(400, new DefaultUTF8Demo());
        demos.put(408, new SimpleWebServerDemo());
        demos.put(413, new CodeSnippetsInJavadocDemo());
        demos.put(416, new CoreReflectionWithMethodHandlesDemo());
        demos.put(417, new VectorAPIDemo());
        demos.put(418, new InternetAddressResolutionSPIDemo());
        demos.put(419, new ForeignFunctionMemoryDemo());
        demos.put(420, new PatternMatchingForSwitchDemo());
        demos.put(421, new DeprecateFinalizationDemo());
    }
}

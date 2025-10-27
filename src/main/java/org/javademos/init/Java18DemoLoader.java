package org.javademos.init;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;
import org.javademos.java18.jep400.DefaultUTF8Demo;
import org.javademos.java18.jep408.SimpleWebServerDemo;
import org.javademos.java18.jep413.CodeSnippetsInJavadoc;
import org.javademos.java18.jep416.CoreReflectionWithMethodHandles;
import org.javademos.java18.jep417.VectorAPIDemo;
import org.javademos.java18.jep418.InternetAddressResolutionSPI;
import org.javademos.java18.jep419.ForeignFunctionMemoryDemo;
import org.javademos.java18.jep420.PatternMatchingForSwitchSecondPreview;
import org.javademos.java18.jep421.DeprecateFinalization;

import java.util.Map;

/**
 * Loads demos for Java 18.
 */
public class Java18DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(400, new DefaultUTF8Demo());
        demos.put(408, new SimpleWebServerDemo());
        demos.put(413, new CodeSnippetsInJavadoc());
        demos.put(416, new CoreReflectionWithMethodHandles());
        demos.put(417, new VectorAPIDemo());
        demos.put(418, new InternetAddressResolutionSPI());
        demos.put(419, new ForeignFunctionMemoryDemo());
        demos.put(420, new PatternMatchingForSwitchSecondPreview());
        demos.put(421, new DeprecateFinalization());
    }
}

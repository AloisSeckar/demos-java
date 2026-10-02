package org.javademos.init;

import java.util.Map;

import org.javademos.commons.IDemo;
import org.javademos.commons.IDemoLoader;

import org.javademos.java27.jep527.PostQuantumHybridKeyExchangeDemo;
import org.javademos.java27.jep531.LazyConstantsDemo;
import org.javademos.java27.jep533.StructuredConcurrencyDemo;
import org.javademos.java27.jep537.VectorAPIDemo;
import org.javademos.java27.jep538.PemEncodingsDemo;

/**
 * Loads demos for Java 27.
 */
public class Java27DemoLoader implements IDemoLoader {
    
    @Override
    public void loadDemos(Map<Integer, IDemo> demos) {
        demos.put(527, new PostQuantumHybridKeyExchangeDemo());
        demos.put(531, new LazyConstantsDemo());
        demos.put(533, new StructuredConcurrencyDemo());
        demos.put(537, new VectorAPIDemo());
        demos.put(538, new PemEncodingsDemo());
    }
}

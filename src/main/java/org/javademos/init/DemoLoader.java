package org.javademos.init;

import org.javademos.commons.IDemo;

import java.util.Map;

/**
 * Interface for loading demos for a specific Java version.
 */
public interface DemoLoader {

    void loadDemos(Map<Integer, IDemo> demos);
}

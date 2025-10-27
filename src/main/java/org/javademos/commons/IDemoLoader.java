package org.javademos.commons;

import java.util.Map;

/**
 * Interface for loading demos for a specific Java version.
 */
public interface IDemoLoader {

    void loadDemos(Map<Integer, IDemo> demos);
}

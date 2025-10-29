package org.javademos.java14.jep358;

import lombok.Getter;

/**
 * Simple class to show 'helpful' NullPointerExceptions from Java 14.
 * Here we have 4-level nested class structure and somewhere on the way
 * one element is 'null', so invoking method on it will raise 'NullPointer'.
 * 
 * @author Abhineshhh
 */
public class NullPointerLevel1 {
    
    @Getter
    private final NullPointerLevel2 level2;

    public NullPointerLevel1() {
        // this is ok, nested member is properly initialized
        level2 = new NullPointerLevel2();
    }
    
}

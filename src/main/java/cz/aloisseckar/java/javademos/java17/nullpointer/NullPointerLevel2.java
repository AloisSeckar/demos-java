package cz.aloisseckar.java.javademos.java17.nullpointer;

import lombok.Getter;

/**
 * Simple class to show 'helpful' NullPointerExceptions from Java 14.
 * Here we have 4-level nested class structure and somewhere on the way
 * one element is 'null', so invoking method on it will raise 'NullPointer'.
 * 
 * @author alois.seckar@atos.net
 */
public class NullPointerLevel2 {
    
    @Getter
    private final NullPointerLevel3 level3;
    
    public NullPointerLevel2() {
        // this is still ok, nested member is properly initialized
        level3 = new NullPointerLevel3();
    }
    
}

package cz.aloisseckar.java.javademos.java17.j16;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MapMulti {
    
    int length;
    char first;
    boolean endsWithA;
    
    @Override
    public String toString() {
        return "[" + length + " " + first + " " + endsWithA + "] ";
    }
    
}

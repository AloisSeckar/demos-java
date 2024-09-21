package cz.aloisseckar.java.javademos.java17.j16;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MapMulti {
    
    int length;
    char first;
    boolean endsWithA;

    // EXPLICIT "AllArgsConstructor"
    // TODO delete when lombok fixed for JDK 23
    public MapMulti(int length, char first, boolean endsWithA) {
        this.length = length;
        this.first = first;
        this.endsWithA = endsWithA;
    }

    @Override
    public String toString() {
        return "[" + length + " " + first + " " + endsWithA + "] ";
    }
    
}

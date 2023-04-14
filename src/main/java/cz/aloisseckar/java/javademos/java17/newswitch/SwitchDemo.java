package cz.aloisseckar.java.javademos.java17.newswitch;

import cz.aloisseckar.java.javademos.commons.IDemo;
import static java.util.Calendar.*;
import java.util.Random;

/**
 * This class demonstrates some new 'switch' syntax options in Java 17.
 * 
 * Introduced: Java 12
 * Finalized: Java 14
 * 
 * Further reading:
 * https://openjdk.java.net/jeps/361
 * 
 * @author alois.seckar@atos.net
 */
public class SwitchDemo implements IDemo {

    @Override
    public void demo() {
        info("SWITCH DEMO", "Examples for 'switch' enhancements\nintroduced in Java 14");
        
        // code examples taken directly from https://openjdk.java.net/jeps/361
        
        // let's get random day of week
        // and return number of letters in its english name
        
        int day = new Random().nextInt(7) + 1;
        System.out.println("Random day is: " + day);
        
        System.out.println("1) Evaluate switch expression");
                
        // Java < 14
        // traditional way of using 'switch'
        //   - we need separate 'case' for each option
        //   - we need to take care about proper 'break' placement
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                System.out.println(6);
                break;
            case TUESDAY:
                System.out.println(7);
                break;
            case THURSDAY:
            case SATURDAY:
                System.out.println(8);
                break;
            case WEDNESDAY:
                System.out.println(9);
                break;
        }
        // Java 14+
        // new and much more compact way of writing 'switch'
        //   - we can chain values with same evaluation to one line
        //   - operator '->' works both as ':' and 'break;'
        //   - it is possible to have multi-line block of code in {} after '->'
        switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> System.out.println(6);
            case TUESDAY -> System.out.println(7);
            case THURSDAY, SATURDAY -> System.out.println(8);
            case WEDNESDAY -> { 
                System.out.println(9); 
                System.out.println("blocks of code are also allowed");
            }
        }
        
        System.out.println("2) Return value switch expression");
        
        // 'switch' is now capable of directly  returning value
        
        // Java < 14
        // you have to declare first and take care of initialization (either
        // by doing it manually or by having 'switch' covering all possibilities)
        // then you assign value into the variable in each 'case' block
        int numLetters = -1;
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                numLetters = 6;
                break;
            case TUESDAY:
                numLetters = 7;
                break;
            case THURSDAY:
            case SATURDAY:
                numLetters = 8;
                break;
            case WEDNESDAY:
                numLetters = 9;
                break;
        }
        System.out.println("Result is: " + numLetters);
        
        // Java 14+
        // switch can yield a return value directly 
        // return value may appear directly after '->'
        // or it is possible to have multi-line block of code in {} after '->'
        // but you need to use 'yield' keyword ('return' doesn't work here)
        // return values has to be all the same type
        // switch has to cover all inputs (it doesn't if you don't want it 
        // to return any value)
        numLetters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY                -> 7;
            case THURSDAY, SATURDAY     -> 8;
            case WEDNESDAY              -> {
                System.out.println("blocks of code still possible");
                yield 9;
            }
            
            // you cannot mix data types
            //   incompatible types: bad type in switch expression
            //     String cannot be converted to int
            // case WEDNESDAY  -> "9";
                
            // it is required to handle all options when returning a value
            // otherwise compiler throws:
            //   the switch expression does not cover all possible input values    
            default -> -1;  
        };
        System.out.println("Result is: " + numLetters);
        
        System.out.println();
    }
    
}

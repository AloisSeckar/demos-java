package org.javademos.java14.jep361;

import org.javademos.commons.IDemo;

/// Demo for JDK 14 feature JEP 361 - Switch Expressions.
///
/// Switch expressions extend switch to be used as either a statement or an expression,
/// with both traditional "case ... :" and new "case ... ->" labels.
/// This was a preview feature in JDK 12 (JEP 325) and JDK 13 (JEP 354), and became final in JDK 14.
///
/// Key features demonstrated:
/// - Arrow labels (case ... ->)
/// - Switch expressions (assign values directly)
/// - Yield statement for complex blocks
/// - Exhaustiveness checking
/// - Multiple constants per case
///
/// @see org.javademos.java12.jep325.SwitchExpressionsPreview
/// @see org.javademos.java13.jep354.SwitchExpressionsSecondPreview
/// @author Abhineshhh
public class SwitchExpressionsDemo implements IDemo {
    
    @Override
    public void demo() {
        info(361);
        
        System.out.println("=== Traditional Switch vs Arrow Labels ===");
        demonstrateArrowLabels();
        
        System.out.println("\n=== Switch as Expression ===");
        demonstrateSwitchExpression();
        
        System.out.println("\n=== Yield Statement ===");
        demonstrateYieldStatement();
        
        System.out.println("\n=== Multiple Constants per Case ===");
        demonstrateMultipleConstants();
        
        System.out.println("\n=== Exhaustiveness with Enums ===");
        demonstrateExhaustiveness();
    }
    
    /// Demonstrates arrow labels without fall-through
    private void demonstrateArrowLabels() {
        int day = 3;
        
        // Traditional switch (verbose with break statements)
        System.out.println("Traditional switch:");
        switch (day) {
            case 1:
            case 2:
            case 3:
                System.out.println("  Beginning of the week");
                break;
            case 4:
            case 5:
                System.out.println("  Middle of the week");
                break;
            case 6:
            case 7:
                System.out.println("  Weekend");
                break;
            default:
                System.out.println("  Invalid day");
                break;
        }
        
        // Arrow labels (concise, no fall-through)
        System.out.println("Arrow label switch:");
        switch (day) {
            case 1, 2, 3 -> System.out.println("  Beginning of the week");
            case 4, 5    -> System.out.println("  Middle of the week");
            case 6, 7    -> System.out.println("  Weekend");
            default      -> System.out.println("  Invalid day");
        }
    }
    
    /// Demonstrates switch as an expression
    private void demonstrateSwitchExpression() {
        Day day = Day.WEDNESDAY;
        
        // Old way: using a variable and assigning in each case
        int numLettersOld;
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                numLettersOld = 6;
                break;
            case TUESDAY:
                numLettersOld = 7;
                break;
            case THURSDAY:
            case SATURDAY:
                numLettersOld = 8;
                break;
            case WEDNESDAY:
                numLettersOld = 9;
                break;
            default:
                throw new IllegalStateException("Unknown day: " + day);
        }
        System.out.println("Old way - " + day + " has " + numLettersOld + " letters");
        
        // New way: switch expression directly assigns value
        int numLetters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY                -> 7;
            case THURSDAY, SATURDAY     -> 8;
            case WEDNESDAY              -> 9;
        };
        System.out.println("New way - " + day + " has " + numLetters + " letters");
    }
    
    /// Demonstrates yield statement for complex logic in switch expressions
    private void demonstrateYieldStatement() {
        Day day = Day.FRIDAY;
        
        String feeling = switch (day) {
            case MONDAY -> "Terrible";
            case TUESDAY, WEDNESDAY, THURSDAY -> "Neutral";
            case FRIDAY -> {
                String temp = "Great";
                yield temp + "!!! It's Friday!";
            }
            case SATURDAY, SUNDAY -> {
                // Complex logic requiring a block
                int mood = calculateWeekendMood();
                String result = mood > 5 ? "Awesome" : "Good";
                yield result;
            }
        };
        
        System.out.println("On " + day + ", feeling: " + feeling);
    }
    
    /// Demonstrates multiple constants per case
    private void demonstrateMultipleConstants() {
        String month = "July";
        
        int days = switch (month) {
            case "January", "March", "May", "July", "August", "October", "December" -> 31;
            case "April", "June", "September", "November" -> 30;
            case "February" -> 28; // ignoring leap years for simplicity
            default -> throw new IllegalArgumentException("Invalid month: " + month);
        };
        
        System.out.println(month + " has " + days + " days");
    }
    
    /// Demonstrates exhaustiveness checking with enums
    private void demonstrateExhaustiveness() {
        Day day = Day.SATURDAY;
        
        // Switch expression on enum must be exhaustive
        // No default needed if all enum constants are covered
        boolean isWeekend = switch (day) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> false;
            case SATURDAY, SUNDAY -> true;
        };
        
        System.out.println(day + " is weekend: " + isWeekend);
        
        // Alternative with default for future enum additions
        String dayType = switch (day) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Weekday";
            case SATURDAY, SUNDAY -> "Weekend";
            // default added by compiler for safety
        };
        
        System.out.println(day + " is a " + dayType);
    }
    
    private int calculateWeekendMood() {
        return 8; // Always high on weekends!
    }
    
    /// Enum for demonstrating switch with enums
    private enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}

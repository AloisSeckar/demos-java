package org.javademos.java17.jep409;

/**
 * Simple class to show 'sealed class' concept from Java 17.
 * This class is not allowed, therefore it cannot extend from SealedDemoParent.
 * 
 * @see SealedDemoParent
 * 
 * @author alois.seckar@gmail.com
 */

// following two declarations are invalid:

// class is not allowed to extend sealed class: SealedDemoParent (as it is not listed in its permits' clause)
// public class SealedDemoBastard extends SealedDemoParent {

// non-sealed modifier not allowed here
//  (class SealedDemoBastard does not have any sealed supertypes)
// public non-sealed class SealedDemoBastard {

public class SealedDemoBastard {
    
}

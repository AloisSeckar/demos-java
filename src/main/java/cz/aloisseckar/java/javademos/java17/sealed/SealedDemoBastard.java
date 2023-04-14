package cz.aloisseckar.java.javademos.java17.sealed;

/**
 * Simple class to show 'sealed class' concept from Java 17.
 * This class is not allowed, therefore it cannot extend from SealedDemoParent.
 * 
 * @see cz.aloisseckar.java.javademos.java17.sealed.SealedDemoParent
 * 
 * @author alois.seckar@atos.net
 */

// following two declarations are invalid:

// class is not allowed to extend sealed class: SealedDemoParent (as it is not listed in its permits' clause)
// public class SealedDemoBastard extends SealedDemoParent {

// non-sealed modifier not allowed here
//  (class SealedDemoBastard does not have any sealed supertypes)
// public non-sealed class SealedDemoBastard {

public class SealedDemoBastard {
    
}

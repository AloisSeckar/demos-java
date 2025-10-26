package org.javademos.java15.jep339;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.util.Base64;

import org.javademos.commons.IDemo;

/// Demo for JDK 15 feature JEP 339 - Edwards-Curve Digital Signature Algorithm (EdDSA).
///
/// JEP history:
/// - JDK 15: [JEP 339 - Edwards-Curve Digital Signature Algorithm (EdDSA)](https://openjdk.org/jeps/339)
///
/// EdDSA is a modern elliptic curve signature scheme offering better security and performance than
/// traditional signature algorithms like RSA and ECDSA. It's based on Edwards curves, specifically
/// Ed25519 and Ed448, which are defined in RFC 8032.
///
/// Key benefits:
/// - Better security with smaller key sizes
/// - Faster signing and verification
/// - Resistance to side-channel attacks
/// - Deterministic signatures (no random number generation needed)
///
/// Further reading:
/// - [JEP 339 Specification](https://openjdk.org/jeps/339)
/// - [RFC 8032 - Edwards-Curve Digital Signature Algorithm (EdDSA)](https://datatracker.ietf.org/doc/html/rfc8032)
/// - [Ed25519 Overview](https://ed25519.cr.yp.to/)
///
/// @see java.security.KeyPairGenerator
/// @see java.security.Signature
/// @author Abhineshhh
public class EdDSADemo implements IDemo {

    @Override
    public void demo() {
        info(339);

        try {
            demonstrateEd25519();
            System.out.println();
            demonstrateEd448();
        } catch (Exception e) {
            System.err.println("✗ Error demonstrating EdDSA: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /// Demonstrates Ed25519 signature algorithm.
    /// Ed25519 uses a 256-bit elliptic curve and produces 64-byte signatures.
    /// It's designed for high performance and security.
    private void demonstrateEd25519() throws Exception {
        System.out.println("=== Ed25519 Signature Algorithm ===");
        System.out.println();

        // Generate Ed25519 key pair
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("Ed25519");
        KeyPair keyPair = keyPairGen.generateKeyPair();

        System.out.println("✓ Ed25519 key pair generated");
        System.out.println("  Public key format: " + keyPair.getPublic().getFormat());
        System.out.println("  Public key algorithm: " + keyPair.getPublic().getAlgorithm());
        System.out.println("  Private key format: " + keyPair.getPrivate().getFormat());
        System.out.println("  Private key algorithm: " + keyPair.getPrivate().getAlgorithm());
        System.out.println();

        // Create a message to sign
        String message = "Hello, EdDSA with Ed25519!";
        byte[] messageBytes = message.getBytes();

        // Sign the message
        Signature signature = Signature.getInstance("Ed25519");
        signature.initSign(keyPair.getPrivate());
        signature.update(messageBytes);
        byte[] digitalSignature = signature.sign();

        System.out.println("✓ Message signed with Ed25519");
        System.out.println("  Original message: " + message);
        System.out.println("  Signature length: " + digitalSignature.length + " bytes");
        System.out.println("  Signature (Base64): " + Base64.getEncoder().encodeToString(digitalSignature));
        System.out.println();

        // Verify the signature
        Signature verifier = Signature.getInstance("Ed25519");
        verifier.initVerify(keyPair.getPublic());
        verifier.update(messageBytes);
        boolean isValid = verifier.verify(digitalSignature);

        System.out.println("✓ Signature verification result: " + (isValid ? "VALID ✓" : "INVALID ✗"));
        System.out.println();

        // Demonstrate verification failure with tampered message
        byte[] tamperedMessage = "Hello, EdDSA with Ed25519?".getBytes(); // Changed ! to ?
        verifier.initVerify(keyPair.getPublic());
        verifier.update(tamperedMessage);
        boolean isTamperedValid = verifier.verify(digitalSignature);

        System.out.println("✓ Tampered message verification:");
        System.out.println("  Tampered message: Hello, EdDSA with Ed25519?");
        System.out.println("  Verification result: " + (isTamperedValid ? "VALID ✓" : "INVALID ✗ (as expected)"));
    }

    /// Demonstrates Ed448 signature algorithm.
    /// Ed448 uses a 448-bit elliptic curve and produces 114-byte signatures.
    /// It offers higher security margin than Ed25519 at the cost of slightly lower performance.
    private void demonstrateEd448() throws Exception {
        System.out.println("=== Ed448 Signature Algorithm ===");
        System.out.println();

        // Generate Ed448 key pair
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("Ed448");
        KeyPair keyPair = keyPairGen.generateKeyPair();

        System.out.println("✓ Ed448 key pair generated");
        System.out.println("  Public key algorithm: " + keyPair.getPublic().getAlgorithm());
        System.out.println("  Private key algorithm: " + keyPair.getPrivate().getAlgorithm());
        System.out.println();

        // Create a message to sign
        String message = "EdDSA with Ed448 provides even higher security!";
        byte[] messageBytes = message.getBytes();

        // Sign the message
        Signature signature = Signature.getInstance("Ed448");
        signature.initSign(keyPair.getPrivate());
        signature.update(messageBytes);
        byte[] digitalSignature = signature.sign();

        System.out.println("✓ Message signed with Ed448");
        System.out.println("  Original message: " + message);
        System.out.println("  Signature length: " + digitalSignature.length + " bytes");
        System.out.println("  Signature (Base64): " + Base64.getEncoder().encodeToString(digitalSignature));
        System.out.println();

        // Verify the signature
        Signature verifier = Signature.getInstance("Ed448");
        verifier.initVerify(keyPair.getPublic());
        verifier.update(messageBytes);
        boolean isValid = verifier.verify(digitalSignature);

        System.out.println("✓ Signature verification result: " + (isValid ? "VALID ✓" : "INVALID ✗"));
        System.out.println();

        // Key characteristics comparison
        System.out.println("=== Ed25519 vs Ed448 Comparison ===");
        System.out.println("  Ed25519:");
        System.out.println("    - Curve size: 256 bits");
        System.out.println("    - Signature size: 64 bytes");
        System.out.println("    - Security level: ~128 bits");
        System.out.println("    - Performance: Faster");
        System.out.println();
        System.out.println("  Ed448:");
        System.out.println("    - Curve size: 448 bits");
        System.out.println("    - Signature size: 114 bytes");
        System.out.println("    - Security level: ~224 bits");
        System.out.println("    - Performance: Slightly slower, but higher security margin");
    }
}

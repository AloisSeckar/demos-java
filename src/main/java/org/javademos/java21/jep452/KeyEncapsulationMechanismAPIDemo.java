package org.javademos.java21.jep452;

import org.javademos.commons.IDemo;

import javax.crypto.DecapsulateException;
import javax.crypto.KEM;
import javax.crypto.SecretKey;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;

/// Demo for JDK 21 feature **JEP 452 - Key Encapsulation Mechanism**.
///
/// JEP history:
/// - JDK 21: [JEP 452 - Key Encapsulation Mechanism API](https://openjdk.org/jeps/452)
///
/// Further reading:
/// - [Key encapsulation mechanism](https://en.wikipedia.org/wiki/Key_encapsulation_mechanism)
///
/// @author biswarup.chatterjee@tuta.io
public class KeyEncapsulationMechanismAPIDemo implements IDemo {
    @Override
    public void demo() {
        info("KEY ENCAPSULATION MECHANISM DEMO", "Examples of new 'Key encapsulation mechanism' \nintroduced in Java 21");
        try {
            // Demonstrates the use of the Key Encapsulation Mechanism (KEM) API introduced in JEP 452 (JDK 21).
            //
            // A KEM is a cryptographic primitive used to securely establish a shared secret between two parties
            // using asymmetric (public/private) key pairs. It provides a modern, standardized way to perform
            // key agreement without directly exchanging the secret itself.
            //
            // In this demonstration:
            // 1. The receiver generates an asymmetric key pair (X25519).
            // 2. The sender uses the receiver’s public key to perform encapsulation, producing:
            //      - a newly generated shared symmetric secret key
            //      - an encapsulation message (a small byte array)
            // 3. The receiver uses their private key and the encapsulation message to decapsulate,
            //    recovering the same shared secret.
            //
            // The encapsulation message (public key) is the only data exchanged between sender and receiver.
            System.out.println("Receiver generates a key pair (public/private)");

            // Receiver creates a key pair for X25519 (Diffie-Hellman curve).
            // The public key will be shared with the sender.
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("X25519");
            KeyPair receiverKeyPair = kpg.generateKeyPair();
            PublicKey receiverPublicKey = receiverKeyPair.getPublic();
            PrivateKey receiverPrivateKey = receiverKeyPair.getPrivate();

            System.out.println("Receiver key pair generated.");
            System.out.println("Receiver public key (base64): " +
                    Base64.getEncoder().encodeToString(receiverPublicKey.getEncoded()));

            System.out.println();
            System.out.println("STEP 2: Sender initializes KEM and encapsulates a shared secret");

            // Sender uses the receiver's public key to generate
            // a random shared symmetric key and an encapsulation message.
            KEM kem = KEM.getInstance("DHKEM");
            KEM.Encapsulator encapsulator = kem.newEncapsulator(receiverPublicKey);

            // Perform encapsulation
            KEM.Encapsulated enc = encapsulator.encapsulate();

            // Extract shared secret (sender side)
            SecretKey sharedSender = enc.key();
            byte[] senderSecretBytes = sharedSender.getEncoded();

            // Extract encapsulation message (to send to receiver)
            byte[] encapsulationMessage = enc.encapsulation();

            System.out.println("Sender encapsulated a shared secret.");
            System.out.println("Encapsulation message (base64): " +
                    Base64.getEncoder().encodeToString(encapsulationMessage));
            System.out.println("Sender shared secret (base64): " +
                    (senderSecretBytes == null ? "null"
                            : Base64.getEncoder().encodeToString(senderSecretBytes)));

            System.out.println();
            System.out.println("STEP 3: Receiver decapsulates the message to recover the same shared secret");

            // Receiver uses its private key and the encapsulation message
            // to derive the same shared secret.
            KEM.Decapsulator decapsulator = kem.newDecapsulator(receiverPrivateKey);
            SecretKey sharedReceiver = decapsulator.decapsulate(encapsulationMessage);
            byte[] receiverSecretBytes = sharedReceiver.getEncoded();

            System.out.println("Receiver recovered shared secret (base64): " +
                    (receiverSecretBytes == null ? "null"
                            : Base64.getEncoder().encodeToString(receiverSecretBytes)));

            System.out.println();
            System.out.println("STEP 4: Verify that both shared secrets are identical");

            boolean secretsEqual = senderSecretBytes != null
                    && receiverSecretBytes != null
                    && Arrays.equals(senderSecretBytes, receiverSecretBytes);

            System.out.println("Shared secrets equal? " + secretsEqual);

        }
        catch (NoSuchAlgorithmException | InvalidKeyException | DecapsulateException e) {
            throw new RuntimeException(e);
        }
    }
}

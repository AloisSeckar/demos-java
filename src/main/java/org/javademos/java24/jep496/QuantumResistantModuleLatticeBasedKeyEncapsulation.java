package org.javademos.java24.jep496;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.NamedParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.KEM;
import javax.crypto.SecretKey;

import org.javademos.commons.IDemo;

/// Demo for JDK 24 feature **Quantum Resistant Module - Lattice-based Key Encapsulation** (JEP 496)
///
/// JEP history: - JDK 24 (preview): [JEP 496 - Quantum Resistant Module - Lattice-based Key Encapsulation](https://openjdk.org/jeps/496)
///
/// Further reading:
/// [JEP 496](https://openjdk.org/jeps/496)
///
/// @author Ashutosh Singh @Rossville
public class QuantumResistantModuleLatticeBasedKeyEncapsulation implements IDemo {
    public void demo(){
        try {
            // Instantiate a KeyPairGenerator with the family name and initialize it with a parameter-set name
            // If you do not initialize the KeyPairGenerator with a parameter set, the implementation will use ML-KEM-768 as default
            KeyPairGenerator g = KeyPairGenerator.getInstance("ML-KEM");
            g.initialize(NamedParameterSpec.ML_KEM_512);
            KeyPair kp = g.generateKeyPair(); // an ML-KEM-512 key pair
            PublicKey publicKey = kp.getPublic();

            // Encapsulating and decapsulating ML-KEM keys
            // A sender can call the encapsulation function to get a secret key and a key encapsulation message
            KEM ks = KEM.getInstance("ML-KEM");
            KEM.Encapsulator enc = ks.newEncapsulator(publicKey);
            KEM.Encapsulated encap = enc.encapsulate();
            byte[] msg = encap.encapsulation();     // send this to receiver
            SecretKey _ = encap.key(); // rename "_" to valid variable name to use it

            // A receiver can then call the decapsulation function to 
            // recover the secret key from the key encapsulation message sent by the sender
            byte[] receivedMsg = msg; // received from sender
            KEM kr = KEM.getInstance("ML-KEM");
            KEM.Decapsulator dec = kr.newDecapsulator(kp.getPrivate());
            SecretKey _ = dec.decapsulate(receivedMsg); // rename "_" to valid variable name to use it

            // Encoding and decoding ML-KEM keys
            // Convert a ML-KEM private key to its PKCS #8 encoding, and vice-versa
            KeyFactory f = KeyFactory.getInstance("ML-KEM");
            PKCS8EncodedKeySpec p8spec = f.getKeySpec(kp.getPrivate(),PKCS8EncodedKeySpec.class);
            PrivateKey _ = f.generatePrivate(p8spec); // rename "_" to valid variable name to use it

            // Convert a ML-KEM public key to its X.509 encoding, and vice-versa
            X509EncodedKeySpec x509spec = f.getKeySpec(kp.getPublic(),X509EncodedKeySpec.class);
            PublicKey _ = f.generatePublic(x509spec); // rename "_" to valid variable name to use it
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
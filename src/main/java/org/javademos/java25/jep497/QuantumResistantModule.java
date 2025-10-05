package org.javademos.java25.jep497;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.spec.NamedParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.Signature;

import org.javademos.commons.IDemo;

/// Demo for JDK 25 feature **Quantum Resistant Algorithm - Lattice-based Digital Signature** (JEP 497)
///
/// JEP history: - JDK 25 (preview): [JEP 497 - Quantum Resistant Algorithm - Lattice-based Digital Signature](https://openjdk.org/jeps/497)
///
/// Further reading:
/// [JEP 497](https://openjdk.org/jeps/497)
///
/// @author Ashutosh Singh @Rossville
public class QuantumResistantModule implements IDemo {
    @Override
    public void demo() {
        try {
            // We are KeyPairGenerator API to generate ML-DSA key pairs
            // of the Signature API to sign and verify ML-DSA signatures,
            // and of the KeyFactory API to convert ML-DSA keys to and from their encodings
            KeyPairGenerator g = KeyPairGenerator.getInstance("ML-DSA");
            g.initialize(NamedParameterSpec.ML_DSA_44);
            KeyPair kp = g.generateKeyPair(); // an ML-DSA-44 key pair

            byte[] msg = "Hello, Quantum!".getBytes();
            Signature ss = Signature.getInstance("ML-DSA");
            ss.initSign(kp.getPrivate());
            ss.update(msg);
            byte[] sig = ss.sign();

            // Verification step of the digital signature
            Signature verifier = Signature.getInstance("ML-DSA");
            verifier.initVerify(kp.getPublic());
            verifier.update(msg);
            boolean isValid = verifier.verify(sig);
            System.out.println("Signature valid: " + isValid);

            // Converting a ML-DSA private key to its PKCS #8 encoding, and vice-versa
            KeyFactory f = KeyFactory.getInstance("ML-DSA");
            PKCS8EncodedKeySpec p8spec = f.getKeySpec(kp.getPrivate(),
                    PKCS8EncodedKeySpec.class);
            PrivateKey sk2 = f.generatePrivate(p8spec);

            System.out.println("Original and reconstructed private keys are equal: "
                    + java.util.Arrays.equals(kp.getPrivate().getEncoded(), sk2.getEncoded()));
        } catch (java.security.NoSuchAlgorithmException | java.security.InvalidAlgorithmParameterException
                | java.security.InvalidKeyException | java.security.SignatureException
                | java.security.spec.InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}
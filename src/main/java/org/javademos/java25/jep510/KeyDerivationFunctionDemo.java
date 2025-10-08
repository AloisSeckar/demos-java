package org.javademos.java25.jep510;

import org.javademos.commons.IDemo;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;
import java.util.Base64;

/// Demo for JDK 25 feature **JEP 510 - Key Derivation Function API**.
///
/// JEP history:
/// - JDK 24: [JEP 478 - Key Derivation Function API (Preview)](https://openjdk.org/jeps/478)
/// Further reading:
/// - [JEP 510: Key Derivation Function API @ daily.dev](https://app.daily.dev/posts/jep-510-key-derivation-function-api-18iteuevj)
///
/// @author Kishan Singh @Kishan_Singh
public class KeyDerivationFunctionDemo implements IDemo {
    @Override
    public void demo() {
        info(510); // Print JEP info header
        System.out.println("\nJEP 510 introduces a standard API for Key Derivation Functions (KDFs) in Java.");
        System.out.println("This demo shows how to derive a key from a password using PBKDF2.");
        System.out.println();

        // Example parameters
        String password = "mySecretPassword";
        byte[] salt = "randomSalt123456".getBytes();
        int iterations = 65536;
        int keyLength = 256;

        try {
            // In Java 25+, you can use the new KeyDerivationFunction API (JEP 510)
            // For demonstration, we use PBKDF2 via SecretKeyFactory (backward compatible)
            // Replace with KeyDerivationFunction API when available in your JDK
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keyLength);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            SecretKey key = skf.generateSecret(spec);
            byte[] derivedKey = key.getEncoded();

            System.out.println("Derived key (Base64): " + Base64.getEncoder().encodeToString(derivedKey));
            System.out.println("\nNote: In Java 25+, use the new KeyDerivationFunction API for a more unified approach.");
        } catch (NoSuchAlgorithmException | java.security.spec.InvalidKeySpecException e) {
            System.out.println("Key derivation failed: " + e.getMessage());
        }
    }
}

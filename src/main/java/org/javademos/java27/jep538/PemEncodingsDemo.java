package org.javademos.java27.jep538;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PEM;
import java.security.PEMDecoder;
import java.security.PEMEncoder;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.util.Base64;
import java.util.List;

import javax.crypto.CryptoException;
import javax.crypto.EncryptedPrivateKeyInfo;

import org.javademos.commons.IDemo;

/// Demo for JDK 27 feature JEP 538 - PEM Encodings of Cryptographic Objects (Third Preview).
///
/// The status in Java 27 is PREVIEW
///  => JVM option `--enable-preview` is required to use it.
///
/// ### Changes in JDK 26 (JEP 524)
/// - `PEMRecord` was renamed to `PEM` and got a `decode()` method that returns the decoded Base64 content
/// - `EncryptedPrivateKeyInfo.encryptKey` methods were renamed to `encrypt` and also accept
///   a `KeyPair` or a `PKCS8EncodedKeySpec`
/// - new `EncryptedPrivateKeyInfo.getKeyPair` methods decrypt PKCS#8 text that also contains the public key
/// - `PEMEncoder` and `PEMDecoder` can encrypt and decrypt `KeyPair` and `PKCS8EncodedKeySpec` objects
///
/// ### Changes in JDK 27 (JEP 538)
/// - `DEREncodable` was renamed to `BinaryEncodable`
/// - `PEM` is an ordinary class instead of a record, `content()` returns `byte[]` instead of `String`,
///   and new constructors accept the Base64 content as `byte[]`
/// - `PEMDecoder.withFactory` was renamed to `withFactoriesOf`
/// - `EncryptedPrivateKeyInfo.getKey(Key, Provider)` and `getKeyPair(Key, Provider)` were replaced
///   by `getKey(Key)` and `getKeyPair(Key)`
/// - new unchecked `javax.crypto.CryptoException` reports failures such as a wrong password
///
/// ### JEP history
/// - JDK 27: [JEP 538 - PEM Encodings of Cryptographic Objects (Third Preview)](https://openjdk.org/jeps/538)
/// - JDK 26: [JEP 524 - PEM Encodings of Cryptographic Objects (Second Preview)](https://openjdk.org/jeps/524)
/// - JDK 25: [JEP 470 - PEM Encodings of Cryptographic Objects (Preview)](https://openjdk.org/jeps/470)
///
/// ### Further reading
/// - [RFC 7468 - Textual Encodings of PKIX, PKCS, and CMS Structures](https://www.rfc-editor.org/rfc/rfc7468)
/// - [RFC 5958 - Asymmetric Key Packages](https://www.rfc-editor.org/rfc/rfc5958)
///
/// @author Akhil CH @Akhil-1527
public class PemEncodingsDemo implements IDemo {

    // password that protects the private keys below
    private static final char[] PASSWORD = "changeit".toCharArray();

    @Override
    public void demo() {
        info(538);

        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("EC");
            generator.initialize(new ECGenParameterSpec("secp256r1"));
            KeyPair keyPair = generator.generateKeyPair();

            // encoders and decoders are immutable and thread-safe, so one instance can be reused
            PEMEncoder encoder = PEMEncoder.of();
            PEMDecoder decoder = PEMDecoder.of();

            // PEM text is the Base64 form of the standard binary encoding between BEGIN and END lines,
            // the format OpenSSL, certificate authorities and many other tools use for keys and certificates
            String publicPem = encoder.encodeToString(keyPair.getPublic());
            System.out.print("Public key as PEM text:\n" + publicPem);

            // the decoder reads the type and the algorithm from the text, no KeyFactory is needed
            // passing the expected class saves a cast (a wrong class throws ClassCastException)
            // withFactoriesOf(provider) would make the decoder use the factories of one specific provider
            ECPublicKey publicKey = decoder.decode(publicPem, ECPublicKey.class);
            System.out.println("Decoded public key equals the original: " + publicKey.equals(keyPair.getPublic()));

            // withEncryption returns a new encoder that protects private keys with a password,
            // using the algorithm from the jdk.epkcs8.defaultAlgorithm security property
            String encryptedPem = encoder.withEncryption(PASSWORD).encodeToString(keyPair.getPrivate());
            System.out.println("Encrypted private key starts with: " + encryptedPem.lines().findFirst().orElseThrow());
            ECPrivateKey privateKey = decoder.withDecryption(PASSWORD).decode(encryptedPem, ECPrivateKey.class);
            System.out.println("Decrypted private key equals the original: " + privateKey.equals(keyPair.getPrivate()));

            // decryption errors are reported with the new unchecked CryptoException
            try {
                decoder.withDecryption("wrong".toCharArray()).decode(encryptedPem, PrivateKey.class);
            } catch (CryptoException e) {
                System.out.println("Wrong password: " + e.getClass().getName());
            }

            // EncryptedPrivateKeyInfo.encrypt allows a non-default algorithm, and PEMEncoder then encodes the result
            // a KeyPair is written as a single PKCS#8 structure that holds the public key too (RFC 5958)
            EncryptedPrivateKeyInfo encryptedPair =
                    EncryptedPrivateKeyInfo.encrypt(keyPair, PASSWORD, "PBEWithHmacSHA512AndAES_256", null, null);
            String pairPem = encoder.encodeToString(encryptedPair);

            // a decoder without withDecryption returns encrypted keys as EncryptedPrivateKeyInfo
            KeyPair restored = decoder.decode(pairPem, EncryptedPrivateKeyInfo.class).getKeyPair(PASSWORD);
            // the restored private key keeps the public key in its encoding, so equals() on the keys is false;
            // comparing the private value shows it is the same key
            boolean samePair = restored.getPublic().equals(keyPair.getPublic())
                    && ((ECPrivateKey) restored.getPrivate()).getS().equals(((ECPrivateKey) keyPair.getPrivate()).getS());
            System.out.println("Key pair restored from one encrypted PEM text: " + samePair);

            // PEM holds text of any type, including types with no Java class, such as PKCS#10 certificate requests
            // decoding to PEM.class also keeps any text before the BEGIN line, which decoding to a key skips
            PEM raw = decoder.decode("Signing key of the demo service\n" + publicPem, PEM.class);
            System.out.println("PEM type: " + raw.type()
                    + ", leading text: " + new String(raw.leadingData(), StandardCharsets.ISO_8859_1).strip()
                    + ", binary size: " + raw.decode().length + " bytes");

            // since JDK 27 PEM also accepts the Base64 content as bytes
            PEM note = new PEM("DEMO NOTE", Base64.getEncoder().encode("any binary data".getBytes(StandardCharsets.UTF_8)));
            String notePem = encoder.encodeToString(note);

            // when the type is not known in advance, a switch finds out what the decoder returned
            // BinaryEncodable is sealed, but some permitted classes are not public, so the switch needs a default
            for (String text : List.of(publicPem, encryptedPem, notePem)) {
                String found = switch (decoder.decode(text)) {
                    case PublicKey key -> key.getAlgorithm() + " public key";
                    case PrivateKey key -> key.getAlgorithm() + " private key";
                    case EncryptedPrivateKeyInfo info -> "encrypted private key (" + info.getAlgName() + ")";
                    case PEM other -> "PEM of type " + other.type() + ", which has no Java class";
                    default -> "other object";
                };
                System.out.println("Decoded: " + found);
            }
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
    }
}

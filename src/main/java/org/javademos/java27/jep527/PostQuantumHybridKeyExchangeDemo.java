package org.javademos.java27.jep527;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;

import org.javademos.commons.IDemo;

/// Demo for JDK 27 feature JEP 527 - Post-Quantum Hybrid Key Exchange for TLS 1.3.
///
/// ### JEP history
/// - JDK 27: [JEP 527 - Post-Quantum Hybrid Key Exchange for TLS 1.3](https://openjdk.org/jeps/527)
///
/// ### Further reading
/// - [JEP 496 - Quantum-Resistant Module-Lattice-Based Key Encapsulation Mechanism](https://openjdk.org/jeps/496)
/// - [Named groups in the Java Security Standard Algorithm Names](https://docs.oracle.com/en/java/javase/27/docs/specs/security/standard-names.html#named-groups)
/// - [IETF draft defining the hybrid ECDHE-MLKEM groups for TLS 1.3](https://datatracker.ietf.org/doc/draft-ietf-tls-ecdhe-mlkem/)
///
/// @author Akhil CH @Akhil-1527
public class PostQuantumHybridKeyExchangeDemo implements IDemo {

    // password of the throwaway keystore created below
    private static final char[] PASSWORD = "changeit".toCharArray();

    @Override
    public void demo() {
        info(527);

        try {
            // TLS calls the key exchange schemes that a client and a server can agree on "named groups"
            // a hybrid group combines quantum-resistant ML-KEM (JEP 496) with classic elliptic-curve Diffie-Hellman,
            // so the exchanged keys stay safe as long as at least one of the two algorithms is not broken
            // since JDK 27 the hybrid X25519MLKEM768 group is the first one a TLS 1.3 client offers,
            // so existing code gets it without any change
            // the client also sends a classic x25519 key share, so servers without hybrid support still connect
            // (TLS 1.2 connections never use the hybrid groups)
            String[] defaultGroups = SSLContext.getDefault().getDefaultSSLParameters().getNamedGroups();
            System.out.println("Named groups enabled by default: " + String.join(", ", defaultGroups));

            // two more hybrid groups, SecP256r1MLKEM768 and SecP384r1MLKEM1024, are supported but not enabled by default
            // SSLParameters.setNamedGroups selects the groups for a single connection
            // here both ends of a local connection allow only SecP384r1MLKEM1024,
            // so the handshake can only succeed by using it
            SSLContext localContext = localhostContext(Path.of("tmp", "jep527demo.p12"));
            System.out.println("Handshake allowing only SecP384r1MLKEM1024: " + handshake(localContext, "SecP384r1MLKEM1024"));
        } catch (IOException | GeneralSecurityException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        // to change the default list for the whole JVM, start it with the jdk.tls.namedGroups system property:
        //   java -Djdk.tls.namedGroups=SecP256r1MLKEM768,X25519MLKEM768,x25519 ...
        // it is read only once, so calling System.setProperty after TLS has been used has no effect
        // if the client and the server have no named group in common, the handshake fails,
        // so keep a classic group such as x25519 in the list unless you control both ends
        System.out.println();
    }

    /// Creates a context with a throwaway self-signed certificate that the server presents and the client trusts.
    private static SSLContext localhostContext(Path keyStore) throws IOException, GeneralSecurityException, InterruptedException {
        // there is no public JDK API to create a certificate, so keytool from the running JDK creates one
        Files.createDirectories(keyStore.getParent());
        Files.deleteIfExists(keyStore);
        Process keytool = new ProcessBuilder(
                Path.of(System.getProperty("java.home"), "bin", "keytool").toString(),
                "-genkeypair", "-alias", "localhost", "-keyalg", "EC", "-dname", "CN=localhost", "-validity", "1",
                "-keystore", keyStore.toString(), "-storepass", new String(PASSWORD))
                .redirectErrorStream(true)
                .redirectOutput(ProcessBuilder.Redirect.DISCARD)
                .start();
        if (keytool.waitFor() != 0) {
            throw new IOException("keytool could not create " + keyStore);
        }
        KeyStore store = KeyStore.getInstance(keyStore.toFile(), PASSWORD);
        Files.delete(keyStore);

        KeyManagerFactory keys = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keys.init(store, PASSWORD);
        TrustManagerFactory trust = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trust.init(store);
        SSLContext context = SSLContext.getInstance("TLSv1.3");
        context.init(keys.getKeyManagers(), trust.getTrustManagers(), null);
        return context;
    }

    /// Runs a TLS 1.3 handshake between a local server and client that both allow only the given named group.
    private static String handshake(SSLContext context, String namedGroup) throws IOException {
        try (SSLServerSocket server = (SSLServerSocket) context.getServerSocketFactory()
                .createServerSocket(0, 1, InetAddress.getLoopbackAddress())) {
            server.setSSLParameters(onlyGroup(server.getSSLParameters(), namedGroup));
            Thread.startVirtualThread(() -> {
                try (SSLSocket socket = (SSLSocket) server.accept()) {
                    socket.startHandshake();
                } catch (IOException e) {
                    // a failed handshake is reported on the client side
                }
            });

            try (SSLSocket client = (SSLSocket) context.getSocketFactory()
                    .createSocket(server.getInetAddress(), server.getLocalPort())) {
                client.setSSLParameters(onlyGroup(client.getSSLParameters(), namedGroup));
                client.startHandshake();
                return client.getSession().getProtocol() + " with " + client.getSession().getCipherSuite();
            }
        }
    }

    private static SSLParameters onlyGroup(SSLParameters params, String namedGroup) {
        params.setNamedGroups(new String[] {namedGroup});
        return params;
    }
}

package org.javademos.java16.jep380;

import org.javademos.commons.IDemo;
import java.io.IOException;
import java.net.StandardProtocolFamily;
import java.net.UnixDomainSocketAddress; 
import java.nio.channels.ServerSocketChannel;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * ## JEP 380: Unix-Domain Socket Channels
 *
 * ### History
 * Unix domain sockets provide efficient inter-process communication (IPC)
 * on the same host, avoiding network stack overhead. This JEP adds support
 * for them to Java's NIO channel APIs.
 *
 * ### Links
 * - [Official JEP 380](https://openjdk.org/jeps/380)
 *
 * @since Java 16
 */
public class UnixDomainSocketsDemo implements IDemo {

    @Override
    public void demo() {
        //Call info helper
        info(380);

        // The Demo
        // Important: Unix Domain Sockets are only supported on Unix-like OS (Linux, macOS)
        String os = System.getProperty("os.name").toLowerCase();
        if (!os.contains("linux") && !os.contains("mac")) {
            System.out.println("Unix Domain Sockets are only supported on Linux and macOS.");
            System.out.println("Skipping runtime demo on " + System.getProperty("os.name"));
            return;
        }

        // Define a path for the socket file in the 'tmp' directory
        // Used repo-local 'tmp/' folder as required by contribution guide
        Path socketPath = Path.of("tmp", "jep380demo.socket");

        System.out.println("Attempting to create a Unix Domain Socket at: " + socketPath.toAbsolutePath());

        try {
            // Ensure the directory exists and clean up any old socket file
            Files.createDirectories(socketPath.getParent());
            Files.deleteIfExists(socketPath);

            // Create the Unix Domain Socket Address
            UnixDomainSocketAddress address = UnixDomainSocketAddress.of(socketPath);

            // Open a Server Socket Channel using the UNIX protocol family
            ServerSocketChannel serverChannel = ServerSocketChannel.open(StandardProtocolFamily.UNIX);
            serverChannel.bind(address);
            System.out.println("Server socket channel bound successfully to: " + address);

    
            // Clean up
            serverChannel.close();
            Files.deleteIfExists(socketPath);
            System.out.println("Server socket channel closed and socket file deleted.");
            System.out.println("Demo successful.");

        } catch (UnsupportedOperationException e) {
            System.err.println("Error: Unix Domain Sockets might not be fully supported on this specific OS version.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("An I/O error occurred:");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred:");
            e.printStackTrace();
        }
        System.out.println("Demo complete.");
    }
}
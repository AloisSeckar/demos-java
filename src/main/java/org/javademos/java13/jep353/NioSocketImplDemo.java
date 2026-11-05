package org.javademos.java13.jep353;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UncheckedIOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.javademos.commons.IDemo;

/// Demo for JDK 13 feature JEP 353 - Reimplement the Legacy Socket API.
///
/// JEP history:
/// - JDK 13: [JEP 353 - Reimplement the Legacy Socket API](https://openjdk.org/jeps/353)
///
/// Further reading:
/// - [JEP 373 - Reimplement the Legacy DatagramSocket API](https://openjdk.org/jeps/373)
/// - [java.net.Socket API documentation](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/net/Socket.html)
///
/// @author Alois Sečkár <alois.seckar@gmail.com>
public class NioSocketImplDemo implements IDemo {
    @Override
    public void demo() {
        info(353);

        // The java.net.Socket and ServerSocket API stays the same, but the implementation
        // behind it is replaced by NioSocketImpl, built on the same internals as NIO channels.
        // Legacy PlainSocketImpl can still be selected via -Djdk.net.usePlainSocketImpl=true.

        // Port 0 lets the OS pick a free port. The client connects before accept() is called,
        // the connection waits in the server's backlog until it is accepted.
        try (ServerSocket server = new ServerSocket(0);
             Socket client = new Socket(InetAddress.getLoopbackAddress(), server.getLocalPort());
             PrintWriter clientOut = new PrintWriter(client.getOutputStream(), true);
             BufferedReader clientIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
             Socket connection = server.accept();
             BufferedReader serverIn = new BufferedReader(new InputStreamReader(connection.getInputStream()));
             PrintWriter serverOut = new PrintWriter(connection.getOutputStream(), true)) {

            System.out.println("Server listening on port " + server.getLocalPort());

            clientOut.println("Hello from JEP 353");
            String received = serverIn.readLine();
            System.out.println("Server received: " + received);

            serverOut.println("Echo: " + received);
            System.out.println("Client received: " + clientIn.readLine());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}

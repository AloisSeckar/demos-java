package org.javademos.java15.jep373;

import org.javademos.commons.IDemo;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/// Demo for JDK 15 feature JEP 373 - Reimplement the Legacy DatagramSocket API.
///
/// This JEP modernized the implementation of the legacy DatagramSocket
/// and DatagramSocketImpl APIs without changing their behavior.
/// The reimplementation uses java.nio infrastructure under the hood,
/// improving maintainability and performance.
///
/// JEP link:
/// - [JEP 373 - Reimplement the Legacy DatagramSocket API](https://openjdk.org/jeps/373)
///
///
/// @author alois.seckar@gmail.com
public class DatagramSocketDemo15 implements IDemo {

    @Override
    public void demo() {
        info(373);

        try (DatagramSocket socket = new DatagramSocket()) {
            String message = "Hello from JEP 373!";
            byte[] buffer = message.getBytes();

            InetAddress address = InetAddress.getLocalHost();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 9999);
            socket.send(packet);

            System.out.println("Datagram sent successfully using reimplemented API!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

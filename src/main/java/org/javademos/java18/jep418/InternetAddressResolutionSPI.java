package org.javademos.java18.jep418;

import org.javademos.commons.IDemo;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.spi.InetAddressResolver;
import java.net.spi.InetAddressResolverProvider;
import java.net.spi.InetAddressResolverProvider.Configuration;
import java.util.stream.Stream;

/// # JEP 418: Internet-Address Resolution SPI
///
/// ## Summary
/// This JEP introduces a Service-Provider Interface (SPI) for host name and IP address resolution.
/// It allows the standard `java.net.InetAddress` API to use custom, pluggable resolvers instead of
/// being limited to the operating system's built-in resolver. This is crucial for projects like
/// Loom (to enable non-blocking DNS lookups for virtual threads), for integrating modern network
/// protocols like DNS-over-HTTPS, and for testing frameworks that need to mock DNS responses.
///
/// ## History
/// - **Release:** JDK 18
/// - **Status:** Delivered
///
/// ## Links
/// - [JEP 418: OpenJDK](https://openjdk.java.net/jeps/418)
///
/// @author dhruv-git-sys
///
public class InternetAddressResolutionSPI implements IDemo {

    // --- Part 1: Implementing a Custom Resolver ---
    // The nested classes below demonstrate how to implement a custom resolver provider
    // and resolver. This is for educational purposes; it is not active in this demo's runtime.

    /**
     * A mock resolver that always resolves "mock.example.com" to a fixed IP
     * and delegates all other lookups to the built-in system resolver.
     */
    public static class MockResolver implements InetAddressResolver {
        // Store the configuration provided by the JDK
        private final Configuration config;

        // Accept the configuration in the constructor
        public MockResolver(Configuration config) {
            this.config = config;
        }

        @Override
        public Stream<InetAddress> lookupByName(String host, LookupPolicy lookupPolicy) throws UnknownHostException {
            if ("mock.example.com".equalsIgnoreCase(host)) {
                // For our specific host, return a hardcoded address.
                return Stream.of(InetAddress.getByAddress(host, new byte[]{1, 2, 3, 4}));
            } else {
                // Correctly call the instance method on the stored configuration object.
                return config.builtinResolver().lookupByName(host, lookupPolicy);
            }
        }

        @Override
        public String lookupByAddress(byte[] addr) throws UnknownHostException {
            // Correctly call the instance method on the stored configuration object.
            return config.builtinResolver().lookupByAddress(addr);
        }
    }

    /**
     * The service provider class that the JDK's ServiceLoader will discover.
     * Its primary role is to provide an instance of our custom resolver to the JDK.
     */
    public static class MockResolverProvider extends InetAddressResolverProvider {
        @Override
        public InetAddressResolver get(Configuration configuration) {
            // Create a new resolver instance, passing the provided configuration.
            return new MockResolver(configuration);
        }

        @Override
        public String name() {
            return "Java Demos Mock Resolver";
        }
    }


    @Override
    public void demo() {
        info(418);

        // --- Part 2: Activating the Custom Resolver ---
        // To make the JDK use our `MockResolverProvider`, we would need to register it as a service.
        // This is done by creating a file in the project's META-INF/services directory.
        //
        // File path: `src/main/resources/META-INF/services/java.net.spi.InetAddressResolverProvider`
        //
        // The content of this file would be the fully qualified name of our provider implementation:
        // `org.javademos.java18.jep418.InternetAddressResolutionSPI$MockResolverProvider`
        //
        // If this project were built as a JAR with that service file included, all calls to
        // `InetAddress.getByName()` would automatically use our mock resolver.

        // --- Part 3: Demonstration of Default Behavior ---
        // Since our mock provider is not active in this runtime, the following code
        // will use the default, built-in resolver provided by the operating system.
        try {
            // This line performs a standard DNS lookup using the OS's native resolver.
            InetAddress address = InetAddress.getByName("www.openjdk.org");
            // At this point, `address` would hold the resolved IP. The code runs
            // successfully, demonstrating the default functionality that can be customized.
            System.out.println("Resolved address: " + address.toString());
        } catch (UnknownHostException e) {
            // This block would execute if the DNS lookup fails.
        }
    }
}
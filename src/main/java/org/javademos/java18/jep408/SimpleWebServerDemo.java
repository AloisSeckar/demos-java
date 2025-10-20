package org.javademos.java18.jep408;

import org.javademos.commons.IDemo;

/// # JEP 408: Simple Web Server
///
/// ## History
/// - Introduced as a **standard feature** in **Java 18** (March 2022)
///
/// ## Overview
/// JEP 408 introduces a minimal HTTP server for serving static files. It provides both a
/// command-line tool (`jwebserver`) and an API for programmatic use. The server is designed
/// for prototyping, ad-hoc coding, testing, and educational purposes - NOT for production use.
///
/// ## Key Features
/// - Command-line tool: `jwebserver`
/// - Serves static files from a directory hierarchy
/// - Supports HTTP/1.1 only (no HTTPS by default, no dynamic content)
/// - Binds to loopback (127.0.0.1) by default for security
/// - Default port: 8000
/// - Provides directory listing when no index.html exists
/// - New `HttpHandlers` utility class for creating custom handlers
///
/// ## Why?
/// Similar to Python's `python -m http.server`, Ruby's `ruby -run -e httpd`, and PHP's
/// `php -S`, this feature makes the JDK more approachable by providing a zero-config web
/// server for quick testing and development.
///
/// ## Not Goals
/// - NOT a production-grade server (use Tomcat, Jetty, Netty, nginx, etc. for that)
/// - No CGI or servlet support
/// - No advanced HTTP features
///
/// ## Links
/// - JEP: https://openjdk.org/jeps/408
/// - API Documentation: https://docs.oracle.com/en/java/javase/18/docs/api/jdk.httpserver/com/sun/net/httpserver/SimpleFileServer.html
/// - Command-line Tool: https://docs.oracle.com/en/java/javase/18/docs/specs/man/jwebserver.html
/// - Inside Java Podcast: https://inside.java/2022/03/04/podcast-022/
/// - Inside Java Article: https://inside.java/2022/04/01/simple-web-server/
public class SimpleWebServerDemo implements IDemo {

    @Override
    public void demo() {
        info(408);

        System.out.println("=== COMMAND-LINE TOOL ===\n");
        commandLineExamples();

        System.out.println("\n=== PROGRAMMATIC API ===\n");
        programmaticApiExamples();

        System.out.println("\n=== CUSTOM HANDLERS ===\n");
        customHandlerExamples();

        System.out.println("\n=== KEY TAKEAWAYS ===");
        keyTakeaways();
    }

    /// Demonstrates the command-line `jwebserver` tool usage
    /// The tool is a convenient wrapper around `java -m jdk.httpserver`
    private void commandLineExamples() {
        // The 'jwebserver' command-line tool can be used to quickly start a web server

        // Basic usage:
        //   jwebserver
        //   -> Starts server on http://127.0.0.1:8000 serving current directory

        // Custom port:
        //   jwebserver -p 9000
        //   -> Starts server on port 9000

        // Custom directory:
        //   jwebserver -d /path/to/directory
        //   -> Serves files from specified directory

        // Bind to all interfaces (CAUTION - security risk!):
        //   jwebserver -b 0.0.0.0
        //   -> Makes server accessible from network (default is loopback only)

        // Output levels:
        //   jwebserver -o verbose
        //   -> Shows detailed request/response information
        //   -> Options: none, info (default), verbose

        // Help:
        //   jwebserver -h
        //   -> Shows all available options

        // Under the hood, 'jwebserver' executes:
        //   java -m jdk.httpserver

        System.out.println("Command-line tool 'jwebserver' provides quick file serving capability.");
        System.out.println("See comments in the source code for usage examples.");
    }

    /// Demonstrates creating and using the Simple Web Server programmatically
    /// Shows basic file server creation and configuration options
    private void programmaticApiExamples() {
        System.out.println("Programmatic API allows creating file servers in Java code:\n");

        // Example 1: Create a basic file server
        // Note: We don't actually start it to avoid blocking the demo
        //
        // var server = SimpleFileServer.createFileServer(
        //     new InetSocketAddress(8000),
        //     Path.of("/path/to/files"),
        //     SimpleFileServer.OutputLevel.INFO
        // );
        // server.start();
        //
        // This creates a server that:
        // - Listens on 127.0.0.1:8000 (loopback only for security)
        // - Serves files from the specified directory
        // - Logs requests at INFO level

        System.out.println("Example 1: Basic file server using SimpleFileServer.createFileServer()");
        System.out.println("  Creates server bound to specific address and port");
        System.out.println("  Serves files from a directory with configurable output level\n");

        // Example 2: Create server bound to specific address
        //
        // var server = SimpleFileServer.createFileServer(
        //     new InetSocketAddress("localhost", 9000),
        //     Path.of("/path/to/files"),
        //     SimpleFileServer.OutputLevel.VERBOSE
        // );
        //
        // This allows you to:
        // - Specify exact host and port
        // - Control output verbosity

        System.out.println("Example 2: Custom address and verbosity");
        System.out.println("  Control host, port, and logging output level\n");

        // Example 3: Create file handler for use with HttpServer
        //
        // var handler = SimpleFileServer.createFileHandler(
        //     Path.of("/path/to/files")
        // );
        //
        // HttpServer server = HttpServer.create(
        //     new InetSocketAddress(8000), 0
        // );
        // server.createContext("/files", handler);
        // server.start();
        //
        // This lets you:
        // - Integrate file serving with custom HttpServer
        // - Combine static files with custom endpoints

        System.out.println("Example 3: File handler for existing HttpServer");
        System.out.println("  Integrate static file serving with custom HTTP endpoints\n");

        // Example 4: Output filter for customizing responses
        //
        // var filter = SimpleFileServer.createOutputFilter(
        //     System.out,
        //     SimpleFileServer.OutputLevel.INFO
        // );
        //
        // server.createContext("/", handler).getFilters().add(filter);
        //
        // This provides:
        // - Configurable logging output
        // - Request/response monitoring

        System.out.println("Example 4: Output filter for logging");
        System.out.println("  Add request/response monitoring with configurable output");

        System.out.println("\nNOTE: Servers are not actually started in this demo to avoid blocking.");
    }

    /// Demonstrates the new HttpHandlers utility class
    /// Shows how to create custom request handlers with filtering and path handling
    private void customHandlerExamples() {
        System.out.println("The HttpHandlers utility class provides helper methods:\n");

        // 1. HttpHandlers.of(statusCode, headers, body)
        //    Creates a handler that always returns the same response
        //
        //    Example:
        //    var handler = HttpHandlers.of(200,
        //        Headers.of("Content-Type", "text/plain"),
        //        "Hello, World!");

        System.out.println("1. HttpHandlers.of() - Creates simple response handlers");
        System.out.println("   Returns same status, headers, and body for all requests\n");

        // 2. HttpHandlers.handleOrElse(predicate, handler, fallbackHandler)
        //    Routes requests based on a condition
        //
        //    Example:
        //    var handler = HttpHandlers.handleOrElse(
        //        req -> req.getRequestURI().getPath().endsWith(".json"),
        //        jsonHandler,
        //        htmlHandler
        //    );

        System.out.println("2. HttpHandlers.handleOrElse() - Conditional routing");
        System.out.println("   Routes based on request predicates with fallback\n");

        // 3. Use with mapping for path-based routing:
        //
        //    Example:
        //    HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        //
        //    server.createContext("/api",
        //        HttpHandlers.of(200, Headers.of("Content-Type", "application/json"),
        //            "{\"message\":\"API endpoint\"}"));
        //
        //    server.createContext("/static",
        //        SimpleFileServer.createFileHandler(Path.of("/var/www/static")));
        //
        //    server.start();

        System.out.println("3. Path-based routing with createContext()");
        System.out.println("   Combine multiple handlers for different URL paths");

        demonstrateHandlerPattern();
    }

    /// Demonstrates a practical pattern for using custom handlers
    /// This shows how you might structure a simple API with static file serving
    private void demonstrateHandlerPattern() {
        System.out.println("\n--- Practical Example: API + Static Files ---\n");

        // Practical pattern combining API endpoints with static file serving:
        //
        // // Create the main HTTP server
        // HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        //
        // // Add an API endpoint
        // server.createContext("/api/status", exchange -> {
        //     String response = "{\"status\":\"ok\",\"timestamp\":" +
        //                       System.currentTimeMillis() + "}";
        //     exchange.getResponseHeaders().set("Content-Type", "application/json");
        //     exchange.sendResponseHeaders(200, response.length());
        //     try (OutputStream os = exchange.getResponseBody()) {
        //         os.write(response.getBytes());
        //     }
        // });
        //
        // // Add static file serving
        // var fileHandler = SimpleFileServer.createFileHandler(Path.of("./public"));
        // server.createContext("/", fileHandler);
        //
        // // Add logging
        // var outputFilter = SimpleFileServer.createOutputFilter(
        //     System.out,
        //     SimpleFileServer.OutputLevel.INFO
        // );
        // server.createContext("/").getFilters().add(outputFilter);
        //
        // // Start the server
        // server.start();
        //
        // This pattern provides:
        // - Custom API endpoints at /api/*
        // - Static file serving for everything else
        // - Request/response logging
        // - Clean separation of concerns

        System.out.println("This pattern demonstrates combining:");
        System.out.println("  • Custom API endpoints (e.g., /api/status)");
        System.out.println("  • Static file serving for other paths");
        System.out.println("  • Request/response logging via filters");
        System.out.println("  • Clean separation between dynamic and static content");
    }

    /// Summarizes the key points about JEP 408
    private void keyTakeaways() {
        System.out.println("• Simple Web Server is perfect for development and testing");
        System.out.println("• Use 'jwebserver' for quick file serving from command line");
        System.out.println("• Use the API for programmatic control and custom endpoints");
        System.out.println("• Always binds to loopback by default for security");
        System.out.println("• NOT intended for production - use proper servers for that");
    }
}
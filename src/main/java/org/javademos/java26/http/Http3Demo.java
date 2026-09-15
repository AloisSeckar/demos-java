package org.javademos.java26.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.javademos.commons.IDemo;

/// Demo for JDK 26 feature JEP 517 - HTTP/3 for the HTTP Client API
/// 
/// This feature allows HTTP client to support HTTP/3 protocol
/// 
/// JEP history:
/// - JDK 11: [JEP 321 - HTTP Client](https://openjdk.org/jeps/321)
/// 
/// Further reading:
/// - [Java  HTTP Client](https://cr.openjdk.org/~dfuchs/8291976/apidoc.05/api/java.net.http/java/net/http/HttpClient.html)
/// 
/// @author Shivansh-22866
public class Http3Demo implements IDemo {

    @Override
    public void demo() {
        info("HTTP/3 DEMO", "Example for HTTPClient with HTTP/3 protocol");
        
        // classes used in this demo:
        // HttpRequest + HttpClient + HttpResponse
        
        // Java 10 language feature 'var' is used for initiating variables
        // check var.java11.org.javademos.VarDemo to learn more

        try {
            // Build an HTTP request using method chaining.
            // HttpRequest.newBuilder(URI.create(...)) creates a request builder
            // and specifies the target URI.
            // .version() specifies the HTTP protocol version to use.
            // .GET() sets the request method to GET.
            // .build() creates the final immutable HttpRequest object.
            var request = HttpRequest.newBuilder(URI.create("https://openjdk.org/"))
                                    .version(HttpClient.Version.HTTP_3)
                                    .GET()
                                    .build();
            
            // call the newBuilder() method and use HTTP_3 version to specify the protocol
            var client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_3)
            .build();
            
            // this is all you need to get the HTTP response from server
            // BodyHandlers.ofString() will transform the raw data into String
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            // handling response contents 
            // cut response's body into lines and display each
            response.body().lines().forEach(System.out::println);
            
            // you can display https://openjdk.org in your
            // browser and select 'View page source' to compare its contents
            // and verify you got the exact same output here
            
        } catch (Exception ex) {
            // setting PrintStream/PrintWriter target here will easily suppress
            // the infamous 'Print Stack Trace' compiler warning
            ex.printStackTrace(System.out);
        }
        
        System.out.println();
    }

}
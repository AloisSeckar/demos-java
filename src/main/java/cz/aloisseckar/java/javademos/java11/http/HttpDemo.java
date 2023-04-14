package cz.aloisseckar.java.javademos.java11.http;

import cz.aloisseckar.java.javademos.commons.IDemo;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * This class demonstrates features of the new HttpClient.
 * This allows simpler and cleaner work with external HTTP resources.
 * 
 * Introduced: Java 9
 * Finalized: Java 11
 * 
 * Further reading:
 * https://www.baeldung.com/java-9-http-client
 * 
 * @author alois.seckar@atos.net
 */
public class HttpDemo implements IDemo {

    @Override
    public void demo() {
        info("HTTP DEMO", "Example for new HTTPClient");
        
        // classes used in this demo:
        // HttpRequest + HttpClient + HttpResponse
        
        // Java 10 language feature 'var' is used for initiating variables
        // check cz.aloisseckar.java.javademos.java11.var.VarDemo to learn more

        try {
            // building HTTP request via method chaining
            // .uri() - the most important part specifying target
            // .version - HTTP protocol version (1.1 or 2)
            // .header() (or .headers() for more) - specify yor request
            //    read more about HTTP headers here:
            //    https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers
            // GET/POST/PUT/DELETE - depending on what you need
            var request = HttpRequest.newBuilder()
                    .uri(new URI("http://ellrohir.mzf.cz/demo/index.html"))
                    .version(HttpClient.Version.HTTP_2)
                    .header("my-header", "my-value")
                    .GET()
                    .build();
            
            // simply call factory method to get working HTTP client
            var client = HttpClient.newHttpClient();
            
            // this is all you need to get the HTTP response from server
            // BodyHandlers.ofString() will transform the raw data into String
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            // handling response contents 
            // cut response's body into lines and display each
            response.body().lines().forEach(System.out::println);
            
            // you can display http://alois-seckar.cz/demo/index.html in your
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

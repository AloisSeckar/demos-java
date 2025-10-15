package org.javademos.java18.jep400;

import org.javademos.commons.IDemo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

/// Demo for JDK 18 feature **JEP 400 - UTF-8 by Default**.
///
/// JEP history:
/// - JDK 18: [JEP 400 - UTF-8 by Default (Preview)](https://openjdk.org/jeps/400)
///
/// @author biswarup.chatterjee@tuta.io
public class DefaultUTF8Demo implements IDemo {
    @Override
    public void demo() {
        info("UFT-8 By Default", "Example of 'UFT-8 By Default' feature\nbeing previewed in Java 21");

        System.out.println("Default charset: " + Charset.defaultCharset());

        String text = "Hello, 世界 🌍";

        // Write a file without specifying charset
        try (FileWriter writer = new FileWriter("demo.txt")) {
            writer.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Read the same file without specifying charset
        try (FileReader reader = new FileReader("demo.txt")) {
            char[] buffer = new char[100];
            int len = reader.read(buffer);
            String readText = new String(buffer, 0, len);
            System.out.println("Read text: " + readText);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

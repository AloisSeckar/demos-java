package cz.aloisseckar.java.javademos.java17.j16;

import cz.aloisseckar.java.javademos.commons.IDemo;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class demonstrates some new language features from Java 16.
 * 
 * Introduced: Java 16
 * 
 * Further reading:
 * https://blogs.oracle.com/javamagazine/post/the-hidden-gems-in-java-16-and-java-17-from-streammapmulti-to-hexformat 
 * 
 * @author alois.seckar@atos.net
 */
public class J16Demo implements IDemo {

    @Override
    public void demo() {
        info("JAVA 16 FEATURES DEMO", "Examples for couple of 'hidden' features \nintroduced in Java 16");
        
        System.out.println("Direct Stream.toList()");
        
        // There is now terminating method .toList() available directly 
        // on Stream class. Prior to that you have to use the Collector.
        
        // Java < 16
        List<String> stringList = Stream.of("a", "b", "c").collect(Collectors.toList());
        stringList.forEach(System.out::print);
        System.out.println();
        
        // Java 16+
        List<String> j16StringList = Stream.of("a", "b", "c").toList();
        j16StringList.forEach(System.out::print);
        
        System.out.println();
        
        ////////////////////////////////////////////////////////////////////////
        
        System.out.println("Stream.mapMulti()");
        
        // New method on Streams that allows more complex transitions
        
        // here the output is number of characters in each word
        // method signature:cd
        // <R> Stream<R> map(Function<? super T, ? extends R> mapper)
        Stream.of("Java", "Valhalla", "Panama", "Loom", "Amber")
                .map(String::length)
                .forEach(System.out::print);
        System.out.println();
        
        // here the output is our custom object with 3 values:
        // 1) number of characters in each word
        // 2) first letter of each word
        // 3) flag whether the word ends with 'a'
        // method signature:
        // default <R> Stream<R> mapMulti(BiConsumer<? super T,? super Consumer<R>> mapper)
        Stream.of("Java", "Valhalla", "Panama", "Loom", "Amber")
                .mapMulti((str, mapper) -> mapper.accept(new MapMulti(str.length(), str.charAt(0), str.endsWith("a"))))
                .forEach(System.out::print);
        System.out.println();
        
        ////////////////////////////////////////////////////////////////////////
        
        System.out.println("period-of-day date format");
        System.out.println("Use 'B' symbol in format string");
        
        // 'B' in date/time format string will translate into either:
        //   - midnight             (00:00)
        //   - at night             (00:01 - 05:59)
        //   - in the morning       (06:00 - 11:59)
        //   - noon                 (12:00)
        //   - in the afternoon     (12:01 - 17:59)
        //   - in the evening       (18:00 - 20:59)
        //   - at night             (21:00 - 23:59)
        // based on the given time 
        
        List<LocalTime> variousTimes = Arrays.asList(
                LocalTime.of(0, 0),
                LocalTime.of(0, 1),
                LocalTime.of(5, 59),
                LocalTime.of(6, 0),
                LocalTime.of(11, 59),
                LocalTime.of(12, 0),
                LocalTime.of(12, 01),
                LocalTime.of(17, 59),
                LocalTime.of(18, 00),
                LocalTime.of(20, 59),
                LocalTime.of(21, 00),
                LocalTime.of(23, 59),
                LocalTime.now(ZoneId.of("GMT")),
                LocalTime.now(ZoneId.of("GMT+10")),
                LocalTime.now(ZoneId.of("GMT-10"))
        );

        Locale.setDefault(Locale.UK); // to prevent local symbols (like czech 'ů') from breaking the console output
        variousTimes.forEach(time -> {
            System.out.println(DateTimeFormatter.ofPattern("HH:mm B").format(time));
        });
        
        System.out.println();
        
        ////////////////////////////////////////////////////////////////////////
        
        System.out.println("No nulls in Path");
        
        // now it is not possible to smuggle "null" elements into (file) path
        
        // Java < 16
        // Path.of(null, "path/to/file") ==> null/path/to/file
        
        // Java 16 +
        // this will throw runtime exception:
        // java.lang.NullPointerException 
        //   at java.base/java.util.Objects.requireNonNull(Objects.java:208)
        try {
            Path path = Paths.get(null, "path/to/file");
            System.out.println(path.toString());
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        
        System.out.println();
        
        ////////////////////////////////////////////////////////////////////////
        
        System.out.println("Read lines fix");
        
        // counting lines via LineNumberReader didn't work properly 
        // the last line was ignored in older versions of Java,
        // if the \n symbol was omitted at the end
        // in Java 16 this was fixed
        
        String text1 = "Line 1\n Line 2\n Line 3";
        String text2 = "Line 1\n Line 2\n Line 3\n";
        try {
            // in Java < 16 this will return 2 instead 3
            System.out.println(readLines(text1));
            // this will return 3 in both cases
            System.out.println(readLines(text2));
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        
        System.out.println();
        
    }
    
    // simple method to return the last position of the reader
    // which should bne equal to the number of lines in the source
    private int readLines(String string) throws IOException {
        LineNumberReader reader = new LineNumberReader(new StringReader(string));
        while (reader.read() != -1) { /* reading text line-by-line */ }
        return reader.getLineNumber();
    }
    
}

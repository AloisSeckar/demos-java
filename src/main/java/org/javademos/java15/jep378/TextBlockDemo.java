package org.javademos.java15.jep378;

import org.javademos.commons.IDemo;

/// Demo for JDK 15 feature JEP 378 - Text Blocks.
///
///
/// JEP history:
/// - JDK 15: [JEP 378 - Text Blocks](https://openjdk.org/jeps/378)
/// - JDK 14: [JEP 368 - Text Blocks (Second Preview)](https://openjdk.org/jeps/368)
/// - JDK 13: [JEP 355 - Text Blocks (Preview)](https://openjdk.org/jeps/355)
///
/// Further Reading:
/// - [Java Text Blocks](https://www.baeldung.com/java-text-blocks)
/// - [Programmer's Guide to Text Blocks](http://docs.oracle.com/javase/jp/15/text-blocks/index.html)
///
/// @author alois.seckar@gmail.com, SanjanaMahapatra

public class TextBlockDemo implements IDemo{

    @Override
    public void demo() {
        info(378);

        // Java < 15
        // if you want multi-line text, you have to chain it with "+"
        // and include \n to split the output into lines
        String oldString = "This is multiline string \n"
                + "constructed in the old fashioned way \n"
                + "divided to more lines with + symbols \n"
                + "and with \\n to add line breaks \n";

        System.out.println("Old string for JDK < 15 ");
        System.out.println(oldString);

        // Based on the feedback received from JEP355, in the second preview JEP368, two new escape
        // sequence for explicit control were introduced ->
        // a) \s (A single space preventing automatic stripping of trailing whitespace.
        // b) \ (A backslash at the end of a line to suppress the insertion of a new line character.

        // This change introduced in JEP368, was also taken in the final implementation of JEP378.

        // Example of New Escape

        System.out.println("""
                The character literals and traditional string literals don't
                allow the embedding of newlines, the \\<line-terminator> escape
                sequence applicable for text blocks only.
                """);

        String rawLiteral = "Lorem ipsum dolor sit amet, consectetur adipiscing " +
                "elit, sed do eiusmod tempor incididunt ut labore " +
                "et dolore magna aliqua.";

        System.out.println(rawLiteral);

        System.out.println("The following example demonstrates having a newline, but actually does not do");

        String lineTerminatorText =  """
                Lorem ipsum dolor sit amet, consectetur adipiscing \
                elit, sed do eiusmod tempor incididunt ut labore \
                et dolore magna aliqua.\
                """;

        System.out.println(lineTerminatorText);

        // Java 15+
        // you can have multi-line text inside """ and """ marks
        // new lines are automatically being taken from new lines in source
        String newString = """
                           This is also multiline string
                           but constructed in the new way
                           divided to more lines without + symbols
                           and with no need to declare \\n line breaks
                           """;
        System.out.println();
        System.out.println("New String for JDK 15+ ");
        System.out.println(newString);

        // you can refer to output to see both Strings print out equivalently

        // adding some additional examples to support the statement

        System.out.println("Text blocks can be also used as the method argument -");
        System.out.println("""
                This is the first line in statement
                This is the second line in statement
                This is the third line in statement
                """
        );

        System.out.println("""
        When the text block contains sequence of three or more double quotes,
        escape the first double quote of every run of three double quotes.
        """);

        String originalString = """
                String source = \"\"\"
                    String message = "Hello, World!";
                    System.out.println(message);
                    \"\"\";
                """;

        System.out.println("original string - ");
        System.out.println(originalString);

        String betterString = """
                String source = \"""
                    String message = "Hello, World!";
                    System.out.println(message);
                \""";
                """;

        System.out.println("better string using text blocks - ");
        System.out.println(betterString);

    }
}

package org.javademos.java14.jep368;

import org.javademos.commons.IDemo;

/// Demo for JDK 14 feature <strong>JEP 368 - Text Blocks (Second Preview)</strong>.
///
/// This was a preview JEP. The feature is finalized in JDK 15 by JEP 378.
/// @see org.javademos.java15.jep378.TextBlockDemo
///
/// @author SanjanaMahapatra


public class TextBlockSecondPreviewDemo implements IDemo {

    @Override
    public void demo() {
        info(368);

        // example supporting the claim

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
    }

}

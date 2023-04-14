package cz.aloisseckar.java.javademos.java17.textblock;

import cz.aloisseckar.java.javademos.commons.IDemo;

/**
 * This class demonstrates new way of handling text blocks in Java 15.
 * 
 * Introduced: Java 13
 * Finalized: Java 15
 * 
 * Further reading: 
 * https://www.baeldung.com/java-text-blocks
 * 
 * @author alois.seckar@atos.net
 */
public class TextBlockDemo implements IDemo {

    @Override
    public void demo() {
        info("TEXT BLOCK DEMO", "Examples for 'text blocks' feature\nintroduced in Java 13 and finalized in Java 15");
        
        // Java < 15
        // if you want multi-line text, you have to chain it with "+"
        // and include \n to split the output into lines
        String oldString = "This is multiline string \n"
                + "constructed in the old fashioned way \n"
                + "divided to more lines with + symbols \n"
                + "and with \\n to add line breaks \n";
        System.out.println(oldString);
        
        // Java 15+
        // you can have multi-line text inside """ and """ marks
        // new lines are automatically being taken from new lines in source
        String newString = """
                           This is also multiline string
                           but constructed in the new way
                           divided to more lines without + symbols
                           and with no need to declare \\n line breaks
                           """;
        System.out.println(newString);
        
        // you can refer to output to see both Strings print out equivalently
    }

}

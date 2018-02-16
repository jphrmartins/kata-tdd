package br.com.ubots.katatdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DelimiterTest {

    @Test
    public void testCatchDelimiterDefault() {
        String expression = "1,2";
        Delimiter delimiter = new Delimiter(expression);
        assertEquals(",|\n", delimiter.getDelimiters());
    }

    @Test
    public void testCatchSingleCustomDelimiters() {
        String expression = "//.\n1.2";
        Delimiter delimiter = new Delimiter(expression);
        assertEquals("\\Q.\\E", delimiter.getDelimiters());
    }

    @Test
    public void testCatchSingleManyCustomDelimiters() {
        String expression = "//[***]\n1***3";
        Delimiter delimiter = new Delimiter(expression);
        assertEquals("\\Q***\\E", delimiter.getDelimiters());
    }
    @Test
    public void testCatchNonReservedTermDelimiter(){
        String expression = "//[a]\n1a3";
        Delimiter delimiter = new Delimiter(expression);
        assertEquals("\\Qa\\E", delimiter.getDelimiters());
    }

    @Test
    public void testCatchMultipleCustomDelimiters() {
        String expression = "//[.][;]\n1.3;4";
        Delimiter delimiter = new Delimiter(expression);
        assertEquals("\\Q.\\E|\\Q;\\E", delimiter.getDelimiters());
    }
}

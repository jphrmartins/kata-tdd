package br.com.ubots.katatdd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestDelimiter {

    @Test
    public void testCatchDelimiterDefault(){
        String expression = "1,2";
        Delimiter delimiter = new Delimiter(expression);
        assertEquals(",|\n", delimiter.getDelimiters());
    }
    @Test
    public void testCatchSingleCustomDelimiters(){
        String expression = "//.\n1.2";
        Delimiter delimiter = new Delimiter(expression);
        assertEquals(".", delimiter.getDelimiters());
    }
    @Test
    public void testCatchSingleManyCustomDelimiters(){
        String expression = "//[***]\n1***3";
        Delimiter delimiter = new Delimiter(expression);
        assertEquals("***", delimiter.getDelimiters());
    }

    @Test
    public void testCatchMultipleCustomDelimiters(){
        String expression = "//[.][;]\n1.3;4";
        Delimiter delimiter = new Delimiter(expression);
        assertEquals(".|;", delimiter.getDelimiters());
    }
}

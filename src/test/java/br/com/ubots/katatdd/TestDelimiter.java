package br.com.ubots.katatdd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestDelimiter {
    private Delimiter delimiter;
    @Before
    public void setup(){
        this.delimiter = new Delimiter();
    }
    @Test
    public void testCatchDelimiterDefault(){
        String expression = "1,2";
        assertEquals(", | \n", delimiter.getDelimiters(expression));
    }
    @Test
    public void testCAtchCustomDelimiters(){
        String expression = "//.\n1.2";
        assertEquals(".", delimiter.getDelimiters(expression));
    }
}

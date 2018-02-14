package br.com.ubots.katatdd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCalculator {
    private CalculatorString calculator;

    @Before
    public void setup() {
        this.calculator = new CalculatorString();
    }

    @Test
    public void testEmptyStringValue() {
        int result = calculator.sum("");
        assertEquals(0, result);
    }

    @Test
    public void testSumSingleStringValue() {
        int result = calculator.sum("1");
        assertEquals(1, result);
    }

    @Test(expected = NumberFormatException.class)
    public void testErrorValueNotANumber() {
        int result = calculator.sum("d,b");
    }

    @Test
    public void testSumAnySizeStringValues() {
        int result = calculator.sum("3,\n4");
        assertEquals(7, result);
    }

}

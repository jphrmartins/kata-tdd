package br.com.ubots.katatdd;

import br.com.ubots.katatdd.exception.NegativeNumberException;
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
        int result = calculator.sum("3\n4");
        assertEquals(7, result);
    }

    @Test
    public void testCustomDelimiterAnySizeStringValue() {
        int result = calculator.sum("//;\n1;2");
        assertEquals(3, result);
    }

    @Test
    public void testSingleManyCustomDelimiters() {
        int result = calculator.sum("//[***][;;;]\n1***2;;;2");
        assertEquals(5, result);
    }

    @Test
    public void testMultiplyCustomDelimeters() {
        int result = calculator.sum("//[...][,]\n10...10,5");
        assertEquals(25, result);
    }

    @Test
    public void testIgnoreOverThousandValue() {
        int result = calculator.sum("1001,3,7,2000");
        assertEquals(10, result);
    }

    @Test
    public void testExpressionOneNegativeNumber() {
        try {
            int result = calculator.sum("1,-1");
            fail("do not throw exception");
        } catch (NegativeNumberException e) {
            assertEquals("-1", e.getMessage());
        }
    }

    @Test
    public void testExpressionAnyNegativeNumbers() {
        try {
            int result = calculator.sum("-7,1,-1,-3,-4");
            fail("do not throw exception");
        } catch (NegativeNumberException e) {
            assertEquals("-7 -1 -3 -4", e.getMessage());
        }
    }
    @Test
    public void fastTest(){
        int result = calculator.sum("//[,,]\n10,,10");
        assertEquals(20, result);
    }

}

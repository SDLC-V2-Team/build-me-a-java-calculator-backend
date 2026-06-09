package com.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTests {

    private static final double DELTA = 0.0001;

    // Happy path tests

    @Test
    void testAddPositiveNumbers() {
        assertEquals(5.0, Calculator.add(2.0, 3.0), DELTA);
    }

    @Test
    void testSubtractPositiveNumbers() {
        assertEquals(3.0, Calculator.subtract(5.0, 2.0), DELTA);
    }

    @Test
    void testMultiplyPositiveNumbers() {
        assertEquals(12.0, Calculator.multiply(3.0, 4.0), DELTA);
    }

    @Test
    void testDividePositiveNumbers() {
        assertEquals(3.0, Calculator.divide(6.0, 2.0), DELTA);
    }

    // Error path: division by zero

    @Test
    void testDivideByZeroThrowsArithmeticException() {
        ArithmeticException exception = assertThrows(ArithmeticException.class,
                () -> Calculator.divide(10.0, 0.0));
        assertTrue(exception.getMessage().contains("Division by zero"));
    }

    // Edge case: negative numbers

    @Test
    void testAddNegativeNumbers() {
        assertEquals(0.7, Calculator.add(-2.5, 3.2), DELTA);
    }
}
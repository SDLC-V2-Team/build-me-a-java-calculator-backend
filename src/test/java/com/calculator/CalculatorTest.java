package com.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAdd() {
        assertEquals(5.0, Calculator.add(2, 3), 1e-9);
        assertEquals(-1.0, Calculator.add(2, -3), 1e-9);
    }

    @Test
    void testSubtract() {
        assertEquals(1.0, Calculator.subtract(4, 3), 1e-9);
        assertEquals(-5.0, Calculator.subtract(2, 7), 1e-9);
    }

    @Test
    void testMultiply() {
        assertEquals(15.0, Calculator.multiply(3, 5), 1e-9);
        assertEquals(0.0, Calculator.multiply(0, 100), 1e-9);
    }

    @Test
    void testDivide() {
        assertEquals(2.0, Calculator.divide(10, 5), 1e-9);
        assertEquals(-3.0, Calculator.divide(9, -3), 1e-9);
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> Calculator.divide(5, 0));
    }
}

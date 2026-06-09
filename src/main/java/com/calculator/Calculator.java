package com.calculator;

/**
 * Core arithmetic operations calculator.
 * All methods accept two double operands and return a double result.
 */
public class Calculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Performs division.
     *
     * @param a numerator
     * @param b denominator
     * @return result of division
     * @throws ArithmeticException if b is zero
     */
    public static double divide(double a, double b) {
        if (b == 0.0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
}

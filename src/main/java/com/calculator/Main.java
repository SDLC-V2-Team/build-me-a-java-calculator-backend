package com.calculator;

import java.util.Scanner;

/**
 * Console entry point for the calculator.
 * Reads expressions from standard input, evaluates them, and prints the result.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Java Console Calculator");
        System.out.println("Enter expressions in the form: operand operator operand (e.g., 2 + 3)");
        System.out.println("Type 'exit' to quit.");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("> ");
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                if (input.isEmpty()) {
                    continue;
                }

                String[] parts = input.split("\\s+");
                if (parts.length != 3) {
                    System.out.println("Invalid format. Use: operand operator operand");
                    continue;
                }

                double operand1;
                double operand2;
                try {
                    operand1 = Double.parseDouble(parts[0]);
                    operand2 = Double.parseDouble(parts[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Please enter numeric values.");
                    continue;
                }

                String operator = parts[1];
                double result;
                try {
                    switch (operator) {
                        case "+":
                            result = Calculator.add(operand1, operand2);
                            break;
                        case "-":
                            result = Calculator.subtract(operand1, operand2);
                            break;
                        case "*":
                            result = Calculator.multiply(operand1, operand2);
                            break;
                        case "/":
                            result = Calculator.divide(operand1, operand2);
                            break;
                        default:
                            System.out.println("Unknown operator '" + operator + "'. Use +, -, *, or /.");
                            continue;
                    }
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                    continue;
                }

                // Display result, avoid .0 for integers
                if (result == Math.floor(result) && !Double.isInfinite(result)) {
                    System.out.println((long) result);
                } else {
                    System.out.println(result);
                }
            }
        }

        System.out.println("Goodbye!");
    }
}

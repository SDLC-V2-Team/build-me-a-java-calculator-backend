# Java Console Calculator

A simple console-based calculator that performs basic arithmetic operations (addition, subtraction, multiplication, division) on two operands.

## Requirements
- Java 17 or later
- Maven 3.6+

## Build and Run
```bash
mvn clean package
java -jar target/console-calculator-1.0.0.jar
```

## Usage
Enter expressions in the format `operand operator operand`, e.g.:
- `2 + 3`
- `10 - 4`
- `5 * 6`
- `8 / 2`
- `exit` to quit

Division by zero will display an error message.

## Testing
```bash
mvn test
```
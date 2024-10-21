package Midterm_Practices;

public class CalculatorTest {
    public static void main(String[] args) {
        System.out.println("Static Addition: " + Calculator.add(5, 5));
        System.out.println("Static Subtraction: " + Calculator.subtract(15, 10));

        Calculator calc = new Calculator();
        System.out.println("Instance Multiplication: " + calc.multiply(10, 2));
        System.out.println("Instance Division: " + calc.divide(10, 0));

    }
}

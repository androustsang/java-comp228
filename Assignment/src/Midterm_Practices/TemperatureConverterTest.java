package Midterm_Practices;

import java.util.Scanner;

public class TemperatureConverterTest {

    public static void main(String[] args) {
        double celsius, fahrenheit;

        Scanner input = new Scanner(System.in); // To accept the argument from command line ***

        System.out.printf("Please enter the temperature in Celsius: ");
        celsius = input.nextDouble();
        fahrenheit = TemperatureConverter.celsiusToFahrenheit(celsius);
        System.out.println(celsius + " Celsius in Fahrenheit: " + fahrenheit);
//        System.out.printf("%f Celsius in Fahrenheit: %.2f%n", celsius, fahrenheit);

        System.out.printf("Please enter the temperature in Fahrenheit: ");
        fahrenheit = input.nextDouble();
        celsius = TemperatureConverter.farenheitToCelsius(fahrenheit);
        System.out.println(fahrenheit + " Fahrenheit in Celsius: " + celsius);
//        System.out.printf("%f Fahrenheit in Celsius: %.2f%n",fahrenheit, celsius);

    }
}

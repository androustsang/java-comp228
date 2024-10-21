package Midterm_Practices;

import java.util.Scanner;

public class TemperatureConverter {

    public static double celsiusToFahrenheit(double celsius) {

        return ((celsius * 9/5)+32);

    }

    public static double farenheitToCelsius(double farenheit) {

        return ((farenheit -32)* 5/9);

    }

}

package ch2;

import java.util.Scanner;

/**
 * Μετατρέπει βαθμούς Fahrenheit
 * σε βαθμούς Κελσίου
 */
public class TemperatureApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tempFahrenheit = 0;
        int tempCelsius = 0;

        System.out.println("Please insert temperature in Fahrenheit degrees (int)");
        tempFahrenheit = in.nextInt();

        tempCelsius = 5 * (tempFahrenheit - 32) / 9;

        System.out.printf("%d\u00B0 Fahrenheit degrees are equivalent to %d\u00B0 Celsius degrees\n", tempFahrenheit, tempCelsius);
    }
}
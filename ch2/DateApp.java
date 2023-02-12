package ch2;

import java.util.Scanner;

/**
 *
 */
public class DateApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int day = 0;
        int month = 0;
        int year = 0;

        System.out.println("Please insert day (int)");
        day = in.nextInt();
        System.out.println("Please insert month (int)");
        month = in.nextInt();
        System.out.println("Please insert year (int)");
        year = in.nextInt();

        System.out.printf("%02d/%02d/%02d", day, month, year);
    }
}

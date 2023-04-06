package ui;

import java.util.Locale;
import java.util.Scanner;

public class UserInput {

    private static Scanner scanner = new Scanner(System.in);

    public static void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }


    public static void displayHomeScreen() {

        {
            System.out.println();
            System.out.println("***************************************************");
            System.out.println("  Welcome to Traitor Joe's Paint Search Engine");
            System.out.println("***************************************************");
            System.out.println();
        }
    }

    public static String getSearchOption() {


        System.out.println();
        System.out.print("Please enter your search term here: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        return option;
    }


}


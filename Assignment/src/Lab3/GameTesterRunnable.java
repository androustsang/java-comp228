package Lab3;

import java.util.Scanner;

// Driver class
public class GameTesterRunnable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Superclass object is declared here.
        GameTester gt;
        double hours = 0;

        // Asking the user to enter the type of GameTester to be created
        System.out.println("Please input the type of Game Tester, key in \"F\" for Full-Time and \"P\" for Part-time:");
        String type = sc.nextLine();

        // Validating the input can only be "F" or "P"
        while (!type.equals("F") && !type.equals("P")) {
            System.out.println("Please enter a valid type (\"F\" for Full-Time or \"P\" for Part-time):");
            type = sc.nextLine();
        }

        // Asking the use to provide the Game Tester Name
        System.out.println("Please input the name of Game Tester: ");
        String name = sc.nextLine();

        // Assigning subclass objects to the superclass reference based on the input
        switch (type) {
            case "F":
                gt = new FullTimeGameTester(name);
                break;
            case "P":
                gt = new PartTimeGameTester(name);
                break;
            default:
                return;
        }

        // Based on the method of checking fullTimeStatus returned,
        // it will prompt to ask for number of hours if it's part-time game tester
        if (!gt.getFullTimeStatus()) {
            System.out.println("Please enter the number of hours for Part-Time Game Tester:");
            hours = sc.nextDouble();
        }

        // No matter which subclass object is created, we will print the information
        System.out.println();
        System.out.println("The Game Tester information is as follows:");
        System.out.printf("Game Test type: %s%n", gt.getFullTimeStatus() ? "Full Time" : "Part Time");
        System.out.printf("Game Tester Name: %s%n", gt.getName());
        System.out.printf("Game Tester Salary is: %.2f%n", gt.getSalary(hours));

    }
}

package Lab3;

import java.util.Scanner;

public class InsuracneRunnable {
    public static void main(String[] args) {

        // Array of objects of the Superclass
        Insurance[] insuranceArray;
        // Array storing the monthly cost during user input
        double[] monthlyCostArray;

        System.out.println("Please let us know how many insuraces you would like to input:");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        while (num <= 0) {
            System.out.println("Please let us know how many insuraces you would like to input:");
            num = sc.nextInt();
        }
        sc.nextLine(); //The leftover "\n" character from the sc.nextInt() is not consumed so additional sc.nextLine() here.

        // Initialize the array size
        insuranceArray = new Insurance[num];
        monthlyCostArray = new double[num];

        // Asking the user to input the insurance info
        for (int i = 0; i < num; i++) {

            // Asking the user what insurance type to input
            System.out.println("Please enter the insurace type as \"H\" for Health Or \"L\" for Life:");
            String insuranceType = sc.nextLine();

            // Loop to ensure that the user input for a valid insurance type
            while (!insuranceType.equals("H") && !insuranceType.equals("L")) {
                System.out.println("Please enter a valid insurance type (\"H\" for Health Or \"L\" for Life):");
                insuranceType = sc.nextLine();
            }

            // Asking the user to input the monthly cost
            System.out.println("Please enter the monthly cost:");
            double monthlyCost = sc.nextDouble();

            // Loop to ensure that the monthly cost is not negative
            while (monthlyCost < 0) {
                System.out.println("Please enter a valid monthly cost:");
                monthlyCost = sc.nextDouble();
            }


            if (insuranceType.equals("H")) {
                // Assigning the subclass "Health" object to the superclass "Insurance" in the array
                insuranceArray[i] = new Health();
            } else if (insuranceType.equals("L")) {
                // Assigning the subclass "Life" objectto the superclass "Insurance" in the array
                insuranceArray[i] = new Life();
            }
            monthlyCostArray[i] = monthlyCost;
        } // End of for-loop asking user input

        // Now calling the Screen Manager
        screenManager(insuranceArray, monthlyCostArray);

    }

    public static void screenManager (Insurance[] insuranceArray, double[] monthlyCostArray) {
    //screenManager takes an input of superclass array and a monthly cost array

        if (insuranceArray == null || monthlyCostArray == null) {
            System.out.println("Both the insurance array and monthly cost array cannot be null !");
            return;
        } else if (insuranceArray.length != monthlyCostArray.length) {
            System.out.println("The insurance array and monthly cost array does not match!");
            return;
        }

    // Loop the the Array for Insurance (Superclass)

        for (int i = 0; i < insuranceArray.length; i++) {
            System.out.printf("Insurance Info %d%n", i + 1);

            // Calling the setInsurance method for each object
            insuranceArray[i].setInsuranceCost(monthlyCostArray[i]);

            // Calling the displayInfo method for each object
            insuranceArray[i].displayInfo();
            System.out.println();
        }

        return;


    }

}

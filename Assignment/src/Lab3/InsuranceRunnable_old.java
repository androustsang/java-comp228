package Lab3;

import java.util.Scanner;

// Polymorphic behaviour is in the getUserInput() method during the subclass creation

public class InsuranceRunnable_old {
    public static void main(String[] args) {
        // Array of objects of the Superclass
        Insurance[] insuranceArry ;

        System.out.println("Please let us know how many insuraces you would like to input:");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        while (num <= 0) {
            System.out.println("Please let us know how many insuraces you would like to input:");
            num = sc.nextInt();
        }

        insuranceArry = new Insurance[num];

        for (int i = 0; i < num; i++) insuranceArry[i] = getUserInput();
    }


    public static Insurance getUserInput() {
        Scanner sc = new Scanner(System.in);

        // Declaring the object as superclass first
        Insurance insuranceObj = null ;

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
            // Subclass Object creation
            // Assigning the subclass "Health" to the superclass "Insurace" (defined in the beginning of the method)
            insuranceObj = new Health();

        } else if (insuranceType.equals("L")) {
            // Subclass Object creation
            // Assigning the subclass "Life" to the superclass "Insurace" (defined in the beginning of the method)
            insuranceObj = new Life();

        }

        insuranceObj.setInsuranceCost(monthlyCost);
        return   insuranceObj;

    }
}
package Lab3;

import java.util.Scanner;

// import the static constants from MortgageConstants
import static Lab3.MortgageConstants.SHORT_TERM;
import static Lab3.MortgageConstants.MEDIUM_TERM;
import static Lab3.MortgageConstants.LONG_TERM;

public class ProcessMortgage {
    public static void main(String[] args) {

        // Superclass array of size 3
        Mortgage[] mortgageArray = new Mortgage[3];

        // Get the prime rate first from the user
        System.out.println("Please input the current Prime Rate in ** Percentage ** (do not key in the symbol %):");
        Scanner sc = new Scanner(System.in);
        double primeRate = sc.nextDouble() / 100;
        sc.nextLine();
        System.out.println();

//        System.out.printf("Prime Rate: %.4f%n", primeRate);

        // Loop to ask the user for the 3 mortgages
        for (int i = 0; i < 3; i++) {
            System.out.printf("For Mortgage %d :%n", i + 1);
            System.out.println("Select the Mortgage Type by key in \"B\" for Business Mortgage or \"P\" for Personal Mortgage");
            String mortgageType = sc.nextLine();

            while (!mortgageType.equals("B") && !mortgageType.equals("P")) {
                System.out.println("Please enter a valid Mortgage Type (\"B\" for Business Mortgage or \"P\" for Personal Mortgage)");
                mortgageType = sc.nextLine();
            }

            // Continue to prompt for the rest of information
            System.out.println("Please input the Mortgage Number:");
            String mortgageNumber = sc.nextLine();

            System.out.println("Please input the Customer Name:");
            String customerName = sc.nextLine();

            System.out.println("Please input the Mortgage Amount:");
            int mortgageAmount = sc.nextInt();
            sc.nextLine();

            // Asking the user to input the Mortgage Term as S or M or L
            // for short-term, medium-term or long-term respectively.
            System.out.println("Please input the Mortgage Term. Key in \"S\" for short-term, \"M\" for Mid-term or \"L\" for Long term.");
            String mortgageTermText = sc.nextLine();

            while (!mortgageTermText.equals("S") && !mortgageTermText.equals("M") && !mortgageTermText.equals("L")) {
                System.out.println("Please enter a valid term input: (\"S\" for short-term, \"M\" for Mid-term or \"L\" for Long term)");
                mortgageTermText = sc.nextLine();
            }

            // Based on the input of S or M or L, set the term in integer accordingly
            int mortgageTerm = 0;
            switch (mortgageTermText) {
                case "S": mortgageTerm = SHORT_TERM; break;
                case "M": mortgageTerm = MEDIUM_TERM; break;
                case "L": mortgageTerm = LONG_TERM; break;
                default: mortgageTerm = SHORT_TERM; break;
            }

            try {
                if (mortgageType.equals("B")) {
                    mortgageArray[i] = new BusinessMortgage(mortgageNumber, customerName,mortgageAmount, primeRate, mortgageTerm);
                } else if (mortgageType.equals("P")) {
                    mortgageArray[i] = new PersonalMortgage(mortgageNumber, customerName,mortgageAmount, primeRate, mortgageTerm);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Please input again with valid data.");
                i--;
            }
        }

        // Loop through the Mortgage[] array to display the information
        for (Mortgage mortgage : mortgageArray) {
            if (mortgage != null) {
                mortgage.getMortgageInfo();
                System.out.println();
            }

        };
    }
}

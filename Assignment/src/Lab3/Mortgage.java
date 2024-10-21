package Lab3;

import java.util.Arrays;

public abstract class Mortgage implements MortgageConstants {
    String mortgageType;    // Mortgage type to be used in the subclass constructors
    String mortgageNumber;  // Mortgage Account Number
    String customerName; // Customer Name of the Mortgage
    int mortgageAmount; // Morgage Amount
    double interestRate; // Interest Rate
    int term; // The term

    //  In the Contructors, set value by using the corresponding setters
    // method to validate for mortgageAmount and term
//    public Mortgage(String mortgageType, String mortgageNumber, String customerName, int mortgageAmount, double interestRate, int term) {
//    public Mortgage(String mortgageNumber, String customerName, int mortgageAmount, double interestRate, int term) {
    public Mortgage(String mortgageNumber, String customerName, int mortgageAmount, int term) {
//        this.mortgageType = mortgageType;
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
//        this.interestRate = interestRate;
        setMortgageAmount(mortgageAmount);
        setTerm(term);
    }

    // To print out all the fields in the object
    public void getMortgageInfo() {
        System.out.println("Mortgage Type: " + mortgageType);
        System.out.println("Mortgage Number: " + mortgageNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Mortgage Amount: " + mortgageAmount);
//        System.out.println("Interest Rate: " + interestRate);
        System.out.printf("Interest Rate: %.2f%%%n", interestRate * 100);
        System.out.println("Term: " + term + " Years");
    }

    // Perform the validation of Mortgage Amount not exceeding the
    // MAX_MORTGAGE_AMT at the setters method
    public void setMortgageAmount(int mortgageAmount) {
        if (mortgageAmount < 0 || mortgageAmount > MAX_MORTGAGE_AMT) {
            throw new IllegalArgumentException("Mortgage amount must be between 0 and " + MAX_MORTGAGE_AMT);
        }
        this.mortgageAmount = mortgageAmount;
    }

    // Perform the validation of the Mortgage Term at the setter method
    // to ensure that it is one of the defined term in the interface
    public void setTerm (int term) {
        // if the mortgage term does not belong to one of the values in the array
        // MORTGAGE_TERM_ALLOWED, namely SHORT, MEDIUM or LONG,
        // change the term by SHORT as the default

        // Loop to check the array values
        boolean isTermAllowed = false;
        for (int tmpMortgageTerm : MORTGAGE_TERM_ALLOWED) {
            if (tmpMortgageTerm == term) {
                isTermAllowed = true;
//                System.out.println("Valid term of " + term + " years");
            }
        }

        // if the term is in the allowed array, set it accordingly
        // else we change the term to short term
        if (isTermAllowed) {
            this.term = term;
        } else {
            this.term = SHORT_TERM;
        }
    }

}

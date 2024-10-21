package Lab3;

public class PersonalMortgage extends Mortgage{


    // Constructor for the subclass - PersonalMortgage
    public PersonalMortgage(String mortgageNumber, String customerName, int mortgageAmount, double interestRate, int term) {

        // Use superclass constructor to creat the object
        super(mortgageNumber, customerName, mortgageAmount, term);

        // Set the mortgageType as "Personal Mortgage" in the constructor
        this.mortgageType = "Personal Mortgage";

        // Calculate the corresponding Interest Rate for the Personal  Mortgage
        this.interestRate = calcInterestRate(interestRate);
    }

    // Business logic is set here.
    // Calculate the Mortgage Interest Rate for the Personal Mortgage
    public double calcInterestRate(double interestRate) {

        // For Personal Mortgage, the interest rate is 2% over current prime rate
        return interestRate + 0.02;
    }
}

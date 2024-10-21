package Lab3;

public class BusinessMortgage extends Mortgage {

    // Constructor for the subclass - BusinessMortgage
    public BusinessMortgage(String mortgageNumber, String customerName, int mortgageAmount, double interestRate, int term) {

        // Use superclass constructor to creat the object
        super(mortgageNumber, customerName, mortgageAmount, term);

        // Set the mortgageType as "Business Mortgage" in the constructor
        this.mortgageType = "Business Mortgage";

        // Calculate the corresponding Interest Rate for the Business Mortage
        this.interestRate = calcInterestRate(interestRate);
    }

    // Business logic is set here.
    // Calculate the Mortgage Interest Rate for the Business Mortgage
    public double calcInterestRate(double interestRate) {

        // For Business Mortgage, the interest rate is 1% over current prime rate
        return interestRate + 0.01 ;

    }
}

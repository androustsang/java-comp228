package Lab3;

// Abstract class - Superclass of the Health and Life subclass

public abstract class Insurance {
    String insuranceType;
    double monthlyCost;

    // Abstract Methods of setInsuranceCost and displayInfo
    public abstract void setInsuranceCost (double monthlyCost);
    public abstract void displayInfo() ;

    // Getters for the instance variables
    public double getMonthlyCost() {
        return monthlyCost;
    }

    public String getInsuranceType() {
        return insuranceType;
    }



}

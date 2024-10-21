package Lab3;

// Subclass Life of superclass Insurance
public class Life extends Insurance {

    public Life() {
        // Set the insuranceType varaible to be "Life" for this subclass
        this.insuranceType = "Life";
    }

    @Override
    public void setInsuranceCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Insurance Type: %s%nMonthly Cost: %.2f%n", insuranceType, monthlyCost);
    }
}

package Lab3;

// Subclass FullTimeGameTester from the superclass GameTester
public class FullTimeGameTester extends GameTester {

    // Declare and set the value of the base salary of Full-Time Game Tester
    private double fullTimeSalary = 3000;

    // Constructor of the object using Superclass constructor
    public FullTimeGameTester(String name) {
            super(name);
            this.fullTimeStatus = true; // Set the fullTimeStatus to true upon creation
    }

//  getFullTimeStatus is defined in the superclass
//    public boolean getFullTimeStatus() {
//        return fullTimeStatus;
//    }

    // Override the superclass abstract method of getSalary
    @Override
    public double getSalary(double numHours) {
        return fullTimeSalary;
    }
}

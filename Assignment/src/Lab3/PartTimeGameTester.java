package Lab3;

// Subclass PartTimeGameTester from the superclass GameTester
public class PartTimeGameTester extends GameTester{

    // Declare and set the hourly rate of Part-Time Game Tester
    private double hourlySalaryRate = 20;

    // Constructor of the object using Superclass constructor
    public PartTimeGameTester(String name) {
        super(name);
        this.fullTimeStatus = false; // Set the fullTimeStatus to false upon creation
    }

//  getFullTimeStatus is defined in the superclass
//    public boolean getFullTimeStatus() {
//        return fullTimeStatus;
//    }

    // Override the superclass abstract method of getSalary
    @Override
    public double getSalary(double numHours) {
        // Return the
        return numHours * hourlySalaryRate;
    }
}

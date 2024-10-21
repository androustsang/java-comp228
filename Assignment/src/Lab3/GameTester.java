package Lab3;

// Abstract class as GameTester
abstract class GameTester {
    String name;
    Boolean fullTimeStatus;

    // Constructor for the GameTester superclass
    // It will be used by the subclass
    public GameTester(String name) {
        this.name = name;
    }

    // Method to return the GameTester superclass
    public String getName() {
        return name;
    }

    // Method to return the boolean value of fullTimeStatus
    public boolean getFullTimeStatus() {
        return fullTimeStatus;
    }

    // Two abstract methods and the first one, getSalary is required in the assignment
    public abstract double getSalary(double numHours);

    //    public abstract boolean getFullTimeStatus();
}

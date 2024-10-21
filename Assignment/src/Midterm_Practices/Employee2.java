package Midterm_Practices;

public class Employee2 extends Person2 {
    private double salary;

    public Employee2(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    @Override
    public void displayInfo() {
//        System.out.printf("Name: %s%nAge: %d%n%Salary: %.2f%n", name, age, salary);
        super.displayInfo();
        System.out.println("Salary: " + salary);
    }
}

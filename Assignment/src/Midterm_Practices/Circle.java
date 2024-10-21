package Midterm_Practices;

public class Circle {
    private double radius;

    public Circle() {
        this.radius = 0.0;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculateCicrumference() {
        return 2 * Math.PI * radius;
    }
}

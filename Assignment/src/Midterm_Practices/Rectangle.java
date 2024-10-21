package Midterm_Practices;

public class Rectangle {
    private double width;
    private double height;

    // Constructors
    public Rectangle() {
        this.width = 0;
        this.height = 0;
    }

    public void setWidthHeight(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void calculateArea() {
        System.out.printf("Area: %.1f\n", this.width * this.height);

    }

    public void calculatePerimeter() {
        System.out.printf("Perimeter: %.1f\n", (this.width + this.height) * 2);

    }


}

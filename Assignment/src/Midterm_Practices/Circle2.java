package Midterm_Practices;

public class Circle2 extends Shape {
    private double radius;

    public Circle2(double radius) {
        this.radius = radius;
    }

    @Override
    public void area () {
        System.out.println("Circle area: " + (Math.PI * Math.pow(radius, 2)));
    }

    @Override
    public void perimeter () {
        System.out.println("Circle perimeter: " + (2 * Math.PI * radius));
    }
}

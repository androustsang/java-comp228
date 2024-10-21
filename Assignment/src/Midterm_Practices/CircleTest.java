package Midterm_Practices;

public class CircleTest {

    public static void main(String[] args) {

        Circle c = new Circle();
        c.setRadius(3);

        System.out.printf("Area: %.2f%n",c.calculateArea());
        System.out.printf("Circumference: %.2f%n", c.calculateCicrumference());
    }


}

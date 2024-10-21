package Midterm_Practices;

public class Rectangle2 extends Shape{

    private double width;
    private double height;


    public Rectangle2(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void area() {
        System.out.println("Rectangle area: " + (width * height));
    }

    @Override
    public void perimeter() {
        System.out.println("Rectangle Perimeter: " + ((width + height)*2) );
    }

}

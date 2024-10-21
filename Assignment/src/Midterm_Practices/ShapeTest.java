package Midterm_Practices;

public class ShapeTest {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle2(4.0, 5.0);
        Shape circle = new Circle2(3.0);

        Shape[] arry = new Shape[2];

        arry[0] = rectangle;
        arry[1] = circle;
        for (Shape shape : arry) {
            shape.area();
            shape.perimeter();
        }
    }
}






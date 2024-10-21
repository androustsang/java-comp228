package Midterm_Practices;

import org.w3c.dom.css.Rect;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidthHeight(4.0, 5.0);

        rectangle.calculateArea();
        rectangle.calculatePerimeter();
    }
}

package ss7_abstract_class_and_interface.bai_tap.interface_resizeable;

import java.util.Random;

public class RectangleTest {
    public static void main(String[] args) {
//        abstract_interface.demo.Rectangle rectangle = new abstract_interface.demo.Rectangle();
//        System.out.println(rectangle);
//
//        rectangle = new abstract_interface.demo.Rectangle(2.3, 5.8);
//        System.out.println(rectangle);
//
//        rectangle = new abstract_interface.demo.Rectangle(2.5, 3.8, "orange", true);
//        System.out.println(rectangle);
        Random random = new Random();
        Rectangle[] rectangles = new Rectangle[20];
        int length = rectangles.length;
        // init array rectangles
        for (int i = 0; i < length; i++) {
            rectangles[i] = new Rectangle(10,10);
        }
        // resize
        for (int i = 0; i < length; i++) {
            System.out.println("=======================================================");
            System.out.println("Rectangle " + (i + 1) + " :");
            System.out.println("Area before resize: " + rectangles[i].getArea());
            int percent = (int)(random.nextDouble() * 100);
            System.out.println("Percent: " + percent);
            rectangles[i].resize(percent);
            System.out.println("Area after resize: " + rectangles[i].getArea());
        }
    }
}

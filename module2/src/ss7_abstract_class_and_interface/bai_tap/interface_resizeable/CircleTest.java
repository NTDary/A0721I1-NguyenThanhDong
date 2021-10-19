package ss7_abstract_class_and_interface.bai_tap.interface_resizeable;

import java.util.Random;

public class CircleTest {
    public static void main(String[] args) {
//        Circle circle = new Circle();
//        System.out.println(circle);
//
//        circle = new Circle(3.5);
//        System.out.println(circle);
//
//        circle = new Circle(10, "indigo", false);
//        System.out.println(circle);
//
//        circle.resize(75);
//        System.out.println(circle);
        Random random = new Random();
        Circle[] circles = new Circle[20];
        int length = circles.length;
        // init array circle
        for (int i = 0; i < length; i++) {
            circles[i] = new Circle(10);
        }
        // resize
        for (int i = 0; i < length; i++) {
            System.out.println("=======================================================");
            System.out.println("Circle " + (i + 1) + " :");
            System.out.println("Area before resize: " + circles[i].getArea());
            int percent = (int)(random.nextDouble() * 100);
            System.out.println("Percent: " + percent);
            circles[i].resize(percent);
            System.out.println("Area after resize: " + circles[i].getArea());
        }
    }
}

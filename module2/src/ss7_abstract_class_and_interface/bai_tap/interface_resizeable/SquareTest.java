package ss7_abstract_class_and_interface.bai_tap.interface_resizeable;

import java.util.Random;

public class SquareTest {
    public static void main(String[] args) {
        Random random = new Random();
        Square[] squares = new Square[20];
        int length = squares.length;
        // init array squares
        for (int i = 0; i < length; i++) {
            squares[i] = new Square(10);
        }
        // resize
        for (int i = 0; i < length; i++) {
            System.out.println("=======================================================");
            System.out.println("Square " + (i + 1) + " :");
            System.out.println("Area before resize: " + squares[i].getArea());
            int percent = (int)(random.nextDouble() * 100);
            System.out.println("Percent: " + percent);
            squares[i].resize(percent);
            System.out.println("Area after resize: " + squares[i].getArea());
        }
    }
}

package ss4_class_object.bai_tap.phuong_trinh_bac_hai;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Input a , b , c
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the a:");
        double a = scanner.nextDouble();
        System.out.print("Enter the b:");
        double b = scanner.nextDouble();
        System.out.print("Enter the c:");
        double c = scanner.nextDouble();

        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);

        if (quadraticEquation.getDiscriminant() > 0) {
            System.out.println("The quadratic has two roots " + quadraticEquation.getRoot1() +
                    " and " + quadraticEquation.getRoot2());
        } else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("The quadratic has one roots " + quadraticEquation.getRoot1());
        } else {
            System.out.println("The equation has no real roots");
        }
    }
}

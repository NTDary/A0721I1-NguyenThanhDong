package ss6_ke_thua.bai_tap.triangle;

import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Khai bao do dai 3 canh tam giac
        double a, b, c;
        String color = "";

        do {
            System.out.print("Nhap vao color tam giac: ");
            color = sc.nextLine();
            System.out.print("Nhap vao canh thu nhat: ");
            a = sc.nextDouble();
            System.out.print("Nhap vao canh thu hai: ");
            b = sc.nextDouble();
            System.out.print("Nhap vao canh thu ba: ");
            c = sc.nextDouble();

            if (a + b <= c || a + c <= b || b + c <= a) {
                System.out.println("Khong thoa man canh tam giac. Hay nhap lai!");
            }
        } while (a + b <= c || a + c <= b || b + c <= a);

        Triangle triangle = new Triangle(a, b, c, color);

        System.out.println("Thong tin tam giac la:");
        System.out.println(triangle);

    }
}


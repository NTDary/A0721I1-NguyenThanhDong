package ss3_array_va_method.bai_tap;

import java.util.Scanner;


public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        int size = 10;
        int n = 5;
        int[] array = new int[size];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;

        System.out.println(array.length);
        int choose;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Choose menu:");
            System.out.println("1. Add value");
            System.out.println("0. Exit");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Input value into array: ");
                    int newValue = sc.nextInt();
                    System.out.println("Choose index in array: ");
                    int setIndex = sc.nextInt();

                    //Kiem tra trong pham vi cua mang
                    if (setIndex < 0 || setIndex > array.length - 1) {
                        System.out.println("Cant add value into array");
                        return;
                    } else {

                        //Hien thi mang truoc khi chen
                        System.out.println("Mang truoc:");
                        for (int i = 0; i < array.length; i++) {
                            System.out.print(array[i] + " ");
                        }
                        if (n >= size) {
                            System.out.println("\n Cant add value - Maximum");
                            return;
                        }
                        //Chen gia tri vao mang
                        for (int i = array.length - 1; i > setIndex; i--) {
                            array[i] = array[i - 1];
                        }
                        array[setIndex] = newValue;
                        n++;
                        System.out.print("\n" + n);
                        //Hien thi mang sau khi chen
                        System.out.println("\n Mang sau:");
                        for (int i = 0; i < array.length; i++) {
                            System.out.print(array[i] + " ");
                        }
                    }
                    break;
                case 0:
                    System.out.println("Exit");
                    System.exit(0);
                default:
                    System.out.println("You don't choose.");
            }
        } while (choose != 0);

    }

}

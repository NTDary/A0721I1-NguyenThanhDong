package ss3_array_va_method.bai_tap;

import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        int[] array1 = new int[5];
        int[] array2 = new int[5];


        //Cách gọi thông qua object
//        GopMang gopMang = new GopMang();
//        gopMang.inputArray(array1);

        inputArray(array1);
        System.out.println("Array1: ");
        outputArray(array1);

        inputArray(array2);
        System.out.println("\nArray2: ");
        outputArray(array2);

        System.out.println("\nGop mang");
        outputArray(concatArray(array1, array2));


    }

    public static void inputArray(int[] array) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.println("\nInput value array - index: " + i);
            array[i] = sc.nextInt();
        }
    }

    public static void outputArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    public static int[] concatArray(int[] array1, int[] array2) {
        int[] array3 = new int[array1.length + array2.length];

        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }
        int temp = 0;
        for (int i = array1.length; i < array3.length; i++) {
            array3[i] = array2[temp];
            temp++;
        }
        return array3;
    }

}

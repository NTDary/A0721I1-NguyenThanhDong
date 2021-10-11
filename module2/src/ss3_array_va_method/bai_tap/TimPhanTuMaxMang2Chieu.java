package ss3_array_va_method.bai_tap;

import java.util.Scanner;

public class TimPhanTuMaxMang2Chieu {
    public static void main(String[] args) {
        int height, width;
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập chiều cao của ma trận");
        height = sc.nextInt();
        System.out.println("Nhập chiều dài của ma trận");
        width = sc.nextInt();

        int[][] myArray = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.println("Nhập giá trị tại vị trí myArray[" + i + "][" + j + "]");
                myArray[i][j] = sc.nextInt();
            }
        }
        outputArray(myArray, height, width);
        System.out.println();
        maxValueArray(myArray, height, width);

    }

    public static void outputArray(int[][] array, int height, int width) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    public static void maxValueArray(int[][] array, int height, int weight) {
        int max = array[0][0];
        String position = "";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                    position = "dòng thứ: " + (Integer.parseInt("1") + i) + " cột thứ: " + (Integer.parseInt("1") + j);
                }
            }
        }
        System.out.print("Giá trị lớn nhất là: " + max + " tại " + position);
    }


}

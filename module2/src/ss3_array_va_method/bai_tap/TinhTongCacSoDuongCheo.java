package ss3_array_va_method.bai_tap;

import java.util.Scanner;

//[*Bài tập] Mảng hai chiều - tính tổng các số ở đường chéo chính của ma trận
public class TinhTongCacSoDuongCheo {
    public static void main(String[] args) {
        int col, row;
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập chiều cao của ma trận");
        row = sc.nextInt();
        System.out.println("Nhập chiều dài của ma trận");
        col = sc.nextInt();

        int[][] myArray = new int[row][col];

        //Nhập mảng 2 chiều vuông
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Nhập giá trị tại vị trí myArray[" + i + "][" + j + "]");
                myArray[i][j] = sc.nextInt();
            }
        }

        //Xuất mảng đã nhập
        System.out.println("Mảng đã nhập:");
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                System.out.print(myArray[i][j] + "\t");
            }
            System.out.println();
        }

        //Tính tổng các số đường chéo
        int sumDuongCheo1 = 0;
        int sumDuongCheo2 = 0;
        int temp = myArray.length-1;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray.length; j++) {
                if(i == j){
                    sumDuongCheo1 += myArray[i][j];
                }
            }
            sumDuongCheo2 += myArray[i][temp];
            temp--;
        }
        System.out.println("Tổng giá trị của đường chéo 1: " + sumDuongCheo1);
        System.out.println("Tổng giá trị của đường chéo 2: " + sumDuongCheo2);
    }
}

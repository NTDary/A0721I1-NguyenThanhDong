package ss3_array_va_method.bai_tap;

import java.util.Scanner;

//[*Bài tập] Tính tổng các số ở một cột xác định
public class TinhTongCacSoOCotXacDinh {
    public static void main(String[] args) {
        int col, row;
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập chiều cao của ma trận");
        row = sc.nextInt();
        System.out.println("Nhập chiều dài của ma trận");
        col = sc.nextInt();

        int[][] myArray = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Nhập giá trị tại vị trí myArray[" + i + "][" + j + "]");
                myArray[i][j] = sc.nextInt();
            }
        }
        System.out.println("Mảng đã nhập:");
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                System.out.print(myArray[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Nhập số cột cần tính tổng");
        int chooseCol = sc.nextInt();
        int sumCol = 0;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                if (j == chooseCol - 1) {
                    sumCol += myArray[i][j];
                }
            }
        }
        System.out.println("Tổng các số ở cột " + chooseCol + " là: " + sumCol);

    }

}

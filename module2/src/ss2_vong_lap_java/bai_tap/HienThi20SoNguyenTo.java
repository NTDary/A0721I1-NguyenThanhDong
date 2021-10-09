package ss2_vong_lap_java.bai_tap;

import java.util.Scanner;

public class HienThi20SoNguyenTo {
    public static void main(String[] args) {
        int numbers;
        int n = 2;
        Scanner sc = new Scanner(System.in);

        //Nhap vao so luong so nguyen to
        System.out.println("Nhập vào số lượng SNT cần xuất ra: ");
        numbers = sc.nextInt();

        for (int count = 0; count < numbers; ) {
            if (findSNT(n)) {
                count++;
                System.out.print(n + " ");
            }
            n++;
        }
    }

    public static boolean findSNT(int n) {
        int temp = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                temp++;
            }
        }
        if (temp == 2) {
            return true;
        } else {
            return false;
        }
    }
}

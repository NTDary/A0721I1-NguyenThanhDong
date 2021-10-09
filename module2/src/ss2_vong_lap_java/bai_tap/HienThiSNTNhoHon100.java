package ss2_vong_lap_java.bai_tap;

public class HienThiSNTNhoHon100 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (findSNT(i)) {
                System.out.print(i + " ");
            }
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

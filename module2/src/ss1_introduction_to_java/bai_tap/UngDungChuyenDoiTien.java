package ss1_introduction_to_java.bai_tap;
import java.util.Scanner;
public class UngDungChuyenDoiTien {
    public static void main(String[] args) {
        int rate = 23000;
        int USD;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tiền USD: ");
        USD = scanner.nextInt();
        int changeVND = USD * rate;
        System.out.println("Giá đổi "+ USD +" USD ra VND là: "+ changeVND);
    }
}

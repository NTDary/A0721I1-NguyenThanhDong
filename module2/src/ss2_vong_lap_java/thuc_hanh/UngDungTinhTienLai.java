package ss2_vong_lap_java.thuc_hanh;
import java.util.Scanner;

public class UngDungTinhTienLai {
    public static void main(String[] args) {
        double money =1.0, interestRate = 1.0;
        int month = 1;
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap so tien: ");
        money = sc.nextDouble();
        System.out.println("Nhap so thang gui: ");
        month = sc.nextInt();
        System.out.println("Nhap lai suat");
        interestRate = sc.nextDouble();
        double totalInterest = 0;
        for(int i = 0; i < month; i++){
            totalInterest += money * (interestRate/100)/12 * month;
        }
        System.out.println("Lai Suat la: " + totalInterest);
    }
}

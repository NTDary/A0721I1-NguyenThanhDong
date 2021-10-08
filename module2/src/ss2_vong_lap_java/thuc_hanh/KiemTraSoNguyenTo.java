package ss2_vong_lap_java.thuc_hanh;
import java.util.Scanner;

public class KiemTraSoNguyenTo {
    public static void main(String[] args) {
        int number, count = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số: ");
        number = sc.nextInt();
        System.out.println(number);

        for(int i=1; i <= number; i++){
            if(number%i == 0){
                count++;
            }
        }
        if(count == 2){
            System.out.println(number + " là số nguyên tố");
        }else{
            System.out.println(number + " không là số nguyên tố");
        }
    }
}

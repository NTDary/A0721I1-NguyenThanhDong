package ss3_array_va_method.bai_tap;
import java.util.Scanner;

//[*Bài tập] Đếm số lần xuất hiện của ký tự trong chuỗi
public class DemSoLanKiTuTrongChuoi {


    public static void main(String[] args) {
        String myString = "codegym danang";
        int count = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào ký tự muốn đềm số lần xuất hiện:");

        char character = sc.next().charAt(0);

        System.out.println(character);


        for(int i=0; i < myString.length(); i++){
            if (myString.charAt(i) == character) {
                count++;
            }
        }
        System.out.println("Ký tự "+ character+" có số lần xuất hiện là: "+count);


    }

}

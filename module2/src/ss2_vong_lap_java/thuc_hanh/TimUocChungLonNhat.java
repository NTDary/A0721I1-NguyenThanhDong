package ss2_vong_lap_java.thuc_hanh;
import java.util.Scanner;

public class TimUocChungLonNhat {
    public static void main(String[] args) {
        int a,b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so a: ");
        a = sc.nextInt();
        System.out.println("Nhap so b: ");
        b = sc.nextInt();

        //Trả về giá trị tuyệt đối của a và b
        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0 || b == 0) {
            System.out.println("No greatest common factor");
        }
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }

        System.out.println("Greatest common factor: " + a);
    }
}

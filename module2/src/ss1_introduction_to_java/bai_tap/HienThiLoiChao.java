package ss1_introduction_to_java.bai_tap;
import java.util.Scanner;

public class HienThiLoiChao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter your name:");
        String getName;
        getName = scanner.nextLine();
        System.out.printf("Hello: "+ getName);

    }
}

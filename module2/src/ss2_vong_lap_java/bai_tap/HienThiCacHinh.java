package ss2_vong_lap_java.bai_tap;
import java.util.Scanner;
public class HienThiCacHinh {
    public static void main(String[] args) {
        int choose = 0;
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle " +
                "(The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
        System.out.println("3. Print isosceles triangle");
        System.out.println("4. Exit");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Choose: ");
        choose = sc.nextInt();
        switch (choose){
            case 1:
                for(int i=0; i <4; i++){
                    for(int j=0; j<4; j++){
                        System.out.print("*  ");
                    }
                    System.out.print("\n");
                }
                break;
            case 2:
                for(int i=1; i<6; i++){
                    for(int j=0; j<i; j++){
                        System.out.print("*  ");
                    }
                    System.out.println("");
                }
                break;
            case 3:
                for(int i=5; i>0; i--){
                    for(int j=0; j<i;j++){
                        System.out.print("*  ");
                    }
                    System.out.print("\n");
                }
                break;
            case 4:
                System.out.print("Exit");
                System.exit(0);
                break;
            default:
                System.out.print("you dont choose");
        }
    }
}

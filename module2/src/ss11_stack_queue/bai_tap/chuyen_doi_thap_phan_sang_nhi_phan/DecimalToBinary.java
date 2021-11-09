package ss11_stack_queue.bai_tap.chuyen_doi_thap_phan_sang_nhi_phan;

import java.util.Stack;
import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lựa chọn chuyển đổi");
        System.out.println("1. Thập phân - Nhị phân");
        System.out.println("2. Nhị phân - Thập phân");
        int choose = scanner.nextInt();
        switch (choose){
            case 1:
                System.out.println("Nhập số thập phân");
                int decimal = scanner.nextInt();
                decimalToBinary(myStack, decimal);
                break;
            case 2:
                System.out.println("Nhập số nhị phân");
                int binary = scanner.nextInt();
                binaryTodecimal(myStack, binary);
                break;
            default:
                System.out.println("Bạn không chọn");
        }





    }

    public static void decimalToBinary(Stack<Integer> myStack, int decimal) {
        String kq = "";
        while (decimal != 0) {
            myStack.push(decimal % 2);
            decimal /= 2;
        }
        while (!myStack.isEmpty()) {
            kq += myStack.pop();
        }
        System.out.print("Kết quả chuyển đổi sang Nhị Phân: " + kq);
    }

    public static void binaryTodecimal(Stack<Integer> myStack, int binary) {
        int kq = 0;
        while (binary > 0) {
            myStack.push(binary % 10);
            binary /= 10;
        }
        while (!myStack.isEmpty()) {
            for (int i = myStack.size() - 1; i >= 0; i--) {
                kq += myStack.pop() * Math.pow(2, i);
            }
            System.out.print("Kết quả chuyển đổi sang Thập Phân: " +kq);
            //System.out.printf(" %d", myStack.pop());
        }
    }
}

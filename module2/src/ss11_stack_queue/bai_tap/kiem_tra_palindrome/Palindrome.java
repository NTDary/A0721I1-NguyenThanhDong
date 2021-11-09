package ss11_stack_queue.bai_tap.kiem_tra_palindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Queue myLinkedList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào một chuỗi");
        String myStr = scanner.nextLine();

        checkPalindrome(myLinkedList, myStr);

    }

    public static void checkPalindrome(Queue myLinkedList, String myStr) {
        for (int i = myStr.length() - 1; i >= 0; i--) {
            myLinkedList.add(myStr.charAt(i));
        }
        String temp = "";
        while (!myLinkedList.isEmpty()) {
            temp += myLinkedList.remove();
        }
        if (myStr.equals(temp))
            System.out.println("Là Palindrome");
        System.out.println("Không phải là Palindrome");

    }
}

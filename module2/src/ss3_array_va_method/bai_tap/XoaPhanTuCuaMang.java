package ss3_array_va_method.bai_tap;

import java.util.Scanner;

public class XoaPhanTuCuaMang {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 5, 6, 7, 8, 9, 10};
        int x, choose;
        //x = 3
        //{1, 2, 3, 3, 5, 6, 7, 8, 9, 10}
        //{1, 2, 3, 5, 6, 7, 8, 9, 10, 0}
        //Nhập phần tử cần xóa
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("1. Delete value in array: ");
            System.out.println("0. Exit ");
            choose = input.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Input value you want delete ");
                    x = input.nextInt();

                    //Xóa phần tử trong mảng
                    for(int i=0; i < array.length; i++){
                        if(x == array[i]){
                            int count = i;
                            for(int j = i ; j < array.length ; j++){
                                if(j != array.length - 1){
                                    array[j] = array[count + 1];
                                    count++;
                                }else{
                                    array[j] = 0;
                                }
                            }
                            i--;
                        }
                    }
                    //In ra các phần tử trong mảng
                    for (int i = 0; i < array.length; i++) {
                        System.out.print(array[i] + " ");
                    }
                    System.out.println("\n");
                    break;
                case 2:
                    System.out.print("Exit");
                    System.exit(0);
                default:
                    System.out.println("You Dont Choose");
            }
        } while (choose != 0);

    }
    public static void test(){
        System.out.println("check");
    }
}

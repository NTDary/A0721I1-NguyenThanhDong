package ss3_array_va_method.bai_tap;
import java.util.Scanner;
public class TImPhanTuNhoNhat {
    public static void main(String[] args) {
        int n;
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử của mảng");
        n = sc.nextInt();
        int[] myArray = new int[n];

        for(int i=0; i<myArray.length; i++){
            System.out.println("Nhập phần tử tại vị trí thứ "+ i);
            myArray[i] = sc.nextInt();
        }
        int minValue = myArray[0];
        int position = 0;
        for(int j=1; j<myArray.length;j++){
            if(minValue > myArray[j]){
                minValue = myArray[j];
                position = j + 1;
            }
        }
        System.out.println("Phần tử nhỏ nhất trong mảng là: " + minValue + " tại vị trí thứ "+ position);
    }
}

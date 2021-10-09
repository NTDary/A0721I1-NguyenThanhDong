package ss3_array_va_method.thuc_hanh;
import java.util.Scanner;

//[Thực hành] Tìm giá trị nhỏ nhất trong mảng sử dụng phương thức
public class TimGiaTriNhoNhat {
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 1, 6, 9};
        int index = minValue(arr);
        System.out.println("The smallest element in the array is: " + arr[index] + " and position in index is " + index);
    }

    //Sử dụng phép lặp để duyệt mảng và trả về index của phần tử có giá trị nhỏ nhất trong mảng ta có đoạn code như sau:
    public static int minValue(int[] array){
        int index = 0;
        for (int i = 1;i<array.length;i++){
            if(array[i]<array[index]){
                index = i;
            }
        }
        return index;
    }
}

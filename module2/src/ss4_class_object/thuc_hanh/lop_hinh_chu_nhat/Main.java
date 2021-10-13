package ss4_class_object.thuc_hanh.lop_hinh_chu_nhat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Input width , height
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the width:");
        double width = scanner.nextDouble();
        System.out.print("Enter the height:");
        double height = scanner.nextDouble();

        //Khởi tạo biến đối tượng rectangle từ tối tượng Rectangle
        Rectangle rectangle = new Rectangle(width,height);

        //Gọi các phương thức của lớp Rectangle thông qua đối tượng rectangle đã tạo
        //để hiển thị các thông số của hình chữ nhật
        System.out.println("Your Rectangle \n"+ rectangle.display());
        System.out.println("Perimeter of the Rectangle: "+ rectangle.getPerimeter());
        System.out.println("Area of the Rectangle: "+ rectangle.getArea());



    }
}

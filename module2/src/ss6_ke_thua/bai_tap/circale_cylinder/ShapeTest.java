package ss6_ke_thua.bai_tap.circale_cylinder;

import ss6_ke_thua.thuc_hanh.he_cac_doi_tuong_hinh_hoc.Square;

public class ShapeTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(3); //? : giá trị được set nằm trong biến circle. *có thể sử dụng static
        circle.setColor("white"); //?

        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder); // cylinder kế thừa circle, khi in ra giá trị đã set ở circle thì không có sự thay đổi
        System.out.println(circle);  //?

        cylinder = new Cylinder(2.3);
        System.out.println(cylinder);

        cylinder = new Cylinder(5.8, "yellow" , 10);
        System.out.println(cylinder);
    }
}

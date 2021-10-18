package ss6_ke_thua.bai_tap.point2d_point3d;

public class PointTest {
    public static void main(String[] args) {

        //test Point2D
        Point2D point2D = new Point2D(); //default
        System.out.println(point2D);

        point2D = new Point2D(3, 4);
        System.out.println(point2D);


        //test Point3D
        Point3D point3D = new Point3D();//default
        System.out.println(point3D);
        point3D = new Point3D(4, 5, 7);
        System.out.println(point3D.toString());

    }
}

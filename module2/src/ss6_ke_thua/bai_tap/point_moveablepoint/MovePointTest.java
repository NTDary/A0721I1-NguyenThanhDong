package ss6_ke_thua.bai_tap.point_moveablepoint;

public class MovePointTest {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);

        point = new Point(2,3);
        System.out.println(point);

        MoveablePoint moveablePoint = new MoveablePoint();
        System.out.println(moveablePoint);

        moveablePoint = new MoveablePoint(2,4,6,6);
        System.out.println(moveablePoint);

        moveablePoint.move();
        System.out.println(moveablePoint);



    }
}

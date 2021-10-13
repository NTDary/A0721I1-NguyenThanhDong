package ss4_class_object.bai_tap.xay_dung_lop_fan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int slow = 1;
        int medium = 2;
        int fast = 3;
        boolean on = true;
        boolean off = false;


        //Khai báo đối tượng fan1
        Fan fan1 = new Fan();
        fan1.setOn(on);
        fan1.setSpeed(fast);
        fan1.setColor("yellow");
        fan1.setRadius(10);
        System.out.println(fan1.toString());

        //Khai báo đối tượng fan2
        Fan fan2 = new Fan();
        fan1.setOn(off);
        fan1.setSpeed(medium);
        fan1.setColor("blue");
        fan1.setRadius(5);
        System.out.println(fan1.toString());

    }
}

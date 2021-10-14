package ss5_access_modifier_static.bai_tap.access_modifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    //contructor không tham số
    Circle(){

    }
    //contructor có tham số
    Circle(double radius) {
        this.radius = radius;
    }

    //method getter
    public double getRadius() {
        return radius;
    }
    public String getColor() {
        return color;
    }

}

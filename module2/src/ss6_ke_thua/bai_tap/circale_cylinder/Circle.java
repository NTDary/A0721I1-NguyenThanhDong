package ss6_ke_thua.bai_tap.circale_cylinder;

public class Circle {
    private double radius = 1.0;
    private String color = "green";

    public Circle(){

    }
    public Circle(String color, double radius) {
        this.color = color;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea() {
        return Math.pow(radius,2) * Math.PI;
    }
    public double getPerimeter() {
        return radius * 2 * Math.PI;
    }
    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                + " and "
                + "with color of "
                + getColor();
    }
}

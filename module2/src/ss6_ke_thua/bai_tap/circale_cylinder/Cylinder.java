package ss6_ke_thua.bai_tap.circale_cylinder;

public class Cylinder extends Circle{
    private double height;

    public Cylinder(){

    }
    public Cylinder(double height){
        this.height = height;
    }
    public Cylinder(double height, String color, double radius) {
        super(color, radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
//    public double getRadius(){
//        return getRadius();
//    }
    public double getVolume(){
        return Math.PI * Math.pow(getRadius(),2) * height;
    }
    @Override
    public String toString() {
        return "A Cylinder with height="
                + height
                + " and "
                + ", which is a subclass of "
                + super.toString();
    }
}

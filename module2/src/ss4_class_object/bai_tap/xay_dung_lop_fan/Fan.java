package ss4_class_object.bai_tap.xay_dung_lop_fan;

public class Fan {
    int slow = 1;
    int medium  = 2;
    int fast = 3;

    private int speed = slow;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    //getter
    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    //setter
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString(){
        if(isOn()){
            return "Fan is on \nTốc độ: " + getSpeed() + " Color: "+getColor() +" Radius: "+ getRadius();
        }else{
            return "Fan is off \nColor: "+getColor() +" Radius: "+ getRadius();
        }
    }
}

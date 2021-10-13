package ss4_class_object.thuc_hanh.lop_hinh_chu_nhat;

public class Rectangle {
    double width,height;

    //Contructor
    public Rectangle(){

    }
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    //Method
    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }
    public String display() {
        return "Rectangle{" + "width=" + width + ", height=" + height + "}";
    }

}

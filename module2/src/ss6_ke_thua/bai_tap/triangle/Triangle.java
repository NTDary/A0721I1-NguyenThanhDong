package ss6_ke_thua.bai_tap.triangle;

public class Triangle extends Shape{
    private double a;
    private double b;
    private double c;

    public Triangle(){
        a = 1.0;
        b = 1.0;
        c = 1.0;
    }
    // Ham khoi tao co doi so
    public Triangle(double a, double b, double c, String color) {
        super(color);
        if (a + b <= c || a + c <= b || b + c <= a) {
            a = 0;
            b = 0;
            c = 0;
        } else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    // Ham kiem tam giac
    public boolean isTriangle() {
        if (a + b <= c || a + c <= b || b + c <= a) {
            return false;
        }
        return true;
    }

    // Ham kiem tra tam giac deu
    public boolean isEquilateral() {
        if ((a == b) && (b == c)) {
            return true;
        }
        return false;
    }

    // Ham kiem tra tam giac can
    public boolean isIsosceles() {
        if ((a == b) || (a == c) || (b == c)) {
            return true;
        }
        return false;
    }

    // Ham kiem tra tam giac vuong
    public boolean isRight() {
        if ((a * a == b * b + c * c) ||
                (b * b == a * a + c * c) ||
                (c * c == a * a + b * b)) {
            return true;
        }
        return false;
    }

    // Ham kiem tra tam giac vuong can
    public boolean isRightIsosceles() {
        if (((a * a + b * b == c * c) && (a == b)) ||
                ((a * a + c * c == b * b) && (a == c)) ||
                ((b * b + c * c == a * a) && (b == c))) {
            return true;
        }
        return false;
    }

    // Ham tra ve thong tin kieu tam giac tam giac
    public String getType() {
        if (isIsosceles()) {
            return "Tam giac can";
        } else if (isEquilateral()) {
            return "Tam giac deu";
        } else if (isRight()) {
            return "Tam giac vuong";
        } else if (isRightIsosceles()) {
            return "Tam giac vuong can";
        }
        return "Tam giac thuong";
    }

    // Ham tinh dien tich tam giac
    public double getArea() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
    public double getPerimeter(){
        return a + b + c;
    }
    @Override
    public String toString() {
        return "A Triangle with a= " + a + " ; b= " + b + " ; c= " + c
                + "; "+getType()
                + ", Area= "+ getArea() + " ; Perimeter= "+ getPerimeter()
                + ", which is a subclass of "
                + super.toString();
    }

}

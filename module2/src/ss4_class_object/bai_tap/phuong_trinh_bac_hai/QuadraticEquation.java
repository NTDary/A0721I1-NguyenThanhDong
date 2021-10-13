package ss4_class_object.bai_tap.phuong_trinh_bac_hai;

public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation() {

    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        double delta = getB() * 2 - 4 * getA() * getC();
        return delta;
    }
    public double getRoot1() {
        double root = (-getB() + Math.pow(getB()*getB()-4*getA()*getC(),0.5))/2*getA();
        return root;
    }
    public double getRoot2() {
        double root = (-getB() - Math.pow(getB()*getB()-4*getA()*getC(),0.5))/2*getA();
        return root;
    }
}

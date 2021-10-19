package ss7_abstract_class_and_interface.bai_tap.interface_resizeable;

import ss6_ke_thua.thuc_hanh.he_cac_doi_tuong_hinh_hoc.Rectangle;

public class Square extends Rectangle implements Resizeable{
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }
    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
    }
    public double  getArea(){
        return getSide() * getSide();
    }
    public double getPerimeter(){
        return getSide() * 4;
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }
    @Override
    public void resize(double percent) {
        setSide(getSide() + (getSide() * percent / 100));
    }

}

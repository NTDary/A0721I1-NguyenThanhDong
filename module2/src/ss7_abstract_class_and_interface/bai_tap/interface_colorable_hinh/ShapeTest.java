package ss7_abstract_class_and_interface.bai_tap.interface_colorable_hinh;

import ss7_abstract_class_and_interface.thuc_hanh.animal_and_edible.Animal;
import ss7_abstract_class_and_interface.thuc_hanh.animal_and_edible.Chicken;
import ss7_abstract_class_and_interface.thuc_hanh.animal_and_edible.Edible;
import ss7_abstract_class_and_interface.thuc_hanh.animal_and_edible.Tiger;

public class ShapeTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle();
        shapes[1] = new Rectangle();
        shapes[2] = new Square();
        for (Shape shape : shapes) {
            System.out.println(shape);

            if (shape instanceof Colorable) {
                Colorable colorable = (Colorable) shape;
                colorable.howToColor();
            }
        };

    }
}

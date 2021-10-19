package ss7_abstract_class_and_interface.thuc_hanh.animal_and_edible;

public class Chicken extends Animal implements Edible{

    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}

package training.lec5;

public class Dog extends AbstractAnimal implements Movement, Playing {

    // variables
    double smellRange;

    // constructors
    public Dog(int legs, boolean hasTail, double smellRange) {
        super(legs, hasTail);
        this.smellRange = smellRange;
    }

    public void sound() {
        System.out.println("Wo wo~");
    }

    @Override
    public void abstractMethod() {

    }

    @Override
    public void running() {
        System.out.println("Dog running");
    }

    @Override
    public void jumping() {
        System.out.println("Dog jumping");
    }

    @Override
    public void play() {
        System.out.println("Dog playing");
    }
}

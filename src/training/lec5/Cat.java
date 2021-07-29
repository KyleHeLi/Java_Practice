package training.lec5;

public class Cat extends AbstractAnimal implements Operation {
    // additional variables
    String color;

    // constructor
    public Cat(int legs, boolean hasTail, String color) {
        super(legs, hasTail);
        this.color = color;
    }

    public Cat() {
        this(4, true, "black");
    }

    public int getLegs() {
        return this.legs;
    }

    // override
    @Override
    public void sound() {
        System.out.println("Meow~");
    }

    public void foo() {
        super.foo();
    }

    @Override
    public void abstractMethod() {

    }

    @Override
    public void running() {
        System.out.println("Cat running");
    }

    @Override
    public void jumping() {
        System.out.println("Cat jumping");
    }

    @Override
    public void play() {
        System.out.println("Cat playing");
    }

    @Override
    public void op() {

    }

    public String toString() {
        return String.format("Cat(legs: %s, hasTail: %s, color: %s)", legs, hasTail, color);
//        return "Cat(" + "legs: " + legs + "hasTail: " + hasTail + "color: " + color + ")";
    }
}

package training.lec5;

public abstract class AbstractAnimal {
    // variables
    int legs;
    boolean hasTail;

    public AbstractAnimal(int legs, boolean hasTail) {
        this.legs = legs;
        this.hasTail = hasTail;
    }

    // setters
    // getters

    public void sound() {
        System.out.println("Some noise");
    }

    public void foo() {
        System.out.println("Animal foo()");
    }

    public abstract void abstractMethod();
}

package training.lec5;

public class Animal {
    // variables
    int legs;
    boolean hasTail;

    public Animal(int legs, boolean hasTail) {
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
}

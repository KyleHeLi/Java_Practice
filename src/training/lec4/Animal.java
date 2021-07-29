package training.lec4;

public class Animal {
    // variables
    private int legs;
    private boolean hasTail;

    // constructors
    public Animal(int legs, boolean hasTail) {
        this.legs = legs;
        this.hasTail = hasTail;
    }

    // setters
    public void setLegs(int legs) {
        this.legs = legs;
    }

    public void setHasTail(boolean tail) {
        hasTail = tail;
    }

    // getters
    public int getLegs() {
        return legs;
    }

    public boolean isHasTail() {
        return hasTail;
    }

    public void sound() {
        System.out.println("making noise");
    }
}

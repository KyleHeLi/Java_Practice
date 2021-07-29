package training.lec5;

public class Student {
    // constants
    // public -> access modifier
    // final -> once assigned a value, it won't change in runtime
    // static -> class variable
    public final static String UNIVERSITY = "University of Ottawa";

    // instance variables
    private String name;
    private int no;
    private boolean isMale;
    private double GPA;

    // constructors
    public Student(int no, String name, boolean isMale, double GPA) {
        this.no = no;
        this.name = name;
        this.isMale = isMale;
        this.GPA = GPA;
    }

    public Student() {
        no = 0;
        name = "";
        isMale = true;
        GPA = 0.0;
    }

    // instance methods
    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    // Encapsulation
    // getters
    public String getName() {
        return name;
    }

    public int getNo() {
        return no;
    }

    public boolean isMale() {
        return isMale;
    }

    public double getGPA() {
        return GPA;
    }

    // class methods
    public static void foo() {
        System.out.println("A Test");
    }

    // cannot override in subclass
    public final void bar() {
        System.out.println("This is a bar from Student class.");
    }

    /// overload -> method signature
    public void ma() { // ma()

    }

    public void ma(String name) { // ma(String)

    }

    public void ma(String name, String name2) { // ma(String, String)

    }

    public void ma(String name, int tt) { // ma(String, int)

    }

    public void ma(int tt, String name) { // ma(int, String)

    }

    public static void main(String[] args) {
        Student a = new Student();
        System.out.println(a.no);
        System.out.println(a.name);
        System.out.println(a.isMale);
        System.out.println(a.GPA);

        Student b = new Student(123, "Ken", true, 8.5);

        System.out.println(Student.UNIVERSITY);
        Student.foo();
        System.out.println(Math.PI);
    }
}

package training.lec4;

public class Student extends Animal {
    // 8 primitive types
    // int, short, byte, boolean, char, long, double, float

    // variables
    // Encapsulation
    // access modifier: public, protected, (default), private
    public int no;
    private String name;
    private boolean sex;
    private double GPA;

    // constructors
    public Student() {
        super(2, false);
        no = 0;
        name = "";
        sex = false;
        GPA = 0;
    }
    public Student(int no, String name, boolean sex, double GPA) {
        super(2, false);
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.GPA = GPA;
    }
    public Student(int no, String name) {
//        this.no = no;
//        this.name = name;
//        this.sex = false;
//        this.GPA = 0;
         this(no, name, false, 0);
    }

    // setters
    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    // Polymorphism ->
    // 1. overloading -> method signature
    // method name + parameters' types =>
    public void speakLanguage() {   // method signature: speakLanguage()
        System.out.println("Chinese");
    }

    public void speakLanguage(String language) { // method signature: speakLanguage(String)
        System.out.println(language);
    }

    public void speakLanguage(String a, int b) {

    }
    public void speakLanguage(int a, String b) {

    }

    // Inheritance
    // 2. overriding
//    public void sound() {
//        System.out.println("speaking a language");
//    }

    // getters
    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public boolean getSex() {
        return sex;
    }

    public double getGPA() {
        return GPA;
    }

    public static void main(String[] args) {
        Student a = new Student();
        a = new Student(123, "ken", true, 90);
        Student b = new Student(123, "Kate");
        System.out.println(a.GPA);
        System.out.println(b.GPA);
    }
}

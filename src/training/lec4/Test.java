package training.lec4;

public class Test {
    public static void main(String[] args) {
        Student a = new Student();
        System.out.println(a.no);
        a.no = 1;
        System.out.println(a.no);

        System.out.println(a.getName());
        a.setName("Ken");
        System.out.println(a.getName());

        a.speakLanguage();
        a.speakLanguage("English");

        Animal b = new Animal(4, true);
        b.sound();
        a.sound();

    }
}

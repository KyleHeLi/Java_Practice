package training.lec7;

public class OuterClass {

    public class InnerClass {

    }

    public static class StaticInnerClass {

    }

    public void foo() {
        InnerClass a = new InnerClass();
    }

    public static void foo2() {
        StaticInnerClass a = new StaticInnerClass();
    }

    public static void main(String[] args) {
        OuterClass test = new OuterClass();
//        test.StaticInnerClass();
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        InnerClass innerClass = new OuterClass().new InnerClass();
    }


}

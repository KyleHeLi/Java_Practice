package training.lec7;


public class Test {
    public static void main(String[] args) {
        OuterClass.StaticInnerClass a = new OuterClass.StaticInnerClass();
        OuterClass b = new OuterClass();
        OuterClass.InnerClass c = new OuterClass().new InnerClass();
    }
}

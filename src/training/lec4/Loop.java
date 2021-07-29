package training.lec4;

import java.util.ArrayList;
import java.util.List;

public class Loop {

    public static void main(String[] args) {

//        // for loop 1
//        for (int i = 0, len = 10; i < len; i++) {
//            System.out.println(i);
//        }
//
//        // for loop 2, iterator
//        int[] aArray = new int[10];
//        for (int a : aArray) {
//            System.out.println(a);
//        }
//        for (int i = 0; i < aArray.length; i++) {
//            System.out.println(aArray[i]);
//        }
//
//        IntegerList<String> a = new FixedIntegerArrayList<String>();
//        a.add("a");
//        a.add("b");
//        a.add("c");
//        for (String b : a) {
//            System.out.println(b);
//        }

        // While loop
//        int i = 0;
//        while (i < 2) {
//            System.out.println("Still running");
//            i += 1; // ++i, i++, i = i + 1
//        }
//
//        do {
//            System.out.println("Keep running");
//        } while (i < 2);

        // continue, break
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
//                continue;
                break;
            }
            System.out.println("test: " + i);
        }
    }
}

package training.lec8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    // List {"a", "b", "c", "d"}
    // List {"d", "c", "b", "a"}
    // method(aList, num)
    // method(aList, 2) -> List{"c", "d", "a", "b"}

    public static void main(String[] args) {
        List<String> aStringList = new ArrayList<String>();
        aStringList.add("a");
        aStringList.add("b");

        System.out.println(aStringList.get(0));
        System.out.println(aStringList.get(1));

        List<String> aStringList2 = new LinkedList<String>();
        aStringList2.add("a");
    }
}

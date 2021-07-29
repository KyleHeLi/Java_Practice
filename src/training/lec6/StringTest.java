package training.lec6;


public class StringTest {
    public static String capitalize(String s) {
        String result = s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
        return result;
    }

    public String tt() {
        return "";
    }

    public static void printArray(String[] array) {
        StringBuilder stringBuilder = new StringBuilder("StringArray: {"); // StringBuffer
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i] + "\n");
        }
        stringBuilder.append("}");

        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) {
        // String is immutable
        String aa = new String("a");    // store in heap
        String a = "abcd";  // data segment/static area
        String b = "efgh";
        a = a + b; // a += b
        System.out.println(a);

//        char[] charArray = a.toCharArray();
//        for (int i = 0; i <= charArray.length-1; i++) {
//            if(Character.isLetter(charArray[i])) {
//                System.out.println("Is letter");
//            } else {
//                System.out.println("Is not letter");
//            }
//        }

        for (int i = 0; i < a.length(); i++) {
            if(Character.isLetter(a.charAt(i))) {
                System.out.println("Is letter");
            } else {
                System.out.println("Is not letter");
            }
        }

        String c = "aa";
        String d = "cc";
        System.out.println(c.concat(d));
        System.out.println(c);
        Character.isDigit('a');
        Character.isLetter('1');

        String aString = "abcdefgh";
        System.out.println(aString.substring(3));
        System.out.println(aString.substring(2, 6));

        System.out.println(aString.contains("abd"));
        System.out.println(aString.contains("abcd"));

        aString = "kyle,cassie,kevin,kel";
        String[] names = aString.split(",");
        for (String name : names) {
            System.out.println(name);
        }

        printArray(names);

        // Array is mutable
        int[] anArray = new int[10];
        anArray[2] = 1;

        String test = "AbsdfeIFHE";
        System.out.println(capitalize(test));
    }
}

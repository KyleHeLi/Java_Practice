package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    private List<Integer> stack;
    private List<Integer> minStack;
    private int min;
    private int minNumber;

    public MinStack() {
        // do intialization if necessary
        stack = new ArrayList<Integer>();
        min = Integer.MAX_VALUE;
        minNumber = 0;
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        stack.add(number);
        if (min > number) {
            min = number;
            minNumber = 1;
        } else if (min == number) {
            minNumber++;
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int elemToPop = stack.remove(stack.size() - 1);
        if (elemToPop == min) {
            minNumber--;
            if (minNumber < 1) {
                if (stack.size() >= 1) {
                    int tmpMin = stack.get(0).intValue();
                    for (Integer elem : stack) {
                        if (elem.intValue() < tmpMin) {
                            tmpMin = elem.intValue();
                        }
                    }
                    min = tmpMin;
                } else {
                    min = Integer.MAX_VALUE;
                }
            }
        }
        return elemToPop;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return min;
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println("== Example1 ==");
        MinStack test = new MinStack();
        test.push(1);
        System.out.println(test.min());
        test.pop();
        test.push(2);
        test.push(3);
        System.out.println(test.min());
        test.push(1);
        System.out.println(test.min());

        System.out.println("== Example2 ==");
        test = new MinStack();
        test.push(1);
        System.out.println(test.min());
        test.push(2);
        System.out.println(test.min());
        test.push(3);
        System.out.println(test.min());

        System.out.println("== Example3 ==");
        test = new MinStack();
        test.push(-1);
        test.push(-2);
        System.out.println(test.min());
        test.pop();
        test.push(-3);
        test.push(3);
        test.push(2);
        test.pop();
        test.pop();
        test.pop();
        test.pop();
        test.push(400);
        test.push(3);
        test.push(200);
        test.push(1);
        System.out.println(test.min());
        test.pop();
        System.out.println(test.min());
    }
}
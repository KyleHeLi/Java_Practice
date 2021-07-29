package com.leetcode.amazon;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    private List<Integer> stack;
    private List<Integer> minStack;

    public MinStack() {
        // do intialization if necessary
        stack = new ArrayList<Integer>();
        minStack = new ArrayList<Integer>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        stack.add(number);
        if (minStack.size() > 0) {
            if (minStack.get(minStack.size()-1) >= number) {
                minStack.add(number);
            }
        } else {
            minStack.add(number);
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int elemToPop = stack.remove(stack.size() - 1);
        if (elemToPop == minStack.get(minStack.size() - 1)) {
            minStack.remove(minStack.size() - 1);
        }
        return elemToPop;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return minStack.get(minStack.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println("== Example1 ==");
        MinStack test = new MinStack();
        test.push(1);
        System.out.println(test.min());
        System.out.println(test.pop());
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
        System.out.println(test.pop());
        test.push(-3);
        test.push(3);
        test.push(2);
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        test.push(400);
        test.push(3);
        test.push(200);
        test.push(1);
        System.out.println(test.min());
        System.out.println(test.pop());
        System.out.println(test.min());
    }
}
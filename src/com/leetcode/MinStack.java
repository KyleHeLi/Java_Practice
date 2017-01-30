package com.leetcode;

import java.util.EmptyStackException;
import java.util.Stack;

public class MinStack {
	/** initialize your data structure here. */
    private int min = Integer.MAX_VALUE;
    private Stack<int[]> st = new Stack<int[]>();
    private int[] stackArray;
    public MinStack() {
        
    }
    
    public void push(int x) {
        min = this.getMin();
        if (min == Integer.MAX_VALUE || x < min) {
            min = x;
        }
        stackArray = new int[2];
        stackArray[0] = x;
        stackArray[1] = min;
        st.push(stackArray);
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
    	if (st.empty()) {
    		return Integer.MAX_VALUE;
    	} else {
    		return st.peek()[1];
    	}  
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		
		System.out.println(minStack.getMin());
		try {
			for (int i=0; i<1; i++) {
				minStack.pop();
			}
			System.out.println(minStack.top());
			System.out.println(minStack.getMin());
		} catch (EmptyStackException e) {
			System.err.println("EmptyStackException: " + e.getMessage());
		} finally {
			System.out.println("There is an empty stack");
		}
	}

}

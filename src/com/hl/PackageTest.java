package com.hl;

import java.util.EmptyStackException;

import com.leetcode.MinStack;

/**
* @author Kyle Lee 
* @version 1.0 - Created date: 2017年2月1日 下午4:22:37
* @filename Practice/com.hl/PackageTest.java
* This program demonstrates using the class in different packages
*/

public class PackageTest {

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

package com.hl;

import com.hl.Employee;

/**
* @author Kyle Lee 
* @version 1.0 - Created date: 2017年2月1日 下午2:54:26
* @filename Practice/com.hl/ParamTest.java
* This program demonstrates parameter passing in Java
*/

public class ParamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Test 1: Method can't modify numeric parameters
		 */	
		System.out.println("Testing tripleValue:");
		double percent = 10;
		System.out.println("Before: percent=" + percent);
		tripleValue(percent);
		System.out.println("After: percent=" + percent);
		
		/*
		 * Test 2: Methods can change the state of object parameters
		 */	
		System.out.println("===============");
		System.out.println("Tesing tripleSalary:");
/*		staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);*/
		Employee harry = new Employee("Harry", 50000, 1989, 10, 1);
		System.out.println("Before: salary=" + harry.getSalary());
		tripleSalary(harry);
		System.out.println("After: salary=" + harry.getSalary());
		
		/*
		 * Test 3: Methods can't attach new objects to object parameters
		 */	
		System.out.println("===============");
		System.out.println("Tesing swap:");
		Employee a = new Employee("Alice", 70000, 1987, 11, 11);
		Employee b = new Employee("Bob", 60000, 1988, 7, 1);
		System.out.println("Before: a=" + a.getName());
		System.out.println("Before: b=" + b.getName());
		swap(a, b);
		System.out.println("After: a=" + a.getName());
		System.out.println("After: b=" + b.getName());
	}
	
	// doesn't work
	public static void tripleValue(double x) {
		x = 3 * x;
		System.out.println("End of method: x=" + x);
	}
	
	// works
	public static void tripleSalary(Employee x) {
		x.raiseSalary(200);
		System.out.println("End of method: salary=" + x.getSalary());
	}
	
	public static void swap(Employee x, Employee y) {
		Employee temp = x;
		x = y;
		y = temp;
		System.out.println("End of method: x=" + x.getName());
		System.out.println("End of method: y=" + y.getName());
	}
}

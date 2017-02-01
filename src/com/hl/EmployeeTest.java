package com.hl;

//import java.sql.Date;
import java.time.LocalDate;

/**
* @author Kyle Lee 
* @version 1.0 - Created date: 2017年1月31日 下午3:40:03
* @filename Practice/com.hl/EmployeeTest.java
* This program tests the Employee class.
*/

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// fill the staff array with three Employee objects
		Employee[] staff = new Employee[3];
		
		staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
		
		// raise everyone's salary by 5%
		for (Employee e : staff) {
			e.raiseSalary(5);
		}
		
		// print out information about all Employee objects
		for (Employee e : staff) {
			System.out.printf("name=%s, salary=%.2f, hireDay=%s \r\n", e.getName(), 
					e.getSalary(), e.getHireDay());
		}
	}
}

class Employee {
	
	// instance field
	private String name;
	private double salary;
	// Java 1.7
//	private Date hireDay;
	// Java 1.8
	private LocalDate hireDay;
	
	// constructor
	public Employee(String n, double s, int year, int month, int day) {
		name = n;
		salary = s;
		hireDay = LocalDate.of(year, month, day);
	}
	
	// methods
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public LocalDate getHireDay() {
		return hireDay;
	}
	
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
}
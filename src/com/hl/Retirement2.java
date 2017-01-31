package com.hl;

import java.util.Scanner;

/**
* @author Kyle Lee 
* @version 1.0 - Created date: 2017年1月31日 上午11:49:45
* @filename Practice/com.hl/Retirement2.java
* This program create a new 
*/

public class Retirement2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		System.out.println("How much money will you contribute every year?");
		double payment = in.nextDouble();
		
		System.out.println("interest rate in %:");
		double interestRate = in.nextDouble();
		
		double balance = 0;
		int year = 0;
		
		String input;
		
		// update account balance while user isn't ready to retire
		do {
			// add this year's payment and interest
			balance += payment;
			double interest = balance * interestRate / 100;
			balance += interest;
			
			year++;
			
			// print current balance
			System.out.printf("After year %d, your balance is %,.2f \r\n", year, balance);
			
			// ask if ready to retire and get input
			System.out.println("Ready to retire? (Y/N)");
			input = in.next();
		} while (input.equals("N"));
		
		// close the scanner instance
		in.close();
	}

}

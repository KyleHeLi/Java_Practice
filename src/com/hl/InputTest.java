package com.hl;

import java.io.Console;
import java.util.Scanner;

public class InputTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		// get first input
		System.out.println("What is your name?");
		String name = in.nextLine();
		
		// get second input
		System.out.println("How old are you?");
		int age = in.nextInt();
		
		// set user name and password
/*		Console cons = System.console();
		String username = cons.readLine("User name: ");
		char[] passwd = cons.readPassword("Password: ");*/
		
		// display output on console
		System.out.println("Hello, " + name + ". Next year, you'll be " + (age + 1));
/*		System.out.println("The username is " + username);
		System.out.println("The password is " + passwd);*/
	}

}

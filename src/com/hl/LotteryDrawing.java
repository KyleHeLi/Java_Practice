package com.hl;

import java.util.Arrays;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

/**
* @author Kyle Lee 
* @version 1.0 - Created date: 2017��1��31�� ����2:44:07
* @filename Practice/com.hl/LotteryDrawing.java
* This program demonstrates array mnipulation
*/

public class LotteryDrawing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many numbers do you need to draw?");
		int k = in.nextInt();
		
		System.out.println("What is the highest number you can draw?");
		int n = in.nextInt();
		
		// fill an array with numbers 1 2 3 ... n
		int[] numbers = new int[n];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}
		
		// draw k numbers and put them into a second array
		int[] result = new int[k];
		for (int i = 0; i < result.length; i++) {
			// make a random index between 0 and n-1
			int r = (int) (Math.random() * n);
			
			// pick the element at teh random location
			result[i] = numbers[r];
			
			// move the last element into the random location
			numbers[r] = numbers[n - 1];
			n--;
		}
		
		// print the sorted array
		Arrays.sort(result);
		System.out.println("Bet the following combination. It'll make you rich!");
		for (int r : result)
			System.out.println(r);
	}

}

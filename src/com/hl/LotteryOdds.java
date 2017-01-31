package com.hl;

import java.util.Scanner;

/**
* @author Kyle Lee 
* @version 1.0 - Created date: 2017年1月31日 下午12:17:01
* @filename Practice/com.hl/LotteryOdds.java
* This program demonstrates a <code>for</code> loop
*/

public class LotteryOdds {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many numbers do you need to draw?");
		int k = in.nextInt();
		
		System.out.println("What is the highest number you can draw?");
		int n = in.nextInt();
		/*
		 * compute binomial coefficient n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
		 */
		int lotteryOdds = 1;
		for (int i = 1; i <= k; i++) {
			lotteryOdds = lotteryOdds * (n - i + 1) / i;
		}
		
		System.out.printf("Your odds are 1 in %d. Good luck!", lotteryOdds);
		
		in.close();
	}

}

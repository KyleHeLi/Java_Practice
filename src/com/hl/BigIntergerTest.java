package com.hl;

import java.math.BigInteger;
import java.util.Scanner;

/**
* @author Kyle Lee 
* @version 1.0 - Created date: 2017年1月31日 下午2:05:17
* @filename Practice/com.hl/BigIntergerTest.java
* This program uses big numbers to compute the odds of winning the grand prize 
* in a lottery
*/

public class BigIntergerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many numbers do you need to draw?");
		int k = in.nextInt();
		
		System.out.println("What is the highest number you can draw?");
		int n = in.nextInt();
		
		BigInteger lotteryOdds = BigInteger.valueOf(1);
		
		for (int i = 1; i <= k; i++) {
			lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n - i + 1)).divide(
					BigInteger.valueOf(i));
		}
		
		System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck!");
		in.close();
	}

}

package com.parvin.numbers;

/*
 * trailing zeroes are created by multiples of 10, and 
 * multiples of 10 are created by multiples of 2 and 5
 * 
 * there will always be more 2's than 5's so just counting
 * 5's will be sufficient.
 * 
 * 15 contributes one multiple of 5
 * and 25 contributes two multiples of 5.
 */

public class FindTrailingZeroes {

	public static void main(String args[]){
		int trailingZeros1 = countFactZeroes1(30);
		int trailingZeros2 = countFactZeroes1(30);
		
		System.out.println(trailingZeros1 + " : " + trailingZeros2 );
	}
	
	public static int countFactZeroes1(int num){
		int count = 0;
		for(int i=2; i<=num; i++){
			count += factorsOf5(i);
		}
		return count;
	}
	
	private static int factorsOf5(int num){
		int count = 0;
		while(num % 5 == 0){
			count ++; 
			num = num/5;
		}
		return count;
	}
	
	public static int countFactZeroes2(int num){
		int count = 0;
		if(num < 0){
			return -1;
		}
		
		for(int i=5; num/i > 0 ; i*=5){
			count += num/i;
		}
		
		return count;
	}
}

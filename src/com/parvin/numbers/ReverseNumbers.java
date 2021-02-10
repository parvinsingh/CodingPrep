package com.parvin.numbers;

import java.util.ArrayList;

/**
 * Assume we are dealing with an environment which could only store integers 
 * within the 32-bit signed integer range: [-2^31,  2^31 - 1]. 
 * For the purpose of this problem, 
 * assume that your function returns 0 when the reversed integer overflows.
 * @author papanesa
 *
 */
public class ReverseNumbers {
	public static void main(String[] args) {
		System.out.println(reverse(123));
	}
	
	private static int reverse(int num) {
		if(num == 0) return num;
		boolean isNegative = false;
		if(num < 0) {
			isNegative = true;
			num = num*(-1);
		}
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int factor = 1;
		int output = 0;
		while(num>0) {
			numbers.add(num%10);
			num = num/10;
		}
		for(int i=numbers.size()-1; i>=0 ; i--) {
			output = output + numbers.get(i)*factor;
			factor = factor*10;
		}
		if(isNegative) {
			output = (-1)*output;
		}
		return (output >= (-1)*(Math.pow(2, 31)) && output <= (Math.pow(2, 31) - 1)) ? output : 0;
	}

}

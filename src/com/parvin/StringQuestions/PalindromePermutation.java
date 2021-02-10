package com.parvin.StringQuestions;

import java.util.Scanner;

//given a string check if it is a permutation of a palindrome
// taco cat
public class PalindromePermutation {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		boolean result = isPalindromePermutation(input);
		System.out.println(result);
	}
	
	private static boolean isPalindromePermutation(String input) {
		int[] ip = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for(Character ch: input.toCharArray()) {
			if(Character.isLetter(ch)){
				ip[Character.getNumericValue('z') - Character.getNumericValue(ch)]++;
			}
		}
		boolean result = false;
		for(int i: ip) {
			if(i%2 == 1) {
				if(result) {//result was true only for the first occurence of an odd count character
					return false;
				}
				result = true;
			}
		}
		return result;
	}
}

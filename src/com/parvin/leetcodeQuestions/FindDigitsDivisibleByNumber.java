package com.parvin.leetcodeQuestions;

import java.util.Scanner;

/**
 * Given an integer, , traverse its digits (1,2,...,n) and determine how many digits 
 * evenly divide  (i.e.: count the number of times  divided by each digit i has a 
 * remainder of ). Print the number of evenly divisible digits.
 * 
 * Note: Each digit is considered to be unique, so each occurrence of the same 
 * evenly divisible digit should be counted (i.e.: for , the answer is ).
 * 
 * Input Format
The first line is an integer, T , indicating the number of test cases. 
The T subsequent lines each contain an integer, N.

Constraints 
 1 <= T <= 15
 0 <N < 10^9

Output Format

For every test case, count and print (on a new line) the number of digits in  that 
are able to evenly divide .

Sample Input
2
12
1012

Output
2
3

 * @author ppanesar
 *
 */
public class FindDigitsDivisibleByNumber {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int result = findCountOfDivisibleDigits(n);
            System.out.println(result);
        }
        
    }
	
	private static int findCountOfDivisibleDigits(int input){
		int digitCount = 0;
		int num = input;
		while(num > 0){
			int lastDigit = num % 10;
			if(lastDigit!=0 && input % lastDigit == 0){
				digitCount++;
			}
			num = num/10;
		}
		return digitCount;
	}
}

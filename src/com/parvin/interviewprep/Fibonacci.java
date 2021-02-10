package com.parvin.interviewprep;

public class Fibonacci {

	public static void main(String[] args) {
		printFirstNFibonacci(7);
	}
	
	public static void printFirstNFibonacci(int n) {
		if(n < 0 ) {
			System.out.println("invalid input");
		}
		if(n == 0 ) {
			System.out.println(n);
		}else {
			int b = 0;
			int a = 1;
			System.out.println(b);
			System.out.println(a);
			
			while(n>=2) {
				int oldR = a;
				a = a+b; //r is the total sum
				b = oldR;
				System.out.println(a);
				n--;
			}
		}
		
	}
}

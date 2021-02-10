package com.parvin.interviewprep;

//https://www.hackerrank.com/challenges/sam-and-substrings/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

public class SamAndSubstrings {
	
	public static void main(String args[]) {
		addDigits("123");
	}
	
	public static void addDigits(String input) {
		long sum = 0;
		while(!input.isEmpty()) {
			sum = sum + (addSubNumbers(input));//234+23+2
			input = input.substring(0, input.length()-1);
		}
	}

	private static long addSubNumbers(String input) {
		long sum = 0;
		long totalSum = 0;
		int factor = 1;//23
		for(int i=input.length()-1; i>=0; i--) {
			char c = input.charAt(i);
			long num = Character.getNumericValue(c); //%(long)(Math.pow(10, 9)+7);
			sum = sum + (factor * num);//4+30+200
			factor = factor*10;
			totalSum = totalSum + sum;//4+34+234
		}
		//return (totalSum)%(long)(Math.pow(10, 9)+7);
		return totalSum;
	}

}

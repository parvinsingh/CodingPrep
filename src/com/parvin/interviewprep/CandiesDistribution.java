package com.parvin.interviewprep;

import Utilities.PrintArrays;

//https://www.hackerrank.com/challenges/candies/problem

public class CandiesDistribution {
	
	private static int[] distributeCandies(int[] students) {
		int len = students.length;
		int[] candies = new int[len];
		
		for(int i=0; i<len-1; i++) {
			if(candies[i] == 0) {
				candies[i] = 1;
			}
			//Left to right
			if(students[i] < students[i+1] && (candies[i] >= candies[i+1])) {
				candies[i+1] = candies[i] + 1;
			}
		}
		for(int i=len-1; i>0; i--) {
			//right to left
			if(candies[i] == 0) {
				candies[i] = 1;
			}
			if((students[i] < students[i-1]) && (candies[i] >= candies[i-1])) {
				candies[i-1] = candies[i] + 1;
			}
		}
		return candies;
	}

	public static void main(String args[]) {
		int[] input1 = {4, 6, 4, 5, 6, 2};
		int[] input2 = {1, 2, 2};
		int[] input3 = {2, 4, 2, 6, 1, 7, 8, 9, 2, 1};
		
		int[] candies1 = distributeCandies(input1);
		PrintArrays.printArray(candies1);
		int[] candies2 = distributeCandies(input2);
		PrintArrays.printArray(candies2);
		int[] candies3 = distributeCandies(input3);
		PrintArrays.printArray(candies3);
	}
	
}

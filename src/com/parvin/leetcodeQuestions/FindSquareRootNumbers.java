package com.parvin.leetcodeQuestions;

public class FindSquareRootNumbers {

	public static void main(String args[]){
		int result = countOfSquareIntegers(6, 24);
		System.out.println(result);
	}
	
	private static int countOfSquareIntegers(int start, int end){
		int count = 0;
		for(int i=start; i<=end; i++){
			double sq = Math.sqrt(i);
			if(sq == Math.rint(sq)){
				count++;
			}
		}
		return count;
	}
}

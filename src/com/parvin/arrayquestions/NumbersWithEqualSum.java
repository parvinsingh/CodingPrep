package com.parvin.arrayquestions;

import java.util.HashMap;

//https://medium.com/@molchevsky/numbers-with-equal-digit-sum-c8a7e01ad7db

public class NumbersWithEqualSum {
	public static void main(String[] args) {
		int[] arr = {51,71,17,42,44,80,33,02};
		int[] arr1 = {42,33,60};
		int[] arr2 = {51,32,43};
		System.out.println(EqualSum(arr));
	}
	
	public static int EqualSum(int[] input) {
		NumbersWithEqualSum nwes = new NumbersWithEqualSum();
		HashMap<Integer, NumPairs> pairs = new HashMap<Integer, NumPairs>();
		int maxSum = 0;
		for(int inp : input) {
			int s = SumDigits(inp);
			if(pairs.containsKey(s)) {
				NumPairs pair = pairs.get(s);
				int s1 = pair.first + inp;
				int s2 = pair.second + inp;
				if( s1 > s2) {
					pairs.get(s).addSecond(inp);
					maxSum = Math.max(maxSum, s1);
				}else {
					pairs.get(s).addFirst(inp);
					maxSum = Math.max(maxSum, s2);
				}
			}else {
				NumPairs p = nwes.new NumPairs();
				p.addFirst(inp);
				pairs.put(s, p);
			}
		}
		return maxSum;
	}
	
	private static int SumDigits(int digit) {
		int s = 0;
		while(digit>0) {
			s = s + (digit%10);
			digit = digit/10;
		}
		return s;
	}
	
	class NumPairs {
		int first;
		int second;
		
		public NumPairs(){
		}
		
		public void addFirst(int a) {
			this.first = a;
		}
		
		public void addSecond(int b) {
			this.second = b;
		}
	}
}

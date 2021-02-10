package com.parvin.StringQuestions;

import java.util.ArrayList;
import java.util.List;

import Utilities.PrintArrays;

//https://www.hackerrank.com/challenges/weighted-uniform-string/problem

public class WeightedUniformStrings {
	
	static int[] weights = new int[26];
	static {
		weights[0] = 1;
		for(int i=1; i<weights.length; i++) {
			weights[i] = weights[i-1]+1;
		}
	}
	
	public static void main(String args[]) {
		String input = "abccddde";
		int[] queries = {1,3,12,5,9,10};
		String[] result = uniformStrings(input, queries);
		PrintArrays.printArray(result);
	}
	
	public static String[] uniformStrings(String s, int[] queries) {
		List<Integer> stringWeights = new ArrayList<Integer>();
		int len = s.length();
		int index = 1;
		char prevChar = s.charAt(0);
		int totalWeight = weights[prevChar-'a'];
		while(index < len) {
			stringWeights.add(totalWeight);
			char currChar = s.charAt(index);
			int charWeight = weights[currChar - 'a'];
			if(prevChar == currChar) {
				totalWeight = totalWeight + charWeight;
			}else {
				prevChar = currChar;
				totalWeight = charWeight;
			}
			index++;
		}
		stringWeights.add(totalWeight);

		String[] result = new String[queries.length];
		for(int i=0; i<queries.length; i++) {
			result[i] = stringWeights.contains(queries[i]) ? "YES" : "NO";
		}
		return result;
    }

}

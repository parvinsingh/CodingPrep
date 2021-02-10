package com.parvin.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
public class LeastNumOfUniqueIntegers {

	public static void main(String[] args) {
		int[] input = {4,4,3,1,1,3,3,2,2}; 
		int result = leastUniqueIntegers(input, 3);
		System.out.print(result);
	}
	
	private static int leastUniqueIntegers(int[] input, int k) {
		HashMap<Integer, Integer> map = new HashMap<>(); //freq of occurence
		for(int i=0; i<input.length; i++) {
			int c = map.getOrDefault(input[i], 0);
			map.put(input[i], ++c);
		}
		
		List<Map.Entry<Integer, Integer>> entries =
				new LinkedList<>(map.entrySet());
		
		Collections.sort(entries, (a, b) -> a.getValue().compareTo(b.getValue()));
		
		while(!entries.isEmpty() && k>0) {
			int frequency = entries.get(0).getValue();
			if(frequency <= k) {
				entries.remove(0); //if the occurence is less than k, remove all
			}
			k = k-frequency;
		}
		return entries.size();
	}
}

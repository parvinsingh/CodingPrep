package com.parvin.StringQuestions;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.TreeMap;


public class FirstUniqueCharacter {
	
	public static void main(String args[]){
//		String input = "ab";
//		findUniqueCharacter(input);
		int[] input = {5,3,3,6,7,5,4,6,4,9,2};
		int uniqueInteger = findUniqueInteger(input);
		System.out.println(uniqueInteger);
	}

	private static void findUniqueCharacter(String input){
		if(input==null || input.length()==0){
			System.out.println("Input is empty or null");
			return;
		}
		input = input.trim();
		//linkedHashMap preserves the order of insertion
		LinkedHashMap<Character, Integer> counterMap = new LinkedHashMap<Character, Integer>();
		if(input.length()==1){
			System.out.println("The first unique character is " + input);
			return;
		}else{
			for(int i=0; i<input.length(); i++){
				if(!counterMap.containsKey(input.charAt(i))){
					//containsKey
					counterMap.put(input.charAt(i), 1);
				}else{
					int c = counterMap.get(input.charAt(i));
					counterMap.put(input.charAt(i), c+1);
				}
			}
		}
		
		for(Character ch: input.toCharArray()){
			if(counterMap.get(ch)==1){
				System.out.println("The first unique character is " + ch);
				return;
			}
		}
		System.out.println("There are no unique characters");
		return;
		
	}
	
	/*
	 * Find the smallest unique integer in a random integer array with 
	 * possible duplicates.
	 * {5,3,3,1,6,7,5,4,6,4,9,2}
	 */
	public static int findUniqueInteger(int[] input){
//		LinkedHashMap<Integer, Boolean> isUniqueMap = new LinkedHashMap<Integer, Boolean>();
		TreeMap<Integer, Boolean> isUniqueMap = new TreeMap<>();
		for(int i: input){
			if(isUniqueMap.containsKey(i)){
				isUniqueMap.put(i, Boolean.FALSE);
			}else{
				isUniqueMap.put(i, Boolean.TRUE);
			}
		}
		int minUnique = Integer.MAX_VALUE;
		for(int i: input){
			if(isUniqueMap.get(i) == Boolean.TRUE && i<minUnique){
				return i;
			}
		}
		return minUnique;
		//return 0;
	}
	
}

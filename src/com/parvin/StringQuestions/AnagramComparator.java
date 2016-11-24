package com.parvin.StringQuestions;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;


public class AnagramComparator {

	public static void main(String args[]){
		String[] input = {"pool", "race", "map", "acre", "pam", "loop", "care", "polo"};
		mapAnagrams(input);
		for(String str: input){
			System.out.print(str + " ,");
		}
	}
	
	private static String sortChars(String input){
		char[] letters = input.toCharArray();
		Arrays.sort(letters);
		return String.valueOf(letters);
	}
	
	private static void mapAnagrams(String[] inputArr){
		LinkedHashMap<String, LinkedList<String>> map = 
				new LinkedHashMap<String, LinkedList<String>>();
		for(String s: inputArr){
			String key = sortChars(s);
			if(!map.containsKey(key)){
				map.put(key, new LinkedList<String>());
			}
			LinkedList<String> anagrams = map.get(key);
			anagrams.add(s);
		}
		int index=0;
		for(String str: map.keySet()){
			LinkedList<String> values = map.get(str);
			for(String t: values){
				inputArr[index]=t;
				index++;
			}
		}
	}
}

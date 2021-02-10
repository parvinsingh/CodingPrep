package com.parvin.StringQuestions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;


public class AnagramFunctions {

	public static void main(String args[]){
		//String[] input = {"pool", "race", "map", "acre", "pam", "loop", "care", "polo"};
		String[] input = {"cat", "dog", "tac", "god", "act",  "tom marvolo riddle ","abc", "def",  "cab", "fed", "clint eastwood ", "i am lord voldemort", "elvis", "old west action",  "lives"};
		List<LinkedList<String>> result = mapAnagrams(input);
		for(LinkedList<String> group: result){
			System.out.print("{");
			for(String str: group){
				System.out.print(str+",");
			}
			System.out.println("}");
		}
	}
	
	private static String sortChars(String input){
		char[] letters = input.toCharArray();
		Arrays.sort(letters);
		return String.valueOf(letters);
	}
	
	private static List<LinkedList<String>> mapAnagrams(String[] inputArr){
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
		List<LinkedList<String>> grouping = new LinkedList<LinkedList<String>>();
		
		for(String str: map.keySet()){
			LinkedList<String> values = map.get(str);
			
			grouping.add(values);
//			for(String t: values){
//				inputArr[index]=t;
//				index++;
//			}
		}
		return grouping;
	}
}

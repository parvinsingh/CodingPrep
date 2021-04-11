package com.parvin.interviewprep;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * @author papanesa
 *
 */
public class LongesCommonPrefix {

	public static void main(String[] args) {
		String[] input1 = {"flower","flow","flight"};
		String[] input2 = {"dog","racecar","car"};
		String[] input3 = {"", ""};
		String result1 = getLongestCommonPrefix(input1);
		System.out.println(result1);
		String result2 = getLongestCommonPrefix(input2);
		System.out.println(result2);
		String result3 = getLongestCommonPrefix(input3);
		System.out.println(result3);
	}

	private static String getLongestCommonPrefix(String[] input) {
		if(input.length == 0 || input[0].isBlank()) {
			return "";
		}
		if(input.length == 1) {
			return input[0];
		}
		//find the smallest string first
		String smallestStr = input[0];
		for(String str : input) {
			//find the smallest string
			if(str.length() < smallestStr.length()) {
				smallestStr = str;
			}
		}
		if(smallestStr.isBlank()) {
			return "";
		}
		//search in the remaining strings
		String prefix = smallestStr;
		for(String str: input) {
			prefix = getCommonPrefix(str.substring(0, prefix.length()), prefix);
			if(prefix.isBlank()) {
				return "";
			}
		}
		
		return (prefix.isBlank()) ? "" : prefix;
	}
	//TimeComplexity-> O(NL) -> where N: input size, and L: smallest string size

	private static String getCommonPrefix(String original, String prefix) {
		if(original.charAt(0) != prefix.charAt(0) || original.isBlank() || prefix.isBlank()) {
			return "";
		}
		while(!original.startsWith(prefix)) {
			prefix = prefix.substring(0, prefix.length()-1);
			if(prefix.isBlank()) {
				return "";
			}
		}
		return prefix;
	}
}

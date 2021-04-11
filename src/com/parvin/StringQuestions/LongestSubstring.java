package com.parvin.StringQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.sun.jdi.CharType;

/**
 * Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abbbcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
 * @author papanesa
 *
 */
public class LongestSubstring {

	public static void main(String args[]) {
		int length = lengthOfLongestSubstring("abbbcabcbb");
		System.out.println(length);
		System.out.println("======");
		System.out.println(longestSubstringWithKDistinctCharacters("cbbebi", 3));
		System.out.println(longestSubstringWithKDistinctCharacters("araaci", 1));
		System.out.println(longestSubstringWithKDistinctCharacters("araaci", 2));
		
	}
	
	private static int lengthOfLongestSubstring(String s) {
		if(s.isEmpty()) {
			return 0;
		}
		if(s.length() == 1) {
			return 1;
		}
		String tempString = new String();
		String resultStr = new String();
		int i = 0;
		while(i<s.length()) {
			int dupIndex = tempString.indexOf(s.charAt(i));
			if(dupIndex == -1) {
				tempString += String.valueOf(s.charAt(i));
				i++;
			}else {
				if(tempString.length() > resultStr.length()) {
					resultStr = tempString;
				}
				tempString = tempString.substring(dupIndex+1, tempString.length());
				//tempString = new String();
			}
		}
		if(tempString.length() > resultStr.length()) {
			resultStr = tempString;
		}
		System.out.println(resultStr);
		return resultStr.length();
    }
	
	private static int longestSubstringWithKDistinctCharacters(String s, int k) {
		int start = 0; int end = 0; int maxLength = 0;
		Map<Character, Integer> charMap = new HashMap<>();
		
		for(; end<s.length(); end++) {
			char c = s.charAt(end);
			
			charMap.put(c, charMap.getOrDefault(c, 0)+1);
			
			while(charMap.size()>k) {
				char startChar = s.charAt(start);
				charMap.put(startChar, charMap.get(startChar)-1);
				if(charMap.get(startChar)==0) {
					charMap.remove(startChar);
				}
				start++;
			}
			maxLength = Math.max(maxLength, end - start + 1);
		}
		return maxLength;
	}
}

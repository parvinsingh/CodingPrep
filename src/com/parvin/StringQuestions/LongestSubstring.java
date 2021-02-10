package com.parvin.StringQuestions;

import java.util.ArrayList;

import com.sun.jdi.CharType;

/**
 * Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
 * @author papanesa
 *
 */
public class LongestSubstring {

	public static void main(String args[]) {
		int length = lengthOfLongestSubstring("abcabcbb");
		System.out.println(length);
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
		return resultStr.length();
    }
}

package com.parvin.leetcodeQuestions;

import java.util.Stack;

/**
 * input = "a,bc$"
 * output = "c,ba$"
 * 
 * input = ""
 * @author papanesa
 *
 */
public class ReverseStringWithSpecialCharacters {

	public static void main(String[] args) {
		String input = "a,bc$d";
		String output = reverseString(input);
		System.out.println(output);
		
		System.out.println(reverseWordsInASentence("Let's take LeetCode contest"));
		System.out.println(reverseSomeCharsOfString("abcdefghijkl", 3));
	}

	private static String reverseString(String input) {
		char[] chs = input.toCharArray();
		int i=0;
		int j=chs.length-1;
		while(i<j) {
			if(((chs[i]>=97 && chs[i]<=122) || (chs[i]>=65 && chs[i]<=90))
					&& ((chs[j]>=97 && chs[j]<=122) || (chs[j]>=65 && chs[j]<=90))) {
				char temp = chs[i];
				chs[i] = chs[j];
				chs[j] = temp;
				i++;
				j--;
			}else {
				if(!((chs[i]>=97 && chs[i]<=122) || (chs[i]>=65 && chs[i]<=90))) {
					i++;
				}else {
					j--;
				}
			}
		}
		return String.copyValueOf(chs);
	}
	
	//https://leetcode.com/problems/reverse-words-in-a-string-iii/
	private static String reverseWordsInASentence(String input) {
		String[] strArray = input.split(" ");
		StringBuffer result = new StringBuffer("");
		for(String str : strArray) {
			result.append(reverseString(str)+" ");
		}
		return result.toString().trim();
	}
	
	//https://leetcode.com/problems/reverse-string-ii/
	private static String reverseSomeCharsOfString(String input, int k) {
		int i = 0;
		char[] chars = input.toCharArray();
		int start = 0;
		while(start < chars.length) {
			i = start;
			int range = start+k;
			if(range > chars.length) {
				range = chars.length;
			}
			while(i < range) {
				char temp = chars[i];
				chars[i] = chars[range-1];
				chars[range-1] = temp;
				i++; range--;
			}
			start = start + 2*k;
		}
		return String.valueOf(chars);
	}
}

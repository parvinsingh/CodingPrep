package com.parvin.StringQuestions;

import java.util.ArrayList;

/**
 * Find all permutations of a string in a given text.
 * @author ppanesar
 *
 */

public class findAllPermsInAText {

	public static void main(String args[]){
		String text = "aaabccbaabcyxbacmkcba";
		String input = "abc";
		findAllPerms2(text, input);
		
	}

	//will not work if there are duplicates or the text format is something like this- aabcca
	private static void findAllPerms(String text, String input) {
		StringBuilder result = new StringBuilder(input.length());
		StringBuilder strB = new StringBuilder(input);
		
		for(char ch: text.toCharArray()){
			int index = strB.indexOf(String.valueOf(ch)); 
			if(index != -1){
				strB.replace(index, index+1, "");
				result.append(ch);
				if(result.length() == input.length()){
					System.out.println(result.toString());
					strB = new StringBuilder(input);
					result = new StringBuilder(input.length());
				}
			}else{
				strB = new StringBuilder(input);
				result = new StringBuilder(input.length());
			}
		}
	}
	
	//will work for all kind of inputs
	private static void findAllPerms2(String text, String input) {
		int index = 0;
		for(int i=index; i<text.length(); i++){
			int idx = input.indexOf(text.charAt(i));
			if(idx!=-1){
				if(checkPermExists(input, text.substring(i, i+input.length()))){
					i = i + input.length()-1;
				}
			}
		}
		
	}
	
	private static boolean checkPermExists(String input, String possibleStr){
		int[] letters1 = new int[128]; // should always check with the interviewer if the characterset is ASCII
		int[] letters2 = new int[128];
		
		for(int i=0; i<input.length(); i++){
			char c1 = input.charAt(i);
			char c2 = possibleStr.charAt(i);
			letters1[c1]++;
			letters2[c2]++;
		}
		
		for(int j=0; j<128; j++){
			if(letters1[j] != letters2[j]){
				return false;
			}
		}
		System.out.println(possibleStr);
		return true;
	}
	
}

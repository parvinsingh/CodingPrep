package com.parvin.StringQuestions;
import java.util.ArrayList;
import java.util.List;


public class CombinationsOfString {

	public static void main(String[] args){
		StringBuilder output = new StringBuilder();
		char[] letters = {'g','g','l','o','o','e'};
		printCombinations("0123456789", output, 0);
//		
//		System.out.println("-------------------");
		
//		String maxWord = legalMaxWord(letters, output, 0, 0, "");
//		System.out.println(maxWord);
//		ArrayList<String> result = permutation("abcdef");
//		for(String str: result){
//			System.out.println(str);
//		}
		
	}

	private static String legalMaxWord(char[] input, StringBuilder output, int index, int maxLen, String result) {
		for(int i= index; i<input.length; i++){
			output.append(input[i]);
			if(output.length()>maxLen && isLegalWord(output.toString())){
				result = output.toString();
				maxLen = result.length();
			}
			if(i<input.length) index++;
			legalMaxWord(input, output, index, maxLen, result);
			output.setLength(output.length()-1);
		}
		return result;
	}
	
	//Combination of digits
	private static void printCombinations(String input, StringBuilder output, int index) {//idx=0,1,2,3,4
		if(output.length()==4) {
			System.out.println(output);
			return;
		}
		for(int i= index; i<input.length(); i++){//i=3to10
			output.append(input.charAt(i));//0123
			if(i<input.length()) {
				index++;
			}
			printCombinations(input, output, index);
			output.setLength(output.length()-1);
		}
	}
	
	private static boolean isLegalWord(String word){
		//do comparison against a dictionary or an arraylist
		return word == "google";
	}
	
	private static ArrayList<String> permutation(String input){
		if(input==null) return null;
		ArrayList<String> result = new ArrayList<String>();
		if(input.length()==1) {
			result.add(input);
		}else if(input.length() > 1){
			String last = input.substring(input.length()-1);
			String remainder = input.substring(0, input.length()-1);
			result.addAll(merge(permutation(remainder), last));
		}
		return result;
		
	}

	private static ArrayList<String> merge(
			ArrayList<String> list, String c) {
	    ArrayList<String> res = new ArrayList<String>();
	    // Loop through all the string in the list
	    for (String s : list) {
	        // For each string, insert the last character to all possible postions
	        // and add them to the new list
	        for (int i = 0; i <= s.length(); ++i) {
	        	StringBuffer strBuff = new StringBuffer(s);
	            String ps = strBuff.insert(i, c).toString();
	            res.add(ps);
	        }
	    }
	    return res;
	}
}

package com.parvin.StringQuestions;

public class StringPermutation {

	public static void main(String args[]){
		String input1 = "google";
		String input2 = "leogog";
		boolean isPerm = isPermutation(input1, input2);
		if(isPerm){
			System.out.println(input1 + " is permutation of the String " + input2);
		}
	}
	
	private static boolean isPermutation(String str1, String str2){
		if(str1.length() != str2.length()){
			return false;
		}
		
		int[] letters1 = new int[128]; // should always check with the interviewer if the characterset is ASCII
		int[] letters2 = new int[128];
		
		for(int i=0; i<str1.length(); i++){
			char c1 = str1.charAt(i);
			char c2 = str2.charAt(i);
			letters1[c1]++;
			letters2[c2]++;
		}
		
		for(int j=0; j<128; j++){
			if(letters1[j] != letters2[j]){
				return false;
			}
		}
		return true;
	}
	
}

package com.parvin.StringQuestions;

public class UniqueString {

	public static void main(String args[]){
		String input1 = "google";
		
		if(isUniqueString(input1)){
			System.out.println("String " + input1 + " has unique characters.");
		}else{
			System.out.println("String " + input1 + " does not have unique characters.");
		}
	}
	
	private static boolean isUniqueString(String input){
		if(input.length() > 128){
			return false;
		}
		boolean[] char_set = new boolean[128];
		
		for(int i=0; i<input.length()-1; i++){
			int val = input.charAt(i);
			if(char_set[val]){
				//character is already present
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
	
}

package com.parvin.StringQuestions;


public class StringCompression {

	public static void main (String args[]){
		String input = "abbbccdddjjjjjlmmm";
		String compressedString = compressString(input);
		if(compressedString!=null){
			System.out.println(compressString(input));
		}
//		String input1 = "I am a good engineer";
//		replaceSpaceChars(input1);
		System.out.println(deCompressString(compressedString));
	}
	
	private static String compressString(String input){
		if(input == null || input.length() <=0){
			return null;
		}else if(input.length()==1){
			return input;
		}
		char ch = input.charAt(0);
		int charCount = 1;
		StringBuffer result = new StringBuffer();
		for(int i=1; i<input.length(); i++){
			if(ch == input.charAt(i)){
				charCount++;
			}else{
				result.append(ch + String.valueOf(charCount));
				ch=input.charAt(i);
				charCount=1;
			}
		}
		result.append(ch + String.valueOf(charCount));
		
		if(result.length() < input.length()){
			return result.toString();
		}
		return input;
	}
	
	private static String deCompressString(String input){
		if(input == null || input.length() <=0){
			return null;
		}else if(input.length()==1){
			return input;
		}
		
		StringBuffer result = new StringBuffer();
		for(int i=1; i<input.length(); i=i+2){
			int rep = Character.getNumericValue(input.charAt(i));
			char ch = input.charAt(i-1);
			while(rep > 0) {
				result.append(ch);
				rep--;
			}
		}
		
		return result.toString();
	}
	
	//Method to replace the space characters with '%20' characters
	private static void replaceSpaceChars(String input){
		if(input==null || input.length()==0){
			System.out.print("The input string is empty or null " + input);
			return;
		}
		StringBuffer result = new StringBuffer();
		for(char ch: input.toCharArray()){
			if(Character.isWhitespace(ch)){
				result.append("%20");
			}else{
				result.append(ch);
			}
		}
		System.out.print("Input string is converted to " + result.toString());
	}
}

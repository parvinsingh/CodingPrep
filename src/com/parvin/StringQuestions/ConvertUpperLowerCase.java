package com.parvin.StringQuestions;

public class ConvertUpperLowerCase {

	public static void main(String args[]){
		String input = "pARviN";
		String result = convert(input);
		System.out.println("For the given input: " + input + " the output is: " + result);
	}
	
	private static String convert(String input){
		//upper case 65 to 90, inclusive
		//lower case 97 to 122, inclusive
		char[] output = new char[input.length()];
		int index = 0;
		for(char ch: input.toCharArray()){
			if((int)ch>=97 && (int)ch<=122){
				//upper case character in the String 
				ch = (char) (ch - 32);
				output[index]=ch;
			}else if((int)ch>=65 && (int)ch<=90){
				//lower case character in the String
				ch = (char) (ch + 32);
				output[index]=ch;
			}else{
				//assuming any other character is remained untouched
				output[index]=ch;
			}
			index++;
		}
		return String.valueOf(output);
	}
}

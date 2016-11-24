package com.parvin.StringQuestions;

public class OccurenceOfString {

	public static void main(String args[]){
		String input = "helloworldhelloasfnrworldsdlkwwworld";
		findOccurence(input, "world");
	}
	
	private static void findOccurence(String input, String findStr){
		int counter = 0;
		int index = 0;
		while (index != -1){
			index = input.indexOf(findStr, index);
			if(index != -1){
				counter++;
				index += findStr.length();
			}
		}
		System.out.println("Num of occurences of the word " + findStr + " in the input String = " + counter);
	}
}

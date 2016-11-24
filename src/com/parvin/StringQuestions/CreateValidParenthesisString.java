package com.parvin.StringQuestions;

public class CreateValidParenthesisString {

	public static void main(String args[]){
		createValidString(4);
		System.out.println("=====");
		createValidString(6);
		System.out.println("=====");
		createValidString(10);
		System.out.println("=====");
	}
	
	public static void createValidString(int i){
		createValidString(i/2, i/2, "");
	}

	private static void createValidString(int open, int close, String string) {
		if(open==0 && close==0){
			System.out.println(string);
		}
		if(open > close){
			return;
		}
		if(open > 0){
			createValidString(open-1, close, string+"(");
		}
		if(close > 0){
			createValidString(open, close-1, string+")");
		}
	}
	
	
}

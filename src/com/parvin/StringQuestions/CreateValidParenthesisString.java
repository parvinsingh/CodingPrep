package com.parvin.StringQuestions;

import java.util.Stack;

import junit.framework.Assert;

public class CreateValidParenthesisString {

	public static void main(String args[]){
		String str1 = "String1";
		String str2 = new String("String1");
		str2.intern();
		String str3 = "String1";
		System.out.println(str1);
		System.out.println("=====");
		System.out.println(str1 == str2);
		
		System.out.println(str1.equalsIgnoreCase(str2));
		
		createValidString(3);
		System.out.println("=====");
		createValidString(6);
		System.out.println("=====");
		
		String s1 = "()";
		String s2 = "([]{})";
		String s3 = "()[]{}";
		String s4 = "([{}])";
		String s5 = "([{])";
		String s6 = "]{}])";
		String s7 = "]";
		String s8 = "[";
		String s9 = "";
		
		System.out.println(s1 + " " + isNotValid(s1));
		System.out.println(s2 + " " + isNotValid(s2));
		System.out.println(s3 + " " + isNotValid(s3));
		System.out.println(s4 + " " + isNotValid(s4));
		System.out.println(s5 + " " + isNotValid(s5));
		System.out.println(s6 + " " + isNotValid(s6));
		System.out.println(s7 + " " + isNotValid(s7));
		System.out.println(s8 + " " + isNotValid(s8));
		System.out.println(s9 + " " + isNotValid(s9));
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
	
	private static boolean isNotValid(String s) {
		String[] arr = s.split("");
		Stack<String> stack = new Stack<>();
		int i = 0;
		
		while(i < arr.length) {
			if(isClosed(arr[i])){
				if(stack.isEmpty() || !isValidConstruct(stack.pop() + arr[i])) {
					return true;
				}
				i++;
				continue;
			}
			stack.push(arr[i]);
			i++;
		}
		return stack.size()>0 ? true : false;
	}
	
	private static boolean isValidConstruct(String s) {
		return (s.equals("()") || s.equals("[]") || s.equals("{}"));
	}

	private static boolean isClosed(String s) {
		return (s.equals(")") || s.equals("]") || s.equals("}"));
	}
	
	
}

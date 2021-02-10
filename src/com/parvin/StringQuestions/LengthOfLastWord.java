package com.parvin.StringQuestions;

public class LengthOfLastWord {

	public static void main(String args[]) {
		System.out.println(lengthOfLastWord("Hello World"));
	}
	
	public static int lengthOfLastWord(String s) {
		s = s.trim();
		System.out.println(s);
		if(s.lastIndexOf(32) != -1) {
			return s.substring(s.lastIndexOf(32)+1).length();
		}else {
			return s.length();
		}
    }
	
	public static int lengthOfLastWord2(String s) {
		s = s.trim();
		System.out.println(s);
		if(s.lastIndexOf(32) != -1) {
			return s.substring(s.lastIndexOf(32)+1).length();
		}else {
			return s.length();
		}
    }
}

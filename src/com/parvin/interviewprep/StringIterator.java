package com.parvin.interviewprep;
//https://leetcode.com/articles/desing-compressed-string-iterator/

public class StringIterator {
	
	private static String deCompressString(String input) {
		StringBuilder str = new StringBuilder();
		int i = 0;
		int num = 0;
		while(i < input.length()) {
			char ch = input.charAt(i);
			if((i+1 < input.length()) && Character.isDigit(input.charAt(i+1))) {
				num = Character.getNumericValue(input.charAt(i+1));
				for(int j=1; j<=num; j++) {
					str.append(ch);
				}
				i=i+2;
			}else {
				str.append(ch);
				i++;
			}
		}
		return str.toString();
	}
	
	public static void main(String[] args) {
		String result = deCompressString2("GE2KSFORGE3K2");
		System.out.println(result);
	}
	
	private static String deCompressString2(String input) {
		StringBuilder builder = new StringBuilder();
		
		int i=0;
		while(i < input.length()-1) {//0134567891112
			char ch = input.charAt(i);//Geksforgeks
			if(Character.isDigit(input.charAt(i+1))) {//2
				int num = Character.getNumericValue(input.charAt(i+1));
				for(int k=1; k<=num; k++) {
					builder.append(ch);//geeksforgee
				}
				i = i+2;
			}else {
				builder.append(ch);//geeksforgeeks
				i = i+1;
			}
		}
		return builder.toString();
	}
}

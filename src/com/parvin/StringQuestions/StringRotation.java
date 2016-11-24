package com.parvin.StringQuestions;

public class StringRotation {

	public static void main (String args[]){
		isStringRotated("erbottlegat", "waterbottle");
	}
	
	private static void isStringRotated(String s2, String s1){
		if(s1==null && s2 == null){
			return;
		}
		if(s1 != null && s2 !=null && s1.length()!=s2.length()){
			System.out.print("Strings are not of equal length, so not rotated");
		}
		String tempString = s1 + s2;
		boolean isRotated = isSubString(s2, tempString);
		if(isRotated){
			System.out.print("Strings are rotated");
		}
	}
	
	private static boolean isSubString(String sub, String input){
		//need to check for all the characters in the STring
		return input.contains(sub);
	}
}

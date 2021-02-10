package com.parvin.StringQuestions;

public class StringEdits {

	public static void main(String args[]) {
		boolean result1 = areStringsEditable("pale", "bake");
		System.out.println(result1);
		boolean result2 = areStringsEditable("pale", "pales");
		System.out.println(result2);
		boolean result3 = areStringsEditable("pale", "ple");
		System.out.println(result3);
		boolean result4 = areStringsEditable("pale", "bale");
		System.out.println(result4);
		boolean result5 = areStringsEditable("pale", "palier");
		System.out.println(result5);
	}
	
	private static boolean areStringsEditable(String first, String second) {
		if(Math.abs(first.length() - second.length()) > 1) {
			return false;//cannot be edited by inserting, replacing or removing one character
		}
		
		boolean result = false;
		String s1 = first.length() < second.length() ? first : second; //shorter
		String s2 = first.length() < second.length() ? second : first; //longer
		int idx1 = 0;
		int idx2 = 0;
		while(idx2<s2.length() && idx1<s1.length()) {
			if(s1.charAt(idx1)!=s2.charAt(idx2)) {
				if(result) {
					return false;
				}
				result = true;
				if(s1.length() == s2.length()) {
					idx1++;
				}
			}else {
				idx1++;
			}
			idx2++;
		}
		
		return true;
	}
}

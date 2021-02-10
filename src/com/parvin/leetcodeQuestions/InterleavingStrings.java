package com.parvin.leetcodeQuestions;
//https://leetcode.com/problems/interleaving-string/
public class InterleavingStrings {

	public static void main(String[] args) {
		String s1 = "aa";
		String s2 = "ab";
		String s3 = "aaba";
		System.out.println(checkInterleaved(s1, s2, s3));
	}
	
	private static boolean areStringsInterleaved(String s1, String s2, String s3) {
		if(s3.equals(s1+s2) || s3.equals(s2+s1)) {
			return true;
		}
		if(s3.length() != (s1.length()+s2.length())){
			return false;
		}
		if(s3.isEmpty() || (s1.isEmpty() && s2.isEmpty())) {
			return false;
		}
		//Check for null and empty conditions
		while(!s3.isEmpty()) {
			//get S1 prefix
			int s1Prefix = getCommonPrefix(s1, s3).isEmpty() ? 0 : getCommonPrefix(s1, s3).length();
			int s2Prefix = getCommonPrefix(s2, s3).isEmpty() ? 0 : getCommonPrefix(s2, s3).length();
			
			if(s1Prefix == 0 && s2Prefix == 0) {
				return false;
			}
			
			if(s1Prefix >= s2Prefix) {
				s1 = s1.substring(s1Prefix, s1.length());
				s3 = s3.substring(s1Prefix, s3.length());
			}else {
				s2 = s2.substring(s2Prefix, s2.length());
				s3 = s3.substring(s2Prefix, s3.length());
			}
		}
		return true;
	}
	
	private static String getCommonPrefix(String A, String B) {
		int len = Math.min(A.length(), B.length());
		String prefix = "";
		for(int i=0; i<=len-1; i++) {
			if(A.charAt(i) == B.charAt(i)) {
				prefix = A.substring(0, i+1);
				continue;
			}else {
				break;
			}
		}
		return prefix;
	}
	
	private static boolean checkInterleaved(String str1, String str2, String CheckInString) {
		int i = 0, j = 0, k = 0;
		if (str1.length() + str2.length() != CheckInString.length()) {
			return false;
		}
		while (k < CheckInString.length()) {
			if (i < str1.length() && str1.charAt(i) == CheckInString.charAt(k)) {
				i++;
			} else if (j < str2.length() && str2.charAt(j) == CheckInString.charAt(k)) {
				j++;
			} else {
				return false;
			}
			k++;
		}
		if (!(i == str1.length() && j == str2.length() && k == CheckInString.length())) {
			return false;
		}
		return true;
	}
}

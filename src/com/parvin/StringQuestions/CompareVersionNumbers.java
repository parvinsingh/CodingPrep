package com.parvin.StringQuestions;
//https://leetcode.com/problems/compare-version-numbers/

public class CompareVersionNumbers {

	public static void main(String[] args) {
		System.out.println(compareVersions("1.01", "1.001"));
		System.out.println(compareVersions("1.0", "1.0.0"));
		System.out.println(compareVersions("7.5.2.4", "7.5.3"));
		System.out.println(compareVersions("1.0.1", "1"));
		System.out.println(compareVersions("0.1", "1.1"));
	}
	
	public static int compareVersions(String version1, String version2) {
		String v1 = version1;
		String v2 = version2;
		int result = 0;
		while(!v1.isEmpty() && !v2.isEmpty()) {
			String c1 = null;
			String c2 = null;
			if(v1.indexOf(".") != -1) {
				c1 = v1.substring(0,v1.indexOf("."));
			}else {
				c1 = v1;
			}
			if(v2.indexOf(".") != -1) {
				c2 = v2.substring(0,v2.indexOf("."));
			}else {
				c2 = v2;
			}
			result = compare(c1, c2);
			v1 = v1.indexOf(".") != -1 ? v1.substring(v1.indexOf(".")+1) : "";
			v2 = v2.indexOf(".") != -1 ? v2.substring(v2.indexOf(".")+1) : "";
			if(result == 0) {
				if(v2.isBlank()) {
					return v1.matches(".*[1-9].*") ? 1 : result;
				}else if(v1.isBlank()) {
					return v2.matches(".*[1-9].*") ? -1 : result;
				}
			}else {
				return result;
			}
		}
		 return result;
	}
	
	private static int compare(String C1, String C2) {
		if(Integer.valueOf(C1) == Integer.valueOf(C2)) {
			return 0;
		}
		return Integer.valueOf(C1) > Integer.valueOf(C2) ? 1 : -1;
	}
}

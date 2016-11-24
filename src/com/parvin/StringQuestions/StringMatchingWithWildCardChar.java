package com.parvin.StringQuestions;


/*
 * Given two strings where first string may contain wild card characters and 
 * second string is a normal string. Write a function that returns true if the 
 * two strings match. 
 * The following are allowed wild card characters in first string.
* --> Matches with 0 or more instances of any character or set of characters.
* ? --> Matches with any one character.
For example, "g*ks" matches with "geeks" match. 
And string "ge?ks*" matches with "geeksforgeeks" 
(note '*' at the end of first string). But "g*k" doesn't match with "gee"
as character 'k' is not present in second string.
 */

public class StringMatchingWithWildCardChar {
	
	public static void main(String args[]){
		test1();
		test2();
		test3();
		test4();
	}

	private static void test1() {
		boolean isMatch = isMatch("c:d", "caad"); // should be true is returned as false
		System.out.println(isMatch);
	}
	
	private static void test2() {
		boolean isMatch = isMatch("g:eks", "geeksforgeeks"); // should be true is returned as false
		System.out.println(isMatch);
	}
	
	private static void test3() {
		boolean isMatch = isMatch("ge?eks", "geeksforgeeks"); // should be true is returned as false
		System.out.println(isMatch);
	}
	
	private static void test4() {
		boolean isMatch = isMatch("ge?ks:", "geeksforgeeks"); // should be true is returned as false
		System.out.println(isMatch);
	}
	
	private static boolean isMatch(String wildStr, String normal){
		boolean isMatch = false;
		
		if(wildStr.contains("?") && !wildStr.contains(":")){
			if(wildStr.length() != normal.length()) return false;
			for(int i=0; i<wildStr.length(); i++){
				if(wildStr.charAt(i) == '?' || wildStr.charAt(i) == normal.charAt(i)){
					isMatch = true;
				}else{
					return false;
				}
			}
			return isMatch;
		}
		
		String[] fragments = wildStr.split(":");
		
		for(String fragment: fragments){
			if(fragment.contains("?")){
				for(int i=0; i<fragment.length(); i++){
					if(fragment.charAt(i) == '?' || fragment.charAt(i) == normal.charAt(i)){
						isMatch = true;
					}else{
						return false;
					}
				}
			}else{
				int index = normal.indexOf(fragment);
				if(index != -1){
					isMatch = true;
					normal.substring(index+1, normal.length());
				}else{
					return false;
				}
			}
		}
		return isMatch;
	}
	
}

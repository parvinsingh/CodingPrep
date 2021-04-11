package com.parvin.StringQuestions;

public class InterleavingStrings {

	public static void main(String args[]) {
		String s1 = "a";
		String s2 = "";
		String s3 = "c";
		s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
		s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
		s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
		
		System.out.println(areStringsInterleaved(s1, s2, s3));
	}
	
	public static boolean areStringsInterleaved(String s1, String s2, String s3) {
		
		if(s3.equals(s1+s2) || s3.equals(s2+s1)) {
			return true;
		}
		
        if(s3.isEmpty() || s3.length() != (s1.length()+s2.length())){
			return false;
		}
		
		if(s1.isEmpty() && !s3.equalsIgnoreCase(s2)
				|| s2.isEmpty() && !s3.equalsIgnoreCase(s1)) {
			return false;
		}
        
        if(s3.charAt(0) != s1.charAt(0) && s3.charAt(0) != s2.charAt(0)) {
			return false;
		}
		
		if(s3.charAt(0) == s1.charAt(0) && s3.charAt(0) == s2.charAt(0)) {
			return areStringsInterleaved(s1.substring(1), s2, s3.substring(1))
					|| areStringsInterleaved(s1, s2.substring(1), s3.substring(1));
		}else if(s3.charAt(0) == s1.charAt(0) && s3.charAt(0) != s2.charAt(0)) {
			return areStringsInterleaved(s1.substring(1), s2, s3.substring(1));
		}else {
			return areStringsInterleaved(s1, s2.substring(1), s3.substring(1));
		}
	}
}

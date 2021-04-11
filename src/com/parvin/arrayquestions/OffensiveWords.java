package com.parvin.arrayquestions;

public class OffensiveWords {

	public static void main( String args[] ) {
        // Driver code

        //String S = "mooooronnn"; // modified word
		String S = "mooorooonnn"; // modified word
		String W = "moron"; // original word
        
        if (flagWords(S, W)){
            System.out.println("Word Flagged");
            System.out.println("The Word " + '"' + S + '"' + " is a possible morph of " + '"' + W + '"');
        }
        else
            System.out.println("Word Safe");
    }

	private static boolean flagWords(String s, String w) {
		int i=0;
		int j=0;
		
		while(i<s.length() && j<w.length()) {
			if(s.charAt(i)!=w.charAt(j)) {
				return true;
			}
			int countW = getCharCount(w, j, w.length());
			int countS = getCharCount(s, i, s.length());
			
			if(countS-countW>=3) {
				return true;
			}
			i = i+countS;
			j = j+countW;
		}
		
		return false;
	}

	private static int getCharCount(String word, int idx, int len) {
		int count = 0;
		for(int i=idx; i<len; i++) {
			if(word.charAt(i)!=word.charAt(idx)) {
				return count;
			}
			count++;
		}
		return count;
	}
	
}

package com.parvin.StringQuestions;


public class ReverseVowelsInString {

	public static String reverseVowels(String s) {
        if(s==null || s.isEmpty()) return s;
        char[] letters = s.toCharArray();
        char[] vowels = new char[s.length()];
        int i=0;
        for(char ch: letters){
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' 
            		|| ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ){
                vowels[i]=ch;
                i++;
            }
        }
        i--;
        for(int j=0; j<letters.length && i>=0; j++){
            char ch = letters[j];
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' 
            		|| ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ){
                letters[j] = vowels[i];
                i--;
            }
        }
        return new String(letters);
    }

	 public static void main(String[] args) {
	        
		 	String input = "aA";
	        System.out.println("Input: " + input + " Output: " + reverseVowels(input));
	   }	
}

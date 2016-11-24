package com.parvin.StringQuestions;
/*
 * Find the longest word that is available in the array of words.
 */

public class LongestWordInDictionary {

	private String findLongestWord(String[] inputWords, char letters[]){
		int maxWordSize = 1;
		String maxWord = null;
		int[] available = new int[26];
		for(char c: letters){
			int index = c - 'a';
			available[index]++;
		}
		for(String word: inputWords){
			if(word.length() > letters.length){
				continue; //go to the next String
			}
			boolean isValidWord = true;
			int[] count = new int[26];
			for(char c: word.toCharArray()){
				int index = c - 'a';
				count[index]++;
				if(count[index] > available[index]){
					//Not a valid word
					isValidWord = false;
					break;
				}
			}
			if(isValidWord && word.length() >= maxWordSize){
				maxWord = word;
			}
		}
		return maxWord;
	}
}

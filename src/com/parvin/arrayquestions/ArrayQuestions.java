package com.parvin.arrayquestions;
/**
 * Given an array A, how would you create an array B where for each i from 0 to n, 
b[i] = a[0] * a[1] * ... * a[n-1] /a[i] 
You should do this in O(n) time without using division. 

As an example, if A = {1,2,3,4}, B should be (24,12,8,6).
 * @author ppanesar
 *
 */
public class ArrayQuestions {

	//Using Inner class to return the indices and values
	class IndexValue{
		int highIndex;
		int lowIndex;
		int maxValue;
	}	
	
	public static void main(String[] args){
//		int[] arr = {2, 5, 1, 7, 3, 9} ;
//		ArrayQuestions aq = new ArrayQuestions();
//		ArrayQuestions.IndexValue value = aq.new IndexValue();
//		IndexValue maxValue = findMaxDiff(arr, value);
//		System.out.println(maxValue.maxValue);
		int[] arr = {1,2,3,5,6,7,8,9,4};
//		mergeSortingAlgo(arr);
	}
	
	//Find the intersection of two input arrays
	
	
	//find the max difference in a given array of integers,
	//the larger number always appears after the smaller number
	private static IndexValue findMaxDiff(int[] inputArr, IndexValue value){
		int input = inputArr[0];
		int lowIndex = 0;
		int highIndex = 0;
		int maxDiff = 0;
		for(int i=1; i<inputArr.length; i++){
			if(inputArr[i]>input){
				int currDiff = inputArr[i]-input;
				if(currDiff >= maxDiff){
					maxDiff = currDiff;
					highIndex = i;
				}
			}else{
				input=inputArr[i];
				lowIndex = i;
			}
		}
		value.lowIndex = lowIndex;
		value.highIndex = highIndex;
		value.maxValue = maxDiff;
		return value;
	}
	
	//Find the largest sequence in the array
	public static int[] largestSequence(int[] arr){
		int maxStartIndex = 0;
		int maxEndIndex = 0;
		int maxStartIndexSoFar = 0;
		//int maxStartValue = arr[0];
		int maxEndValue = arr[0];
		int maxSum = arr[0];//max so far
		for(int i=1; i<arr.length; i++){
			if(maxEndValue<0){
				maxEndValue = arr[i];
				maxStartIndexSoFar = i;
			}else{
				maxEndValue = maxEndValue + arr[i];
			}
			if(maxEndValue > maxSum){
				maxSum = maxEndValue;
				maxEndIndex = i;
				maxStartIndex = maxStartIndexSoFar;
			}
		}
		int[] result = new int[arr.length];
	    int index=0;
	    for(int j=maxStartIndex; j<maxEndIndex; j++){
	      result[index]=arr[j];
	      index++;
	    }
	  return result;
	}
	
	
	//Finding the longest word from the given array of words
	private String findLongestWord(String[] inputWords, char[] letters){
		int maxWordLength = 0;
		String maxWord = null;
		int[] charCount = new int[26];//integer array to keep the count at the letter index
		for(char ch: letters){
			int index = ch - 'a';
			charCount[index]++;
		}
		//Loop over the array of Strings
		
		for(String word: inputWords){
			if(word==null || word.length() > letters.length){
				continue; // move on to the next word
			}
			boolean legalWord = true;
			int[] wordCount = new int[26];
			for(char ch: word.toCharArray()){
				int index = ch - 'a';
				wordCount[index]++;
				if(wordCount[index]>charCount[index]){
					legalWord = false;
					break;
				}
			}
			if(legalWord && maxWordLength < word.length()){
				maxWordLength = word.length();
				maxWord = word; 
			}
		}
		return maxWord;
	}
}

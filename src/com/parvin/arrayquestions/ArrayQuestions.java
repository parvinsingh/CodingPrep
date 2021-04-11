package com.parvin.arrayquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Random array questions
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
		testMinSwapsUsingCyclicSort();
		testMinSwapsUsingBFS();
		testFindMaxDiffBetweenSuccessiveElements();
		testFindLargestDiff();
		testLargestSequence();
	}
	
	private static void testMinSwapsUsingCyclicSort() {
		int[] arr = {1,5,4,3,2};
		System.out.println(minimumSwapsCyclicSort(arr));
		System.out.println("=====");
	}
	
	private static void testMinSwapsUsingBFS() {
		int[] arr = {1,5,4,3,2};
		System.out.println(minimumSwaps(arr));
		System.out.println("=====");
	}
	
	private static void testFindLongestWord() {
		//findLongestWord
	}
	
	private static void testLargestSequence() {
		
	}
	
	private static void testFindMaxDiffBetweenSuccessiveElements() {
		int[] arr = {2, 5, 1, 7, 3, 9};
		System.out.println(findMaxDiffBetweenSuccessiveElements(arr));
		System.out.println("=====");
	}
	
	private static void testFindLargestDiff() {
		int n=6;
		List<Integer> list = new ArrayList<Integer>(); 
		list.add(2); 
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(findLargestDiff(6, list));
	}
	
	//find largest difference after removing integers in the list
	//given an integer array with some ints removed, find the largest difference
	//between consecutive numbers.
	//n- > number of integers, starting from 1.
	//e.g: n=6, arr=[2,4] -> means that number 2 and 4 are removed 
	//this is a part of PrisonBreak problem
	public static int findLargestDiff(int n, List<Integer> arr) {
		int diff = 1;
		int maxDiff = 1;
		for(int i=1; i<=n-1; i++) {
			if(arr.contains(i) && arr.contains(i+1)) {
				diff++;
			}else {
				diff = 1;
			}
			maxDiff = Math.max(diff, maxDiff);
		}
		return maxDiff+1;
	}
	
	
	private static int findMaxDiffBetweenSuccessiveElements(int[] inputArr){
		Arrays.sort(inputArr);
		int input = inputArr[0];
		int maxDiff = 0;
		for(int i=1; i<inputArr.length; i++){
			if(inputArr[i]>input){
				int currDiff = inputArr[i]-input;
				maxDiff = Math.max(maxDiff, currDiff);
			}
			input=inputArr[i];
		}
		return maxDiff;
	}
	
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
	
	public static void subSortArray(int[] input) {
		int end_left = findLeftPoint(input);
		if(end_left >= input.length-1) {
			return; //already sorted
		}
		int start_right = findRightPoint(input);
	}
	
	private static int findLeftPoint(int[] array) {
		for(int i=1; i<array.length; i++) {
			if(array[i] < array[i-1]) return i-1;
		}
		return array.length-1;
	}
	
	private static int findRightPoint(int[] array) {
		for(int i=array.length-2; i>=0; i--) {
			if(array[i] > array[i+1]) return i+1;
		}
		return 0;
	}
	
	//find the minimum swaps needed to sort the array
	//time: O(nlogn) space- O(n)
	//min swaps is when each element is at its right index in array
	private static int minimumSwaps(int[] arr) {
        boolean[] visited = new boolean[arr.length+1];
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=1; i<visited.length; i++){
            map.put(i, arr[i-1]);
        }
        
        int swapCount = 0;
        for(int i=1; i<map.size(); i++){
            
            if(!visited[i]){
                visited[i] = true;
                
                if(i == map.get(i)){
                    continue;
                }else{
                    int indexToSwapWith = map.get(i);
                    
                    while(!visited[indexToSwapWith]){
                        visited[indexToSwapWith] = true;
                        
                        int nextIndex = map.get(indexToSwapWith);
                        indexToSwapWith = nextIndex;
                        swapCount = swapCount + 1;
                    }
                }
            }
        }
        return swapCount;
    }
	
	//O(n) time and O(1) space.
	//while loop runs in the worst case for O(n-1) times and for loop O(n)
	//note there is no i increment inside while loop
	private static int minimumSwapsCyclicSort(int[] a) {
		int count = 0;
		for(int i=0; i<a.length; i++){//i=0,1,2,3
	      while(i+1!=a[i]){
	        int temp = a[a[i] - 1];//temp = a[5] = 2
	        a[a[i] - 1] = a[i];//a[5] = a[1] = 6
	        a[i] = temp;//a[1] = 2
	        count++;
	      }
	    } 
		return count;
	}
}

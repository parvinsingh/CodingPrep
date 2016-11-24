package com.parvin.arrayquestions;
/**
 * An array of n integers with both positive and negative integers
 * Find the first continuous sequence of integers with the largest sum
 * {-7,4,-2,5,3,-6,8,-9} = {4,-2,5,3,-6,8}
 * @author ppanesar
 *
 */
public class LargestSequenceInArray {

	public static void main(String args[]){
		int[] input = {1,2,4,-10,1,2,3};//{-7,-2,5,3,-6,8,-9};
		maxSequence(input);
	}
	
	private static void maxSequence(int[] arr){
		int maxSoFar = arr[0];//-7,4,7,10,12
		int maxEndingHere = arr[0];//-7,4,2,7,10,4,12,3
		int maxEndingIndex = 0;
		int maxStartingIndex = 0;
		for(int i=1; i<arr.length; i++){
			if(maxEndingHere<0){
				maxEndingHere=arr[i];//max sum till now, temporarily
				maxStartingIndex=i;
			}else{
				maxEndingHere = maxEndingHere + arr[i];
			}
			if(maxEndingHere >= maxSoFar){
				maxSoFar = maxEndingHere;
				maxEndingIndex = i;
			}
		}
		System.out.print
			("maxStartingIndex: " + maxStartingIndex + " maxEndingIndex: " + maxEndingIndex);
		System.out.print('\n');
		System.out.print("max Sequence Sum: " + maxSoFar + "\n");
		for(int i=maxStartingIndex; i<=maxEndingIndex; i++){
			System.out.print(arr[i]);
			System.out.print(", ");
		}
	}
}

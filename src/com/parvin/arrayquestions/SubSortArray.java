package com.parvin.arrayquestions;

import Utilities.PrintArrays;

//find two indices in an originally unsorted array, between which when sorted, will return the entire array sorted
public class SubSortArray {

	public static void main(String args[]) {
		int[] array = {1,2,4,7,10,11,7,12,6,7,16,18,19};
		int[] result = SubSortingIndices(array);
		
		PrintArrays.printArray(result);
	}
	
	public static int[] SubSortingIndices(int[] array){
		int leftEnd = findLeftIndex(array);// -1 indicates its already sorted
		int rightEnd = findRightIndex(array);// -1 indicates its already sorted
		
		//middle part is from leftEnd to rightEnd
		//now find the minimum and max in the middle
		//entire left side should be less than Min of Middle
		//entire right side should be more than Max of Middle
		
		int min_idx = rightEnd; //min of right side;
		int max_idx = leftEnd;
		
		for(int i=leftEnd+1; i<=rightEnd; i++) {
			if(array[i] < array[min_idx]) {
				min_idx = i;
			}
			if(array[i] > array[max_idx]) {
				max_idx = i;
			}
		}
		
		//extend the left and rights
		int L = shrinkLeft(array, leftEnd, min_idx);
		int R = shrinkRight(array, rightEnd, max_idx);
		
		return new int[]{L,R};
	}
	
	private static int shrinkRight(int[] array, int rightEnd, int max_idx) {
		int compare = array[max_idx];
		for(int i=rightEnd; i<array.length; i++) {
			if(array[i] >= compare) {
				return i-1;
			}
		}
		return array.length-1;
	}

	private static int shrinkLeft(int[] array, int leftEnd, int min_idx) {
		int compare = array[min_idx];
		for(int i=leftEnd-1; i>=0; i--) {
			if(array[i]<=compare) {
				return i+1;
			}
		}
		return 0;
	}

	private static int findRightIndex(int[] arr) {
		for(int i=arr.length-2; i>=0; i--) {
			if(arr[i] > arr[i+1]) {
				return i+1;
			}
		}
		return -1;
	}

	private static int findLeftIndex(int[] arr) {
		for(int i=1; i<=arr.length-1; i++) {
			if(arr[i] < arr[i-1]) {
				return i-1;
			}
		}
		return -1;
	}
	
}

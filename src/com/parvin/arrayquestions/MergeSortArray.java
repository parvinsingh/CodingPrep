package com.parvin.arrayquestions;

public class MergeSortArray {
	
	public static void main(String[] args){
		int[] arr = {1,2,3,5,6,7,8,9,4};
		mergeSortingAlgo(arr);
	}
	
	//MergeSort an array of integers
		//O(n logN) time complexity
		//O(N) space complexity
		public static void mergeSortingAlgo(int[] input){
			int[] helperArr = new int[input.length];
			mergeSort(input, 0, input.length-1, helperArr);
			for(int i=0; i<input.length-1; i++){
				System.out.println(input[i]);
			}
		}
		
		private static void mergeSort(int[] arr, int start, int end, int[] helper){
			if(start<end){
				int mid = (start+end)/2;
				mergeSort(arr, start, mid, helper);//left half
				mergeSort(arr, mid+1, end, helper);//right half
				merge(arr, start, end, mid, helper);
			}
		}
		
		private static void merge(int[] arr, int start, int end, int mid, int[] helper){
			//copying the values into a temporary array
			for(int i=start; i<=end; i++){
				helper[i] = arr[i];
			}
			int left = start;
			int right = mid+1;
			int current = start;//this is for reading the original array
			while(left<=mid && right<=end){
				if(helper[left]<=helper[right]){
					arr[current] = helper[left];
					left++;
				}else{
					arr[current] = helper[right];
					right++;
				}
				current++;
			}
			if(left<=mid){
				arr[current] = arr[left];
				current++;
				left++;
			}
		}
}

	package com.parvin.numbers;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
 * @author papanesa
 *
 */
public class ArrayRotation {

	public static void main(String args[]) {
		int[] array = {4,5,6,7,0,1,2};
		int[] array2 = {6,9,12,0,3,5};
		int[] array3 = {5};
		int resultIndex = findNumInRotatedArray(array, 6);
		System.out.println(resultIndex);
		System.out.println(findNumInRotatedArray(array, 3));
		System.out.println(findNumInRotatedArray(array, 1));
		System.out.println(findNumInRotatedArray(array2, 12));
		System.out.println(findNumInRotatedArray(array3, 6));
	}
	
	private static int findNumInRotatedArray(int[] nums, int target) {
		if(nums.length < 1) return -1;
		int pivot = findPivot(nums, 0, nums.length-1);
		if(pivot == -1) {
			// not rotated at all
			return binarySearch(nums, target, 0, nums.length-1);
		}
		
		if(nums[pivot] == target) {
			return pivot;
		}
		if(nums[0] <= target) {
			return binarySearch(nums, target, 0, pivot-1);
		}
		return binarySearch(nums, target, pivot+1, nums.length-1);
	}

	private static int findPivot(int[] arr, int low, int high) {
		if(high < low) {
			return -1;
		}
		if(high == low) {
			return low;
		}
		
		int mid = (high+low) / 2;
		if(mid < high && arr[mid] > arr[mid+1]) {
			return mid+1;
		}
		if(mid > low && arr[mid] < arr[mid-1]) {
			return mid-1;
		}
		if (arr[low] >= arr[mid]) {
	        return findPivot(arr, low, mid-1); 
		}
	    return findPivot(arr, mid + 1, high); 
	}

	private static int binarySearch(int[] arr, int key, int low, int high) {
       if (high < low) 
           return -1; 
         
       /* low + (high - low)/2; */       
       int mid = (low + high)/2;   
       if (key == arr[mid]) 
           return mid; 
       if (key > arr[mid]) 
           return binarySearch(arr, key, (mid + 1), high); 
       return binarySearch(arr, key, low, (mid -1));
	}
}

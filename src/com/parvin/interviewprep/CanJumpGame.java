package com.parvin.interviewprep;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * 
 * The key to solve this problem is to find: 
 * 1) when the current position can not reach next position (return false) , 
 * and 2) when the maximum index can reach the end (return true).
 */
public class CanJumpGame {

	public static void main(String[] args) {
		int[] arr1 = {3,2,1,0,4};
		int[] arr2 = {2,3,1,1,4};
		//int[] arr3 = {1,2,3};
		int[][] arr = {arr1, arr2};
		for(int[] a : arr) {
			System.out.println(canJump(a));
		}
	}
	
	private static boolean canJump(int[] arr) {
		if(arr.length <= 0) {
			return false;
		}
		if(arr.length == 1) {
			return true;
		}
		int maxReachIndex = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(maxReachIndex <= i && arr[i]==0) {
				return false;
			}
			if(maxReachIndex < i + arr[i]){
				maxReachIndex = i + arr[i];
			}
			if(maxReachIndex >= arr.length-1) {
				return true;
			}
		}
		return true;
	}
}

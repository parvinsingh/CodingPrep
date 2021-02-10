package com.parvin.interviewprep;

public class CanJumpGame {

	public static void main(String[] args) {
//		int[] arr1 = {3,2,1,0,4};
		int[] arr2 = {2,3,1,1,4};
		//int[] arr3 = {1,2,3};
		int[][] arr = {arr2};
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

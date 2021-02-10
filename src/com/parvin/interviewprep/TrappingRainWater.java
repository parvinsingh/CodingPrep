package com.parvin.interviewprep;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 * @author papanesa
 *
 */
public class TrappingRainWater {

	public static void main(String args[]) {
		int[] arr1 = {2,0,2};
		int[] arr2 = {3,0,0,2,0,4};
		int[] arr3 = {0,1,0,2,1,0,1,3,2,1,2,1};
		List<int[]> input = new ArrayList<int[]>();
		//input.add(arr1);
		//input.add(arr2);
		input.add(arr3);
		for(int[] a : input) {
			System.out.println(trapRainWater(a));
		}
	}
	
	private static int trapRainWater(int[] arr) {
		int[] leftArr = new int[arr.length];//capture the max number to the left of the element
		int[] rightArr = new int[arr.length];//capture the max number to the right of the element
		
		leftArr[0] = arr[0];
		rightArr[arr.length-1] = arr[arr.length-1];
		int lmax = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			leftArr[i] = Math.max(leftArr[i-1], arr[i]);
		}
		for(int i=arr.length-2; i>=0; i--) {
			rightArr[i] = Math.max(rightArr[i+1], arr[i]);
		}
		int c = 0;
		for(int i=0; i<arr.length; i++) {
			c = c + (Math.min(leftArr[i], rightArr[i])-arr[i]);
		}
		
		return c;
		
	}
}

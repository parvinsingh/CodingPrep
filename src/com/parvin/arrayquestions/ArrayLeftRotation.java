package com.parvin.arrayquestions;

/**
 * Rotate the given array to the left by number of steps.
 * input = [1,2,3,4,5] and 3
 * output = [4,5,1,2,3]
 * @author papanesa
 *
 */
public class ArrayLeftRotation {

	public static void main(String args[]) {
		int[] arr = {1,2,3,4,5};
		int[] result = rotateleft2(arr, 3);
		for(int i: result) {
			System.out.print(i + ",");
		}
	}
	
	private static int[] rotateleft2(int[] arr, int steps) {
		int[] result = new int[arr.length];
		int idx = 0;
		
		for(int i=steps; i<arr.length; i++) {
			result[idx] = arr[i];
			idx++;
		}
		
		for(int i=0; i<steps; i++) {
			result[idx] = arr[i];
			idx++;
		}
		return result;
	}
	
}

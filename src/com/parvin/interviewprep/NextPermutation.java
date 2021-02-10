package com.parvin.interviewprep;

import java.util.ArrayList;

/**
 * https://leetcode.com/articles/next-permutation/
 * We need to find the first pair of two successive numbers a[i]a[i] and a[i-1]a[i−1], 
 * from the right, which satisfy a[i] > a[i-1]a[i]>a[i−1]. 
 * Now, no rearrangements to the right of a[i-1]a[i−1] can create a larger permutation 
 * since that subarray consists of numbers in descending order. 
 * Thus, we need to rearrange the numbers to the right of a[i-1]a[i−1] including itself.
 * @author papanesa
 *
 */
public class NextPermutation {

	public static void main(String args[]) {
		String ip = "abedc";
		//int[] nums = {2,1,8,7,6,5}; //find the next largest number in sequence.
		int[] nums = {1,2,3,4};
		int[] result = nextPermutation(nums);
		for(int r : result) {
			System.out.println(r);
		}
		
	}
	
	private static int[] nextPermutation(int[] input) {
		//read the input reverse, and find the point where it stops becoming ascending
		
		int pivot = 0;
		for(int i=input.length-1; i>0; i--) {
			if(input[i] > input[i-1]) {
				pivot = i-1;
				break;
			}
		}
		int id = input.length-1;
		for(int k=input.length-1; k>pivot; k--) {
			if(input[k] > input[pivot]) {
				id = k;
				break;
			}
		}
		swap(input, id, pivot);
		reverse(input, pivot+1);
		return input;
	}
	
	private static void swap(int[] nums, int index, int pivot) {
		int temp = nums[pivot];
		nums[pivot] = nums[index];
		nums[index] = temp;	
	}
	
	private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}

package com.parvin.arrayquestions;

/**
 * 	
 * 
 * @author papanesa
 *
 */
public class JumpGame {
	
	public static void main(String[] args) {
		int[] nums1 = {2,3,0,0,4};
		int[] nums2 = {4,2,3,0,3,1,2};
		boolean canJump = jumpgame1(nums1);
		System.out.println(canJump);
		System.out.println(jumpgame3(nums2, 2, 0));
	}
	
	private static boolean jumpgame1(int[] array) {
		int lastknowngoodindex = array.length-1;
		for(int i=array.length-1; i>=0; i--) {
			if(i+array[i] >= lastknowngoodindex) {
				lastknowngoodindex = i;
			}
		}
		return lastknowngoodindex == 0;
	}
	
	// https://leetcode.com/problems/jump-game-iii/
	private static boolean jumpgame3(int[] array, int start, int count) {
		if(start < 0 || start > array.length-1) {
			return false;
		}
		if(count >= array.length) {
			return false;
		}
		if(array[start] == 0) {
			return true;
		}
		return jumpgame3(array, start+array[start], count+1) ||
				jumpgame3(array, start-array[start], count+1);
	}
}

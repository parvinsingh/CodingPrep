package com.parvin.arrayquestions;

/**
 * 	
 * 
 * @author papanesa
 *
 */
public class JumpGame {
	
	public static void main(String[] args) {
		int[] nums1 = {2,1,1,1,4};
		int[] nums2 = {4,2,3,0,0,1,2};
		System.out.println(minJumps(nums2));
//		boolean canJump = jumpgame1(nums1);
//		System.out.println(canJump);
//		System.out.println(jumpgame3(nums2, 2, 0));
	}
	//1,3,5,8,9,2,6,7,6,8,9
	private static boolean jumpgame1(int[] array) {
		int lastknowngoodindex = array.length-1;//10
		for(int i=array.length-1; i>=0; i--) {
			if(i+array[i] >= lastknowngoodindex) {
				lastknowngoodindex = i;
			}
		}
		return lastknowngoodindex == 0;
	}
	
	static int minJumps(int arr[])
	{
		if (arr.length <= 1)
			return 0;

		// Return -1 if not possible to jump
		if (arr[0] == 0)
			return -1;

		// initialization
		int maxReach = arr[0];
		int step = arr[0];
		int jump = 1;

		// Start traversing array
		for (int i = 1; i < arr.length; i++) {
			// Check if we have reached the end of the array
			if (i == arr.length - 1)
				return jump;

			// updating maxReach
			maxReach = Math.max(maxReach, i + arr[i]);

			// we use a step to get to the current index
			step--;

			// If no further steps left {4,2,3,0,0,1,2}
			if (step == 0) {
				// we must have used a jump
				jump++;

				// Check if the current index/position or lesser index is the 
				// maximum reach point from the previous indexes
				if (i >= maxReach)
					return -1;

				// re-initialize the steps to the amount
				// of steps to reach maxReach from position i.
				step = maxReach - i;
			}
		}

		return -1;
	}
	
	public static int countMinJumps(int[] jumps) {
	    int dp[] = new int[jumps.length];
	    return countMinJumpsRecursive(dp, jumps, 0);
	  }

	  private static int countMinJumpsRecursive(int[] dp, int[] jumps, int currentIndex) {
	    // if we have reached the last index, we don't need any more jumps
	    if( currentIndex == jumps.length - 1)
	      return 0;

	    // If an element is 0, then we cannot move through that element
	    if (jumps[currentIndex] == 0)
	      return Integer.MAX_VALUE;

	    // if we have already solved this problem, return the result
	    if(dp[currentIndex] != 0)
	      return dp[currentIndex];

	    int totalJumps = Integer.MAX_VALUE;
	    int start = currentIndex + 1;
	    int end = currentIndex + jumps[currentIndex];
	    while(start < jumps.length && start <= end) {
	      // jump one step and recurse for the remaining array
	      int minJumps = countMinJumpsRecursive(dp, jumps, start++);
	      if(minJumps != Integer.MAX_VALUE)
	        totalJumps = Math.min(totalJumps, minJumps + 1);
	    }
	    dp[currentIndex] = totalJumps;
	    return dp[currentIndex];
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

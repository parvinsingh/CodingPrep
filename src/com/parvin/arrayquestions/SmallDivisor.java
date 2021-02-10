package com.parvin.arrayquestions;

public class SmallDivisor {

	public static void main(String args[]) {
		int[] nums = {44,22,33,11,1};
		
		System.out.println(SmallestDivisorGivenThreshold(nums, 5));
	}
	
	public static long SmallestDivisorGivenThreshold(int[] nums, int thresh) {
		int end = 2;
		while(computeSum(nums, end) > thresh) {
			end = 2*end;
		}
		
		int start = end/2;
		while(start < end) {
			int mid = start + (end-start)/2;
			if(computeSum(nums, mid) > thresh) {
				start = mid+1;
			}else {
				end = mid;
			}
		}
		return start;
	}
	
	private static long computeSum(int[] nums, int x) {
		long sum = 0;
		for(int n: nums) {
			sum += n/x + (n%x == 0 ? 0 : 1);
		}
		return sum;
	}
}

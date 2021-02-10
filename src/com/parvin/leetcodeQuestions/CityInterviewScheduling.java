package com.parvin.leetcodeQuestions;

import java.util.ArrayList;

//https://leetcode.com/problems/two-city-scheduling/

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CityInterviewScheduling {

	public static void main(String args[]) {
//		int[][] costs = {{10,20}, {200,30}, {400,50}, {30,20}};
//		System.out.println(CostOfScheduling(costs, 4));
//		int[][] costs2 = {{10,20}, {30,200}, {50,400}, {30,20}};
//		System.out.println(CostOfScheduling(costs2, 4));
		int[] nums = {1,1,3,1,2,3,5};
		System.out.println(minSubArrayLen(7, nums));
	}
	
	private static int CostOfScheduling(int[][] costs, int num) {
		Arrays.sort(costs, (a, b) -> 
			((a[0]-a[1]) - (b[0] - b[1]))
		);
		int cost = 0;
		for(int i=0; i<num/2; i++) {
			cost = cost + costs[i][0];
		}
		for(int i=num/2; i<num; i++) {
			cost = cost + costs[i][1];
		}
		return cost;
	}
	
	//using sliding window
	//minimum size subarray
	public static int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int l = 0, r = 0;
        int currSum = 0;
        
        int res = Integer.MAX_VALUE;
        
        while(r < n) {
            while(r < n && currSum < s) {
                currSum += nums[r];
                r++;
            }
            
            while(l < n && currSum >= s) {
                currSum -= nums[l];
                res = Math.min(res, r-l);
                l++;
            }
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
    }
	
}

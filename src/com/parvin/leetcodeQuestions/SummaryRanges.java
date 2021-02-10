package com.parvin.leetcodeQuestions;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/summary-ranges/
/*
 * Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 */

public class SummaryRanges {
	
	public static void main(String args[]) {
		int[] input = {0,2,3,4,6,8,9};
		List<String> output = summaryRanges(input);
		for(String s: output){
			System.out.println(s);
		}
	}

	 public static List<String> summaryRanges(int[] nums) {
		 int len = nums.length;
		 int index = 0;
		 List<String> result = new ArrayList<String>();
		 StringBuffer strBuff = new StringBuffer();
	     while(index < len) {
	    	 int start = nums[index];
	    	 while((index<len-1) && nums[index]+1 == nums[index+1]) {
	    		 index++;
	    	 }
	    	 if(start < nums[index]) {
	    		 strBuff.append(start + "->"+nums[index]);
	    	 }else {
	    		 strBuff.append(nums[index]);
	    	 }
	    	 result.add(strBuff.toString());
	    	 strBuff = new StringBuffer();
	    	 index++;
	     }
	     return result;
	 }	
}

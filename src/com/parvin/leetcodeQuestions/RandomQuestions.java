package com.parvin.leetcodeQuestions;

import java.io.*;
import java.util.*;

public class RandomQuestions {
	  public static void main(String[] argv) {
//	    System.out.println("Hello, world!");
//	    System.out.println("This is a fully functioning Java environment.");
//	    int[] hArray = {1,8,6,2,5,4,8,3,7};
//	    int area = maxArea(hArray);
//	    System.out.println(area);
	    
//	    int[] nums = {1,2,3,4}; //{10,3,5,6,2};
//	    int[] product = productOfArray(nums);
//	    for(int i: product){
//	      System.out.print(i + ",");
//	    }
	    
	    int[] nums2 = {1,-8,6,2,5,4,8,3,7}; //{-1,0,-2,0};
	    int maxProduct = maxProductSubArray(nums2);
	    System.out.println(maxProduct);
	  }

	//container with most water
	//https://leetcode.com/problems/container-with-most-water/
	private static int maxArea(int[] height) {
	    int maxArea = Integer.MIN_VALUE;
	    int i = 0;
	    int j = height.length-1;
	    int h = 0;
	    int area = 0;
	
	    while(i<j){
	      h = (height[i] >= height[j]) ? height[j] : height[i];
	      area = h * (j-i);
	      if(area > maxArea){
	        maxArea = area;
	      }
	      if(height[i] >= height[j]){
	        j--;
	      }else{
	        i++;
	      }
	    }
	  return maxArea;
	  }
	
	  //output the product of array nums, except the num[i].
	//https://leetcode.com/problems/product-of-array-except-self/
	  private static int[] productOfArray(int[] nums){
	    int len = nums.length;
	    int left[] = new int[len];
	    int right[] = new int[len];
	    int result[] = new int[len];
	    
	    int product = 1;
	    left[0] = 1;
	    right[len-1] = 1;
	    for(int i = 1; i<len; i++){
	      product = product * nums[i-1];
	      left[i] = product;
	    }
	    product = 1;
	    for(int i = len-2; i>=0; i--){
	      product = product * nums[i+1];
	      right[i] = product;
	    }
	    for(int j=0; j<len; j++){
	      result[j] = left[j] * right[j];
	    }
	    return result;
	  }
	  
	// Given an integer array nums, find the contiguous subarray within an array 
	//(containing at least one number) which has the largest product. 
	  private static int maxProductSubArray(int[] nums){
	    int prevMin = nums[0];
	    int prevMax = nums[0];
	    int result = nums[0];
	    int currentMax = nums[0];
	    int currentMin = nums[0];
	    
	    for(int i=1; i<nums.length; i++){
	      currentMax = Math.max(prevMin*nums[i], Math.max(prevMax*nums[i],nums[i]));
	      currentMin = Math.min(prevMin*nums[i], Math.min(prevMax*nums[i],nums[i]));
	      result = Math.max(result, currentMax);
	      prevMin = currentMin;
	      prevMax = currentMax;
	    }
	    return result;
	  }
  
}


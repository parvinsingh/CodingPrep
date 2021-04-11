package com.parvin.interviewprep;

import java.util.Collections;
import java.util.PriorityQueue;

import Utilities.PrintArrays;

/*
 * Given an int[] of len L and a windowSize W, output the max element for every
 * window. The output[] will contain L-W+1 elements.
 */

public class MaxNumInSlidingWindow {

	public static void main(String args[]) {
		//int[] input = {8,9,6,4,7,2,3,5};
		//int[] input = {9,8,7,6,5,4,3,2,1};
		int[] input = {1,2,3,4,5,6,7,8,9};
		int wSize = 3;
		int[] result = findMaxInWindow(input, wSize);
		int[] result2 = findMaxInWindow2(input, wSize);
		PrintArrays.printArray(result);
		PrintArrays.printArray(result2);
	}
	
	//time complexity: O((N-W+1)*(W)) -> O(NW)
	//space complexity: O(1)
	private static int[] findMaxInWindow2(int[] input, int wSize) {
		int[] result = new int[input.length-wSize+1];
		for(int i=0; i<=input.length-wSize; i++) {//iterate upto len-windowSize
			int max = input[i];
			for(int j=i+1; j<i+wSize; j++) {
				//run from index 1 more to window size, wSize times.
				if(max < input[j]) {
					max = input[j];
				}
			}
			result[i] = max;
		}
		return result;
	}

	//using a max PQ, the max elem will always be on the top.
	//Note: in a PriorityQueue -> the heapification occurs during the add or offer operation
	//Space Complexity -> O(W)
	//Time Complexity -> O(N*Wlog(W)) time
	private static int[] findMaxInWindow(int[] input, int wSize) {
		int[] result = new int[input.length-wSize+1];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		int i=0;
		int idx = 0;
		for(; i<wSize; i++) {
			pq.add(input[i]);//O(log (W)) time
		}
		
		result[idx] = pq.peek();//constant time O(1)
		idx++;
		
		for(; i<input.length; i++) {
			if(pq.size() == wSize) {
				pq.remove(input[i-wSize]);//O(W) time
			}
			pq.add(input[i]);//O(log(W))
			result[idx] = pq.peek();
			idx++;
		}
		
		return result;
	}
	
}

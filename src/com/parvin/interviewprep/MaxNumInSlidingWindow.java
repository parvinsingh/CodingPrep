package com.parvin.interviewprep;

import java.util.Collections;
import java.util.PriorityQueue;

import Utilities.PrintArrays;

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
	
	//time complexity: O((N-K+1)*(K)) -> O(NK)
	//space complexity: O(1)
	private static int[] findMaxInWindow2(int[] input, int wSize) {
		int[] result = new int[input.length-wSize+1];
		for(int i=0; i<=input.length-wSize; i++) {
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

	private static int[] findMaxInWindow(int[] input, int wSize) {
		int[] result = new int[input.length-wSize+1];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		int i=0;
		int idx = 0;
		for(; i<wSize; i++) {
			pq.add(input[i]);
		}
		
		result[idx] = pq.peek();
		idx++;
		
		for(; i<input.length; i++) {
			if(pq.size() == wSize) {
				pq.remove(input[i-wSize]);
			}
			pq.add(input[i]);
			result[idx] = pq.peek();
			idx++;
		}
		
		return result;
	}
	
}

package com.parvin.arrayquestions;

import java.util.Collections;
import java.util.PriorityQueue;

//Find the Nth smallest element in an unsorted array in linear time

public class NthSmallestElement {

	public static void main(String args[]) {
		int[] input = {10,2,5,6,11,3,15};//2,3,5,6,10,11,15
		
		int result = findNSmallest(input, 3);
		System.out.println(result);
		System.out.println(findNLargest(input, 3));
	}

	private static int findNSmallest(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<arr.length; i++) {
			pq.add(arr[i]);
		}
		
		while(k-1 > 0) {
			pq.poll();
			k--;
		}
		
		return pq.poll();
	}
	
	private static int findNLargest(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<arr.length; i++) {
			pq.add(arr[i]);
		}
		
		while(k-1 > 0) {
			pq.poll();
			k--;
		}
		return pq.poll();
	}
}

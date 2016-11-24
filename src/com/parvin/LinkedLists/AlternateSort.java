package com.parvin.LinkedLists;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

// Java program to rearrange a given list such that it
// consists of alternating minimum maximum elements
public class AlternateSort {
	
	public static void main(String args[]){
		Integer[] arr = {1,21,11,5,4,17,29,10};
		LinkedList<Integer> input = new LinkedList<Integer>(Arrays.asList(arr));
	
		rearrangeAndSort(input);
	}
	
	private static void rearrangeAndSort(LinkedList<Integer> input){
		Collections.sort(input);
		for(int i=1; i<(input.size()+1)/2; i++){
			int last = input.removeLast();
			input.add(2*i-1, last);
		}
		System.out.println(input);
	}
}

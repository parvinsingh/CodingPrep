package com.parvin.arrayquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlattenArray {

	public static void main(String args[]) {
		int[][] arr = { 
	            {1}, 
	            { 3, 4, 5, 6 }, 
	            { 7, 8, 9 } , {10}
	        }; 
		Integer[] flatArray = flattenStream(arr) 
                .toArray(Integer[] ::new); 

		// Print the flattened array 
		System.out.println(Arrays.toString(flatArray)); 
	}
	
	private static List<Integer> flattenStream(int[][] arrays){
		List<Integer> list = new ArrayList<Integer>();
		
		for(int[] arr: arrays) {
			Arrays.stream(arr).forEach(list::add);
		}
		
		return list;
	}
}

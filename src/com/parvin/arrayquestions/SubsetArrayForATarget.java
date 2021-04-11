package com.parvin.arrayquestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetArrayForATarget {

	public static void main(String args[]) {
		int[] input = {1,1,-1,2,3,4};
		int target = 5;
		Set<String> result = new HashSet<String>();
		printSubsetSums(input, target, 0, new String(), result);
		
		for(String s: result) {
			System.out.println(s);
		}
		System.out.println("===============");
		List<ArrayList<Integer>> result2 = new ArrayList<ArrayList<Integer>>();
		returnSubsetArrays(input, target, result2, 0, new ArrayList<Integer>());
		for(ArrayList<Integer> s: result2) {
			System.out.print("{");
			for(int i: s) {
				System.out.print(i+",");
			}
			System.out.println("}");
		}
	}
	
	public static void returnSubsetArrays
							(int[] arr, int target, List<ArrayList<Integer>> result, int idx, ArrayList<Integer> temp) {
		if(target == 0 && !temp.isEmpty()) {
			result.add(temp);
			temp = new ArrayList<Integer>();
			return;
		}
//		if(idx == arr.length) {
//			return;
//		}
		
		//if(target>0 && idx<arr.length) {
			returnSubsetArrays(arr, target, result, idx+1, temp); //exclude
			temp.add(arr[idx]);
			returnSubsetArrays(arr, target-arr[idx], result, idx+1, temp);//include
		//}
		
		
	}
	
	//in general did not account for as particularly exceptional in coding in JAVA
	//6 hr interview -> intro-15 mins -> personal touch
	//1.5 hr - virtual whiteboard - talk through the problem
	//1 hr - craft demonstration project - MS powerpoint - create this presentation
	//1:1 manager conversation 
	
	//print-all-subsets-in-an-array-that-equal-to-a-given-sum-recursively
	public static void printSubsetSums(int[] arr, int sum, int i, String acc, Set<String> result) 
    {
        if (sum == 0 && !"".equals(acc)) {
        	result.add(acc);
            //System.out.println(acc);
            acc = "";
        }
        if (i == arr.length) {
            return;
        }
        printSubsetSums(arr, sum, i + 1, acc, result);//exclude the value at index
        printSubsetSums(arr, sum - arr[i], i + 1, acc+" "+arr[i], result); // include the value at index
    }
	
}

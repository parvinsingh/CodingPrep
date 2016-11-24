package com.parvin.arrayquestions;

/**
 * Find the largest and second largest from a given sorted array
 * 
 * @author ppanesar
 *
 */
public class HighAndSecondHighest {

	private static void highAndSecondHigh(int[] arr){
		int max = arr[0];
		int secondMax = arr[0];
		for(int i=1; i < arr.length; i++){
			if(arr[i]>=max){
				secondMax=max;
				max=arr[i];
			}else if(arr[i]>=secondMax){
				secondMax = arr[i];
			}
		}
		System.out.println("highest value is = " + max);
		System.out.println("Second highest value is = " + secondMax);
	}
	
	public static void main(String args[]){
		int[] arr = new int[]{15,19,10,3,1,11,21};
		highAndSecondHigh(arr);
	}
}

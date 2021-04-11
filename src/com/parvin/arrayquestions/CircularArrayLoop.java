package com.parvin.arrayquestions;

/**
 * Check loop in array according to given constraints
Given an array arr[0..n-1] of positive and negative numbers we need to find if there is a 
cycle in array with given rules of movements. If a number at an i index is positive, 
then move arr[i]%n forward steps, i.e., next index to visit is (i + arr[i])%n. 
Conversely, if it’s negative, move backward arr[i]%n steps i.e., next index to visit is (i – arr[i])%n. 
Here n is size of array. If value of arr[i]%n is zero, then it means no move from index i.
 * @author papanesa
 *
 */
public class CircularArrayLoop {

	public static void main(String args[]){
		//int[] input = {1,2};
		int[] input = {2, -1, 1, 2, 2};//{2, -1, 0, 2, 2};
		boolean isLooped = circularArrayLoop(input);
		System.out.print(isLooped);
	}
	
	public static boolean circularArrayLoop(int[] nums) {
		int size = nums.length;
        if(size < 2) return false;
        
        int loopStartIndex = 0;
        int index = 0;
        do{
        	if(nums[index] > 0){
            	index = moveForward(index, nums[index], size);
            }else if(nums[index] < 0){
            	index = moveBackward(index, Math.abs(nums[index]), size);
            }else {
            	return false; //0 at an index means no loop
            }
        	if(loopStartIndex == index) return true;
        }while (loopStartIndex != index);
        return false;
    }

	private static int moveBackward(int i, int steps, int size) {
		int index = i;
		while(steps > 0){
			steps--;
			index--;
			if(index < 0) 
				index = size -1;
		}
		return index;
	}

	private static int moveForward(int i, int steps, int size) {
		int index = i;
		while(steps > 0){
			steps--;
			index++;
			if(index > size-1) 
				index = 0;
		}
		return index;
	}
	
}

package com.parvin.arrayquestions;

import java.util.Stack;

public class CircularArrayLoop {

	public static void main(String args[]){
		int[] input = {-1,2};
		boolean isLooped = circularArrayLoop(input);
		System.out.print(isLooped);
	}
	
	public static boolean circularArrayLoop(int[] nums) {
		int size = nums.length;
        if(size < 2) return false;
        
        int loopStartIndex = 0;
        int index = 0;
        int start = nums[0];
        do{
        	if(nums[index] > 0){
            	index = moveForward(index, nums[index], size);
            }else {
            	index = moveBackward(index, Math.abs(nums[index]), size);
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

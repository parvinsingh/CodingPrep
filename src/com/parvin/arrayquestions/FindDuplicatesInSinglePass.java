package com.parvin.arrayquestions;

public class FindDuplicatesInSinglePass {

	//Array of itnegers 
	//length = 1+n    100
	//range of numbers = 1 to n    1 to 99   1 - 50 and 51 - 99
	// I need to find out the duplicates, and print them
	
	public static void main(String args[]){
		int[] arr = {4,3,3,5,2,1,7,9,8,4};
		findRepeating(arr, arr.length);
	}
	
	public int findDuplicate(int[] array){
		return findDuplicate(array, array.length-1);
	}
	
	private int findDuplicate(int[] array, int n){
		
		int bigRange = n/2 ; //[1-50], size of range
		int smallRange = n/2-1;   //[51-99], size of range
		int bigRangeCounter = 0;
		int smallRangeCounter = 0;
		
		for(int i=0; i<array.length-1; i++){
			if(array[i]>0 && array[i]<=bigRange){
				bigRangeCounter ++;
			}else if (array[i]>smallRange){
				smallRangeCounter ++;
			}
		}
		if(smallRangeCounter > smallRange){
			return findDuplicate(array, smallRange);
		}
		return 0;
	}
	
	//arr = [4,6,3,5,2,1,7,9,8,4]		
	//findDuplicate(arr, 10)
	//findDuplicate(arr, 5)
	
	private static void findRepeating(int[] arr, int size){
		int i;
		  System.out.println("The repeating elements are: \n");
		  for(i = 0; i < size; i++)
		  {
		    if(arr[Math.abs(arr[i])] >= 0){
		      arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
		    }else{
		    	System.out.println(Math.abs(arr[i]));
		    }
		  }
	}
	
	
}

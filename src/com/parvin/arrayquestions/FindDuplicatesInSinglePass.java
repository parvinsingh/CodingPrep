package com.parvin.arrayquestions;

public class FindDuplicatesInSinglePass {

	//Array of itnegers 
	//length = 1+n    100
	//range of numbers = 1 to n    1 to 99   1 - 50 and 51 - 99
	// I need to find out the duplicates, and print them
	
	public static void main(String args[]){
		int[] arr = {4,3,3,5,2,1,7,9,8,4};
		findDuplicate(arr);
	}
	
	public static void findDuplicate(int[] array){
		int[] temp = new int[99];
		for(int i=0; i<array.length; i++) {
			temp[array[i]]++;
			if(temp[array[i]]>1) {
				System.out.println(array[i]);
			}
		}	
	}
	
}

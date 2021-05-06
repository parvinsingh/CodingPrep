package com.parvin.arrayquestions;

import java.util.ArrayList;

public class FindDuplicatesInSinglePass {

	//Array of itnegers 
	//length = 1+n    100
	//range of numbers = 1 to n    1 to 99   1 - 50 and 51 - 99
	// I need to find out the duplicates, and print them
	
//	public static void main(String args[]){
//		int[] arr = {4,3,3,5,2,1,7,9,8,4};
//		findDuplicate(arr);
//	}
	
	public static void findDuplicate(int[] array){
		int[] temp = new int[99];
		for(int i=0; i<array.length; i++) {
			temp[array[i]]++;
			if(temp[array[i]]>1) {
				System.out.println(array[i]);
			}
		}	
	}
	
	//find missing number from the given array of numbers
	//this approach avoids overflow
	// if overflow is not a concern, we can do n*(n+1)/2 - sum
	private static void getMissingNo(int a[]) 
    {
		//assume that index is same as value
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int j = a[0];//init to the first value in array
		for (int i=0;i<a.length;i++)
		{
		    if (j==a[i])
		    {//if number is present then value at index and value(j) are same
		        j++;
		        continue;
		    }
		    else
		    {
		        arr.add(j);
		        i--;//this is needed because arr[i-1] might be equal to value j+1
		    j++;
		    }
		}
		System.out.println("missing numbers are ");
		for(int r : arr)
		{
		    System.out.println(" " + r);
		}
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        int[] arr = { 1,2,3,4,6,7,8,9,10,12 };
        getMissingNo(arr);
    }
	
}

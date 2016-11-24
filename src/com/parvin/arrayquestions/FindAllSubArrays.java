package com.parvin.arrayquestions;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubArrays {

	public static void main(String[] args){
		int[] arr = {2, 5, 1, 7, 3, 9} ;
		findAllSubsetArrays(arr);
	}
	
	private static void findAllSubsetArrays(int[] arr){
		int size = arr.length;
		int[] copy = arr;
		
		List<int[]> arryList = new ArrayList<int[]>();
		//int[] tempArr2 = new int[size];
		//int[] tempArr1 = new int[size];
		//int temp = 0;
		for(int i=0; i<size; i++){
			int[] tempArr = {arr[i]};
//			tempArr1[i] = arr[i]; 
			arryList.add(tempArr);
			int[] tempArr1 = new int[size];
			for(int j=i+1; j<size; j++){
				tempArr1[j] = arr[j];
				arryList.add(tempArr1);
			}
		}
		for(int[] subArray: arryList){
			System.out.print("{ ");
			for(int m=0; m<subArray.length; m++){
				System.out.print(subArray[m] + ",");
			}
			System.out.println("}");
		}
	}
	
}

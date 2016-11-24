package com.parvin.StringQuestions;

public class ApptioPhoneScreen {
//To find the largest sequence in an array
//	Input = array of integers, -ve & +ves
//			  output = sub-array of integers, that when totalled gives the largest sum
//			    
//			input= [-7,2,3,1,5,-100] , output= [2,3,1,5]
//			    
//			    input = [1,2,4,-10,1,2,3]
	public static void main(String args[]){
		int[] input = {1,2,4,-10,1,5,3};//{-7,-2,5,3,-6,8,-9};
		int[] result = getMaxSubArray(input);
		for(int i: result){
			System.out.print(i);
			System.out.print(", ");
		}
	}
	
			    private static int[] getMaxSubArray(int[] arr){    
					
			    //error condition
			    if(arr==null || arr.length<=0){
			      //print error
			    	return null;
			    }
			    
			    int maxstartingIndex =0;
					int maxendIndex = 0;
			   	int maxSum = 0;
			    int maxSumSoFar = arr[0];
			    int maxStartingIndexSoFar = 0;
			    
			    for(int i=1; i<arr.length; i++){
			    
			    	if(maxSumSoFar<0) { 
			    		maxSumSoFar = arr[i];
			      	maxStartingIndexSoFar = i;
			      }else{
			      	maxSumSoFar = maxSumSoFar + arr[i]; //7-10=-3
			      }
			      if(maxSumSoFar >= maxSum){
			        maxSum = maxSumSoFar; //7
			        maxendIndex = i;     //'2'
			        maxstartingIndex = maxStartingIndexSoFar;
			      }
			  	}  
				int[] result = new int[arr.length];
			    int index=0;
			    for(int j=maxstartingIndex; j<=maxendIndex; j++){
			      result[index]=arr[j];
			      index++;
			    }
			  return result;
			}
			    
	
}

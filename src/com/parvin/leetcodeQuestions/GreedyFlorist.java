package com.parvin.leetcodeQuestions;

import java.io.IOException;

public class GreedyFlorist {

	
	    // Complete the getMinimumCost function below.
	private static int getMinimumCost(int k, int[] c) {
	        int numOfFlowers = c.length;
	        int minCost = 0;
	        int[] friends = new int[k];
	        int index = 0;
	        for(int i = c.length-1; 
        			i>=0 && numOfFlowers>0; 
        			i--, numOfFlowers--) {
	        	if(index==k) {
	        		index = 0;
	        	}
        		minCost = minCost + c[i]*(1+friends[index]);
        		friends[index]++; 
        		index++;
        	}
	        
	        return minCost;
	    }

	    public static void main(String[] args) throws IOException {
	        int[] cost = {1,3,5,7,9};
	        System.out.println(getMinimumCost(3, cost));
	    }
}

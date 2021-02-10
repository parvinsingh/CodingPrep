package com.parvin.leetcodeQuestions;
//https://www.programcreek.com/2014/03/leetcode-gas-station-java/
public class GasStation {

	public static void main(String args[]) {
		//int[][] input = {{1,1},{2,3},{3,2},{4,4},{5,5}};
		int[][] input = {{4,3},{5,2},{2,7},{6,3},{5,2},{3,9}};
		System.out.println(canCompleteCircuit(input));
		
		int[] gas = {4,5,2,6,5,3};
		int[] cost = {3,2,7,3,2,9};
		System.out.println(canCompleteCircuit(gas, cost));
	}
	
	public static int canCompleteCircuit(int[] gas, int[] cost) {
        int remainingTillNext = 0;
        int TotalGasRemaining = 0;
        int start = 0;
        for(int i=0; i<gas.length; i++){
            int temp = gas[i]-cost[i];//1
            
            if(remainingTillNext >= 0){
                remainingTillNext += temp;//-1
            }else{
                remainingTillNext = temp;//1
                start = i;//2
            }
            TotalGasRemaining += remainingTillNext;//-1
        }
        return TotalGasRemaining>=0 ? start : -1;
    }
	
	public static int canCompleteCircuit(int[][] GasAndCost) {
		int sumRemaining = 0; //gas remaining from previous stop point 
		int totalRemaining = 0; // total gas remaining
		int start = 0;
		
		for(int i=0; i<GasAndCost.length; i++) {
			int remaining = GasAndCost[i][0] - GasAndCost[i][1];
			if(sumRemaining >= 0) {
				sumRemaining += remaining; 
			}else {
				//if previous gas remaining was negative
				sumRemaining = remaining;
				start = i;
			}
			totalRemaining += sumRemaining;
		}
		
		return totalRemaining >= 0 ? start : -1;
	}
}

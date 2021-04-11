package com.parvin.interviewprep;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
	
	public static void main(String[] args) {
	     int[][] schedules = {{3,20}, {-2, 0}, {0,2}, {16,17}, {19,23}, {30,40}, {27, 33}};
	     int[][] result = meetingTimes(schedules, -5, 44, 2);
	     
	        //print array
	    for(int i=0; i< result.length; i++){
	        System.out.println(result[i][0] + "," + result[i][1]);
	        
	    }
	   }
	
	// schedules[][] -> represents the busy calendar times.
	// given duration of the meeting, and start and end times, you need to
	// find out all the slots where the meeting can be booked.
	public static int[][] meetingTimes(int[][] schedules, int start, int end, int duration){
	    
	    //sorted array on start times
	    Arrays.sort(schedules, new Comparator<int[]>() {
	        @Override
	        public int compare(int[] a, int[] b){
	            return a[0]-b[0];
	        }
	    
	    });
	    
	    int[][] output = new int[schedules.length+1][2];
	    int maxEnd = start;
	    int idx = 0;
	    for(int i=0; i<schedules.length; i++){
	        if(maxEnd < schedules[i][0] && Math.abs(maxEnd - schedules[i][0]) >= duration){
	            output[idx][0] = maxEnd;
	            output[idx][1] = schedules[i][0];
	        }
	        maxEnd = maxEnd > schedules[i][1] ? maxEnd : schedules[i][1];
	        idx++;
	    }
	    
	    if(maxEnd < end && Math.abs(maxEnd - end) >= duration) {
	    	output[idx][0] = maxEnd;
            output[idx][1] = end;
	    }
	    
	    return Arrays.stream(output).filter(s -> (s[0] != s[1])).toArray(int[][] :: new);
	    //return output;
	    
	}

//	public static void main(String args[]) {
//		int[][] a = {{2,3},{4,5},{6,7},{8,9},{1,10}};
//		//int[][] a = {{1,4},{0,4}};
//		int[][] op = merge(a);
//		for(int i=0; i<op.length; i++) {
//			if(op[i] != null) {
//				System.out.print(op[i][0] + "," + op[i][1]);
//				System.out.println();	
//			}
//		}
//	}
//	
	/*
	 * https://leetcode.com/problems/merge-intervals/
	 * @author papanesa
	 * Input: [[1,3],[2,6],[8,10],[15,18]]
	 * Output: [[1,6],[8,10],[15,18]]
	 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
	 *
	 */
	private static int[][] merge(int[][] input) {
		if(input.length <= 0) {
			return new int[0][];
		}
		
		//sort the input based on the first index of the interval
		Arrays.sort(input, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
			
		});
		
		int len = input.length;
		
		int[][] output = new int[len][];
		int op = 0;
		int index = 1;
		int[] temp = input[0];
		while(index < len) {
			if(merge(temp, input[index])) {
				int b[] = input[index];
				temp[0] = temp[0] >= b[0] ? b[0] : temp[0];
				temp[1] = temp[1] <= b[1] ? b[1] : temp[1];
			}else {
				output[op] = temp;
				op++;
				temp = input[index];
			}
			index++;
		}
		output[op] = temp;
		
		//filtering takes care of removing the nulls
		return Arrays.stream(output).filter(s -> (s != null)).toArray(int[][] :: new);
	}
	
	private static boolean merge(int[] a, int[] b) {
		if((a[0] <= b[0]) && (b[0] <= a[1])
				||((b[0] <= a[0]) && (a[0] <= b[1]))) {
			return true;
		}
		return false;
	}
}

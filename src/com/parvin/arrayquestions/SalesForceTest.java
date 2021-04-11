package com.parvin.arrayquestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SalesForceTest {

	public static void main(String args[]) {
		//List<Integer> input = Arrays.asList(new Integer[] {10,20,10,15,5,30,20});
		
		Integer[] arr = {6,18,8,14,10,12,18,9};
		LinkedList<Integer> input = new LinkedList<Integer>(Arrays.asList(arr));
		
		long result = teamFormation(input, 8, 3);
		System.out.println(result);
		
	}
	//remove the max from front or end, given the window size k.
	public static long teamFormation(List<Integer> score, int team_size, int k) {
	    
		int i=0;
		int j=score.size();
		int t = 0;
		int front_max = 0;
		int back_max = 0;
		
		int[] team = new int[team_size];

		long sum = 0;
		if(score.size() <= k || score.size()==team_size){
            for(int a: score) {
                sum = sum+a;
            }
            return sum;
        }
		int backIdx = 0;
		while(t < team_size) {
			//loop from front
			for(i=0; i<k; i++) {
				front_max = Math.max(front_max, score.get(i));
			}
			
			//loop from back
			for(j=score.size()-1; j>=score.size()-k; j--) {
				if(back_max <= score.get(j)) {
					back_max = score.get(j);
					backIdx = j;
					continue;
				}
				//back_max = Math.max(back_max, score.get(j));
			}
			
			if(front_max > back_max) {
				int idx = score.indexOf(front_max);
				team[t] = score.remove(idx);
			}else if(front_max < back_max) {
				//int idx = score.lastIndexOf(back_max);
				team[t] = score.remove(backIdx);
			}else {
				int idx = score.indexOf(front_max);
				team[t] = score.remove(idx);
			}
			t++;
			front_max = 0;
			back_max = 0;
		}

		for(int a: team) {
			sum = sum+a;
		}
		return sum;
	}
	
}

package com.parvin.leetcodeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/most-visited-sector-in-a-circular-track/

public class MostVisitedSector {
	
	public static void main(String args[]) {
		int[] rounds = {1,3,1,2};
		List<Integer> result = mostVisited(4, rounds);
		for(int i: result) {
			System.out.println();	
		}
		
	}

	public static List<Integer> mostVisited(int n, int[] rounds) {
		List<Integer> ans = new ArrayList<>();
        if(rounds[0] <= rounds[rounds.length - 1]) {
            for(int i = rounds[0]; i <= rounds[rounds.length - 1]; i++) {
                ans.add(i);
            }
        }
        else {
            for(int i = 1; i <= rounds[rounds.length - 1]; i++) {
                ans.add(i);
            }
            for(int i = rounds[0]; i <= n; i++) {
                ans.add(i);
            }
        }
        return ans;
    }
}

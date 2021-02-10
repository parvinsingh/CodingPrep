package com.parvin.leetcodeQuestions;

import java.util.ArrayDeque;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/ 

public class RottenOranges {

	public static void main(String[] args) {
		int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
		int[][] grid1 = {{2,1,1},{1,1,0},{0,1,1}};
		int[][] grid2 = {{0,2}};
		int[][] grid3 = {{1,1,2,0,2,0}};
		System.out.println(timeToRot(grid));
	}
	
	public static int timeToRot(int[][] input) {
		int rowLength = input.length;
		int colLength = input[0].length;
		int time = 0;
		Queue<Orange> qu = new ArrayDeque<Orange>();
		RottenOranges ro = new RottenOranges();
		int count_fresh = 0;
		
		for(int a=0; a<rowLength; a++) {
			for(int b=0; b<colLength; b++) {
				if(input[a][b] == 2) {
					qu.add(ro.new Orange(a, b));
				}else if(input[a][b] == 1) {
                    count_fresh++;
                }
			}
		}
		if(count_fresh == 0) {//no oranges to rot
			return 0;
		}
		
		while(!qu.isEmpty()) {
			int size = qu.size();
			boolean change = false;
			
			for(int k=0; k<size; k++) {
				Orange currentO = qu.poll();
				
				int i = currentO.r;
				int j = currentO.c;
				
				if((j-1)>=0 && input[i][j-1]==1) {
					input[i][j-1] = 2;
					qu.add(ro.new Orange(i, j-1));
					count_fresh--;
					change = true;
				}
				if((j+1)<colLength && input[i][j+1]==1) {
					input[i][j+1] = 2;
					qu.add(ro.new Orange(i, j+1));
					count_fresh--;
					change = true;
				}
				if((i-1)>=0 && input[i-1][j]==1) {
					input[i-1][j] = 2;
					qu.add(ro.new Orange(i-1, j));
					count_fresh--;
					change = true;
				}
				if((i+1)<rowLength && input[i+1][j]==1) {
					input[i+1][j] = 2;
					qu.add(ro.new Orange(i+1, j));
					count_fresh--;
					change = true;
				}
			}
			if(change) {
				time++;
			}
			
		}
		
		return count_fresh == 0 ? time : -1;
	}
	
	class Orange { // represents the minute taken for the orange to rot
		int r;
		int c;
		public Orange(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}

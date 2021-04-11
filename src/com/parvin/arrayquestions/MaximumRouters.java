package com.parvin.arrayquestions;

public class MaximumRouters {

	public static void main(String args[]) {
		int[][] grid = {
	            {2,9,6},
	            {8,4,7},
	            {5,3,1}
	        };
	        System.out.println("Maximum Routers are " + maxRouters(grid));
	}

	private static int maxRouters(int[][] grid) {
		// TODO Auto-generated method stub
		int[][] cache = new int[grid.length][grid[0].length];
		int res = 0;
		
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(cache[i][j]==0) {
					int prev_val = grid[i][j];
					dfsSearch(i, j,grid ,cache, prev_val);
					res = Math.max(res, cache[i][j]);
				}
			}
		}
		
		return res;
	}

	private static int dfsSearch(int i, int j, int[][] grid, int[][] cache, int prev) {
		if(i < 0 || j < 0 || i > grid.length-1 || j > grid[0].length-1) {
			return 0;
		}else if(prev > grid[i][j]) {
			return 0;
		}else if(cache[i][j] != 0) {
            return cache[i][j];
		}
		
		int down = dfsSearch(i+1, j, grid, cache, grid[i][j]);//down
		int up = dfsSearch(i-1, j, grid, cache, grid[i][j]);//up
		int right = dfsSearch(i, j+1, grid, cache, grid[i][j]);//right
		int left = dfsSearch(i, j-1, grid, cache, grid[i][j]);//left
		
		cache[i][j] = 1+ Math.max(Math.max(right, left), Math.max(up, down));
		return cache[i][j];
	}
	
}

package com.parvin.interviewprep;
//https://leetcode.com/problems/unique-paths/
public class UniquePathsOnGrid {

	public static void main(String args[]) {
		System.out.println(CountOfUniquePaths(7, 3));
//		int[][] input = {{1}};
//		System.out.println(CountOfUniquePathsWithObstacles(input));
		int[][] input = {{1,3,1},{1,5,1},{4,2,1}};
		//int[][] input = {{1,4,8,6,2,2,1,7},{4,7,3,1,4,5,5,1},{8,8,2,1,1,8,0,1},{8,9,2,9,8,0,8,9},{5,7,5,7,1,8,5,5},{7,0,9,4,5,6,5,6},{4,9,9,7,9,1,9,0}};
		System.out.println(minPathSum(input));
		System.out.println(minPathSumDP(input));
	}
	
	private static int CountOfUniquePaths(int m, int n) {
		int[][] tempCount = new int[m][n];
		for(int i=0; i<m; i++) {
			tempCount[i][0]=1; //left-most column is all 1
		}
		
		for(int i=0; i<n; i++) {
			tempCount[0][i]=1; //top-most row is all 1
		}
		
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				tempCount[i][j] = tempCount[i][j-1] + tempCount[i-1][j];
			}
		}
		return tempCount[m-1][n-1];
	}
	
	public static int CountOfUniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;//rows
		int n = obstacleGrid[0].length;//cols
		
		int[][] tempCount = new int[m][n];
		for(int i=0; i<m; i++) {
			if(obstacleGrid[i][0] == 1 || (i != 0 && tempCount[i-1][0] == 0)) {
				tempCount[i][0]=0;
			}else {
				tempCount[i][0]=1; //left-most column is all 1	
			}
		}
		
		for(int i=0; i<n; i++) {
			if(obstacleGrid[0][i] == 1 || (i != 0 && tempCount[0][i-1] == 0)) {
				tempCount[0][i]=0;
			}else {
				tempCount[0][i]=1; //top-most row is all 1
			}
		}
		
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				tempCount[i][j] = (obstacleGrid[i][j] == 1) ?
									0 : tempCount[i][j-1] + tempCount[i-1][j];
			}
		}
		return tempCount[m-1][n-1];
    }
	
	//https://leetcode.com/problems/minimum-path-sum/
	public static int minPathSum(int[][] grid) {
		return minPathSum(0, 0, grid);
	}
	
	public static int minPathSum(int r, int c, int[][] grid) {
		if(r == grid.length-1 && c == grid[0].length-1) {
			return grid[r][c];
		}
		
		if(r<grid.length-1 && c<grid[0].length-1) {
			int r1 = grid[r][c] + minPathSum(r+1, c, grid);
			int r2 = grid[r][c] + minPathSum(r, c+1, grid);
			
			return Math.min(r1, r2);
		}
		if(r<grid.length-1) {//left most column
			return grid[r][c] + minPathSum(r+1, c, grid);
		}
		
		if(c<grid[0].length-1) {//top row
			return grid[r][c] + minPathSum(r, c+1, grid);
		}
		return 0;
    }
	
	public static int minPathSumDP(int[][] grid) {
	    if(grid == null || grid.length==0)
	        return 0;
	 
	    int m = grid.length;
	    int n = grid[0].length;
	 
	    int[][] dp = new int[m][n];
	    dp[0][0] = grid[0][0];    
	 
	    // initialize top row with sum
	    for(int i=1; i<n; i++){
	        dp[0][i] = dp[0][i-1] + grid[0][i];
	    }
	 
	    // initialize left column with sum
	    for(int j=1; j<m; j++){
	        dp[j][0] = dp[j-1][0] + grid[j][0];
	    }
	 
	    // fill up the dp table with 
	    // for each cell calculate the sum from top and side
	    for(int i=1; i<m; i++){
	        for(int j=1; j<n; j++){
	            if(dp[i-1][j] > dp[i][j-1]){
	                dp[i][j] = dp[i][j-1] + grid[i][j];
	            }else{
	                dp[i][j] = dp[i-1][j] + grid[i][j];
	            }
	        }
	    }
	 
	    return dp[m-1][n-1];
	}
}

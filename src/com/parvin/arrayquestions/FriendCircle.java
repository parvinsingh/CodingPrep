package com.parvin.arrayquestions;

public class FriendCircle {
	
	public static void main(String args[]) 
	  { 
	      int n = 4;
	      int[][] friends = {
	        {1,1,0,0},
	        {1,1,1,0},
	        {0,1,1,0},
	        {0,0,0,1}
	      };
	      
	      //int[] visited = {0,1,0,0};
	      
	     System.out.println("Number of friends circles: " + FindNumOfCircles(friends, n)); 
	  } 

	public static int FindNumOfCircles(int[][] matrix, int n) {
		int r = matrix.length;
		int c = matrix[0].length;
		int[] visited = new int[matrix[0].length];
		int numOfCircles = 0;
		
		for(int i=0; i<r; i++) {
			if(visited[i]==0) {
				dfsSearch(visited, matrix, i, c);
				numOfCircles++;
			}
		}
		return numOfCircles;
	}
	
	public static void dfsSearch(int[] visited, int[][] matrix, int row, int col) {
		for(int i=0; i<col; i++) {
			if(matrix[row][i] == 1 && visited[i]==0 && i!=row) {
				visited[i]=1;
				dfsSearch(visited, matrix, i, col);
			}
		}
	}
	
}

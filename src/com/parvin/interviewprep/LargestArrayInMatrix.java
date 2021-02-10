package com.parvin.interviewprep;

public class LargestArrayInMatrix {
	
	public static void main(String args[]) {
		int[][] input = {
				{1,0,0,1,0,0},
				{0,0,1,1,0,0},
				{1,1,1,1,1,0},
				{0,1,1,1,1,1},
				{0,1,1,1,1,1},
				{1,1,1,1,1,1}
		};
		Cell result = LargestArray(input);
		System.out.println("Size of largest square = " + result.size);
		System.out.println("Co-ordinates of square are = {" 
				+ (result.r-result.size+1) + "," + (result.c-result.size+1)
				+ "} and {" 
				+ (result.r) + "," + (result.c) + "}");
	}

	private static Cell LargestArray(int[][] input) {
		int rows = input.length;
		int cols = input[0].length;
		LargestArrayInMatrix lm = new LargestArrayInMatrix();
		int[][] result = new int[input.length][input[0].length];
		Cell maxSizeCell = lm. new Cell(0, 0, 0);
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				//find min of neighboring cells
				if((i==0 || j==0)) {
					result[i][j] = input[i][j];
				}else if(input[i][j]==1){
					result[i][j] = input[i][j] + Math.min(
										Math.min(result[i-1][j], result[i-1][j-1]),
										result[i][j-1]);
				}
				if(maxSizeCell.size < result[i][j]) {
					maxSizeCell = lm. new Cell(i, j, result[i][j]);
				}
			}
		}
		return maxSizeCell;
	}
	
	class Cell {
		int r;
		int c;
		int size = 0;
		Cell(int i, int j, int s){
			r = i;
			c = j;
			size = s;
		}
	}
	
}

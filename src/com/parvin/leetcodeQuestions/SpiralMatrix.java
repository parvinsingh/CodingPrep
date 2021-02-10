package com.parvin.leetcodeQuestions;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/spiral-matrix/

public class SpiralMatrix {

	public static void main(String args[]) {
		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
 		List<Integer> result = spiralOrder(matrix);
 		for(int i: result) {
 			System.out.print(i+",");
 		}
 		int[][] output = generateMatrix(3);
	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
        int rows = matrix.length-1;//
        int cols = matrix[0].length-1;
        int startRow = 0;//top left corner OR row
        int startCol = 0;
        while(startRow<=rows && startCol<=cols) {
        	//print the top row
        	for(int i=startCol; i<=cols; i++) {
        		result.add(matrix[startRow][i]);
        	}
        	startRow++;//move down to the next row
        	
        	//print the last column
        	for(int i=startRow; i<=rows; i++) {
        		result.add(matrix[i][cols]);
        	}
        	cols--;//move to left after printing last column
        	
        	//print the row
        	for(int i=cols; i>=startCol; i--) {
        		result.add(matrix[rows][i]);
        	}
    		rows--;
        	
    		for(int i=rows; i>=startRow; i--) {
        		result.add(matrix[i][startCol]);
        	}
    		startCol++;
        	
        }
        return result;
    }	
	
	private static int[][] generateMatrix(int n){
		int[][] result = new int[n][n];
		int rows = n-1;
		int cols = n-1;
		int startRow = 0;
		int startCol = 0;
		int num = 1;
		while(startRow<=rows && startCol<=cols) {
			//top row
			for(int i=startCol; i<=cols; i++) {
				result[startRow][i] = num;
				num++;
			}
			startRow++;
			
			//right most column
			for(int i=startRow; i<=rows; i++) {
				result[i][cols] = num;
				num++;
			}
			cols--;
			
			//bottom row
			for(int i=cols; i<=startCol; i--) {
				result[rows][i] = num;
				num++;
			}
			rows--;
			
			//left most column
			for(int i=rows; i<=startRow; i--) {
				result[i][startCol] = num;
				num++;
			}
			startCol++;
		}
		return result;
	}
}

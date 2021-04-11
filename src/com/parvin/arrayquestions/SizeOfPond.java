package com.parvin.arrayquestions;

import java.util.ArrayList;
import java.util.List;

public class SizeOfPond {
	
	public static void main(String args[]) {
		int[][] matrix1 = {{0,1,2,0},
							{0,0,0,1},
							{1,1,0,1},
							{2,0,0,1}};
		
		int[][] matrix2 = {{0,1,2,0},
							{0,1,0,1},
							{1,1,0,1},
							{0,1,0,1}};
		List<Integer> result = sizeOfPond(matrix1);
		for(int i: result) {
			System.out.print(i+",");
		}
		System.out.println();
		result = sizeOfPond(matrix2);
		for(int i: result) {
			System.out.print(i+",");
		}
	}

	public static List<Integer> sizeOfPond(int[][] M) {
		int[][] op = new int[M.length][M[0].length];
		
		op[0][0] = M[0][0] == 0 ? 1 : -1;
		
		//top row
		for(int j=1; j<M.length; j++) {
			if(M[0][j]>0) {
				op[0][j] = -1;
				continue;
			}
			op[0][j] = op[0][j-1]>0 ? 1+op[0][j-1] : 1;
		}
		
		//left column
		for(int i=1; i<M[0].length; i++) {
			if(M[i][0]>0) {
				op[i][0] = -1;
				continue;
			}
			op[i][0] = op[i-1][0]>0 ? 1+op[i-1][0] : 1;
			op[i-1][0] = -1;
		}
		
		//rest of matrix
		for(int i=1; i<M.length; i++) {
			for(int j=1; j<M[i].length; j++) {
				if(M[i][j]>0) {
					op[i][j] = -1;
					continue;
				}
				op[i][j] = calculateSize(i, j, M, op);
			}
		}
		
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<op.length; i++) {
			for(int j=0; j<op[i].length; j++) {
				if(op[i][j]>0) {
					result.add(op[i][j]);
				}
			}
		}
		
		return result;
	}

	private static int calculateSize(int i, int j, int[][] m, int[][] op) {
		int size = 1;
		if(op[i][j-1]>0) {
			size += op[i][j-1];
			op[i][j-1]=-1;
		}
		if(op[i-1][j]>0) {
			size += op[i-1][j]; 
			op[i-1][j]=-1;
		}
		if(op[i-1][j-1]>0) {
			size += op[i-1][j-1];
			op[i-1][j-1]=-1;
		}
		if(op[i-1][j+1]>0) {
			size += op[i-1][j+1]; 
			op[i-1][j+1] = -1;
		}
		return size;
	}
}

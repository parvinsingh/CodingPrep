package com.parvin.arrayquestions;

//asked in an interview- fuboTV

public class DiagnolConsistentMatrix {

	public static void main(String args[]) {
		int[][] matrix = {{1,2,3,4,5},
						{7,1,2,3,4},
						{0,7,1,2,3},
						{6,0,7,1,2},
						{9,6,0,7,1}};
		System.out.println(checkIfDiagnollyConstant(matrix));
	}

	private static boolean checkIfDiagnollyConstant(int[][] matrix) {
		int r = matrix.length;//5
		
		for(int i=0; i<r-1; i++) {// i<4
			int[] first = matrix[i];
			int[] second = matrix[i+1];
			if(!compareArrays(first, second)) {
				return false;
			}
		}
		return true;
	}

	private static boolean compareArrays(int[] first, int[] second) {
		for(int i=0; i<first.length-1; i++) {
			if(first[i] != second[i+1]) {
				return false;
			}
		}
		return true;
	}
}

package com.parvin.leetcodeQuestions;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	public static void main(String args[]) {
		char ch = 'b';
		boolean[] m = new boolean[9];
		System.out.println((int) (ch - 'a'));
	}
	
	private static boolean ValidateSudoku(int[][] matrix) {
		int r = matrix.length;
		int c = matrix[0].length;
		Set<String> validationSet = new HashSet<String>();
		for(int i=0; i<r-1; i++) {
			for(int j=0; j<c-1; j++) {
				if(!validationSet.add("found in row " + i + " number " + matrix[i][j]) ||
				!validationSet.add("found in col " + j + " number " + matrix[i][j]) ||
				!validationSet.add("found in grid " + i/3 + "-" + j/3 + " number " + matrix[i][j])) {
					return false;
				}
			}
		}
		return true;
	}
}

package com.parvin.leetcodeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/predict-the-winner/

public class PredictWinner {
	
	public static void main(String args[]) {
		int[] arr = {1, 5, 233, 7};
		List<Integer> inpList = new ArrayList<Integer>();
		for(int i:arr) {
			inpList.add(i);
		}
	}

	public static boolean predictWin(List<Integer> input, int p1, int p2, int size, boolean isFirst) {
		if(size == 0) {
			if(p1 >= p2) {
				return true;
			}else {
				return false;
			}
		}
		boolean win = false;
		if(input.get(0) > input.get(size-1)) {
			int val = input.get(0);
			input.remove(0);
			p1 = isFirst ? p1+val:p1;
			p2 = !isFirst ? p2+val:p2;
		}else {
			int val = input.get(size-1);
			input.remove(size-1);
			p1 = isFirst ? p1+val:p1;
			p2 = !isFirst ? p2+val:p2;
		}
		
		isFirst = isFirst ? false: true;
		return predictWin(input, p1, p2, input.size(), isFirst);
	}
}

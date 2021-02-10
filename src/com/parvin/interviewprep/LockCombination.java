package com.parvin.interviewprep;
//provided a number of keys for a number lock, validate if the lock can open or not
//also print the combination

import Utilities.PrintArrays;

public class LockCombination {
	
	boolean[] validCombination;
	int numOfKeys = 0;

	public LockCombination(boolean[] validCombo, int keys) {
		numOfKeys = keys;
		validCombination = validCombo.clone();
	}
	
	public boolean isValidCombination() {
		boolean[] combo = new boolean[numOfKeys];
		return createCombinations(numOfKeys-1, combo);
	}
	
	private boolean createCombinations(int n, boolean[] combo) {
		if(checkCombo(combo)) {
			PrintArrays.printArray(combo);
			return true;
		}else {
			boolean[] orig = combo.clone();
			combo[n] = true;
			if(!checkCombo(combo) && n>0) {
				return createCombinations(n-1, combo) || createCombinations(n-1, orig);
			}else if(checkCombo(combo)){
				PrintArrays.printArray(combo);
				return true;
			}else {
				return false;
			}
		}
		
	}

	//fix the directory structure and make this as protected
	public boolean checkCombo(boolean[] combination) {
		for(int i=0; i<combination.length; i++) {
			if(combination[i]!=validCombination[i]) {
				return false;
			}
		}
		return true;
	}
}

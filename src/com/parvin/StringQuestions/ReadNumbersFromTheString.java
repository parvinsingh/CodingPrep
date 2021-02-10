package com.parvin.StringQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadNumbersFromTheString {

	public static void main(String[] args) {
		String input = "The number 1200 is greater than 9.00 but less than 1500";
		fetchNumbers(input);
		
	}
	//case1 - consider the ASCII value for ',' or '.'
	//case2 - consider the ASCII value for '.' decimal point or -ve numbers

	private static void fetchNumbers(String input) {
		//remove the spaces
		//ASCII value for 0-9 is 48-57 inclusive
		int[] nums = new int[10];
		String[] stringNumbers = new String[10];
		int index = 0;
		StringBuffer strBuff = new StringBuffer();
		for(int i =0; i<input.length(); i++) {
			if(((int)input.charAt(i) >= 48 && (int)input.charAt(i) <= 57)
					||(int)input.charAt(i) == 44 || (int)input.charAt(i) == 46) {
				strBuff.append(input.charAt(i));
			}else if(strBuff.length()>0) {
				String temp = strBuff.toString();
				stringNumbers[index] = temp;
				if(temp.contains(",")) {
					//find out the desired outcome in this case or in case of decimal point
				}
				//nums[index] = Integer.parseInt(temp);
				strBuff = new StringBuffer();
				index++;
			}
		}
		String temp = strBuff.toString();
		stringNumbers[index] = temp;
		//nums[index] = Integer.parseInt(temp);
		for(String num : stringNumbers) {
			if(num != null) {
				System.out.println(num);
			}
		}
		System.out.println("****************");
	}
	
}

package com.parvin.interviewprep;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * @author papanesa
 *
 */
public class ZigZagConversion {
	
	public static void main(String[] args) {
		//String input = "GEEKSFORGEEKS";
		String input = "PAYPALISHIRING";
		String output = getZigZagged2(input, 4);
		System.out.println(output);
	}

	private static String getZigZagged2(String input, int row) {
		//edge cases
		if(row == 1 || input.length() == 1 || input.length() <= row) {
			return input;
		}
		int index = -1;
		int len = input.length();
		String[] output = new String[row];
		boolean down = true;
		for(int i=0; i<len; i++) {
			if(down) {
				index++;	
			}else {
				index--;
			}
			output[index] = (output[index] == null) 
									? String.valueOf(input.charAt(i)) 
											: output[index]+String.valueOf(input.charAt(i));
			if(index >= row-1) {
				down = false;
			}
			if(index <= 0){
				down = true;
			}
		}
		StringBuffer op = new StringBuffer("");
		for(String str: output) {
			op.append(str);
		}
		return op.toString();
	}

	private static String getZigZagged(String input, int rows) {
		if(rows == 1 || input.length() == 1 || input.length() <= rows) {
			//edge cases
			return input;
		}
		char[] chars = input.toCharArray();
		int idx = 0;
		String[] buffers = new String[rows];
		boolean down = true;
		for(int i=0; i < chars.length; i++) {
			buffers[idx] = buffers[idx] == null ? String.valueOf(chars[i]) : buffers[idx] + String.valueOf(chars[i]);
			if(down) {
				idx++;
				if(idx >= rows) {
					idx = idx-2;
					down = false;
				}
			}else {
				idx--;
				if(idx < 0) {
					idx = idx+2;
					down = true;
				}
			}
			
		}
		String result = "";
		for(String str : buffers) {
			result = result+str;
		}
		return result;
	}
	
	

}

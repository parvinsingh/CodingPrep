package com.parvin.StringQuestions;

/*
 * Given a string that represents truck load/unload journal, 
 * identify final total weight of boxes. 
 * Format: [+-]NbW, where N - number of boxes(optional), W - weight of a box. 
 * Example: "b40 +3b20 -2b10 " would result in total weight of +80.
 */
public class WeightOfBox {

	public static void main(String args[]) {
		String input1 = "b40+3b20-2b10";
		System.out.println(TotalWeight(input1));
		System.out.println("=======");
		
		String input2 = "1b40-3b15-2b1";
		System.out.println(TotalWeight(input2));
		System.out.println("=======");
		
		String input3 = "0b40+8b10-2b10";
		System.out.println(TotalWeight(input3));
	}
	
	public static int TotalWeight(String input) {
		StringBuffer buff = new StringBuffer();
		int numOfBox = 1;
		int weight = 0;
		boolean isNeg = false;
		int totalWeight = 0;
		
		for(char ch : input.toCharArray()) {
			if(Character.isDigit(ch)) {
				buff.append(ch);
				continue;
			}
			if(Character.isAlphabetic(ch)) {//b
				String temp = buff.toString();
				buff = new StringBuffer();
				numOfBox = temp.isEmpty() ? 1 : Integer.valueOf(temp);//
				continue;
			}
			
			String temp = buff.toString();//40
			buff = new StringBuffer();
			weight = numOfBox * Integer.valueOf(temp);
			weight = isNeg ? (-1)*weight : weight;
			totalWeight += weight;
			
			if(Character.compare(ch, '+') == 0) {
				isNeg = false;
				continue;
			}
			if(Character.compare(ch, '-') == 0) {
				isNeg = true;
				continue;
			}
		}
		
		String temp = buff.toString();
		weight = numOfBox * Integer.valueOf(temp);
		weight = isNeg ? (-1)*weight : weight;
		totalWeight += weight;
		
		return totalWeight;
	}
	
}

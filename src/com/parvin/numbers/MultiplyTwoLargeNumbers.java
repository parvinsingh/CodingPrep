package com.parvin.numbers;

public class MultiplyTwoLargeNumbers {
	
	private static long multiply(String num1, String num2) {
		long product = 0;
		int factor = 1;
		for (int i= num2.length()-1; i>=0; i--) {
			int X = Character.getNumericValue(num2.charAt(i));
			long tempResult = Math.multiplyExact(Long.valueOf(num1), X);
			product = product + (factor*tempResult);
			factor = factor * 10;
		}
		return product;
	}
	
	public static void main (String[] args) {
		//System.out.println(multiply2("52","11"));
		System.out.println(multiply2("349123132","112353323"));
	}

	private static String multiply2(String num1, String num2) {
		int carry = 0;
		int tempResult = 0;
		StringBuilder result = new StringBuilder();
		for (int i= num2.length()-1; i>=0; i--) {
			int X = Character.getNumericValue(num2.charAt(i));
			tempResult = (int) (carry + Math.multiplyExact(Long.valueOf(num1), X));
			carry = tempResult/10;
			result.insert(0, tempResult%10);
		}
		result.insert(0, carry);
		return result.toString();
	}
}

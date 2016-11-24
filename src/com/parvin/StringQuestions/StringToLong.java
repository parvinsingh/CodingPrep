package com.parvin.StringQuestions;

public class StringToLong {

	public static void main(String args[]){
		ConvertStringToLong("-345");
		ConvertIntToString(-534);
	}
	
	private static void ConvertStringToLong(String str)
	{
	/* code goes here to convert a string to a long */
		boolean isNegative = false;
		if(str.charAt(0) == '-'){
			isNegative = true;
			str = str.substring(1);
		}
			long result = 0;
			int factor = 1;
			for(int i=str.length()-1;i>-1;i--)
			{
				char c = str.charAt(i);
				int k = c-48;//value of 'c' will be the ASCII code of integer 5
				result = (factor*k)+result;
				factor = factor * 10;
			}
			if(isNegative){
				System.out.println("Therefore the long number is : " + (-1*result));
				return;
			}
			System.out.println("Therefore the long number is : " + result);
	}
	
	private static void ConvertIntToString(int input)
	{ 
			String result = "" ;
			boolean negative = (input<0)? true:false;
			input = Math.abs(input);
			while(input>0)
			{
				int lastDigit = input%10;
				result = lastDigit + result;
				input = input/10;
			}
			if(negative){
				result = "-"+result;
			}
			System.out.println("Therefore the string value is : " + result);
	
	}
}

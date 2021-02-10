package com.parvin.StringQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringToLong {

	public static void main(String args[]){
//		ConvertStringToLong("-345");
//		ConvertIntToString(-534);
		
		String integralString = "-91283472332";
	    System.out.println(myAtoi(integralString));
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
	
	private static int myAtoi(String str) {
	      String input = str.trim();
	      boolean isNegative = false;
	      
	      char firstChar = input.charAt(0);
	      if(firstChar == '-'){
	        isNegative = true;
	        input = input.substring(1);
	      } else if(firstChar == '+'){
	        isNegative = false;
	        input = input.substring(1);
	      } else if(firstChar < 48 || firstChar > 57){
	        return 0;
	      }
	      
	      int factor = 1;
	      int result = 0;
	      List<Character> resultArr = new ArrayList<Character>();
	      for(int j=0; j<input.length(); j++){
	        char c = input.charAt(j);
	        if(c >= 48 && c <= 57){
	        	resultArr.add(c);
	        }else {
	        	break;
	        }
	      }
	      Collections.reverse(resultArr);
	      for(char c : resultArr) {
	    	  result = result + factor*(c-48);
	    	  factor = factor*10;
	      }
	      
	      result = isNegative ? -1*result : result;
	      
	      if (result > Integer.MAX_VALUE) {
	            return Integer.MAX_VALUE;   
	        } else if (result < Integer.MIN_VALUE) {
	            return Integer.MIN_VALUE;
	        } else {
	            return result;
	        }
	    }
}

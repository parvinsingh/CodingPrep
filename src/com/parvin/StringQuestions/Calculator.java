package com.parvin.StringQuestions;

public class Calculator {
	
	/*
	You are building an educational website and want to create a simple calculator for students to use. The calculator will only allow addition and subtraction of non-negative integers.

	Given an expression string using the "+" and "-" operators like "5+16-2", write a function to find the total.

	stack 
	6
	pop+[i+1]     [i]

	Sample input/output:
	calculate("6+9-12")  => 3
	calculate("1+2-3+4-5+6-7") => -2
	calculate("100+200+300") => 600    
	calculate("1-2-3-0") => -4
	calculate("255") => 255        
	calculate("0-1-2-3") => -6

	n: length of the input string

	*/
	public static void main(String[] argv) {
	    String expression1 = "6+9-12"; // = 3
	    String expression2 = "1+2-3+4-5+6-7"; // = -2
	    String expression3 = "100+200+300"; // = 600
	    String expression4 = "1-2-3-0"; // = -4
	    String expression5 = "255"; // = 255
	    String expression6 = "0-1-2-3"; // = -6
	    int result = calculate(expression6);
	    System.out.println(result);
	  }
	  
	  private static int calculate(String str){
	    char[] charArray = str.toCharArray();
	    int sum = 0;
	    boolean isNeg = false;
	    StringBuffer buff = new StringBuffer();
	    
	    for(int i=0; i<charArray.length; i++){
	    	char ch = charArray[i];
	    	
	    	if(Character.compare(ch, '-') != 0 && Character.compare(ch, '+') != 0) {
	    		buff.append(ch);
	    		continue;
	    	}
	    	String temp = buff.toString();
	    	buff = new StringBuffer();
	    	if(isNeg) {
    			sum = sum - Integer.valueOf(temp);
    		}else {
    			sum = sum + Integer.valueOf(temp);
    		}
	    	
	    	if(Character.compare(ch, '-') == 0) {
	    		isNeg = true;
	    		continue;
	    	}
	    	if(Character.compare(ch, '+') == 0){
	    		isNeg = false;
	    		continue;
	    	}
	    }
	    
	    String temp = buff.toString();
    	if(isNeg) {
			sum = sum - Integer.valueOf(temp);
		}else {
			sum = sum + Integer.valueOf(temp);
		}
	    return sum;
	  }
	
}

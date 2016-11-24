package com.parvin.numbers;
/**
 * Find the maximum depth of nested parenthesis
 * S = "( a(b) (c) (d(e(f)g)h) I (j(k)l)m)";
Output : 4

S = "( p((q)) ((s)t) )";
Output : 3

S = "";
Output : 0

S = "b) (c) ()";
Output : -1 

S = "(b) ((c) ()"
Output : -1 
 */
public class NestedParenthesis {

	public static void main(String[] args){
		String[] input = {"({(})","{()}{[]}","()","((}})", ")("};
		validateBraces(input);
		for(String str: input){
			System.out.println(str);
		}
	}

	private static void validateBraces(String[] bracesInput) {
		for(int j=0; j<bracesInput.length; j++){
			String input = bracesInput[j];
			int curlyCount=0;
			int squareCount=0;
			int parenthesisCount=0;
			for(int i=0; i<input.length(); i++){
				if(input.charAt(i) =='('){
					parenthesisCount++;
				}else if(input.charAt(i) ==')' && parenthesisCount>0){
					parenthesisCount--;
				}else if(input.charAt(i) =='{'){
					curlyCount++;
				}else if(input.charAt(i) =='}' && curlyCount>0){
					curlyCount--;
				}else if(input.charAt(i) =='['){
					squareCount++;
				}else if(input.charAt(i) ==']' && squareCount>0){
					squareCount--;
				}
			}
//			if(parenthesisCount==0&&squareCount==0&&curlyCount==0){
//				bracesInput[j]="YES";
//			}else{
//				bracesInput[j]="NO";
//			}
			if(parenthesisCount!=0 || squareCount!=0 || curlyCount!=0){
				bracesInput[j]="NO";
			}else{
				bracesInput[j]="YES";
			}
		}
	}
}

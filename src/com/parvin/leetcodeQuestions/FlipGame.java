package com.parvin.leetcodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {

	public static void main(String args[]) {
		System.out.println(canWin("++++"));
		System.out.println(generatePossibleNextMoves("++++"));
	}
	
	//https://www.programcreek.com/2014/05/leetcode-flip-game-ii-java/
	public static boolean canWin(String s) {
	    if(s==null||s.length()==0){
	        return false;
	    }
	 
	   return canWinHelper(s.toCharArray()); 
	}
	 
	public static boolean canWinHelper(char[] arr){
	    for(int i=0; i<arr.length-1;i++){
	        if(arr[i]=='+'&&arr[i+1]=='+'){
	            arr[i]='-';
	            arr[i+1]='-';
	 
	            boolean win = canWinHelper(arr);
	 
	            arr[i]='+';
	            arr[i+1]='+';
	 
	            //if there is a flip which makes the other player lose, the first play wins
	            if(!win){
	                return true;
	            }
	        }
	    }
	 
	    return false;
	}
	
	//https://www.programcreek.com/2014/04/leetcode-flip-game-java/
	public static List<String> generatePossibleNextMoves(String s) {
	    List<String> result = new ArrayList<String>();
	 
	    if(s==null)
	        return result;
	 
	    char[] arr = s.toCharArray();
	    for(int i=0; i<arr.length-1; i++){
	        if(arr[i]==arr[i+1] && arr[i]=='+'){
	            arr[i]='-';
	            arr[i+1]='-';
	            result.add(new String(arr));
	            arr[i]='+';
	            arr[i+1]='+';
	        }
	    }
	 
	    return result;
	}
}

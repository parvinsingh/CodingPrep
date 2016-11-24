package com.parvin.StringQuestions;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Given a digit string, return all possible letter combinations that the number could represent. 
 * (Check out your cellphone to see the mappings) 
 * Input:Digit string "23", Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @author ppanesar
 *
 */
public class LetterCombinationsOfPhoneNumber {
	
	public static void main(String args[]){
		ArrayList<String> result = letterCombinations("23");
		for(String str: result){
			System.out.println(str + ", ");
		}
	}

	public static ArrayList<String> letterCombinations(String digits){
		HashMap<Character, String> map = new HashMap<Character, String>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		map.put('0', " ");
		
		ArrayList<String> result = new ArrayList<String>();
		
		if(digits==null || digits.isEmpty()){
			return result;
		}
		ArrayList<Character> temp = new ArrayList<Character>();
		getString(digits, temp, result, map);
		return result;
	}
	
	private static void getString(String digits, ArrayList<Character> temp, ArrayList<String> result, HashMap<Character, String> map){
		if(digits.length()==0){
			char[] tempArr = new char[temp.size()];
			for(int i=0; i<temp.size(); i++){
				tempArr[i]=temp.get(i);
			}
			result.add(String.valueOf(tempArr));
			return;
		}
		String currentChar = digits.substring(0, 1);
		String letters = map.get(currentChar.charAt(0));
		for(int i=0; i<letters.length(); i++){
			temp.add(letters.charAt(i));
			getString(digits.substring(1), temp, result, map);
			temp.remove(temp.size()-1);
		}
	}
}

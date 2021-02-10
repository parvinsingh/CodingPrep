package com.parvin.leetcodeQuestions;

/**
 * https://www.hackerrank.com/challenges/happy-ladybugs/problem 
 * Happy Ladybugs is a board game having the following properties:

The board is represented by a string, , of length . The  character of the string, , denotes the  cell of the board.
If  is an underscore (i.e., _), it means the  cell of the board is empty.
If  is an uppercase English alphabetic letter (ascii[A-Z]), it means the  cell contains a ladybug of color .
String  will not contain any other characters.
A ladybug is happy only when its left or right adjacent cell (i.e., ) is occupied by another ladybug having the same color.
In a single move, you can move a ladybug from its current position to any empty cell.
Given the values of  and  for  games of Happy Ladybugs, determine if it's possible to make all the ladybugs happy. For each game, print YES on a new line if all the ladybugs can be made happy through some number of moves. Otherwise, print NO.


As an example, . You can move the rightmost  and  to make  and all the ladybugs are happy.
 * @author papanesa
 *
 */
public class HappyLadyBugs {

	public static void main(String args[]) { 
		String[] input = {"YYR_B_BR","ABDDBA", "AABBCC", "AABC_C", "DD_FQ_QQF", "_", "AA", "AB"};
		for (String ip: input) {
			System.out.println(canLadyBugsBeHappy(ip));
		}
	}
	
	private static boolean canLadyBugsBeHappy(String input) {
		if(!input.contains("_")) {
			for(int i=0; i<=input.length()-1; i++){
				if(i==0 && input.charAt(i)!=input.charAt(i+1)) {
					return false;
				}else if(i!=0 && input.charAt(i)!=input.charAt(i-1) && input.charAt(i)!=input.charAt(i+1)) {
					return false;
				}
			}
			return true;
		} else {
			//has space 
			//check if there is one unique character
			int[] ascii = new int[26];
			for(int i=0; i<input.length(); i++) {
				if(input.charAt(i) != '_') {
					ascii[(int)input.charAt(i)-65]++;
				}
			}
			for(int i=0; i<26; i++) {
				if(ascii[i] == 1) {
					return false;
				}
			}
			return true;
		}
	}
}

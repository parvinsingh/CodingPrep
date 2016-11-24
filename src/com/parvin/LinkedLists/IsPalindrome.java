package com.parvin.LinkedLists;
import java.util.Stack;


public class IsPalindrome {
	
	public static void main(String[] args){
		String input = "A B BA";
		boolean isPalindrome = isAPalindrome(input);
		System.out.print("Given string " + input + " is a Palindrome = " + isPalindrome);
	}

	private static boolean isAPalindrome(String input){
		if(input == null){
			return false;
		}
		if(input.length()==1){
			return true;
		}
		input = input.replace(" ", "");//This will remove all white spaces
		char letters[] = input.toCharArray();
		int endIndex=input.length()-1;
		boolean isPalindrome = false;
		for(int startIndex=0; startIndex<endIndex; startIndex++){
			//Do not need this if-else condition if we are using replace() method in the String class.
			/*if(letters[startIndex] == ' '){
				continue;
			}else if(letters[endIndex] == ' '){
				endIndex--;
			}else*/ if(letters[startIndex] == letters[endIndex]){
				isPalindrome = true;
				endIndex--;
			}else{
				isPalindrome = false;
				break;
			}
		}
		return isPalindrome;
	}
	
	//Implement a method to check if LinkedList is palindrome.
	private static boolean isListPalindrome(LinkedListNode head){
		if(head==null){
			return false;
		}
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		
		Stack<Integer> tempStack = new Stack<Integer>();
		while(fast!=null && fast.next!=null){
			tempStack.push(slow.data);
			slow=slow.next;
			fast=fast.next.next;
		}
		if(fast.next==null){
			slow=slow.next;
		}
		while(slow!=null){
			if(slow.data != tempStack.pop().intValue()){
				return false;
			}
			slow=slow.next;                                                                                                                                                          
		}
		return true;
	}
}
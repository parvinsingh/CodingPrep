package com.parvin.StringQuestions;

/**
 * Check if the input string can be a palindrome
 * by removing at most one character
 * levell --> level
 * abcdcba --> abccba
 * tacocat --> tacsocat
 * @author papanesa
 *
 */
public class PossiblePalindrome {

	public static void main(String args[]) {
		String input = "abcdscba";//abcdscba
		int isPalindrome = checkIfPalindrome(input);
		System.out.println("By removing the character at index:" + isPalindrome + " the string will be palindrome");

        String result = SwapAndPalindrome(input);
        System.out.println("By swapping the characters, the palindrome is :" + result);
	}

	private static int checkIfPalindrome(String input) {
		int start = 0;
		int end = input.length()-1;
		while (start < end) {
			if(input.charAt(start) == input.charAt(end)) {
				start++;
				end--;
			}else {
				if(checkPalindrome(input, start+1, end)) {
					return start;
				}
				if(checkPalindrome(input, start, end-1)) {
					return end;
				}
				return -1;
			}
		}
		return -2;
	}

	private static boolean checkPalindrome(String input, int start, int end) {
		while (start < end) {
			if (input.charAt(start) != input.charAt(end)) {
				return false;
			} else {
				start++;
				end--;
			} 
		}
		return true;
	}
	
	public static String SwapAndPalindrome(String input){
        char[] arr = input.toCharArray();
        int swap = 0;
        int i = 0;
        int j = arr.length-1;
        char temp;
        while(i<j){
            if(arr[i] != arr[j]){
                if(arr[i+1] == arr[j]){
                    //swap i and i+1 and increment i, decrement j, swap++
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;

                    i++;j--;
                    swap++;
                } else if(arr[i] == arr[j-1]){
                    //swap j and j-1 and increment i, decrement j, swap++
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;

                    i++;j--;
                    swap++;
                } else if(arr[i+1] == arr[j-1] && i+1 != j-1){
                    //swap i and i+1, swap j and j-1 and increment i, decrement j, swap+2
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;

                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;

                    i++;j--;
                    swap = swap+2;
                }else{
                    swap = -1;break;
                }       
            } else{
                //increment i, decrement j
                i++;j--;
            }
        }       
        System.out.println("No Of Swaps: "+swap);
        return String.valueOf(arr);
    }
}

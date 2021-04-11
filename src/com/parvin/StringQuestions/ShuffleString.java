package com.parvin.StringQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


//shuffle the string to return if the string can be arranged with alternate characters or not.
public class ShuffleString
    {
        public static void main(String args[])
        {
            String userInput = "AAAAAAAABBBCDE";//length=11
            String userInput2 = "BBB";//length=11
            System.out.println(shuffleString(userInput));
            System.out.println("======");
            boolean result = shuffleString(userInput2);
            System.out.println(result);
        }
        
        public static boolean shuffleString(String input) {
        	HashMap<Character, Integer> freqMap = new HashMap<Character, Integer>();
        	
        	for(char s: input.toCharArray()) {
        		int c = freqMap.getOrDefault(s, 0);
        		freqMap.put(s, c+1);
        	}
        	
        	List<Character> keys = new ArrayList<>(freqMap.keySet());
    		
    		Collections.sort(keys, 
    				(c1,c2) -> freqMap.get(c2) - freqMap.get(c1));
    		
    		int start = 0;
    		int i = 0;
    		char[] resArr = new char[input.length()];
    		for(Character k: keys) {
    			int count = freqMap.get(k);
    			i = start;
    			while(count>0 && i<input.length()) {
    				if(resArr[i] == 0) {
        				resArr[i] = k;//0,2,4,6
        				count -= 1;
        				i += 2;
    				}else {
    					i += 1;
    				}
    			}
    			if(count > 0) {
    				return false;
    			}
    			freqMap.replace(k, 0);
    			start += 1;
    		}
    		System.out.println(String.valueOf(resArr));
    		return true;
        }
    }
package com.parvin.StringQuestions;

import java.util.LinkedList;
import java.util.List;

public class ReflowStrings {

	public static void main(String args[]) {
		String[] input = {"The day is sunny as",
		                  "in Seattle in the state",
		                  "of Washington"};
		
		String[] input2 = {"The day is sunny as",
                "in Seattle"};
		
		List<String> result = reShuffleString(input2, 7);
		System.out.println("--------------");
		for(String s: result) {
			System.out.println(s);
		}
	}

	private static List<String> reShuffleString(String[] input, int origLen) {
		List<String> result = new LinkedList<String>();
		StringBuffer buff = new StringBuffer();
		for(String s: input) {
			buff.append(s.replace(" ", "-"));
			buff.append("-");
		}
		buff.setLength(buff.length()-1);
		System.out.println(buff.toString());
		
		String workStr = buff.toString();
		String temp = new String();
		System.out.println("WorkStr= "+workStr);
		
		while(workStr.contains("-") && workStr.length()>=origLen) {
			if(Character.compare(workStr.charAt(origLen), '-') == 0) {
				result.add(workStr.substring(0, origLen));
				workStr = workStr.substring(origLen+1);
			}else {
				temp = workStr.substring(0, origLen-1);
				int goodIndex = temp.lastIndexOf('-');
				if(goodIndex >= 0) {
					result.add(workStr.substring(0, goodIndex));
					workStr = workStr.substring(goodIndex+1);
				}else {
					result.add(temp);
					workStr = workStr.substring(origLen);
				}
			}
		}
		
		result.add(workStr);
		
		return result;
	}
}
